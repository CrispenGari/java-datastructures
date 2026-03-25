


public class Main{

    public static void  main(String[] args){

        BST bst = new BST();

        System.out.printf("Is the tree empty: %b\n", bst
                .isEmpty());
        bst.insert(50);
        bst.insert(70); bst.insert(70); bst.insert(80); bst.insert(60);
        bst.insert(30); bst.insert(40); bst.insert(20); bst.insert(10); bst.insert(21);
        bst.insert(15);
        bst.insert(13);
        boolean exist13 = bst.search(13);
        boolean exists21 = bst.search(21);
        bst.insert(-2);

        System.out.printf("Is the tree empty: %b\n", bst
                .isEmpty());
        System.out.printf("13: %b\n", exist13);
        System.out.printf("21: %b\n", exists21);
        System.out.printf("50: %b\n", bst.search(50));
        System.out.printf("Minimum value: %d\n", bst.findMin());
        System.out.printf("Maximum value: %d\n", bst.findMax());

    }
}