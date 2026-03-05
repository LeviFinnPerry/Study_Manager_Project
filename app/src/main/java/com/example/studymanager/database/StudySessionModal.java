package com.example.studymanager.database;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

// Study session table is related to paper but not dependent on it
@Entity(tableName = "study_session_table",
        foreignKeys = @ForeignKey(
                entity = CourseModal.class,     // The parent class
                parentColumns = "paperId",      // PK of parent
                childColumns = "paperId_fk"    // FK name
        ),
        indices = {@Index("paperId_fk")}
)

public class StudySessionModal {
    @PrimaryKey(autoGenerate = true)
    private int studySessionId;     // Unique ID
    private String dateTimeStart;   // Date of study session
    private String dateTimeEnd;     // Time of study session
    private int durationMinutes;    // Duration of study session
    private String notes;           // Notes for study session
    private int paperId_fk;         // Foreign key to paper table

    // Constructor for study session table
    public StudySessionModal(String dateTimeStart, String dateTimeEnd, int durationMinutes, String notes, int paperId_fk) {
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd = dateTimeEnd;
        this.durationMinutes = durationMinutes;
        this.notes = notes;
        this.paperId_fk = paperId_fk;
    }

    // Getter and setters for study session table
    // Id
    public int getStudySessionId() {
        return studySessionId;
    }
    public void setStudySessionId(int studySessionId) {
        this.studySessionId = studySessionId;
    }
    // Date
    public String getDateTimeStart() {
        return dateTimeStart;
    }
    public void setDateTimeStart(String dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }
    public String getDateTimeEnd() {
        return dateTimeEnd;
    }
    public void setDateTimeEnd(String dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }
    // Duration
    public int getDurationMinutes() {
        return durationMinutes;
    }
    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
    // Notes
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    // Foreign key to paper
    public int getPaperId_fk() {
        return paperId_fk;
    }
    public void setPaperId_fk(int paperId_fk) {
        this.paperId_fk = paperId_fk;
    }

}
