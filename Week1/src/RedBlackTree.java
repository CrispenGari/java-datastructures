import java.util.LinkedList;
import java.util.Queue;

class RBNode {
    int value;
    RBNode left;
    RBNode right;
    RBNode parent;
    boolean color; // true = RED, false = BLACK

    public RBNode(int value) {
        this.value = value;
        this.color = true; // New nodes are RED
        left = null;
        right = null;
        parent = null;
    }
}

public class RedBlackTree {
    RBNode root;

    public RedBlackTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        RBNode node = new RBNode(value);
        root = bstInsert(root, node);
        fixViolation(node);
    }

    private RBNode bstInsert(RBNode root, RBNode node) {
        if (root == null)
            return node;

        if (node.value < root.value) {
            root.left = bstInsert(root.left, node);
            root.left.parent = root;
        } else if (node.value > root.value) {
            root.right = bstInsert(root.right, node);
            root.right.parent = root;
        }

        return root;
    }
    private void rotateLeft(RBNode x) {
        RBNode y = x.right;
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;

        y.parent = x.parent;

        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    private void rotateRight(RBNode y) {
        RBNode x = y.left;
        y.left = x.right;

        if (x.right != null)
            x.right.parent = y;

        x.parent = y.parent;

        if (y.parent == null)
            root = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        x.right = y;
        y.parent = x;
    }

    private void fixViolation(RBNode node) {
        while (node != root && node.parent.color == true) {

            RBNode parent = node.parent;
            RBNode grandparent = parent.parent;

            if (parent == grandparent.left) {

                RBNode uncle = grandparent.right;

                if (uncle != null && uncle.color == true) {
                    parent.color = false;
                    uncle.color = false;
                    grandparent.color = true;
                    node = grandparent;
                } else {

                    if (node == parent.right) {
                        node = parent;
                        rotateLeft(node);
                    }

                    parent.color = false;
                    grandparent.color = true;
                    rotateRight(grandparent);
                }

            } else {

                RBNode uncle = grandparent.left;

                if (uncle != null && uncle.color == true) {
                    parent.color = false;
                    uncle.color = false;
                    grandparent.color = true;
                    node = grandparent;
                } else {

                    if (node == parent.left) {
                        node = parent;
                        rotateRight(node);
                    }

                    parent.color = false;
                    grandparent.color = true;
                    rotateLeft(grandparent);
                }
            }
        }

        root.color = false;
    }

    public boolean search(int value) {
        return searchTree(root, value);
    }

    private boolean searchTree(RBNode root, int value) {
        if (root == null)
            return false;

        if (value == root.value)
            return true;

        if (value < root.value)
            return searchTree(root.left, value);

        return searchTree(root.right, value);
    }

    public int findMin() {
        RBNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public int findMax() {
        RBNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    public RBNode delete(RBNode root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.value) {
            root.left = delete(root.left, value);
        } else if (value > root.value) {
            root.right = delete(root.right, value);
        } else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            root.value = findMinNode(root.right).value;
            root.right = delete(root.right, root.value);
        }

        return root;
    }

    private RBNode findMinNode(RBNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public void inorder(RBNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + ", ");
            inorder(root.right);
        }
    }

    public void preorder(RBNode root) {
        if (root != null) {
            System.out.print(root.value + ", ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(RBNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value + ", ");
        }
    }

    public void bfs() {
        if (root == null)
            return;

        Queue<RBNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            RBNode current = queue.poll();
            System.out.print(current.value + ", ");

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }
    }
    public int height(RBNode root) {
        if (root == null)
            return -1;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

}