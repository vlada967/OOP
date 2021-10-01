package ru.nsu.fit.oop.task1_1_1;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

class HeapSortTest {
    @Test
    void testEmpty() {
        int input[] = new int[] {};
        int output[] = new int[] {};
        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);    }

    @Test
    void testOneNumber() {
        int input[] = new int[] {1};
        int output[] = new int[] {1};
        HeapSort.sort(input);
        Assertions.assertArrayEquals(input, output);    }

    @Test
    void testNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    HeapSort.sort(null);
                });
    }

    @ParameterizedTest
    @MethodSource("SortingArrays")
    void SortingArrays(int a, int b, int c, int d, int e) {
        int input1[] = new int[] {a, b, c, d, e};
        int input2[] = new int[] {a, b, c, d, e};
        HeapSort.sort(input1);
        Arrays.sort(input2);
        Assertions.assertArrayEquals(input1, input2);
    }
    private static Stream<Arguments> SortingArrays() {
        return Stream.of(
                Arguments.of(5, 4, 3, 2, 1),
                Arguments.of(6, -1, 3, -27, 0),
                Arguments.of(1000000000, 2, 3, 4, 0)
        );
        }
    }
