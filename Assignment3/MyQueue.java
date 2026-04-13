package Assignment3;

import java.util.LinkedList;

public class MyQueue<T> {
    private LinkedList<T> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void enqueue(T item) {
        queue.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue.removeFirst();
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue.getFirst();
    }

    public int size() {
        return queue.size();
    }

    public void empty() {
        queue.clear();
    }

    public String toString() {
        // Only using enqueue, dequeue, peek, and empty methods to build the string representation
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            T item = dequeue();
            sb.append(item).append(" ");
            enqueue(item); // Re-enqueue the item to maintain the original order
        }
        return sb.toString().trim();
    }

    public T move_to_rear() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T item = dequeue();
        enqueue(item);
        return item;
    }
}