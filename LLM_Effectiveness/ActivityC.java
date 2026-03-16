import java.util.ArrayList;

public class ActivityC {
    public ActivityC() {
        ArrayList<Integer> ArrayList = new ArrayList<Integer>();
        ArrayList.add(5);
        ArrayList.add(2);
        ArrayList.add(9);
        ArrayList.add(1);
        ArrayList.add(3);
        System.out.println("Original array list: " + ArrayList);
        ArrayList<Integer> sortedArrayList = mergeSort(ArrayList);
        System.out.println("Sorted array list: " + sortedArrayList);
    }

    public ArrayList<Integer> mergeSort(ArrayList<Integer> ArrayList) {
        if (ArrayList.size() <= 1) {
            return ArrayList;
        }
        int mid = ArrayList.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(ArrayList.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(ArrayList.subList(mid, ArrayList.size()));
        return merge(mergeSort(left), mergeSort(right));
    }

    public ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}
