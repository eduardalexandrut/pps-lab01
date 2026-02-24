package tdd;

import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {
    private final Stack<MinMaxEntry> stack = new Stack<>();

    record MinMaxEntry(int val, int min, int max) {
    }

    @Override
    public void push(int value) {
        if (stack.isEmpty()){
            stack.push(new MinMaxEntry(value, value, value));
        }
        final var currentMin = Math.min(stack.peek().min, value);
        final var currentMax = Math.max(stack.peek().max, value);
        stack.push(new MinMaxEntry(value, currentMin, currentMax));
    }

    @Override
    public int pop() {
        return stack.pop().val;
    }

    @Override
    public int peek() {
        return stack.peek().val;
    }

    @Override
    public int getMin() {
        return stack.peek().min;
    }

    @Override
    public int getMax() {
        return stack.peek().max;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
