package com.example.studymanager;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studymanager.database.CourseModal;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    // Add data
    @Insert
    void insert(CourseModal model);

    // Remove data
    @Delete
    void delete(CourseModal model);

    // Update data
    @Update
    void update(CourseModal model);

    // Delete all papers
    @Query("DELETE FROM paper_table")
    void deleteAllCourses();

    // Select all papers
    @Query("SELECT * FROM paper_table")
    LiveData<List<CourseModal>> getAllCourses();

}
