package ru.nsu.fit.oop.task1_3_2;

import java.util.HashMap;

record Subject(String name, int grade, String teacher) {
}

public class Semester {
    private HashMap<String, Subject> subjects;
    private double sumOfGrades;
    private double numberOfSubjects;

    public Semester() {
        this.numberOfSubjects = 0.0;
        this.sumOfGrades = 0.0;
        this.subjects = new HashMap<>();
    }

    /**
     * Method to get the number of subjects
     * @return the number of subjects
     */
    public double getNumberOfSubjects() {
        return numberOfSubjects;
    }

    /**
     * Method to get the sum of the grades
     * @return the sum of the grades
     */
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
    /**
     * Method to add the attestation (exam or credit) to the grade book
     * @param currentSemester - semester when the subject was studied
     * @param name - name of the subject
     * @param grade - grade for the exam or credit
     * @param teacher - teacher of the subject
     */
    public void addAttestation(int currentSemester, String name, int grade, String teacher) {
        numberOfSubjects++;
        sumOfGrades += grade;
        Subject subject = new Subject(name, grade, teacher);
        subjects.put(name, subject);
    }
}
