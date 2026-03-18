package Assignment2;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nTesting SingleLinkedList...");
        testSingleLinkedList();

        System.out.println("\nTesting MyStack...");
        testMyStack();

        System.out.println("\n");
    }

    public static void testSingleLinkedList() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        System.out.println("Initial list: " + list);
        System.out.println("Is empty? " + list.isEmpty());

        // Edge case: removeFirst / removeLast on empty list
        try {
            list.removeFirst();
        } catch (NoSuchElementException e) {
            System.out.println("removeFirst on empty list throws: " + e.getMessage());
        }
        try {
            list.removeLast();
        } catch (NoSuchElementException e) {
            System.out.println("removeLast on empty list throws: " + e.getMessage());
        }

        // Add elements
        list.addFirst(10); // List: [10]
        list.addLast(20);  // List: [10, 20]
        list.addFirst(5);  // List: [5, 10, 20]
        System.out.println("After addFirst/addLast: " + list);

        // getFirst / getLast
        System.out.println("getFirst(): " + list.getFirst()); // 5
        System.out.println("getLast(): " + list.getLast());   // 20

        // insert at various positions
        list.insert(-3, 1);   // before start, acts like addFirst, List: [1, 5, 10, 20]
        list.insert(2, 7);   // middle, List: [1, 5, 7, 10, 20]
        list.insert(10, 25); // beyond end, acts like addLast, List: [1, 5, 7, 10, 20, 25]
        System.out.println("After inserts: " + list);

        // find existing and non-existing elements
        System.out.println("find(7): " + list.find(7));    // should return index 2
        System.out.println("find(100): " + list.find(100)); // not found, should return size 6

        // remove by index
        boolean removed = list.remove(0); // remove first element
        System.out.println("Removed index 0? " + removed + " -> " + list);
        removed = list.remove(list.size() - 1); // remove last element
        System.out.println("Removed last index? " + removed + " -> " + list);
        removed = list.remove(1); // remove middle element
        System.out.println("Removed middle index 1? " + removed + " -> " + list);
        removed = list.remove(10); // invalid index
        System.out.println("Removed invalid index 10? " + removed);

        // removeFirst / removeLast on non-empty list
        System.out.println("removeFirst(): " + list.removeFirst() + " -> " + list);
        System.out.println("removeLast(): " + list.removeLast() + " -> " + list);

        // isEmpty at the end
        System.out.println("Is list empty now? " + list.isEmpty());
    }

    public static void testMyStack() {
        MyStack stack = new MyStack();

        System.out.println("Initial stack is empty? " + stack.isEmpty());

        // Edge case: pop, peek, average on empty stack
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("pop on empty stack throws: " + e);
        }
        try {
            stack.peek();
        } catch (EmptyStackException e) {
            System.out.println("peek on empty stack throws: " + e);
        }
        try {
            stack.average();
        } catch (EmptyStackException e) {
            System.out.println("average on empty stack throws: " + e);
        }

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("After pushing 10,20,30 -> size: " + stack.size());

        // Peek at top element
        System.out.println("peek(): " + stack.peek()); // should be 30

        // Average
        System.out.println("average(): " + stack.average()); // should be 20.0

        // Pop elements
        System.out.println("pop(): " + stack.pop()); // removes 30
        System.out.println("pop(): " + stack.pop()); // removes 20
        System.out.println("After popping two elements -> size: " + stack.size());
        System.out.println("Stack is empty? " + stack.isEmpty());

        // Peek & average with one element
        System.out.println("peek(): " + stack.peek());    // should be 10
        System.out.println("average(): " + stack.average()); // should be 10.0

        // Pop last element
        System.out.println("pop(): " + stack.pop()); // removes 10
        System.out.println("Stack is empty? " + stack.isEmpty());

        // Edge case: pop again
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("pop on empty stack throws: " + e);
        }
    }
}
