import java.util.ArrayList;

public class ActivityB {

    public ActivityB() {
        ArrayList<Integer> ArrayList = new ArrayList<Integer>();
        ArrayList.add(1);
        ArrayList.add(2);
        ArrayList.add(3);
        int sum = recursive_sum(ArrayList);
        System.out.println("The sum of the array list is: " + sum);
    }

    public int recursive_sum(ArrayList<Integer> ArrayList) {
        if (ArrayList.size() == 0) {
            return 0;
        } else {
            int lastElement = ArrayList.get(ArrayList.size() - 1);
            ArrayList.remove(ArrayList.size() - 1);
            return lastElement + recursive_sum(ArrayList);
        }
    }
}