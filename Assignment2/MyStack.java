package Assignment2;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack {
    private ArrayList<Integer> stack;

    public MyStack() {
        // Initializes an empty stack.
        stack = new ArrayList<>();
    }
    
    public void push(int value) {
        // Adds an element to the top of the stack.
        stack.add(value);
    }

    public int pop() {
        /*
        Removes and returns the element at the top of the stack.
        Throws an EmptyStackException if the stack is empty.
        */
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    public int peek() {
        /*
        Returns the element at the top of the stack without removing it.
        Throws an EmptyStackException if the stack is empty.
        */
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        // Returns true if the stack is empty, false otherwise.
        return stack.isEmpty();
    }

    public int size() {
        // Returns the number of elements in the stack.
        return stack.size();
    }

    public double average() {
        /*
        Calculates the average of all elements in the stack.
        Throws an EmptyStackException if the stack is empty.
        */
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
