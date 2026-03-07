import java.util.LinkedList;
import java.util.Queue;

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

public class BST {
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
