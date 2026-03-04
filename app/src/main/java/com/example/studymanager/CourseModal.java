package com.example.studymanager;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Initially starting with a basic single table to get all basic paper outline information
@Entity(tableName = "full_table")
public class CourseModal {
    // Key information from top of paper outline
    @PrimaryKey(autoGenerate = true)
    private int id;                     // Unique ID for each paper
    private String paperTitle;          // Course name of paper

    private String paperOccurrenceCode; // Occurrence code
    private String semester;              // Semester paper occurs in
    private String points;                 // Points total in the paper

    private String startDate;           // Start date for paper

    private String endDate;             // End date for paper

    //private String staffName;           // Name for convenor

    //private String staffEmail;          // Email for convenor

    // Constructor for the course information
    public CourseModal(String paperTitle, String paperOccurrenceCode, String semester, String points, String startDate, String endDate) {
        this.paperTitle = paperTitle;
        this.paperOccurrenceCode = paperOccurrenceCode;
        this.semester = semester;
        this.points = points;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getting and setting methods for paper information

    //Paper Title
    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    //Paper occurance
    public String getPaperOccurrenceCode() {
        return paperOccurrenceCode;
    }

    public void setPaperOccurrenceCode(String paperOccurrenceCode) {
        this.paperOccurrenceCode = paperOccurrenceCode;
    }

    // Semester

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    // Points

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    // Start date

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    // End date

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    // Staff name
    /*
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    // Staff email

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }
    */
    // Id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

