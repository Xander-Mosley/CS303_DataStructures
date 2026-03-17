package Structures;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class MySingleLinkedList<T> implements Iterable<T> {
    /*
    The head of the linked list, which points to the first node.
    The tail of the linked list, which points to the last node.
    The size of the linked list, which keeps track of the number of nodes in the list.
    */
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MySingleLinkedList() {
        // Initializes an empty linked list by setting head and tail to null and size to 0.
        head = tail = null;
        size = 0;
    }

    public MySingleLinkedList(T[] array) {
        // Initializes the linked list with the elements from the provided array.
        this(); // Calls the default constructor to avoid skipping initialization if the default constructor changes.
        for (T data : array) {
            addLast(data);
        }
    }

    private static class Node<T> {
        // The data stored in the node and the reference to the next node in the list.
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private class MySingleLinkedListIterator implements Iterator<T> {
        // Inner class that implements the Iterator interface to allow for iteration over the linked list.
        private Node<T> current;

        public MySingleLinkedListIterator() {
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
        /*
        Checks if the size is 0 to determine if the list is empty.
        Returns true if the list contains no elements, false otherwise.
        */
        return size == 0;
    }

    public T getFirst() {
        /*
        Returns the first element in the list.
        Throws a NoSuchElementException if the list is empty.
        */
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }

    public T getLast() {
        /*
        Returns the last element in the list.
        Throws a NoSuchElementException if the list is empty.
        */
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.data;
    }

    public T get(int index) {
        /*
        Returns the element at the specified index in the list.
        Throws an IndexOutOfBoundsException if the index is out of bounds.
        */
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
        /*
        Finds the first occurrence of the specified element in the list.
        Returns the index of the element if found, otherwise returns the size of the list.
        */
        Node<T> current = head;
        int index = 0;
        // Uses a while loop incase the size value ever gets corrupted
        while (current != null) {
            // Handles null values correctly by checking for null before calling equals function.
            if ((data == null && current.data == null) ||
                (data != null && data.equals(current.data))) {
                return index;
            }
            current = current.next;
            index++;
        }
        return size; // Not found
    }

    public int lastIndexOf(T data) {
        /*
        Finds the last occurrence of the specified element in the list.
        Returns the index of the element if found, otherwise returns -1.
        */
        Node<T> current = head;
        int lastIndex = -1;
        int index = 0;
        // Uses a while loop incase the size value ever gets corrupted
        while (current != null) {
            // Handles null values correctly by checking for null before calling equals function.
            if ((data == null && current.data == null) ||
                (data != null && data.equals(current.data))) {
                lastIndex = index;
            }
            current = current.next;
            index++;
        }
        return lastIndex; // Not found
    }

    public void addFirst(T data) {
        // Adds a new element at the beginning of the list using the provided data.
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        // Adds a new element at the end of the list using the provided data.
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T data) {
        // Inserts a new element at the specified index in the list using the provided data.
        if (index <= 0) {
            addFirst(data);
            return;
        } 
        if (index >= size) {
            addLast(data);
            return;
        }
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public void addBefore(T prior, T data) {
        /*
        Adds the specified element before the first occurrence of the specified prior element in the list.
        Throws a NoSuchElementException if the prior element is not found.
        */
        if (isEmpty()) {
            addFirst(data);
            return;
        }
        if ((prior == null && head.data == null) ||
            (prior != null && prior.equals(head.data))) {
            addFirst(data);
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            if ((prior == null && current.next.data == null) ||
                (prior != null && prior.equals(current.next.data))) {
                Node<T> newNode = new Node<>(data);
                newNode.next = current.next;
                current.next = newNode;
                size++;
                return;
            }
            current = current.next;
        }
        throw new NoSuchElementException("Node with data " + prior + " not found");
    }

    public void addAfter(T prior, T data) {
        /*
        Adds the specified element after the first occurrence of the specified prior element in the list.
        Throws a NoSuchElementException if the prior element is not found.
        */
        if (isEmpty()) {
            addFirst(data);
            return;
        }
        if ((prior == null && tail.data == null) ||
            (prior != null && prior.equals(tail.data))) {
            addLast(data);
            return;
        }
        Node<T> current = head;
        while (current != null) {
            if ((prior == null && current.data == null) ||
                (prior != null && prior.equals(current.data))) {
                Node<T> newNode = new Node<>(data);
                newNode.next = current.next;
                current.next = newNode;
                size++;
                return;
            }
            current = current.next;
        }
        throw new NoSuchElementException("Node with data " + prior + " not found");
    }

    public T removeFirst() {
        /*
        Removes and returns the first element in the list.
        Throws a NoSuchElementException if the list is empty.
        */
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        T data = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return data;
    }

    public T removeLast() {
        /*
        Removes and returns the last element in the list.
        Throws a NoSuchElementException if the list is empty.
        */
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        T data = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            Node<T> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
        return data;
    }

    public boolean remove(int index) {
        /*
        Removes the element at the specified index in the list.
        Returns true if the element was removed, false otherwise.
        */
        if (index < 0 || index >= size) {
            return false;
        }
        if (index == 0) {
            removeFirst();
            return true;
        }
        if (index == size - 1) {
            removeLast();
            return true;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
        return true;
    }

    public T removeBefore(T prior) {
        /*
        Removes the element before the first occurrence of the specified prior element in the list.
        Throws a NoSuchElementException if the prior element is not found.
        */
        if (size < 2) {
            return null;
        }
        if ((prior == null && head.data == null) ||
            (prior != null && prior.equals(head.data))) {
            return null;
        }
        if ((prior == null && head.next.data == null) ||
            (prior != null && prior.equals(head.next.data))) {
            return removeFirst();
        }
        Node<T> current = head;
        while (current.next.next != null) {
            if ((prior == null && current.next.next.data == null) ||
                (prior != null && prior.equals(current.next.next.data))) {
                T temp = current.next.data;
                current.next = current.next.next;
                size--;
                return temp;
            }
            current = current.next;
        }
        throw new NoSuchElementException("Node with data " + prior + " not found");
    }

    public T removeAfter(T prior) {
        /*
        Removes the element after the first occurrence of the specified prior element in the list.
        Throws a NoSuchElementException if the prior element is not found.
        */
        if (size < 2) {
            return null;
        }
        Node<T> current = head;
        while (current != null && current.next != null) {
            if ((prior == null && current.data == null) ||
                (prior != null && prior.equals(current.data))) {
                T temp = current.next.data;
                current.next = current.next.next;
                if (current.next == null) { // If we removed the last node, update the tail reference.
                    tail = current;
                }
                size--;
                return temp;
            }
            current = current.next;
        }
        throw new NoSuchElementException("Node with data " + prior + " not found");
    }

    @Override
    public String toString() {
        // Returns a string representation of the list in the format [element1, element2, ...].
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
        // Removes all elements from the list, resetting it to an empty state.
        head = tail = null;
        size = 0;
    }

    public boolean contains(T data) {
        // Checks if the list contains the specified element.
        return find(data) != size;
    }

    public T set(int index, T data) {
        /*
        Replaces the element at the specified index in the list with the provided data.
        Throws an IndexOutOfBoundsException if the index is out of bounds.
        */
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
        // Returns an iterator to allow for enhanced for-loops and other iteration patterns.
        return new MySingleLinkedListIterator();
    }

    public int size() {
        // Returns the number of elements in the list.
        return size;
    }
}