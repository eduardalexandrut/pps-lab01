package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  <br>
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  <br>
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {
    /**
     * Checks if the queue is empty
     *
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Adds an element to the rear of the queue
     *
     * @param element to be added
     */
    void enqueue(int element);

    /**
     * Returns the element from the front of the queue
     *
     * @return element from the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    int dequeue();

    /**
     * Should show the element at the front of the queue.
     *
     * @return the element at the front of the queue
     */
    int peek();

    /**
     * Should show the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    int size();
}