// Imports libraries (if needed) go here
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
Java uses braces, not indentations, to define code blocks
Java is case-sensitive
Only one public class is allowed per file, and it must match the file name (Main.java)
Otherwise, it will cause a compilation error
*/
public class Main {
    public static void main(String[] args) {
        /*
        This is the main method, the entry point of any program
        static means that no object of the class is needed to run this method
        void means that this method does not return any value
        String[] args is an array of strings that can hold command-line arguments passed to the program
        Typically, put variables, inputs, logic, and outputs here
        Usually end with some clean-up code, if necessary
        E.g., scanner.close()
        */
       /*
       Assignment steps:
       1. Read data from an input file into a standard array
       2. Create a function for checking if a certain integer exists in the array if the number is present return the index where the number is present.
       3. Create a function that can modify the value of an integer when called with the index of the integer in the array and return the new value and old value back to the user.
       4. Create a function that adds a new integer to the end of the array.
       5. Create a function which intakes an index of an array and removes the integer altogether.
       6. Add a try and catch blocks to the user inputs for the following functions from question 1.
         - A function that can modify the value of an integer when called with the index of the integer in the array and return the new value and old value back to the user.
         - A function that adds a new integer to the end of the array.
        */

        int[] data = new int[100];
        try {
            File file = new File("A1input.txt");
            Scanner scanner = new Scanner(file);
            int index = 0;
            while (scanner.hasNextInt() && index < data.length) {
                data[index] = scanner.nextInt();
                index++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return;
        }
        System.out.println("\nReading data from the file...");
        for (int i = 0; i < data.length; i += 10) {
            for (int j = 0; j < 10 && (i + j) < data.length; j++) {
                System.out.printf("%2d ", data[i + j]); // %2d pads single digits with a space for better alignment
            }
            System.out.println();
        }
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%2d ", data[i]);
        }

        System.out.println("\nFinding integer 42 in the array...");
        int location = findInteger(data, 42);
        System.out.println("Integer 42 found at index: " + location);

        System.out.println("\nModifying an integer in the array...");
        ValueChange result = modifyInteger(data, 10, 99);
        System.out.println("Returned Old Value: " + result.oldValue + ", Returned New Value: " + result.newValue);

        System.out.println("\nAdding an integer in the array...");
        data = addInteger(data, 99);
        for (int i = 0; i < data.length; i += 10) {
            for (int j = 0; j < 10 && (i + j) < data.length; j++) {
                System.out.printf("%2d ", data[i + j]);
            }
            System.out.println();
        }
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%2d ", data[i]);
        }

        System.out.println("\nDeleting an integer in the array...");
        data = removeInteger(data, 10);
        for (int i = 0; i < data.length; i += 10) {
            for (int j = 0; j < 10 && (i + j) < data.length; j++) {
                System.out.printf("%2d ", data[i + j]);
            }
            System.out.println();
        }
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%2d ", data[i]);
        }

        System.out.println("\nTesting try and catch blocks...");
        int[] emptyData = null;
        ValueChange result2 = modifyInteger(data, 200, 99);
        if (result2 != null) {
            System.out.println("Returned Old Value: " + result2.oldValue + ", Returned New Value: " + result2.newValue);
        }
        ValueChange result3 = modifyInteger(emptyData, 0, 4);
        if (result3 != null) {
            System.out.println("Returned Old Value: " + result3.oldValue + ", Returned New Value: " + result3.newValue);
        }
        data = addInteger(emptyData, 2);
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%2d ", data[i]);
        }
    }
    // Other methods are defined outside the main method, but still within the Main class

    public static int findInteger(int[] array, int target) {
        /*
        This method takes an array of integers and a target integer to find
        It returns the index of the target if found, or -1 if not found
        The typing is required because generics do not work with primitive types like int
        I tried to use <T> and T to make it more flexible, but it didn't work
        */
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Return the index where the target is found
            }
        }
        return -1; // Return -1 if the target is not found
        // This is a standard convention in Java and C-style languages that clearly means "not found"
    }

    public static ValueChange modifyInteger(int[] array, int index, int newValue) {
        /*
        This method modifies the value of an integer at a specific index in the array
        It returns the old value and the new value back to the user
        */
        try {
            int oldValue = array[index];
            array[index] = newValue;
            // System.out.println("Old Value: " + oldValue + ", New Value: " + newValue);
            /*
            I didn't recall if we were supposed to print the old and new values or return them, so I decided to return them
            Java enfores single return type values, so I created a structure (ValueChange) to hold both the old and new values
            This makes it easier to access both values without needing to use an array or other workaround
            */
            return new ValueChange(oldValue, newValue);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds: " + e.getMessage());
            return null; // Return null to indicate an error occurred
        } catch (NullPointerException e) {
            System.out.println("Array is empty: " + e.getMessage());
            return null; // Return null to indicate an error occurred
        }
    }

    public static int[] addInteger(int[] array, int newValue) {
        /*
        This method adds a new integer to the end of the array
        Since arrays in Java are fixed in size, I create a new array that is one element larger than the original array, copy the old values, and add the new value at the end
        This is also about the point I realized that I should have created a generic class to handle the array and its operations
        That would have allowed me to store values such as the current capacity and size of the array, and made it easier to manage the array without needing to create new arrays every time we add or remove elements
        But this works for the purpose of this assignment
        */
        try {
            int[] newArray = new int[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            newArray[array.length] = newValue;
            return newArray;

        } catch (NullPointerException e) {
            System.out.println("Array is empty: " + e.getMessage());
            return new int[]{newValue}; // Return a new array with just the new value if the original array is null
        }
    }

    public static int[] removeInteger(int[] array, int index) {
        /*
        This method removes an integer at a specific index in the array
        Similar to addInteger, I create a new array that is one element smaller than the original array, copy the old values except for the one at the specified index
        */
        if (array == null || index < 0 || index >= array.length) {
            return array; // Return the original array if the index is out of bounds
        }

        int[] newArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j] = array[i];
                j++;
            }
        }
        return newArray;
    }
}
// Non-public classes can follow the main class in the same file, but they cannot be accessed from outside this file
// For this assigment, I'll just put all the code within one script for simplicity

class ValueChange {
    int oldValue;
    int newValue;

    ValueChange(int oldValue, int newValue) {
        this.oldValue = oldValue;
        this.newValue = newValue;
    }
}