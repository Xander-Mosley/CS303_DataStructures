package Assignment3;

// import java.util.LinkedList;

// public class InsertionSort {
//     // Implementing an insertion sort method that sorts a double linked list of generic type in increasing order without using indexing
//     public static <T extends Comparable<T>> void insertionSort(LinkedList<T> list) {
//         if (list == null || list.size() <= 1) {
//             return; // No need to sort
//         }

//         Node<T> loop_position = list.getFirst().next;
//         while (loop_position != null) {
//             T key = loop_position.data;
//             Node<T> j = loop_position.prev;

//             // Move elements of list[0..i-1], that are greater than key, to one position ahead of their current position
//             while (j != null && j.data.compareTo(key) > 0) {
//                 j = j.prev;
//             }
//             // Insert the key at its correct position in the sorted subarray
//             if (j == null) {
//                 // Insert at the beginning
//                 head.prev = new Node<>(key);
//                 head.prev.next = head;
//                 head = head.prev;
//             } else {
//                 // Insert after j
//                 Node<T> newNode = new Node<>(key);
//                 newNode.next = j.next;
//                 newNode.prev = j;
//                 if (j.next != null) {
//                     j.next.prev = newNode;
//                 }
//                 j.next = newNode;
//             }
//             loop_position = loop_position.next; // Move to the next element
//         }
//     }
// }
