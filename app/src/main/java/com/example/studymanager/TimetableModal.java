package com.example.studymanager;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "timetable_table")
public class TimetableModal {
    @PrimaryKey(autoGenerate = true)
    private int id;                     // Unique ID

    private String eventName;           // Event name

    private String dayOfWeek;           // Weekday event occurs on

    private String startTime;           // Start time of event

    private String endTime;             // End time of event

    private String location;            // Location of event

}

