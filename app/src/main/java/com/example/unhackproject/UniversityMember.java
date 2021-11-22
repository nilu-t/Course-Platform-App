package com.example.unhackproject;

/*
 * This class implements inheritance in which Professor and Student classes inherit from UniversityMembers.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class UniversityMember {

    /*
     * A university member can teach or enroll in a course.
     * The university assigns identification numbers to both the student and professors.
     */

    /*
     * As a university member you must be assigned an identification number.
     */
    int identificationNum;

    public UniversityMember(){

    }

    /**
     * This method sets the name of the professor or student.
     * @param identificationNum either the name of a professor or a student.
     */
    public UniversityMember(int identificationNum){
        this.identificationNum = identificationNum;

    }

    /**
     * This method creates the course being taught by the professor.
     * @param identificationNum of the professor.
     * @param courseTeaching of the professor.
     */
    public void teachCourse(int identificationNum, String courseTeaching) {
    }

    /**
     * This method creates the course being taken by the student.
     * @param identificationNum of the student.
     * @param courseTaking of the student.
     */
    public void enrollCourse(int identificationNum, HashMap<Integer, ArrayList<String>> professorMap, String courseTaking) {
    }
}

class Professor extends UniversityMember {

    private HashMap<Integer, ArrayList<String>> professorMap; //HashMap of all the professors. Key is professor identification number, value is the ArrayList of courses they are teaching.
    private ArrayList<String> coursesTeachingList; //arrayList of all the courses the professor

    public Professor(){

    }

    public Professor(int profIdentificationNum){
        super(profIdentificationNum);
    }

    public Professor(int identificationNumber,HashMap<Integer,ArrayList<String>> professorMap,ArrayList<String> coursesTeachingList){
        this(identificationNumber);
        this.professorMap = professorMap;
        this.coursesTeachingList = coursesTeachingList;
    }


    public void teachCourse(int identificationNum, String courseTeaching){
        this.coursesTeachingList.add(courseTeaching);
        this.professorMap.put(identificationNum, coursesTeachingList); //adding the professor identification number as the key. Also, the value of the HashMap is the ArrayList of all courses prof is teaching.
    }

}

class Student extends UniversityMember {

    private HashMap<Integer, ArrayList<String>> studentMap; //HashMap of all the students. Key is the student identification number, value if the ArrayList of courses they are taking.
    private ArrayList<String> coursesTakenList;

    public Student() {

    }

    public Student(int studentIdentificationNum){
        super(studentIdentificationNum);
    }

    public Student(int studentIdentificationNum,HashMap<Integer,ArrayList<String>> studentMap,ArrayList<String> coursesTakenList){
        this(studentIdentificationNum);
        this.studentMap = studentMap;
        this.coursesTakenList = coursesTakenList;
    }

    /**
     * This method adds the course the student is taking in the semester.
     * @param professorIdentificationNum is the professor the student is taking courses with.
     * @param courseTaking is the course the student is taking.
     */
    @Override
    public void enrollCourse(int professorIdentificationNum, HashMap<Integer, ArrayList<String>> professorMap, String courseTaking){
        this.studentMap.put(this.identificationNum, this.coursesTakenList); //adding the student identification number as the key. Also, the value of the HashMap is the ArrayList of all courses taken by the student.
        this.coursesTakenList = studentMap.get(this.identificationNum); //the ArrayList of all the courses the student has taken is the value of the HashMap in which the key is the student identification number.

        ArrayList<String> tempProfessorList = professorMap.get(professorIdentificationNum); //retrieving the value of HashMap which is the ArrayList of all courses the professor is teaching.

        boolean isProfTeachingCourse = false; //initially false.

        //iterating the temp professor list to check if the course the student taking is there.
        for(int i = 0; i < tempProfessorList.size(); i++){
            isProfTeachingCourse = isProfTeachingCourse || (courseTaking.equals(tempProfessorList.get(i)));
        }

        //if the professor is teaching the course and since the student is taking the course, then the student is taking the course with the professor.
        if(isProfTeachingCourse){
            //adding the courses the student took to the student respective ArrayList and the HashMap.
            this.coursesTakenList.add(courseTaking);
            this.studentMap.put(this.identificationNum,this.coursesTakenList);
        }
    }


}