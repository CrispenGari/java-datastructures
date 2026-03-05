# Using Heaps

A **Heap** is a special type of binary tree used mainly for **priority queues**.

A heap must satisfy two properties:

1. **Complete Binary Tree**
    - All levels are filled except possibly the last level.
    - The last level is filled from left to right.

2. **Heap Property**

There are two types of heaps:

### Max Heap
The parent node is **greater than or equal to its children**.

Example:

```
        90
       /  \
     70    60
    / \    /
   20 40  50
```

The largest value is always at the **root**.

### Min Heap
The parent node is **less than or equal to its children**.

Example:
```
        10
       /  \
     20    30
    / \    /
   40 50  60
```

The smallest value is always at the **root**.

Heaps are commonly used in:

- Priority queues
- Heap sort
- Graph algorithms (Dijkstra, Prim)


Because heaps are complete binary trees, they are efficiently stored in arrays.

For a node at index `i`:

```
Parent = (i - 1) / 2  
Left Child = 2i + 1  
Right Child = 2i + 2
```
### A. Min Heap


```java
public class MinHeap {

    int[] heap;
    int size;
    int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }
    private int parent(int i) {
        return (i - 1) / 2;
    }
    private int leftChild(int i) {
        return (2 * i) + 1;
    }
    private int rightChild(int i) {
        return (2 * i) + 2;
    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
```

#### Insert

Steps:

1. Insert the new element at the **end of the heap**
2. Compare it with its **parent**
3. If the parent is larger, **swap**
4. Continue until the heap property is restored

This process is called **Heapify Up**.

```java
public class MinHeap {

    int[] heap;
    int size;
    int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }
    private int parent(int i) {
        return (i - 1) / 2;
    }
    private int leftChild(int i) {
        return (2 * i) + 1;
    }
    private int rightChild(int i) {
        return (2 * i) + 2;
    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap Full");
            return;
        }
        heap[size] = value;
        int current = size;
        size++;
        while (current != 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
}
```

### Extract Min

Steps:

1. Remove the **root element**
2. Move the **last element to the root**
3. Restore the heap property using **Heapify Down**

```java
public class MinHeap {

    int[] heap;
    int size;
    int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }
    private int parent(int i) {
        return (i - 1) / 2;
    }
    private int leftChild(int i) {
        return (2 * i) + 1;
    }
    private int rightChild(int i) {
        return (2 * i) + 2;
    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap Full");
            return;
        }
        heap[size] = value;
        int current = size;
        size++;
        while (current != 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public int extractMin() {
        if (size <= 0)
            return Integer.MAX_VALUE;
        if (size == 1) {
            size--;
            return heap[0];
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return root;
    }
    private void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;
        if (left < size && heap[left] < heap[smallest])
            smallest = left;
        if (right < size && heap[right] < heap[smallest])
            smallest = right;
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }
}
```

### Traversing a Heap

Heaps are typically traversed using **Level Order Traversal**.

Since a heap is stored as an **array**, traversal simply prints elements in order.


```java

public class MinHeap {

    int[] heap;
    int size;
    int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }
    private int parent(int i) {
        return (i - 1) / 2;
    }
    private int leftChild(int i) {
        return (2 * i) + 1;
    }
    private int rightChild(int i) {
        return (2 * i) + 2;
    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap Full");
            return;
        }
        heap[size] = value;
        int current = size;
        size++;
        while (current != 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public int extractMin() {
        if (size <= 0)
            return Integer.MAX_VALUE;
        if (size == 1) {
            size--;
            return heap[0];
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return root;
    }
    private void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;
        if (left < size && heap[left] < heap[smallest])
            smallest = left;
        if (right < size && heap[right] < heap[smallest])
            smallest = right;
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }
    public void traverseHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}
```

In the main clas we will have something like:

```java
public class Main {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);
        heap.insert(30);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(40);

        System.out.println("Heap Traversal:");
        heap.traverseHeap();
        System.out.println("\nExtract Min: " + heap.extractMin());
        System.out.println("Heap After Extraction:");
        heap.traverseHeap();
    }
}
```

### B. Max Heap Implementation

In a **Max Heap**, the parent node is always **greater than its children**.

The largest element is always stored at the **root of the heap**.

Example:
```
        90
       /  \
     70    60
    / \    /
   20 40  50
```


````java
class MaxHeap {

    int[] heap;
    int size;
    int capacity;

    public MaxHeap(int capacity) {

        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }
    private int parent(int i) {
        return (i - 1) / 2;
    }
    private int leftChild(int i) {
        return (2 * i) + 1;
    }
    private int rightChild(int i) {
        return (2 * i) + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
````

#### Insert Operation

Steps:

1. Insert the new element at the **end of the heap**
2. Compare it with its **parent**
3. If the parent is smaller, **swap**
4. Continue until the heap property is restored

```java
class MaxHeap {

    int[] heap;
    int size;
    int capacity;

    public MaxHeap(int capacity) {

        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }
    private int parent(int i) {
        return (i - 1) / 2;
    }
    private int leftChild(int i) {
        return (2 * i) + 1;
    }
    private int rightChild(int i) {
        return (2 * i) + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap Full");
            return;
        }
        heap[size] = value;
        int current = size;
        size++;
        while (current != 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
}
```
#### Extract Max

Steps:

1. Remove the **root node**
2. Replace it with the **last element**
3. Restore the heap property using **Heapify Down**

```java
class MaxHeap {

    int[] heap;
    int size;
    int capacity;

    public MaxHeap(int capacity) {

        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }
    private int parent(int i) {
        return (i - 1) / 2;
    }
    private int leftChild(int i) {
        return (2 * i) + 1;
    }
    private int rightChild(int i) {
        return (2 * i) + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap Full");
            return;
        }
        heap[size] = value;
        int current = size;
        size++;
        while (current != 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public int extractMax() {
        if (size <= 0)
            return Integer.MIN_VALUE;
        if (size == 1) {
            size--;
            return heap[0];
        }int root = heap[0];

        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return root;
    }
    private void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left < size && heap[left] > heap[largest])
            largest = left;

        if (right < size && heap[right] > heap[largest])
            largest = right;

        if (largest != i) {

            swap(i, largest);
            heapify(largest);
        }
    }
}
```
### Heap Traversal

Since heaps are stored as arrays, we traverse them using **level order traversal**.

```java

class MaxHeap {

    int[] heap;
    int size;
    int capacity;

    public MaxHeap(int capacity) {

        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }
    private int parent(int i) {
        return (i - 1) / 2;
    }
    private int leftChild(int i) {
        return (2 * i) + 1;
    }
    private int rightChild(int i) {
        return (2 * i) + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap Full");
            return;
        }
        heap[size] = value;
        int current = size;
        size++;
        while (current != 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public int extractMax() {
        if (size <= 0)
            return Integer.MIN_VALUE;
        if (size == 1) {
            size--;
            return heap[0];
        }int root = heap[0];

        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return root;
    }
    private void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left < size && heap[left] > heap[largest])
            largest = left;

        if (right < size && heap[right] > heap[largest])
            largest = right;

        if (largest != i) {

            swap(i, largest);
            heapify(largest);
        }
    }
    public void traverseHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}
```

In the main class we will have the following:

```java
public class Main {

    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap(10);

        heap.insert(30);
        heap.insert(50);
        heap.insert(20);
        heap.insert(70);
        heap.insert(10);

        System.out.println("Max Heap Traversal:");
        heap.traverseHeap();

        System.out.println("\nExtract Max: " + heap.extractMax());

        System.out.println("Heap After Extraction:");
        heap.traverseHeap();
    }
}
```

