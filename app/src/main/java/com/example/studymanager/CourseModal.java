package com.example.studymanager;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Initially starting with a basic single table to get all paper outline information
@Entity(tableName = "full_table")
public class CourseModal {
    // Key information from top of paper outline
    @PrimaryKey(autoGenerate = true)
    private int id;                     // Unique ID for each paper
    private String courseName;          // Course name of paper
    private int points;                 // Points total in the paper

    private String startDate;           // Start date for paper

    private String endDate;             // End date for paper

    private String staffName;           // Name for convenor

    private String staffEmail;          // Email for convenor


}

