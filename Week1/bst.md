### Trees (Binary Search Trees)

A **tree** is a hierarchical data structure consisting of nodes connected by edges.  
Trees allow efficient searching, insertion and deletion operations.

A **Binary Search Tree (BST)** is a special type of binary tree where:

- All values in the **left subtree** are smaller than the root
- All values in the **right subtree** are greater than the root

Example:
```
        50
       /  \
     30    70
    / \    / \
   20 40  60 80
  / \
 10  21
  \
   15
```
---

1. `Parent Node` - is the node where the tree starts, it sometimes called a root node. This is where all operations of a tree originates.
2. `Child Node` - Any node that is connected to another node above it's hierarch.
3. `Leaf Nodes` -Nodes that doesn't have root nodes.
4. `Siblings` - Nodes with the same parent.
5. `Ancestor` Node - Is a node that has grand children.
6. `Path` - The sequency of edges from one node to another.
7. `Distance` - the number of shots edges between two nodes.
8. `Degree` - A degree of a node is the total number of nodes it has.
9. `Depth` - the number of edges from the root node to that node. Eg the depth of the root node is 0
10. `Height` - The number of edges from the deepest leaf to that node.

### 1. Creating a Tree Node

Each node stores:

- the value
- reference to the left child
- reference to the right child

```java
class Node {
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
```

### 2. Binary Search Tree Class

The BST class stores the **root node** of the tree.

```java
class BST {
    Node root;
    public BST() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }
}
```
### 3. Insert Operation

Insertion follows BST rules:

1. If the tree is empty, the new node becomes the root.
2. If the value is smaller than the current node, go left.
3. If the value is larger, go right.
4. Continue until an empty position is found.


```java
class BST {
    Node root;
    public BST() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertNode(root.left, value);
        } else if (value > root.value) {
            root.right = insertNode(root.right, value);
        }
        return root;
    }
}
```

### 4. Search Operation

Search starts from the root.

Steps:

1. If the node is null - value does not exist.
2. If the node value equals the search value - return true.
3. If the value is smaller - search left subtree.
4. If the value is greater - search right subtree.

```java
class BST {
    Node root;
    public BST() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertNode(root.left, value);
        } else if (value > root.value) {
            root.right = insertNode(root.right, value);
        }
        return root;
    }
    public boolean search(int value) {
        return searchTree(root, value);
    }
    private boolean searchTree(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.value) {
            return true;
        }
        if (value < root.value) {
            return searchTree(root.left, value);
        }
        return searchTree(root.right, value);
    }
}
```

### 5. Finding the Minimum Value

The minimum value in a BST is always the **leftmost node**.

```java
class BST {
    Node root;

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertNode(root.left, value);
        } else if (value > root.value) {
            root.right = insertNode(root.right, value);
        }
        return root;
    }

    public boolean search(int value) {
        return searchTree(root, value);
    }

    private boolean searchTree(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.value) {
            return true;
        }
        if (value < root.value) {
            return searchTree(root.left, value);
        }
        return searchTree(root.right, value);
    }

    public int findMin() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }
}
```

### 6. Finding the Maximum Value

The maximum value is always the **rightmost node**.

```java
class BST {
    Node root;
    public BST() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertNode(root.left, value);
        } else if (value > root.value) {
            root.right = insertNode(root.right, value);
        }
        return root;
    }
    public boolean search(int value) {
        return searchTree(root, value);
    }
    private boolean searchTree(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.value) {
            return true;
        }
        if (value < root.value) {
            return searchTree(root.left, value);
        }
        return searchTree(root.right, value);
    }
    public int findMin() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public int findMax() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }
}
```

### 7. Deleting a Node

Deletion has three cases:

1. Node is a **leaf**  - simply remove it
2. Node has **one child** - replace it with the child
3. Node has **two children** - replace it with the minimum value from the right subtree

```java

class BST {
    Node root;
    public BST() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertNode(root.left, value);
        } else if (value > root.value) {
            root.right = insertNode(root.right, value);
        }
        return root;
    }
    public boolean search(int value) {
        return searchTree(root, value);
    }
    private boolean searchTree(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.value) {
            return true;
        }
        if (value < root.value) {
            return searchTree(root.left, value);
        }
        return searchTree(root.right, value);
    }
    public int findMin() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public int findMax() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }
    public Node delete(Node root, int value) {

        if (root == null) {
            return null;
        }

        if (value < root.value) {
            root.left = delete(root.left, value);
        }
        else if (value > root.value) {
            root.right = delete(root.right, value);
        }
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            root.value = findMinNode(root.right).value;
            root.right = delete(root.right, root.value);
        }
        return root;
    }
    private Node findMinNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
```

### # 8. Depth First Traversal (DFS)

DFS explores a branch fully before moving to the next branch.

Types of DFS:

1. Preorder
2. Inorder
3. Postorder

```java
class BST {
    Node root;
    public BST() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertNode(root.left, value);
        } else if (value > root.value) {
            root.right = insertNode(root.right, value);
        }
        return root;
    }
    public boolean search(int value) {
        return searchTree(root, value);
    }
    private boolean searchTree(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.value) {
            return true;
        }
        if (value < root.value) {
            return searchTree(root.left, value);
        }
        return searchTree(root.right, value);
    }
    public int findMin() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public int findMax() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }
    public Node delete(Node root, int value) {

        if (root == null) {
            return null;
        }

        if (value < root.value) {
            root.left = delete(root.left, value);
        }
        else if (value > root.value) {
            root.right = delete(root.right, value);
        }
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            root.value = findMinNode(root.right).value;
            root.right = delete(root.right, root.value);
        }
        return root;
    }
    private Node findMinNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public void inorder(Node root) {

        if (root != null) {

            inorder(root.left);
            System.out.print(root.value + ", ");
            inorder(root.right);
        }
    }
    public void preorder(Node root) {

        if (root != null) {

            System.out.print(root.value + ", ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public void postorder(Node root) {
        if (root != null) {

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value + ", ");
        }
    }
}
```

### 9. Breadth First Search (BFS)

BFS explores the tree **level by level**.

Steps:

1. Create a queue
2. Add the root node
3. Remove a node from the queue
4. Add its children to the queue
5. Repeat until the queue is empty


```java
class BST {
    Node root;
    public BST() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertNode(root.left, value);
        } else if (value > root.value) {
            root.right = insertNode(root.right, value);
        }
        return root;
    }
    public boolean search(int value) {
        return searchTree(root, value);
    }
    private boolean searchTree(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.value) {
            return true;
        }
        if (value < root.value) {
            return searchTree(root.left, value);
        }
        return searchTree(root.right, value);
    }
    public int findMin() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public int findMax() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }
    public Node delete(Node root, int value) {

        if (root == null) {
            return null;
        }

        if (value < root.value) {
            root.left = delete(root.left, value);
        }
        else if (value > root.value) {
            root.right = delete(root.right, value);
        }
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            root.value = findMinNode(root.right).value;
            root.right = delete(root.right, root.value);
        }
        return root;
    }
    private Node findMinNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public void inorder(Node root) {

        if (root != null) {

            inorder(root.left);
            System.out.print(root.value + ", ");
            inorder(root.right);
        }
    }
    public void preorder(Node root) {

        if (root != null) {

            System.out.print(root.value + ", ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public void postorder(Node root) {
        if (root != null) {

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value + ", ");
        }
    }
    public void bfs() {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node current = queue.poll();
            System.out.print(current.value + ", ");

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }
    }
}

```


### 10. Height of a Tree

The **height** of a tree is the number of edges on the longest path from the root to a leaf.


```java


class BST {
    Node root;
    public BST() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public int height(Node root) {
        if (root == null)
            return -1;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertNode(root.left, value);
        } else if (value > root.value) {
            root.right = insertNode(root.right, value);
        }
        return root;
    }
    public boolean search(int value) {
        return searchTree(root, value);
    }
    private boolean searchTree(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.value) {
            return true;
        }
        if (value < root.value) {
            return searchTree(root.left, value);
        }
        return searchTree(root.right, value);
    }
    public int findMin() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public int findMax() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }
    public Node delete(Node root, int value) {

        if (root == null) {
            return null;
        }

        if (value < root.value) {
            root.left = delete(root.left, value);
        }
        else if (value > root.value) {
            root.right = delete(root.right, value);
        }
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            root.value = findMinNode(root.right).value;
            root.right = delete(root.right, root.value);
        }
        return root;
    }
    private Node findMinNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public void inorder(Node root) {

        if (root != null) {

            inorder(root.left);
            System.out.print(root.value + ", ");
            inorder(root.right);
        }
    }
    public void preorder(Node root) {

        if (root != null) {

            System.out.print(root.value + ", ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public void postorder(Node root) {
        if (root != null) {

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value + ", ");
        }
    }
    public void bfs() {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node current = queue.poll();
            System.out.print(current.value + ", ");

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }
    }
}
```

And this is how the `BST` can be used in the `main` class.

```java
public class Main {
    public static void main(String[] args){
        BST tree = new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        System.out.println("Search 40: " + tree.search(40));
        System.out.print("Inorder: ");
        tree.inorder(tree.root);
        System.out.println("\nMin: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());
    }
}
```

