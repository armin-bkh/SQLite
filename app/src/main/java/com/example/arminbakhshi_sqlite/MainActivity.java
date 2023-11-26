package com.example.arminbakhshi_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText courseName, courseTracks, courseDuration, coursetext;
    private Button CourseBtn;
    private Database database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        courseName = findViewById(R.id.idCourseName);
        courseTracks = findViewById(R.id.CourseTracks);
        courseDuration = findViewById(R.id.idCourseDuration);
        coursetext = findViewById(R.id.idCourseDescription);
        CourseBtn = findViewById(R.id.idBtnCourse);

        database = new Database(MainActivity.this);

        CourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseName = CourseBtn.getText().toString();
                String courseTrackss = courseTracks.getText().toString();
                String courseDurationn = courseDuration.getText().toString();
                String courseDescription = coursetext.getText().toString();

                if (courseName.isEmpty() &&
                        courseTrackss.isEmpty() &&
                        courseDurationn.isEmpty() &&
                        courseDescription.isEmpty()) {
                    Toast.makeText(
                            MainActivity.this,
                            "please Enter the information",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                database.addNewCourse(courseName,courseDescription,courseDescription,courseTrackss);
                Toast.makeText(MainActivity.this, "دوره اضافه شد", Toast.LENGTH_SHORT).show();
                CourseBtn.setText("");
                courseDuration.setText("");
                courseTracks.setText("");
                coursetext.setText("");
            }
        });

    }
}