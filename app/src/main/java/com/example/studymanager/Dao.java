package com.example.studymanager;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
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
    @Query("DELETE FROM full_table")
    void deleteAllCourses();

    // Select all papers
    @Query("SELECT * FROM full_table ORDER BY id ASC")
    LiveData<List<CourseModal>> getAllCourses();

}
