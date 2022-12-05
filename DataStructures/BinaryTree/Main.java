package BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.addict(10);
        tree.addict(5);
        tree.addict(14);
        tree.addict(9);
        tree.addict(6);
        tree.addict(2);
        tree.InOrder(tree.getRoot());

        tree.remove(9);

        tree.InOrder(tree.getRoot());
    }
}
