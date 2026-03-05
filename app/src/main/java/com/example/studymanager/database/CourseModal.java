package com.example.studymanager.database;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

// Setting the paper table as a many to one relationship with semester
@Entity(tableName = "paper_table",
        foreignKeys = @ForeignKey(
                entity = SemesterModal.class,   // The parent class
                parentColumns = "semesterCode",   // PK of parent
                childColumns = "semester", // FK name
                onDelete = ForeignKey.CASCADE   // Dependency on paper
        )
)
public class CourseModal {
    // Key information from top of paper outline
    @PrimaryKey(autoGenerate = true)
    private int paperId;                     // Unique ID for each paper
    private String paperCode;           // Code for the paper
    private String paperName;           // Course name of paper
    private String occurrenceCode;      // Occurrence code
    private String semester;            // Semester paper occurs in
    private String points;              // Points total in the paper
    private String startWeek;            // Start week for paper
    private String endWeek;             // End week for paper

    // Constructor for the course information
    public CourseModal(String paperCode, String paperName, String occurrenceCode, String semester, String points, String startWeek, String endWeek) {
        this.paperCode = paperCode;
        this.paperName = paperName;
        this.occurrenceCode = occurrenceCode;
        this.semester = semester;
        this.points = points;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
    }

    // Getting and setting methods for paper information
    // Paper code
    public String getPaperCode() {
        return paperCode;
    }
    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
    }

    //Paper Name
    public String getPaperName() {
        return paperName;
    }
    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    //Paper occurance
    public String getOccurrenceCode() {
        return occurrenceCode;
    }
    public void setOccurrenceCode(String occurrenceCode) {
        this.occurrenceCode = occurrenceCode;
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
    public String getStartWeek() {
        return startWeek;
    }
    public void setStartWeek(String startWeek) {
        this.startWeek = startWeek;
    }

    // End date
    public String getEndWeek() {
        return endWeek;
    }
    public void setEndWeek(String endWeek) {
        this.endWeek = endWeek;
    }

    // Id
    public int getPaperId() {
        return paperId;
    }
    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }
}

