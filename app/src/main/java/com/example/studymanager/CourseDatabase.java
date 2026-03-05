package com.example.studymanager;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.studymanager.database.AssessmentsModal;
import com.example.studymanager.database.CourseModal;
import com.example.studymanager.database.SemesterModal;
import com.example.studymanager.database.TimetableModal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Database entries for the app
@Database(entities = {CourseModal.class, SemesterModal.class, TimetableModal.class, AssessmentsModal.class},
          version = 1,
          exportSchema = false)
public abstract class CourseDatabase extends RoomDatabase {
    // Instance of database
    private static CourseDatabase instance;
    // Abstract database object
    public abstract Dao Dao();

    // Create a fixed thread pool to handle background database operations
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    // Getting instance of database
    public static synchronized CourseDatabase getInstance(Context context) {
        // Check if the instance is null
        if (instance == null) {
        instance = Room.databaseBuilder(context.getApplicationContext(),
                CourseDatabase.class, "course_database")
                .addCallback(roomCallback)
                .build();
        }
        return instance;
    }

    // Create a callback for the room database
    private static final RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // Populate the database
            databaseWriteExecutor.execute(() -> {
                Dao Dao = instance.Dao();
                // Populate the database

            });
        }
    };

}
