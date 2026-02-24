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
        stack.push(1);
        Assertions.assertEquals(elementToAdd, stack.peek());
    }
}