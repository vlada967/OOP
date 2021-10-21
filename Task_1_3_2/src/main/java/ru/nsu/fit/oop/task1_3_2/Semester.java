package ru.nsu.fit.oop.task1_3_2;

import java.util.HashMap;

record Subject(String name, int grade, String teacher) {
}

public class Semester {
    private HashMap<String, Subject> subjects;

    private double sumOfGrades;
    private double numberOfSubjects;
    private int semesterNumber;

    public Semester(int semesterNumber) {
        this.semesterNumber = semesterNumber;
        this.numberOfSubjects = 0.0;
        this.sumOfGrades = 0.0;
        this.subjects = new HashMap<>();
    }

    public Semester() {}

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public double getNumberOfSubjects() {
        return numberOfSubjects;
    }

    public double getSumOfGrades() {
        return sumOfGrades;
    }

    public Subject getSubjectByName(String name) {
        Subject subject = null;
        if (subjects.containsKey(name)) {
            subject = subjects.get(name);
        }
        return subject;
    }

    public void addAttestation(int currentSemester, String name, int grade, String teacher) {
        if (subjects.containsKey(name)) {
            System.out.println("You cannot overwrite the attestation results.");
            return;
        }
        numberOfSubjects++;
        sumOfGrades += grade;
        Subject subject = new Subject(name, grade, teacher);
        subjects.put(name, subject);
    }

}
