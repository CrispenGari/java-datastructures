

public class Main{
    public static void  main(String[] args){
        AVL tree = new AVL();
        int[] array = {-2, 9, 0, 14, 6, 89, 100, 45, -54};
        for(int ele: array){
            tree.root = tree.insert(tree.root, ele);
        }
        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root);
        System.out.println("\nPreorder Traversal:");
        tree.preorder(tree.root);
    }
}