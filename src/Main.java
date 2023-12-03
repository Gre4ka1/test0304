import org.w3c.dom.Node;

import java.util.Scanner;

class BinaryTree {

    int value;
    BinaryTree lchild;
    BinaryTree rchild;
    public BinaryTree(int value) {
        this.value = value;
        this.lchild = null;
        this.rchild = null;
    }

    public BinaryTree insertNode(BinaryTree node, int targetValue) {
        if (node == null) {
            node = new BinaryTree(targetValue);
            return node;
        }
        if (node.value > targetValue) {
            if (node.lchild == null)
                return node.lchild = new BinaryTree(targetValue);
            else
                return insertNode(node.lchild, targetValue);
        }
        else if (node.value < targetValue) {
            if (node.rchild == null)
                return node.rchild = new BinaryTree(targetValue);
            else
                return insertNode(node.rchild, targetValue);
        }
        return null;
    }
    public static int height(BinaryTree root){
        if (root==null){
            return 0;
        }
        return 1+Math.max(height(root.lchild),height(root.rchild));
    }

}
public class Main{
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int a = in.nextInt();
        BinaryTree tree = new BinaryTree(a);
        if (a==0) return;
        do {
            a = in.nextInt();
            if (a==0) break;
            tree.insertNode(tree,a);
        }while (a!=0);
            System.out.println(BinaryTree.height(tree)-1);

    }
}