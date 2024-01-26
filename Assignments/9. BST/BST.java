class BinarySearchTree {

    node root;
    node ptr;

    class node {
        node L = null;
        int data;
        node R = null;
    }

    void insertion(int val) {
        node n = new node();
        n.data = val;
        ptr = root;
        if (root == null)
            root = n;
        else {
            while (n.data != ptr.data) {
                if (n.data < ptr.data) {
                    if (ptr.L != null)
                        ptr = ptr.L;
                    else {
                        ptr.L = n;
                        break;
                    }
                } else {
                    if (ptr.R != null)
                        ptr = ptr.R;
                    else {
                        ptr.R = n;
                        break;
                    }
                }
            }
        }
    }

    void PostTraverse(node ptr) {
        if (ptr != null) {
            PostTraverse(ptr.L);
            PostTraverse(ptr.R);
            System.out.print(" " + ptr.data);
        }
    }

    void postorder() {
        System.out.println("\npost order traverse\n");
        PostTraverse(root);
    }

    void PreTraverse(node ptr) {
        if (ptr != null) {
            System.out.print(" " + ptr.data);
            PreTraverse(ptr.L);
            PreTraverse(ptr.R);
        }
    }

    void preorder() {
        System.out.println("\npre order traverse\n");
        PreTraverse(root);
    }

    void InTraverse(node ptr) {
        if (ptr != null) {
            InTraverse(ptr.L);
            System.out.print(" " + ptr.data);
            InTraverse(ptr.R);
        }
    }

    void inorder() {
        System.out.println("In order traverse\n");
        InTraverse(root);
    }

    node search(int val) {
        ptr = root;
        while (ptr != null) {
            if (ptr.data == val)
                return ptr;
            if (val < ptr.data)
                ptr = ptr.L;
            else
                ptr = ptr.R;
        }
        return null;
    }

    node delete(node temp, int val) {
        if (temp == null)
            return null;
        if (val < temp.data)
            temp.L = delete(temp.L, val);
        else if (val > temp.data)
            temp.R = delete(temp.R, val);
        else {
            if (temp.L == null && temp.R == null)
                return null;

            // single child

            if (temp.L == null || temp.R == null) {
                node child = temp.L != null ? temp.L : temp.R;
                return child;
            }

            // two children node

            node pred, parpred;
            pred = temp;
            parpred = temp.L;
            while (pred.R != null) {
                parpred = pred;
                pred = pred.R;
            }
            temp.data = pred.data;
            if (parpred.R == pred)
                parpred.R = delete(pred, pred.data);
            else if (parpred.L == pred)
                parpred.L = delete(pred, pred.data);
            }
        return temp;

    }
}

public class BST {
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();

        bt.insertion(60);
        bt.insertion(40);
        bt.insertion(90);
        bt.insertion(20);
        bt.insertion(50);
        bt.insertion(80);
        bt.insertion(100);
        bt.insertion(70);
        bt.insertion(85);
        bt.insertion(65);

        bt.inorder();
        bt.postorder();
        bt.preorder();

        BinarySearchTree.node temp=bt.search(100);
        if (temp != null) {
        System.out.println("\nNode with value found!");
        } else {
        System.out.println("\nNode with value not found.");
        }

        bt.root = bt.delete(bt.root, 80);
        bt.preorder();
    }
}