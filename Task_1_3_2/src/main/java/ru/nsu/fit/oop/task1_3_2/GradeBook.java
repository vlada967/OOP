package ru.nsu.fit.oop.task1_3_2;

public class GradeBook extends Semester {
    private int id;
    private final Student student;
    private double averageScore;
    private Semester[] semesters;
    private Diploma diploma;

    public GradeBook(int id, String studentName, String studentSurname, String studentSpeciality, int currentSemester) throws IllegalArgumentException {
        super();
        if (id < 0) {
            throw new IllegalArgumentException("Record book record book number cannot be negative. ");
        }
        if (studentName == null || studentName.equals("")) {
            throw new IllegalArgumentException("You have not provided the student's name. ");
        }
        if (studentSurname == null || studentSurname.equals("")) {
            throw new IllegalArgumentException("You have not provided the student's surname. ");
        }
        if (studentSpeciality == null || studentSpeciality.equals("")) {
            throw new IllegalArgumentException("You have not provided the student's speciality. ");
        }
        if (currentSemester <= 0) {
            throw new IllegalArgumentException("ru.nsu.fit.oop.task1_3_2.Semester number cannot be less or equal than zero. ");
        }
        this.id = id;
        this.student = new Student(studentName, studentSurname, studentSpeciality, currentSemester);
        this.semesters = new Semester[8];
        this.diploma = new Diploma();
        this.averageScore = 0.0;
    }

    public double getAverageScore() {
        calculateAverageScore();
        return averageScore;
    }

    private double calculateAverageScore() {
        double sumOfGrades = 0.0;
        double numberOfSubjects = 0.0;
        for (Semester semester : semesters) {
            if (semester != null) {
                sumOfGrades += semester.getSumOfGrades();
                numberOfSubjects += semester.getNumberOfSubjects();
            }
        }
        return sumOfGrades / numberOfSubjects;
    }

    public boolean hasHonorsDegree() {
        return diploma.isHonorsDegree();
    }

    public boolean hasHighScholarship() {
        int pastSemesterId = student.getCurrentSemester() - 1;
        Semester pastSemester = semesters[pastSemesterId];
        if (pastSemester == null) {
            System.out.println("No information about past semester.");
            return false;
        }
        double result = pastSemester.getSumOfGrades() / pastSemester.getNumberOfSubjects();
        return result == 5.0;
    }
}
