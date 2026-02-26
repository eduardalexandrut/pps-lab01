package tdd;

public class CircularQueueImpl implements CircularQueue {
    private int capacity;
    private int front;
    private int rear;
    private int[] items;
    private int size;

    public CircularQueueImpl(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
