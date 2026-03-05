package com.example.studymanager.database;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
// Setting the assessment table as a many to one relationship to the course
@Entity(tableName = "assessment_table",
        foreignKeys = @ForeignKey(
                entity = CourseModal.class,     // The parent class
                parentColumns = "paperId",      // PK of parent
                childColumns = "paperId_fk",    // FK name
                onDelete = ForeignKey.CASCADE   // Dependency on paper
        )
)
public class AssessmentsModal {
    @PrimaryKey(autoGenerate = true)
    private int assessmentId;       // Unique id for assessments table
    private String title;           // Name of the assessment item (this includes tests, assessments etc.
    private String dueDate;         // Day the work is due
    private int weighting;          // Weight of the assessment for overall mark
    private String type;            // Type of assessment (exam, test etc...)
    private String description;     // Description of assessment if available
    private int paperId_fk;         // Foreign key to paper table

    // Constructor for assessment table
    public AssessmentsModal(String title, String dueDate, int weighting, String type, String description) {
        this.title = title;
        this.dueDate = dueDate;
        this.weighting = weighting;
        this.type = type;
        this.description = description;
    }

    // Getters and setters for assessment table
    // Id
    public int getAssessmentId() {
        return assessmentId;
    }
    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }
    // Title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    // Due date
    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    // Weighting
    public int getWeighting() {
        return weighting;
    }
    public void setWeighting(int weighting) {
        this.weighting = weighting;
    }
    // Type
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    // Description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    // Foreign key to paper
    public int getPaperId_fk() {
        return paperId_fk;
    }
    public void setPaperId_fk(int paperId_fk) {
        this.paperId_fk = paperId_fk;
    }
}
