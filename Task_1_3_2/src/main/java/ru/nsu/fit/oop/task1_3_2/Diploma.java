package ru.nsu.fit.oop.task1_3_2;

import java.util.HashMap;

record QualifyingWork(String topic, int grade, String teacher) {
}

public class Diploma {
    private QualifyingWork qualifyingWork;
    private HashMap<String, Subject> supplement;

    private double satisfactoryInRecordBook;
    private double excellentInSupplement;
    private double numberOfSubjects;

    public Diploma() {
        qualifyingWork = null;
        supplement = new HashMap<>();
        satisfactoryInRecordBook = 0.0;
        excellentInSupplement = 0.0;
        numberOfSubjects = 0.0;
    }

    public QualifyingWork getQualifyingWork() {
        return qualifyingWork;
    }

    public void addQualifyingWork(String topic, int grade, String teacher) {
        if (qualifyingWork != null) {
            System.out.println("You cannot change an existing qualifying work.");
            return;
        }
        qualifyingWork = new QualifyingWork(topic, grade, teacher);
    }

    public void addSubjectToSupplement(String name, int grade, String teacher) {
        if (grade == 5) {
            satisfactoryInRecordBook++;
        }
        if (!supplement.containsKey(name)) {
            numberOfSubjects++;
        } else {
            Subject inSupplement = supplement.get(name);
            if (inSupplement.grade() != grade && grade == 5) {
                excellentInSupplement++;
            }
        }
        Subject subject = new Subject(name, grade, teacher);
        supplement.put(name, subject);
    }

    public boolean isHonorsDegree() {
        if (satisfactoryInRecordBook != 0) return false;
        if (excellentInSupplement / numberOfSubjects < 0.75) return false;
        return qualifyingWork != null && qualifyingWork.grade() == 5;
    }
}
