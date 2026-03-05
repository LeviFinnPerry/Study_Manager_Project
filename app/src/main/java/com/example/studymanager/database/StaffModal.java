package com.example.studymanager.database;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "staff_table",
        foreignKeys = @ForeignKey(
                entity = CourseModal.class,     // The parent class
                parentColumns = "paperId",      // PK of parent
                childColumns = "paperId_fk",    // FK name
                onDelete = ForeignKey.CASCADE   // Dependency on paper
        ),
        indices = {@Index("paperId_fk")}
)
public class StaffModal {
    @PrimaryKey(autoGenerate = true)
    private int staffId;            // Unique ID
    private String staffName;       // Name of staff member
    private String staffEmail;      // Email of staff member
    private String staffRole;       // Role of staff member
    private int paperId_fk;         // Foreign key to paper table

    public StaffModal(String staffName, String staffEmail, String staffRole, int paperId_fk) {
        this.staffName = staffName;
        this.staffEmail = staffEmail;
        this.staffRole = staffRole;
        this.paperId_fk = paperId_fk;
    }

    // Getters and setters for staff table
    // Id
    public int getStaffId() {
        return staffId;
    }
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    // Name
    public String getStaffName() {
        return staffName;
    }
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    // Email
    public String getStaffEmail() {
        return staffEmail;
    }
    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }
    // Role
    public String getStaffRole() {
        return staffRole;
    }
    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }
    // Foreign key to paper
    public int getPaperId_fk() {
        return paperId_fk;
    }
    public void setPaperId_fk(int paperId_fk) {
        this.paperId_fk = paperId_fk;
    }
}
