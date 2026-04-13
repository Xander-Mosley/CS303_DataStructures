package Assignment3;

import java.util.LinkedList;

public class InsertionSort {
    // Implementing an insertion sort method that sorts a linked list of generic type in increasing order without using indexing
    public static LinkedList<Integer> insertionSort(LinkedList<Integer> list) {
        LinkedList<Integer> sortedList = new LinkedList<>();
        for (Integer value : list) {
            int i = 0;
            while (i < sortedList.size() && sortedList.get(i) < value) {
                i++;
            }
            sortedList.add(i, value);
        }
        return sortedList;
    }
}
