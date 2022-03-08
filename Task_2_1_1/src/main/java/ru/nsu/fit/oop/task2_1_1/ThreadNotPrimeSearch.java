package ru.nsu.fit.oop.task2_1_1;

import java.util.*;
import java.util.concurrent.*;

public class ThreadNotPrimeSearch extends NotPrimeSearch {
    private Deque<Integer> deque;
    private final Callable<Boolean> SEARCH_NOT_PRIME_TASK = () -> {
        Integer number;
        while ((number = getNumber()) != null) {
            if (!isPrime(number)) {
                return true;
            }
        }
        return false;
    };

    private synchronized Integer getNumber() {
        if (deque.isEmpty()) {
            return null;
        }
        return deque.pop();
    }

    @Override
    public boolean search(int[] array) throws InterruptedException, NullPointerException {
        if (array == null) {
            throw new NullPointerException();
        }
        final int threadsNumber = Runtime.getRuntime().availableProcessors();
        deque = new ArrayDeque<>(Arrays.stream(array).boxed().toList());

        return Executors
                .newFixedThreadPool(threadsNumber)
                .invokeAll(Collections.nCopies(threadsNumber, SEARCH_NOT_PRIME_TASK))
                .stream()
                .anyMatch(future -> {
                    try {
                        return future.get(100, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException | ExecutionException | TimeoutException exception) {
                        throw new RuntimeException(exception);
                    }
                });
    }
}