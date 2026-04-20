# Assignment 2 - Java Linked List and Stack

Xander D Mosley

Professor Syed Jawad Hussain Shah, PhD Candidate

COMP-SCI 303 - Data Structures

Tuesday, March 17th, 2026

## Overview

To convey a deeper understanding of linked lists and stacks within Java. The following concepts were learned for this assignement: private class structures for data classes (nodes) and iteraters, utility methods for a generic class script, and directory organization using package command. The Main script executes the main methods for a custom linked list and stack class along with potential edge cases. The required functionality for the assignment was implemented in the 'MyStack.java' and 'SingleLinkedList.java' file.

### Folder Contents

📁 Assignment2/

├── 🖼️ `Images/                                           # Folder of images`

├── 📘 `Assignment 2_Java.docs                            # Assignment documentation (DOC)`

├── 📕 `Assignment 2_Java.pdf                             # Assignment documentation (PDF)`

├── ⚙️ `Main.class                                        # Compiled Java bytecode (auto-created)`

├── ☕ `Main.java                                         # Main source code`

├── ⚙️ `MyStack.class                                     # Compiled Java bytecode (auto-created)`

├── ☕ `MyStack.java                                      # Custom stack source code`

├── 📝 `README.md                                         # Assignment overview (this file)`

├── ⚙️ `SingleLinkedList.class                            # Compiled Java bytecode (auto-created)`

├── ☕ `SingleLinkedList.java                             # Custom linked list source code`

├── ⚙️ `SingleLinkedList$Node.class                       # Helper class bytecode (auto-created)`

└── ⚙️ `SingleLinkedList$SingleLinkedListIterator.class   # Helper class bytecode (auto-created)`

## How to Complie and Run

### Requirements

- Java Development Kit (JDK) installed (Java 17 or newer recommended)
- Command Prompt, PowerShell, or VS Code terminal

### Compile

From the 'CS303_DataStructures' directory, run the following command:

```bash
javac Assigment2/*.java
```

### Run

```bash
java Assigment2.Main
```

## Program Features

### SingleLinkedList Features

The SingleLinkedList<T> class is a generic implementation of a singly linked list, meaning it can store elements of any type while maintaining a linear sequence of nodes. Internally, it keeps track of three key pieces of state: a head reference to the first node, a tail reference to the last node, and an integer size that records how many elements are in the list. Each element is wrapped in a private static inner Node<T> class, which contains the actual data and a reference to the next node in the sequence. This design allows efficient insertion at both the beginning and end of the list while maintaining a simple structure.

The class provides two constructors: a default constructor that initializes an empty list and another that accepts an array, populating the list by appending each element to the end. By calling the default constructor from the array constructor, it ensures consistent initialization.

The class provides a comprehensive set of insertion methods that allow elements to be added in multiple ways. Basic operations like addFirst and addLast insert elements at the beginning and end of the list, using the head and tail references for efficiency. The insert(int index, T data) method allows placement at any position, handling edge cases by redirecting to the front or back when the index is out of range. More advanced methods like addBefore and addAfter insert elements relative to a specific value already in the list, requiring traversal to locate the target node and then adjusting links accordingly. These methods demonstrate how pointer manipulation enables flexible insertion without shifting elements, unlike arrays.

For deletion, the class includes both standard and value-relative removal operations. Methods like removeFirst and removeLast handle edge cases such as empty lists or single-element lists, updating head and tail as needed. The remove(int index) method removes an element at a specific position, again handling boundary cases separately for efficiency. Additional methods like removeBefore and removeAfter allow removal relative to a given value, which involves carefully skipping over nodes and maintaining proper links. These operations highlight the importance of traversal and pointer updates in a singly linked structure, especially since there are no backward references.

The search and access methods provide ways to locate and retrieve data. The find method returns the index of the first occurrence of a value, while lastIndexOf searches for the final occurrence by scanning the entire list. The contains method builds on find to return a boolean result. For direct access, getFirst, getLast, and get(int index) return elements at specific positions, with bounds checking to prevent invalid access. Notably, comparisons are written to safely handle null values, ensuring the list can store and correctly evaluate null elements.

Finally, the class includes several miscellaneous utility methods that improve usability and completeness. The set method replaces the value at a given index and returns the old value, mimicking behavior found in standard collections. The clear method resets the list to an empty state by nullifying references and resetting size. The size and isEmpty methods provide quick status checks, while toString builds a readable string representation of the list contents. Together, these methods round out the implementation, making it behave similarly to built-in list structures while still exposing the underlying linked list mechanics.

To support iteration, the class implements Iterable<T> and includes a private inner iterator class. This iterator maintains a reference to the current node and moves forward one node at a time, enabling the list to be used in enhanced for-loops. Overall, the structure emphasizes encapsulation (through private inner classes), flexibility (via generics), and efficiency (through direct head/tail access and size tracking), forming a clean and practical implementation of a singly linked list.

### MyStack Features

This custom MyStack class is an implementation of a stack data structure using Java’s ArrayList as its underlying storage. A stack follows the Last-In, First-Out (LIFO) principle, meaning the most recently added element is the first one to be removed. The constructor initializes an empty ArrayList<Integer>, which dynamically resizes as elements are added or removed, making it a flexible choice for managing the stack.

The core stack operations are implemented through the push, pop, and peek methods. The push(int value) method adds a new element to the top of the stack by appending it to the end of the ArrayList. The pop() method removes and returns the top element, which corresponds to the last item in the list; it includes a safety check that throws an EmptyStackException if the stack is empty. Similarly, the peek() method allows you to view the top element without removing it, also throwing an exception if there are no elements. These methods collectively provide the essential behavior expected from a stack.

Additional utility methods enhance usability and introspection. The isEmpty() method quickly checks whether the stack contains any elements, while the size() method returns the current number of items. These are useful for validating operations or controlling program flow when working with the stack.

A notable custom feature of this implementation is the average() method, which is not typically part of standard stack interfaces. This method iterates through all elements in the stack, calculates their sum, and returns the average as a double. Like pop() and peek(), it includes error handling by throwing an EmptyStackException if called on an empty stack. This addition demonstrates how the class extends beyond basic stack functionality to support simple aggregate computations.

## Outputs

Results from testing the custom classes in the Main script.

SingleLinkedList Tests:

- Create an empty linked list and verify it prints as empty
- Check that isEmpty() returns true for a new list
- Attempt removeFirst() on an empty list and expect an exception
- Attempt removeLast() on an empty list and expect an exception
- Add an element to the front using addFirst
- Add an element to the end using addLast
- Add another element to the front and verify overall order
- Retrieve the first element using getFirst() and verify value
- Retrieve the last element using getLast() and verify value
- Insert at a negative index and verify it behaves like adding to the front
- Insert at a middle index and verify correct placement
- Insert beyond the list size and verify it behaves like adding to the end
- Verify the list structure after all insert operations
- Search for an existing value and verify the correct index is returned
- Search for a non-existing value and verify the list size is returned
- Remove the element at index 0 and verify the list updates correctly
- Remove the element at the last index and verify the list updates correctly
- Remove an element from the middle and verify the list updates correctly
- Attempt to remove using an invalid index and verify it returns false
- Remove the first element using removeFirst() on a non-empty list
- Remove the last element using removeLast() on a non-empty list
- Check whether the list is empty at the end

MyStack Tests:

- Create a new stack and verify it starts empty using isEmpty()
- Attempt pop() on an empty stack and expect an exception
- Attempt peek() on an empty stack and expect an exception
- Attempt average() on an empty stack and expect an exception
- Push elements (10, 20, 30) onto the stack
- Verify the stack size after pushes
- Peek at the top element and verify it returns the last pushed value (30)
- Calculate the average of all elements and verify the correct result (20.0)
- Pop the top element and verify the returned value (30)
- Pop the next element and verify the returned value (20)
- Verify the stack size after popping two elements
- Check that the stack is not empty yet
- Peek at the top element when one element remains and verify value (10)
- Calculate the average with one element and verify result (10.0)
- Pop the last remaining element and verify the returned value (10)
- Verify the stack is now empty
- Attempt pop() again on the empty stack and expect an exception

### SingleLinkedList Test Results

<p align="center">
  <img src="images/SingleLinkedList_Test_Results.png" alt="Test Results for the Custom Single Linked List">
</p>

### MyStack Test Results

<p align="center">
  <img src="images/MyStack_Test_Results.png" alt="Test Results for the Custom Stack using Java ArrayList">
</p>
