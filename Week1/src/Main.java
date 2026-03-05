public class Main {

    public static void main(String[] args) {

        AVL tree = new AVL();

        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Inorder Traversal:");

        tree.inorder(tree.root);
    }
}