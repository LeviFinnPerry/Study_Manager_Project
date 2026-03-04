package com.example.studymanager;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

// Database entries for the app
@Database(entities = {CourseModal.class}, version = 1)
public abstract class CourseDatabase extends RoomDatabase {
    // Instance of database
    private static CourseDatabase instance;
    // Abstract database object
    public abstract Dao Dao();

    // Getting instance of database
    public static synchronized CourseDatabase getInstance(Context context) {
        // Check if the instance is null
        if (instance == null) {
        instance = Room.databaseBuilder(context.getApplicationContext(),
                CourseDatabase.class, "course_database")
                .fallbackToDestructiveMigration()
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
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    // Create the task to populate the database in the background
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private PopulateDbAsyncTask(CourseDatabase db) {
            Dao Dao = db.Dao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
