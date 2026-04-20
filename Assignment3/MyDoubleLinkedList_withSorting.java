package Assignment3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoubleLinkedList_withSorting<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyDoubleLinkedList_withSorting() {
        head = null;
        tail = null;
        size = 0;
    }

    public MyDoubleLinkedList_withSorting(T[] array) {
        this();
        for (T data : array) {
            addLast(data);
        }
    }

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private class MyDoubleLinkedListIterator implements Iterator<T> {
        private Node<T> current;

        public MyDoubleLinkedListIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int find(T data) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if ((data == null && current.data == null) ||
                (data != null && data.equals(current.data))) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // not found
    }

    public int lastIndexOf(T data) {
        Node<T> current = tail;
        int index = size - 1;
        while (current != null) {
            if ((data == null && current.data == null) ||
                (data != null && data.equals(current.data))) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1; // not found
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T data) {
        if (index <= 0) {
            addFirst(data);
            return;
        } 
        if (index >= size) {
            addLast(data);
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node<T> newNode = new Node<>(data);
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    public void addBefore(T target, T data) {
        Node<T> current = head;
        while (current != null && !((target == null && current.data == null) ||
                (target != null && target.equals(current.data)))) {
            current = current.next;
        }
        if (current == null) {
            throw new NoSuchElementException();
        }
        Node<T> newNode = new Node<>(data);
        newNode.next = current;
        newNode.prev = current.prev;
        if (current.prev != null) {
            current.prev.next = newNode;
        } else {
            head = newNode;
        }
        current.prev = newNode;
        size++;
    }

    public void addAfter(T target, T data) {
        Node<T> current = head;
        while (current != null && !((target == null && current.data == null) ||
                (target != null && target.equals(current.data)))) {
            current = current.next;
        }
        if (current == null) {
            throw new NoSuchElementException();
        }
        Node<T> newNode = new Node<>(data);
        newNode.prev = current;
        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        current.next = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return data;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T data = current.data;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return data;
    }

    public T removeBefore(T target) {
        Node<T> current = head;
        while (current != null && !((target == null && current.data == null) ||
                (target != null && target.equals(current.data)))) {
            current = current.next;
        }
        if (current == null || current.prev == null) {
            throw new NoSuchElementException();
        }
        T data = current.prev.data;
        if (current.prev.prev != null) {
            current.prev.prev.next = current;
        } else {
            head = current;
        }
        current.prev = current.prev.prev;
        size--;
        return data;
    }

    public T removeAfter(T target) {
        Node<T> current = head;
        while (current != null && !((target == null && current.data == null) ||
                (target != null && target.equals(current.data)))) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            throw new NoSuchElementException();
        }
        T data = current.next.data;
        if (current.next.next != null) {
            current.next.next.prev = current;
        } else {
            tail = current;
        }
        current.next = current.next.next;
        size--;
        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(T data) {
        return find(data) != -1;
    }

    public T set(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T oldData = current.data;
        current.data = data;
        return oldData;
    }

    public Iterator<T> iterator() {
        return new MyDoubleLinkedListIterator();
    }

    public int size() {
        return size;
    }

    // Insertion sort method that sorts the list in increasing order without using indexing
    public void insertionSort() {
        if (size <= 1) {
            return; // No need to sort
        }
        Node<T> loop_position = head.next;
        while (loop_position != null) {
            T key = loop_position.data; // Store the current element to be compared
            loop_position.prev.next = loop_position.next; // Remove the current element from the list
            if (loop_position.next != null) {
                loop_position.next.prev = loop_position.prev;
            } else {
                tail = loop_position.prev; // Update tail if we are removing the last element
            }
            Node<T> j = loop_position.prev;
            while (j != null && j.data.compareTo(key) > 0) {
                j = j.prev;
            }
            // Insert the key at its correct position in the sorted subarray
            if (j == null) {
                // Insert at the beginning
                head.prev = new Node<>(key);
                head.prev.next = head;
                head = head.prev;
            } else {
                // Insert after j
                Node<T> newNode = new Node<>(key);
                newNode.next = j.next;
                newNode.prev = j;
                if (j.next != null) {
                    j.next.prev = newNode;
                } else {
                    tail = newNode; // Update tail if we are inserting at the end
                }
                j.next = newNode;
            }
            loop_position = loop_position.next; // Move to the next element
        }
    }
}