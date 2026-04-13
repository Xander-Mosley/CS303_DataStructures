package Assignment3;

public class RecursiveLinearSearch {
    public static <T> int linearSearch(T[] arr, T target) {
        return linearSearchHelper(arr, target, 0);
    }

    private static <T> int linearSearchHelper(T[] arr, T target, int index) {
        // Base Case: If index exceeds array length, return -1
        if (index == arr.length) {
            return -1;
        }

        // Recursive Case: forward recursion with backward evaluation
        int result = linearSearchHelper(arr, target, index + 1);
        if (result != -1) {
            return result; // Last occurrence found in the recursive call, return it repeatedly until it reaches the initial call
        }
        if (target == null ? arr[index] == null : target.equals(arr[index])) {
            return index; // Target found at the current index
        }
        return -1; // Target not found at the current index
    }
}