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
    void testNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    HeapSort.sort(null);
                });
    }

    @ParameterizedTest
    @MethodSource("sorting")
    void sortingArrays(int[] input1) {
        int input2[] = new int[input1.length];
        System.arraycopy(input1, 0, input2, 0, input1.length);
        HeapSort.sort(input2);
        Arrays.sort(input1);
        Assertions.assertArrayEquals(input1, input2);
    }
    private static Stream<Arguments> sorting() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 3, 2, 1}),
                Arguments.of(new int[]{6, -1, 3, -27, 0}),
                Arguments.of(new int[]{1000000000, 2, 3, 4, 0}),
                Arguments.of(new int[]{1}),
                Arguments.of(new int[]{})
        );
        }
    }
