package com.example.studymanager.database;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "timetable_table",
        foreignKeys = @ForeignKey(
                entity = CourseModal.class,     // The parent class
                parentColumns = "paperId",      // PK of parent
                childColumns = "paperId_fk",    // FK name
                onDelete = ForeignKey.CASCADE   // Dependency on paper
        )
)
public class TimetableModal {
    @PrimaryKey(autoGenerate = true)
    private int timetableId;            // Unique ID
    private String eventName;           // Event name
    private String dayOfWeek;           // Weekday event occurs on
    private String startTime;           // Start time of event
    private String endTime;             // End time of event
    private String location;            // Location of event
    private int paperId_fk;             // Foreign key to paper table


    // Constructor for timetable
    public TimetableModal(String eventName, String dayOfWeek, String startTime, String endTime, String location, int paperId_fk) {
        this.eventName = eventName;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.paperId_fk = paperId_fk;
    }

    // Getters and setters for timetable
    // Id
    public int getTimetableId() {
        return timetableId;
    }
    public void setTimetableId(int timetableId) {
        this.timetableId = timetableId;
    }
    // Event name
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    // Day of week
    public String getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    // Start time
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    // End time
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    // Location
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    // Foreign key to paper
    public int getPaperId_fk() {
        return paperId_fk;
    }
    public void setPaperId_fk(int paperId_fk) {
        this.paperId_fk = paperId_fk;
    }
}


