package com.example.studymanager;

import com.example.studymanager.database.CourseModal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class paperExtractor {
    // Using a single thread for background tasks
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public void fetchAndPopulate(String paperCode, CourseDatabase db) {
        // For now use a known url for population
        String url = "https://paperoutlines.waikato.ac.nz/outline/COMPX576-26A%20(HAM)";

        // Get the information from the website
        executor.execute(() -> {
            try {
                Document doc = Jsoup.connect(url).get();

                // For paper title where col-md-2 is "Paper Title" get col-md-10
                String paperTitleElement = getSpanElementTextByLabel(doc, "Paper Title");

                // For the paper occurrence code where col-md-2 is "Paper Occurrence Code" get col-md-10
                String paperOccurrenceCodeElement = getSpanElementTextByLabel(doc, "Paper Occurrence Code");

                // For the semester where col-md-2 is "When Taught" get col-md-10
                String semesterElement = getSpanElementTextByLabel(doc, "When Taught");

                // For the points where col-md-2 is "Points" get col-md-10
                String pointsElement = getSpanElementTextByLabel(doc, "Points");

                // For the start date where col-md-2 is "Start Week" get col-md-10
                String startWeekElement = getSpanElementTextByLabel(doc, "Start Week");

                // For the end date where col-md-2 is "End Week" get col-md-10
                String endWeekElement = getSpanElementTextByLabel(doc, "End Week");

                // Create a new CourseModal object with the extracted information
                CourseModal courseModal = new CourseModal(paperCode, paperTitleElement, paperOccurrenceCodeElement, semesterElement, pointsElement, startWeekElement, endWeekElement);

                // Insert into the database
                db.Dao().insert(courseModal);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


    }

    // Method to retrieve html span element based on the label
    private String getSpanElementTextByLabel(Document doc, String label) {
        Element paperElement = doc.selectFirst("div.row label:contains('" + label + "') + span");
        assert paperElement != null;
        return paperElement.text();
    }
}

