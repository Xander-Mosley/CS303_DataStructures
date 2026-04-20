# Assignment 3 - Queues, Recursion, and Sorting

Xander D Mosley

Professor Syed Jawad Hussain Shah, PhD Candidate

COMP-SCI 303 - Data Structures

Monday, April 20th, 2026

## Overview

To convery a deeper understanding of queues, recursion, and sorting within Java. The following concepts were learned for this assignment: queue class development, backwards recursive behavior, and insertion sort of a double linked list. The main script executes the required testing of the custom queue data class, recursive linear sort, and insertion sort method for the double linked list class.

### Folder Contents

📁 Assignment3/

├── 🖼️ `Images/                                     # Folder of images`

├── 📘 `Assignment 3_Java.docs                      # Assignment documentation (DOC)`

├── 📕 `Assignment 3_Java.pdf                       # Assignment documentation (PDF)`

├── ⚙️ `Main.class                                  # Compiled Java bytecode (auto-created)`

├── ☕ `Main.java                                   # Main source code`

├── ⚙️ `MyDoubleLinkedList_withSorting.class        # Compiled Java bytecode (auto-created)`

├── ☕ `MyDoubleLinkedList_withSorting.java         # Custom linked list with insortion sort method source code`

├── ⚙️ `MyDoubleLinkedList_withSorting$MyDoubleLinkedListIterator.class     # Compiled Java bytecode (auto-created)`

├── ⚙️ `MyDoubleLinkedList_withSorting$Node.class   # Compiled Java bytecode (auto-created)`

├── ⚙️ `MyQueue.class                               # Compiled Java bytecode (auto-created)`

├── ☕ `MyQueue.java                                # Custom queue source code`

├── 📝 `README.md                                   # Assignment overview (this file)`

├── ⚙️ `RecursiveLinearSearch.class                 # Compiled Java bytecode (auto-created)`

└── ☕ `RecursiveLinearSearch.java                  # Custom backward recursion linear search source code`

## How to Complie and Run

### Requirements

- Java Development Kit (JDK) installed (Java 17 or newer recommended)
- Command Prompt, PowerShell, or VS Code terminal

### Compile

From the 'CS303_DataStructures' directory, run the following command:

```bash
javac Assigment3/*.java
```

### Run

```bash
java Assigment3.Main
```

## Program Features

### MyQueue

The MyQueue<T> class is a custom, generic implemenatation of a linked list based queue. This means that any element type can be stored within the queue. The custom queue allows the following required methods: enqueue (offer), dequeue (poll), peak, size, and empty. Two additional methods were developed to address the requested implementations of the queue: displaying all the elements in the queue and moving the element at the front of the queue to the rear of the queue. Both of these additional methods were developed using the required queue methods (enqueue, dequeue, peak, size, and empty).

### Recursive Linear Search

The RecursiveLinearSearch is a custom, generic function that performs a linear search through an ArrayList for the last occurrence of a target. This process is acheived using forward recursion with backward evaluation. The base case of the recursion is reaching the end of the array. Then, the stack of functions are evaluated starting from the rear. Once the target is found, the remaining evaluations will return the index of the target. This results in a recursive function that identifies the last occurance of a target in a given ArrayList. A similar implementation could be designed for a linked list structure.

### Insertion Sort

An insertion sort method, named insertionSort(), was developed within the custom double linked list class framework, renamed MyDoubleLinkedList_withSorting<T>. The ground work for this method came from modifying the source code for the array based insertion sort provided in the lecture slides. Since the process was designed as a method instead of an external function, the process has access to node properties (head, tail, .next, and .prev). This avoids class functions such as getIndex() that require n operations, reducing the required number of computations, or the Big-O, of this process from n³ to n².

## Outputs

### MyQueue Results

<p align="center">
  <img src="Images/MyQueue_Results.png" alt="Results for the Custom Listed-Based Queue">
</p>

### Recursive Linear Search Results

<p align="center">
  <img src="Images/RecursiveLinearSearch_Results.png" alt="Results for the Recursive Linear Search Function">
</p>

### Insertion Sort Results

<p align="center">
  <img src="Images/InsertionSort_Results.png" alt="Results for the Insertion Sort Method">
</p>
