package tdd;

public class CircularQueueImpl implements CircularQueue {
    private int capacity;
    private int front;
    private int rear;
    private int[] items;
    private int size;

    public CircularQueueImpl(int capacity) {
        this.capacity = capacity;
        this.items = new int[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(int element) {
        rear = (rear + 1) % capacity;
        this.items[rear] = element;
        if (size < capacity) {
            size = size + 1;
        }
    }

    @Override
    public int dequeue() {
        final int enqueuedElement = this.items[front];
        front = (front + 1) % capacity;
        size = size - 1;
        return enqueuedElement;
    }

    @Override
    public int peek() {
        return this.items[front];
    }

    @Override
    public int size() {
        return size;
    }

}
