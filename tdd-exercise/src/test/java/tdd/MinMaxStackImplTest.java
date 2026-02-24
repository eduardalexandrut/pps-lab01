package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    private MinMaxStack stack;

    @BeforeEach
    void setUp() {
        stack = new MinMaxStackImpl();
    }

    @Test
    public void pushShouldAddAnElementOnTop() {
        final var elementToAdd = 1;
        stack.push(elementToAdd);
        Assertions.assertEquals(elementToAdd, stack.peek());
    }

    @Test
    public void popShouldReturnTheElementOnTop() {
        final var elementToPop = 1;
        stack.push(elementToPop);
        Assertions.assertEquals(elementToPop, stack.pop());
    }

    @Test
    public void peekShouldShowTheElementOnTopButNotRemoveIt() {
        final var elementToPeek = 1;
        stack.push(elementToPeek);
        final var size = stack.size();
        Assertions.assertEquals(elementToPeek, stack.peek());
        Assertions.assertEquals(size, stack.size());
    }

    @Test
    public void popOfAllElementsShouldLeaveTheStackEmpty() {
        final var elementToPush = 1;
        final var numberOfElementsToPush = 10;

        for (int i = 0; i < numberOfElementsToPush; i++) {
            stack.push(elementToPush);
        }

        for (int i = 0; i < numberOfElementsToPush; i++) {
            stack.pop();
        }

        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    public void getMinShouldReturnTheMin() {
        final var minElement = 1;

        for  (int i = 1; i < 10; i++) {
            stack.push(i);
        }

        Assertions.assertEquals(minElement, stack.getMin());
    }

    @Test
    public void getMaxShouldReturnTheMax() {
        final var maxElement = 10;

        for  (int i = 10; i > 1; i--) {
            stack.push(i);
        }

        Assertions.assertEquals(maxElement, stack.getMax());
    }
}