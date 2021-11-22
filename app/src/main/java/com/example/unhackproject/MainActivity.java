package com.example.unhackproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.ui.AppBarConfiguration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    LinearLayout linearLayout;

    CoursePlatform platform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        this.constraintLayout = (ConstraintLayout) findViewById(R.id.container);
        this.linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
//        NavController navController = Navigation.findNavController(this, R.id.navigation_home);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);


        /*
         * suppose for now the professor identification number starts with 422...
         * suppose for now the student identification number starts with 218...
         * student was added to 5 courses by the professor.
         * A professor inheritance will be added, but now the courses are assumed.
         * 1.EECS 2001
         * 2.EECS 2030
         * 3.MATH 1090
         * 4.EECS 2031
         * 5.EECS 2011
         */
        platform = new CoursePlatform(); //the platform object will only be created once since to prevent re-initialization of variables.
        platform.setUniMemberIdentification(new Professor(),412);
        platform.teachCourse( "EECS 2001");
        platform.teachCourse( "EECS 2030");
        platform.teachCourse( "MATH 1090");
        platform.teachCourse( "EECS 2031");
        platform.teachCourse( "EECS 2011");

        //enrolling the student to all the professors courses.
        ArrayList<String> coursesOfferedList =  platform.getCoursesOfferedList();
        platform.setUniMemberIdentification(new Student(),218);
        for(int i = 0; i < coursesOfferedList.size(); i++) {
            platform.enrollCourse(412,coursesOfferedList.get(i));
        }

        ArrayList<String> coursesTakenList =  platform.getCoursesTakenList();
        for(int i = 0; i < coursesTakenList.size(); i++) {
            addCourses(coursesOfferedList.get(i));
        }
    }


    public void addCourses(String courseName){

        //inflate the cardview to make it appear on screen.
        final View cardView = getLayoutInflater().inflate(R.layout.user_card, null);

        //set the course name to the given course name from the method.
        TextView courseNameLabel = (TextView) cardView.findViewById(R.id.courseNameLabel);
        courseNameLabel.setText(courseName);

        //add the cardview to the screen.
        linearLayout.addView(cardView);

        //calendar image button
        ImageButton calendarImageButton = cardView.findViewById(R.id.calendarCardImageButton);

        calendarImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do stuff with the calendar.
            }
        });



    }
}