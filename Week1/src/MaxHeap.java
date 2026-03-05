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