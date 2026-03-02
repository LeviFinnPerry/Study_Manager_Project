package com.example.studymanager;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "assessment_table")
public class AssessmentsModal {
    @PrimaryKey(autoGenerate = true)
    private int id;         // Unique id for assessments table
    private String assessmentItem; // Name of the assessment item (this includes tests, assessments etc.

    private String dueDate;     // Day the work is due
    private int percentageOfMark; // Weight of the assessment for overall mark

}
