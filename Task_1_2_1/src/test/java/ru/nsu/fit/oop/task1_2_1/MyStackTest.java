package ru.nsu.fit.oop.task1_2_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    int count = 70;
    private MyStack<Integer> stack;

    private void pushElements(MyStack<Integer> stack, int count) {
        for (int i = 0; i < count; i++) {
            stack.push(i);
        }
    }

    @BeforeEach
    public void initStack() {
        stack = new MyStack<>();
    }

    @Test
    void testPushThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> stack.push(null));
    }

    @Test
    void testPushNumberOfElements() {
        pushElements(this.stack, count);
        int actualCount = stack.size();
        assertEquals(count, actualCount);
    }

    @Test
    void testPushOrderOfElements() {
        pushElements(stack, count);
        count = 0;
        stack.forEach(element -> assertEquals(element, count++));
    }

    @Test
    void testPushStackNumberOfElements() {
        MyStack<Integer> temp = new MyStack<>();
        pushElements(temp, count);
        stack.pushStack(temp);
        int actualCount = stack.size();
        assertEquals(count, actualCount);
    }

    @Test
    void testPushStackOrderOfElements() {
        MyStack<Integer> temp = new MyStack<>();
        pushElements(temp, count);

        stack.pushStack(temp);

        for (int i = count - 1; i >= 0; i--) {
            int expectedElement = i;
            int actualElement = stack.pop();
            assertEquals(expectedElement, actualElement);
        }
    }

    @Test
    void testPopThrowsException() {
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void testPopNumberOfElements() {
        pushElements(this.stack, count);

        for (int i = count - 1; i >= 0; i--) {
            stack.pop();
            int expectedCount = i;
            int actualCount = stack.size();
            assertEquals(expectedCount, actualCount);
        }
    }

    @Test
    void testPopOrderOfElements() {
        pushElements(this.stack, count);

        for (int i = count - 1; i >= 0; i--) {
            int expectedElement = i;
            int actualElement = stack.pop();
            assertEquals(expectedElement, actualElement);
        }
    }

    @Test
    void testPopStackThrowsException() {
        assertThrows(EmptyStackException.class, () -> stack.popStack(1));
    }

    @Test
    void testPopStackNumberOfElements() {
        pushElements(this.stack, count);
        stack.popStack(count);
        int expectedCount = 0;
        int actualCount = stack.size();
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testPopStackOrderOfElements() {
        pushElements(this.stack, count);
        MyStack<Integer> result = stack.popStack(count);
        for (int i = count - 1; i >= 0; i--) {
            int expectedElement = i;
            int actualElement = result.pop();
            assertEquals(expectedElement, actualElement);
        }
    }

    @Test
    void testCount() {
        for (int i = 0; i < 70; i++) {
            stack.push(i);
            int expectedCount = i + 1;
            int actualCount = stack.size();
            assertEquals(expectedCount, actualCount);
        }
    }

    @Test
    void testIteratorHasNext() {
        Iterator<Integer> iterator = stack.iterator();
        assertFalse(iterator.hasNext());

        stack.push(1);
        iterator = stack.iterator();
        assertTrue(iterator.hasNext());
    }

    @Test
    void testIteratorNext() {
        pushElements(this.stack, count);
        Iterator<Integer> iterator = stack.iterator();
        for (int i = 0; i < count; i++) {
            int expectedNext = i;
            int actualNext = iterator.next();
            assertEquals(expectedNext, actualNext);
        }
    }
}