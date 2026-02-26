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
        size = size + 1;
    }

    @Override
    public int peek() {
        return this.items[front];
    }

}
