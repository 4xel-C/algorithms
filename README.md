# Java Algorithms Demonstration

This repository contains Java code demonstrating various algorithms, data structures, and problem-solving techniques. It serves as a learning and exercice resource to understand common algorithms and their implementations in Java.

## Contents

- **[Maths](/maths)**
    - [Euclide Algorithm](/maths/EuclideAlgorithm.java)
    - [Fibonacci Sequence](/maths/FibonacciSequence.java)
- **[Unclassified](/other)**
    - **[Quick select](/other/QuickSelect.java)**
- **[Search Algorithms](/search)** 
    - [Binary Search](/search/BinarySearch.java)
    - [Depth First Search](/search/DirectedDFS.java)
    - [Linear Search](/search/LinearSearch.java)
    - [Longest Substring](/search/LongestSubstring.java)
    - [Substring Search](/search/SubstringSearch.java): Implementation of various algorithm of substring search, such as Knuth-Morris-Pratt algorithm, Boyer-Moore or Rabin-Karp.
- **[Sort Algorithms](/sort)**
    - [Bubble Sort](/sort/BubbleSort.java)
    - [Heap Sort](/sort/HeapSort.java)
    - [Insertion Sort](/sort/InsertionSort.java)
    - [Merge Sort](/sort/MergeSort.java)
    - [Quick Sort](/sort/QuickSort.java)
    - [Selection Sort](/sort/SelectionSort.java)
    - [Shell Sort](/sort/ShellSort.java)
    - [Three Way Quick Sorting](/sort/ThreeWaySorting.java)
    - [Counting sort](/sort/CountingSort.java)
    - [RadixSort](/sort/RadixSort.java)

--- 

- **[DataStructure](/DataStructure/)**
    - [AVL Binary Search Tree](/DataStructure/AVLBinarySearchTree.java): Binary search tree with balancing methods to keep operation complexity around O(log(n)).
    - [Binary Tree](/DataStructure/BinaryTree.java)
    - [Digraph](/DataStructure/Digraph.java)
    - [Max Binary Heap](/DataStructure/MaxHeap.java)
    - [Left leaning red-black Binary search tree](/DataStructure/LLRBTree.java): A red-black binary tree with insertion method.
    - [Linked List](/DataStructure/LinkedList.java)
    - [Recursive list](/DataStructure/RecursiveList.java)
    - [Ternary Search Trie](/DataStructure/TernarySearchTrie.java): Strings manipulation and operation, better memory usage compared to a Trie.
    - [Trie](/DataStructure/Trie.java): Strings manipulation and operation.
    - [Union find](/DataStructure/UnionFind.java): An implementation of the Union find datastructure, using path compression and weighed union.

--- 

- **[Problems](/problems/)**
    - [Four sum problem](/problems/FourSum.java): Resolution of the four sum problem using hashmap to improve efficiency and bring a complexity of O(n²).
    - [CyclicRotation](/problems/CyclicRotation.java): Algorithm to frind out if a string is a cyclic rotation of another string using substring search with a complexity of O(n).

## Getting Started

### Prerequisites

To run the code in this repository, you will need:

- [Java 8 or later](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) installed.
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code).
- Command-line access to compile and run Java files if you prefer not to use an IDE.

### Utils package
The `utils` package propose an `Helper` class that provides various functions to help testing the algorithms:
- `Helper.time`:  provide a wrapper to measure the time in ms to estimate the running time of a function.

### How to Clone the Repository

1. Clone this repository to your local machine using the following command:

   ```bash
   git clone https://github.com/your-username/algorithms.git
   ```
2.  Navigate into the project directory:
    ```bash
    cd algorithms
    ```

## How to run the codes

1. Compile the code you want to test
    ```bash
    javac -cp FileName.java
    ```
2. Run the compiled code using the following command on the .class file:
    ```bash
    java FileName
    ```
