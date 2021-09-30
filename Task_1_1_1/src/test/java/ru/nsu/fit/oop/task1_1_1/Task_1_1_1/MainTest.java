package ru.nsu.fit.oop.task1_1_1.Task_1_1_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void test_first() {
        int input[] = new int[] {5, 4, 3, 2, 1};
        int output[] = new int[] {1, 2, 3, 4, 5};
        Main.sort(input);
        Assertions.assertArrayEquals(input, output);
    }

    @Test
    void test_negative_numbers() {
        int input[] = new int[] {6, -1, 3, -27, 0};
        int output[] = new int[] {-27, -1, 0, 3, 6};
        Main.sort(input);
        Assertions.assertArrayEquals(input, output);    }

    @Test
    void test_empty() {
        int input[] = new int[] {};
        int output[] = new int[] {};
        Main.sort(input);
        Assertions.assertArrayEquals(input, output);    }

    @Test
    void test_one_number() {
        int input[] = new int[] {1};
        int output[] = new int[] {1};
        Main.sort(input);
        Assertions.assertArrayEquals(input, output);    }

    @Test
    void test_big_number() {
        int input[] = new int[] {1000000000, 2, 3, 4};
        int output[] = new int[] {2, 3, 4, 1000000000};
        Main.sort(input);
        Assertions.assertArrayEquals(input, output);    }

}