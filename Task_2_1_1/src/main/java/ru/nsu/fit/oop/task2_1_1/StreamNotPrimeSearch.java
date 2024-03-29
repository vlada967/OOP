package ru.nsu.fit.oop.task2_1_1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamNotPrimeSearch extends NotPrimeSearch {
    @Override
    public boolean search(int[] array) throws NullPointerException {
        if (array == null) {
            throw new NullPointerException();
        }
        IntStream intStream = Arrays.stream(array);
        return !intStream.parallel().noneMatch(number -> isPrime(number));
    }
}
