package com.example.studymanager.ui.course;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.studymanager.PaperExtractor;
import com.example.studymanager.databinding.FragmentCourseBinding;

import org.jsoup.nodes.Document;

public class CourseFragment extends Fragment {

    private FragmentCourseBinding binding;

    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState
    ) {
        CourseViewModel courseViewModel =
                new ViewModelProvider(this).get(CourseViewModel.class);

        binding = FragmentCourseBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCourse;
        courseViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Target url
        String url = "https://paperoutlines.waikato.ac.nz/outline/COMPX576-26A%20(HAM)";

        // Run the extraction of document
        PaperExtractor.getDocumentFromUrl(url, new PaperExtractor.DocumentCallback() {
            @Override
            public void onDocumentRetrieved(Document document) {
                // Document is retrieved in  background thread
                // Parse the information from the document
                Document doc = document;
                // Update the UI in the main thread
                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> {
                        textView.setText(document.title());
                    });
                }
            }

            @Override
            public void onError(Exception e) {
                // Handle the error here
                Log.e("CourseFragment", "Extraction failed", e);
                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> {
                        textView.setText("Extraction failed");
                    });
                }
            }
        });

        // Return the root view
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}