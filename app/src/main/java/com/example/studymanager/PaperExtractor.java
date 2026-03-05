package com.example.studymanager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Class to retrieve HTML content from the specified paper
public class PaperExtractor {
    // Executor to handle the request in the background
    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    // Callback interface to return the document
    public interface DocumentCallback {
        void onDocumentRetrieved(Document document);    // Success
        void onError(Exception e);                      // Error
    }

    // Connects to the waikato uni paper outline and retrieves html document
    public static void getDocumentFromUrl(String url, DocumentCallback callback) {
        executorService.execute(() -> {
            try {
                //Connect to the url with a timeout
                Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0")
                        .timeout(10000)
                        .get();

                // Return the document
                callback.onDocumentRetrieved(doc);
            } catch (IOException e) {
                // Return the error
                callback.onError(e);
            }
        });
    }
}

