package ru.nsu.fit.oop.task1_3_2;

public class GradeBook {
    private int id;
    private final Student student;
    private double averageScore;
    private Semester[] semesters;
    private Diploma diploma;

    /**
     * The method that creates the grade book
     * @param id - id of the grade book
     * @param studentName - name of the student
     * @param studentSurname - surname of the student
     * @param studentSpeciality - speciality (faculty) of the student
     * @param currentSemester - current semester of the studying
     * @throws IllegalArgumentException
     */
    public GradeBook(int id, String studentName, String studentSurname, String studentSpeciality, int currentSemester) throws IllegalArgumentException {
        if (id < 0) {
            throw new IllegalArgumentException("Record book number cannot be negative.");
        }
        if (studentName == null || studentName.equals("")) {
            throw new IllegalArgumentException("You have not provided the student's name.");
        }
        if (studentSurname == null || studentSurname.equals("")) {
            throw new IllegalArgumentException("You have not provided the student's surname.");
        }
        if (studentSpeciality == null || studentSpeciality.equals("")) {
            throw new IllegalArgumentException("You have not provided the student's speciality.");
        }
        if (currentSemester <= 0) {
            throw new IllegalArgumentException("Semester number cannot be less or equal than zero.");
        }
        if (currentSemester > 10) {
            throw new IllegalArgumentException("Semester number cannot be more than ten.");
        }
        this.id = id;
        this.student = new Student(studentName, studentSurname, studentSpeciality, currentSemester);
        this.semesters = new Semester[10];
        this.diploma = new Diploma();
        this.averageScore = 0.0;
    }

    /**
     * The method for getting an average score of the grades
     * @return - average score
     */
    public double getAverageScore() {
        calculateAverageScore();
        return averageScore;
    }

    /**
     * The method for calculating an average score of the grades
     */
    private void calculateAverageScore() {
        double sumOfGrades = 0.0;
        double numberOfSubjects = 0.0;
        for (Semester semester : semesters) {
            if (semester != null) {
                sumOfGrades += semester.getSumOfGrades();
                numberOfSubjects += semester.getNumberOfSubjects();
            }
        }
        averageScore = sumOfGrades / numberOfSubjects;
    }

    /**
     * The method for adding a qualifying work in diploma
     * @param topic - topic of the qualifying work
     * @param grade - grade of the qualifying work
     * @param teacher - supervisor of the qualifying work
     */
    public void setQualifyingWork(String topic, int grade, String teacher) {
        diploma.setQualifyingWork(topic, grade, teacher);
    }

    /**
     * Method to check whether the diploma is with honors
     * @return true if the diploma is with honors; false otherwise
     */
    public boolean hasHonorsDegree() {
        return diploma.isHonorsDegree();
    }

    /**
     * Method to check whether the student has high scholarship
     * @return true if the student has high scholarship; false otherwise
     */
    public boolean hasHighScholarship() {
        if (student.getCurrentSemester() == 1) {
            return false;
        }
        int pastSemesterId = student.getCurrentSemester() - 1;
        Semester pastSemester = semesters[pastSemesterId];
        if (pastSemester == null) {
            System.out.println("No information about past semester.");
            return false;
        }
        int[] grades = pastSemester.getGrades(pastSemesterId);
        int l = pastSemester.getNumberOfSubjects();
        for (int i = 1; i <= l; i++) {
            if (grades[i] != 5) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to add the attestation (exam or credit) to the grade book
     * @param currentSemester - semester when the subject was studied
     * @param name - name of the subject
     * @param grade - grade for the exam or credit
     * @param teacher - teacher of the subject
     */
    public void addAttestation(int currentSemester, String name, int grade, String teacher){
        if (semesters[currentSemester] == null) {
            semesters[currentSemester] = new Semester();
        }
        semesters[currentSemester].addAttestation(currentSemester, name, grade, teacher);
        diploma.addSubjectToSupplement(name, grade, teacher);
    }
}
