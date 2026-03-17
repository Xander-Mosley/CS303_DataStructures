package Assignment2;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack {
    private ArrayList<Integer> stack;

    public MyStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int value) {
        stack.add(value);
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public double average() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        double sum = 0;
        for (int value : stack) {
            sum += value;
        }
        return sum / stack.size();
    }
}
