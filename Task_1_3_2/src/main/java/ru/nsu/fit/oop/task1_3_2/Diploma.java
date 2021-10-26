package ru.nsu.fit.oop.task1_3_2;

import java.util.HashMap;

record QualifyingWork(String topic, int grade, String teacher) {
}

public class Diploma {
    private QualifyingWork qualifyingWork;
    private HashMap<String, Subject> supplement;
    private int satisfactoryInGradeBook;
    private int excellentInSupplement;
    private int numberOfSubjects;

    public Diploma() {
        qualifyingWork = null;
        supplement = new HashMap<>();
        satisfactoryInGradeBook = 0;
        excellentInSupplement = 0;
        numberOfSubjects = 0;
    }

    /**
     * Method to get the qualifying work
     * @return qualifying work
     */
    public QualifyingWork getQualifyingWork() {
        return qualifyingWork;
    }

    /**
     *  Method to set the qualifying work to the grade book
     * @param topic - topic of the qualifying work
     * @param grade - grade for the qualifying work
     * @param teacher - supervisor of the qualifying work
     */
    public void setQualifyingWork(String topic, int grade, String teacher) {
        if (qualifyingWork != null) {
            System.out.println("You cannot change an existing qualifying work.");
            return;
        }
        qualifyingWork = new QualifyingWork(topic, grade, teacher);
    }

    /**
     * Method to add the subject to supplement
     * @param name - name of the subject
     * @param grade - grade for the subject
     * @param teacher - examinator
     */
    public void addSubjectToSupplement(String name, int grade, String teacher) {
        if (grade == 3) {
            satisfactoryInGradeBook = 1;
        }
        if (!supplement.containsKey(name)) {
            numberOfSubjects++;
            if (grade == 5) {
                excellentInSupplement++;
            }
        } else {
            Subject inSupplement = supplement.get(name);
            if (inSupplement.grade() == 5) {
                excellentInSupplement--;
            }
            if (grade == 5) {
                excellentInSupplement++;
            }
        }
        Subject subject = new Subject(name, grade, teacher);
        supplement.put(name, subject);
    }

    /**
     * Method to check whether the diploma is with honors
     * @return true if the diploma is with honors; false otherwise
     */
    public boolean isHonorsDegree() {
        if (satisfactoryInGradeBook != 0) return false;
        if (excellentInSupplement / numberOfSubjects < 0.75) return false;
        return qualifyingWork != null && qualifyingWork.grade() == 5;
    }
}
