package com.example.unhackproject;

import java.util.ArrayList;
import java.util.HashMap;

public class CoursePlatform {

    /*
     * This object is only created one in the MainActivity.
     * The platform keeps track of all the students and all the courses each one takes.
     * The platform keeps track of all the professors and all the courses they are teaching.
     * The platform assigns identification numbers to both the student and professors.
     */
    private HashMap<Integer, ArrayList<String>> professorMap; //HashMap of all the professors. Key is professor identification number, value is the ArrayList of courses they are teaching.
    private ArrayList<String> coursesTeachingList; //arrayList of all the courses the professor

    private HashMap<Integer, ArrayList<String>> studentMap; //HashMap of all the students. Key is the student identification number, value if the ArrayList of courses they are taking.
    private ArrayList<String> coursesTakenList;

    private int identificationNumber;
    //polymorphism in which the professor and student subclasses extend the UniversityMember superclass.
    UniversityMember professor;
    UniversityMember student;

    public CoursePlatform(){
        this.studentMap = new HashMap<>();
        this.coursesTakenList = new ArrayList<>();

        this.professorMap = new HashMap<>();
        this.coursesTeachingList = new ArrayList<>();
    }

    public void setUniMemberIdentification(UniversityMember uniMember,int identificationNumber){

        if(uniMember instanceof Student ){
            this.student = new Student(identificationNumber,studentMap, coursesTakenList);

            this.identificationNumber = identificationNumber;

        } else if (uniMember instanceof Professor ) {
            this.professor = new Professor(identificationNumber,professorMap, coursesTeachingList);

            this.identificationNumber = identificationNumber;

        }

    }

    //all the courses offered by the professor.
    public ArrayList<String> getCoursesOfferedList(){
        return this.coursesTeachingList;
    }

    //all the courses taken by the student.
    public ArrayList<String> getCoursesTakenList(){
        return this.coursesTakenList;
    }

    public void teachCourse(String courseTeaching){
        this.professor.teachCourse(this.identificationNumber, courseTeaching);
    }

    public void enrollCourse(int profIdentificationNumber, String courseTaking){
        this.student.enrollCourse(profIdentificationNumber, this.professorMap,courseTaking);

    }










}
