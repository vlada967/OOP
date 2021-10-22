package ru.nsu.fit.oop.task1_2_1;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Class that implements the work of the stack.
 * @param <T> type of the elements.
 */
public class MyStack<T> implements Iterable<T> {

    private T[] stack;
    private int count;
    private final static int DEFAULT_CAPACITY = 100;

    public MyStack(int capacity) {
        count = 0;
        stack = (T[]) Array.newInstance(Object.class, capacity);
    }

    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Method that pushes the element to the stack.
     *
     * @param element - element that we need to put in the stack.
     */
    public void push(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (count == stack.length) {
            stack = grow(stack.length * 2);
        }
        stack[count] = element;
        count++;
    }

    private T[] grow(int newCapacity) {
        return Arrays.copyOf(stack, newCapacity);
    }

    /**
     * Method that gets element from the stack.
     *
     * @return element of the stack if it exists, otherwise throws exception.
     * @throws EmptyStackException if the stack is empty.
     */
    public T pop() {
        if (count == 0) {
            throw new EmptyStackException();
        }
        T value = stack[--count];
        stack[count] = null;
        return value;
    }

    /**
     * Method that pushes the elements to the stack.
     *
     * @param src - elements that we need to put in the stack
     */
    public void pushStack(MyStack<T> src) {
        final int amount = src.size();
        if (amount == 0)
            return;
        if (count == stack.length) {
            stack = grow(stack.length * 2);
        }
        stack = Arrays.copyOf(stack, stack.length);
        for (int i = count + amount - 1; i > count - 1; i--) {
            stack[i] = src.pop();
        }
        count += amount;
    }

    /**
     * Method that gets elements from the stack.
     *
     * @return elements of the stack
     * @throws IllegalArgumentException if the input is incorrect.
     * @throws EmptyStackException      if the stack is empty.
     */
    public MyStack<T> popStack(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
        if (amount > count) {
            throw new EmptyStackException();
        }
        MyStack<T> result = new MyStack<>();
        for (int i = count - amount; i < count; i++) {
            result.push(this.stack[i]);
            this.stack[i] = null;
        }
        count -= amount;
        return result;
    }

    /**
     * Method that gets amount of elements in the stack.
     *
     * @return amount of pushed elements in the stack.
     */
    public int size() {
        return count;
    }

    /**
     * Implementation of the Iterator for the stack.
     *
     * @return next element of the stack.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index != count;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return stack[index++];
            }
        };
    }
}
