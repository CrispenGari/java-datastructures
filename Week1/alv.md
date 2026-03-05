# Using AVL Trees

An **AVL Tree** is a self-balancing Binary Search Tree.

It automatically keeps the tree balanced after insertion and deletion.

AVL stands for:
- Adelson-Velsky
- Landis

### Why AVL Trees?

Normal Binary Search Trees can become unbalanced.

Example of a bad BST:

```
10
  \
   20
    \
     30
      \
       40
```

This becomes similar to a **linked list**, making operations slow.

AVL trees maintain balance by ensuring:

| Balance Factor | Meaning |
|----------------|:-------|
| -1 | Left subtree taller |
| 0 | Balanced |
| +1 | Right subtree taller |

If the balance factor becomes **less than -1 or greater than 1**, the tree performs **rotations**.

### Types of Rotations

AVL trees use four types of rotations:

1. **Left Rotation (RR Case)**
2. **Right Rotation (LL Case)**
3. **Left-Right Rotation (LR Case)**
4. **Right-Left Rotation (RL Case)**

Rotations help maintain the height of the tree close to **log n**, ensuring fast operations.


#### The `ALVNode`

```java
class AVLNode {
    int key;
    int height;
    AVLNode left;
    AVLNode right;
    AVLNode(int key) {
        this.key = key;
        this.height = 1;
        left = null;
        right = null;
    }
}
```
#### AVL Tree Class

```java
public class AVL {
    AVLNode root;
    int height(AVLNode node) {

        if (node == null)
            return 0;

        return node.height;
    }
}
```
### Get Balance Factor
Next we are going to get the balancing factor

```java
public class AVL {
    AVLNode root;
    int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }
    int getBalance(AVLNode node) {
        if (node == null)
            return 0;
       return height(node.left) - height(node.right);
    }
}
```

### Right Rotation (LL Case)

```java
public class AVL {
    AVLNode root;
    int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }
    int getBalance(AVLNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
}
```

### Left Rotation (RR Case)

```java
public class AVL {
    AVLNode root;
    int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }
    int getBalance(AVLNode node) {
        if (node == null)
            return 0;
       return height(node.left) - height(node.right);
    }
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
       return x;
    }
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }
}
```

#### AVL Insertion

Insertion works like a **Binary Search Tree**, but after inserting we check the **balance factor**.

If the tree becomes unbalanced, we apply the appropriate **rotation**.

```java

class AVLNode {
    int key;
    int height;
    AVLNode left;
    AVLNode right;
    AVLNode(int key) {
        this.key = key;
        this.height = 1;
        left = null;
        right = null;
    }
}


public class AVL {
    AVLNode root;
    int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }
    int getBalance(AVLNode node) {
        if (node == null)
            return 0;
       return height(node.left) - height(node.right);
    }
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
       return x;
    }
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }
    AVLNode insert(AVLNode node, int key) {

        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);

        else if (key > node.key)
            node.right = insert(node.right, key);

        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right))
        int balance = getBalance(node);

        // LL Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // RR Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // LR Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }
}
```

Traversing an AVL Tree

AVL trees are still Binary Search Trees, so they support the same traversals:

1. Inorder 
2. Preorder 
3. Postorder


```java
public class AVL {
    AVLNode root;
    int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }
    int getBalance(AVLNode node) {
        if (node == null)
            return 0;
       return height(node.left) - height(node.right);
    }
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
       return x;
    }
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }
    AVLNode insert(AVLNode node, int key) {

        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);

        else if (key > node.key)
            node.right = insert(node.right, key);

        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // LL Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // RR Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // LR Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }
    void preorder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
}
```

Here is how the main class will look like:

```java
public class Main {

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Inorder Traversal:");

        tree.inorder(tree.root);
    }
}
```