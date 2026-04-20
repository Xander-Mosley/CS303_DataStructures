package Assignment3;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nTesting MyQueue...");
        testMyQueue();
        System.out.println("\nTesting LinearSearchFunction...");
        testLinearSearchFunction();
        System.out.println("\nTesting InsertionSort...");
        testInsertionSort();
        System.out.println("\nAll tests completed.");
    }

    public static void testMyQueue() {
        // Instantiate the queue with integers and push 10 values into the queue
        // Display all the elements in the queue using the toString method
        // Use the move_to_rear method to move the front element to the rear and display the queue again
        MyQueue<Integer> queue = new MyQueue<>();
        for (int i = 1; i <= 10; i++) {
            queue.enqueue(i);
        }
        System.out.println("Queue: " + queue.toString());
        queue.move_to_rear();
        System.out.println("After moving front element to rear");
        System.out.println("Queue: " + queue.toString());
    }

    public static void testLinearSearchFunction() {
        // Creating an array of duplicate integers and search for the last occurance of a specific integer
        Integer[] arr = {2, 6, 1, 3, 7, 10, 10, 5, 10, 9};
        System.out.print("Array: [ ");
        for (Integer num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("]\n");
        int target = 10;
        int index = RecursiveLinearSearch.linearSearch(arr, target);
        System.out.println("Index of last occurrence of " + target + ": " + index);
    }

    public static void testInsertionSort() {
        // Create an array of 10 random integers and sort the array using the insertion sort method
        Integer[] arr = {5, 2, 9, 1, 5, 6, 7, 3, 4, 8};
        MyDoubleLinkedList_withSorting<Integer> list = new MyDoubleLinkedList_withSorting<>(arr);
        System.out.print("Unsorted array: [ ");
        System.out.print(list.toString());
        System.out.print("]\n");
        list.insertionSort();
        System.out.print("Sorted array:   [ ");
        System.out.print(list.toString());
        System.out.print("]\n");
    }
}
