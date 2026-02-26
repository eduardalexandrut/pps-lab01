package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private static final int MAX_CAPACITY = 5;
    private CircularQueue queue;

    @BeforeEach
    public void init() {
        this.queue = new CircularQueueImpl(MAX_CAPACITY);
    }

    @Test
    public void queShouldBeInitializedEmpty() {
        Assertions.assertTrue(this.queue.isEmpty());
    }

    @Test
    public void queEnqueueShouldAddAnElementToTheRear() {
        final int elementToPush = 10;
        this.queue.enqueue(elementToPush);
        Assertions.assertEquals(elementToPush, this.queue.peek());
    }

    @Test
    public void queDequeueShouldReturnTheElementFromTheFront() {
        final int elementToPush = 10;
        this.queue.enqueue(elementToPush);
        final int dequeuedElement = this.queue.dequeue();
        Assertions.assertEquals(elementToPush, dequeuedElement);
    }

    @Test
    public void queShouldRemoveTheOldestElementWhenWeExceedingTheCapacity() {
        final List<Integer> numbersToAdd = IntStream.rangeClosed(0, MAX_CAPACITY)
                .boxed()
                .toList();
        final int newNumberAtTheFront = 5;

        for (final var number : numbersToAdd) {
            this.queue.enqueue(number);
        }

        this.queue.enqueue(newNumberAtTheFront);
        Assertions.assertEquals(newNumberAtTheFront, this.queue.peek());
    }

    @Test
    public void queSizeShouldNeverExceedTheCapacity() {
        final List<Integer> numbersToAdd = IntStream.rangeClosed(0, MAX_CAPACITY * MAX_CAPACITY)
                .boxed()
                .toList();

        for (final var number : numbersToAdd) {
            this.queue.enqueue(number);
        }

        Assertions.assertEquals(MAX_CAPACITY, this.queue.size());
    }


}
