package ru.nsu.fit.oop.task1_3_2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GradeBookTest {

    @Test
    public void testFirstRecordBook() {
        GradeBook book = new GradeBook(200708, "Vlada", "Arkhipova", "Computer science and system design", 3);
        book.addAttestation(1, "Introduction to algebra and analysis", 5, "Vaskevich");
        book.addAttestation(1, "Introduction to discrete mathematics", 5, "Vlasov");
        book.addAttestation(1, "Declarative programming", 4, "Vlasov");
        book.addAttestation(1, "Imperative programming", 4, "Nesterenko");
        book.addAttestation(1, "Physical education", 5, "Zaharova");

        book.addAttestation(2, "Introduction to algebra and analysis", 4, "Vaskevich");
        book.addAttestation(2, "Introduction to discrete mathematics", 5, "Vlasov");
        book.addAttestation(2, "Declarative programming", 4, "Vlasov");
        book.addAttestation(2, "Imperative programming", 3, "Nesterenko");
        book.addAttestation(2, "English", 4, "Khotskina");
        book.addAttestation(2, "Physical education", 5, "Zaharova");

        double expected = 48 / 11;
        double actual = book.getAverageScore();
        assertEquals(expected, actual);
        assertFalse(book.hasHighScholarship());
        assertFalse(book.hasHonorsDegree());
    }
}