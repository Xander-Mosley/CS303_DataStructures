package Assignment2; // Declares which package (or folder) this class belongs to.
// If another class in a different package wants to use this class, it needs to import it using its full name (e.g., Assignment2.SingleLinkedList).
import java.util.NoSuchElementException;
import java.util.Iterator;

// This class represents a single linked list data structure.
public class SingleLinkedList<T> implements Iterable<T> {
    /*
    The head of the linked list, which points to the first node.
    The tail of the linked list, which points to the last node.
    The size of the linked list, which keeps track of the number of nodes in the list.
     */
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Extra functionality for constructors based on the lecture slides:
    public SingleLinkedList() {
        head = tail = null;
        size = 0;
    }

    public SingleLinkedList(T[] array) {
        this(); // Calls the default constructor to avoid skipping initialization if the default constructor changes.
        for (T data : array) {
            addLast(data);
        }
    }

    // Private class for the nodes in the linked list, which contains the data and the reference to the next node.
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    // Extra functionality for iterators based on the lecture slides:
    private class SingleLinkedListIterator implements Iterator<T> {
        private Node<T> current;

        public SingleLinkedListIterator() {
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

    // Required functionality for the linked list from the assignemnt instructions:
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T data) {
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
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
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

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.data;
    }

    /*
    It is better to return an exception than to return a null value.
    Returning null is indistinguishable from a valid null value that could be stored in the list.
     */

    public void insert(int index, T data) {
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

    public boolean remove(int index) {
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

    public int find(T data) {
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

    // Extra functionality for methods based on the lecture slides:

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
        head = tail = null;
        size = 0;
    }

    public boolean contains(T data) {
        return find(data) != size;
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

    public int lastIndexOf(T data) {
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
        return new SingleLinkedListIterator();
    }

    public int size() {
        return size;
    }

    /*
    Need to add more comments to each method
    Should add the following methods:
    addBefore(int index, T data)
    addAfter(int index, T data)
    removeBefore(int index)
    removeAfter(int index)
     */
}