package ru.nsu.fit.oop.unitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsu.fit.oop.task2_1_1.NotPrimeSearch;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class NotPrimeSearchTest {
    @Test
    public void isPrimeNegativeNumber() {
        Assertions.assertFalse(new NotPrimeSearch().isPrime(-10));
    }

    @Test
    public void isPrimeSmallNumber() {
        assertTrue(new NotPrimeSearch().isPrime(3));
    }

    @Test
    public void isPrimeEvenNumber() {
        assertFalse(new NotPrimeSearch().isPrime(200));
    }

    @Test
    public void isPrimeLargePrimeNumber() {
        assertTrue(new NotPrimeSearch().isPrime(1073676287));
    }

    @Test
    public void isPrimeLargeNotPrimeNumber() {
        assertFalse(new NotPrimeSearch().isPrime(16217903));
    }

    @Test
    public void searchThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new NotPrimeSearch().search(null));
    }

    @Test
    public void searchSmallData1() throws ExecutionException, InterruptedException {
        int size = 100;
        int[] array = new int[size];
        Arrays.fill(array, 0, size, 17);
        assertFalse(new NotPrimeSearch().search(array));
    }

    @Test
    public void searchSmallData2() throws ExecutionException, InterruptedException {
        int size = 100;
        int[] array = new int[size];
        Arrays.fill(array, 0, size - 1, 13);
        array[size - 1] = 150;
        assertTrue(new NotPrimeSearch().search(array));
    }

    @Test
    public void searchLargeData1() throws ExecutionException, InterruptedException {
        int size = 1000000;
        int[] array = new int[size];
        Arrays.fill(array, 0, size, 16127);
        assertFalse(new NotPrimeSearch().search(array));
    }

    @Test
    public void searchLargeData2() throws ExecutionException, InterruptedException {
        int size = 1000000;
        int[] array = new int[size];
        Arrays.fill(array, 0, size - 1, 32469);
        array[size - 1] = 91374922;
        assertTrue(new NotPrimeSearch().search(array));
    }
}