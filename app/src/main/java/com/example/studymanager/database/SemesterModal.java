package com.example.studymanager.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "semester_table")
public class SemesterModal {
    @PrimaryKey @NonNull
    private String semesterCode;    // Code of semester
    private int semesterYear;       // Year of semester
    private String startDate;       // Start date of semester
    private String endDate;         // End date of semester
    private String breakStartDate;   // Start date of break
    private String breakEndDate;    // End date of break

    // Constructor for semester table
    public SemesterModal(
            @NonNull String semesterCode,
            int semesterYear,
            String startDate,
            String endDate,
            String breakStartDate,
            String breakEndDate
    ) {
        this.semesterCode = semesterCode;
        this.semesterYear = semesterYear;
        this.startDate = startDate;
        this.endDate = endDate;
        this.breakStartDate = breakStartDate;
        this.breakEndDate = breakEndDate;
    }

    // Getters and setters for semester table
    // Semester Code
    @NonNull
    public String getSemesterCode() { return semesterCode; }

    public void setSemesterCode(@NonNull String semesterCode) { this.semesterCode = semesterCode; }
    // Semester Year
    public int getSemesterYear() { return semesterYear; }

    public void setSemesterYear(int semesterYear) { this.semesterYear = semesterYear; }

    // Start date
    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) { this.startDate = startDate; }

    // End date
    public String getEndDate() { return endDate; }

    public void setEndDate(String endDate) { this.endDate = endDate; }

    // Break start
    public String getBreakStartDate() { return breakStartDate; }

    public void setBreakStartDate(String breakStartDate) { this.breakStartDate = breakStartDate; }

    // Break end date
    public String getBreakEndDate() { return breakEndDate; }

    public void setBreakEndDate(String breakEndDate) { this.breakEndDate = breakEndDate; }
}



