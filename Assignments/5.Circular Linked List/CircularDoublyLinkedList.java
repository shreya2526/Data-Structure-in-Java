class CDLL {
    node start;

    class node {
        node prev;
        int data;
        node next;
    }

    void AddBeg(int val) {
        node n = new node();
        n.data = val;
        if (isEmpty()) {
            start = n;
            n.prev = n;
            n.next = n;
        } else {
            n.next = start;
            n.prev = start.prev;
            start.prev.next = n;
            start.prev = n;
            start = n;
        }
        System.out.println(val + " is insereted at beginning");
    }

    void AddEnd(int val) {
        node n = new node();
        n.data = val;
        if (isEmpty()) {
            start = n;
            n.prev = n;
            n.next = n;
        } else {
            n.next = start;
            n.prev = start.prev;
            start.prev.next = n;
            start.prev = n;
        }
        System.out.println(val + " is inserted at end");
    }

    void AddAfterNode(int val, int index) {
        node n = new node();
        n.data = val;
        if (isEmpty()) {
            System.out.println("List is empty. New node has been inserted as 1st node");
            start = n;
            n.prev = n;
            n.next = n;
        } else {
            int count = 0;
            node t = start;
            while (t != null && count < index - 1) {
                t = t.next;
                count++;
            }
            n.next = t.next;
            n.prev = t;
            t.next.prev = n;
            t.next = n;
        }
        System.out.println(val + " is inserted after " + index + " position");
    }

    void DelBeg() {
        if (isEmpty())
            System.out.println("list is empty");
        else {
            System.out.println(start.data + " is deleted");
            start.next.prev = start.prev;
            start.prev.next = start.next;
            start = start.next;
        }
    }

    void DelEnd() {
        if (isEmpty())
        System.out.println("list is empty");
        else {
            System.out.println(start.prev.data + " is deleted");
            start.prev.prev.next = start;
            start.prev = start.prev.prev;
        }
    }

    void DelAfterNode(int index) {
        if (isEmpty())
            System.out.println("list is empty");
        else {
            node t = start;
            int count = 0;
            int val;
            while (t != null && count < index - 1) {
                t = t.next;
                count++;
            }
            val = t.next.data;
            t.next.next.prev = t;
            t.next = t.next.next;
            System.out.println(val + " is deleted from " + (index+1) + " position");
        }
    }

    void search(int val) {
        if (isEmpty())
            System.out.println("list is empty");
        else {
            node t = start;
            int count = 1;
            if (t.data == val)
                System.out.println(val + " is found at 1st postion");
            else {
                do {
                    t = t.next;
                    count++;
                } while (t.data != val && t != start);
                if (t.data == val)
                    System.out.println(val + " is found at " + count + " position\n");
                else
                    System.out.println(val + " is not found\n");
            }

        }
    }

    boolean isEmpty() {
        if (start == null)
            return true;
        return false;
    }

    void show() {
        System.out.println("\nList elements are:");
        node t = start;
        do {
            System.out.print(t.data + " ");
            t = t.next;
        } while (t != start);
        System.out.println("\n");
    }
}

public class CircularDoublyLinkedList {
    public static void main(String[] args) {
        CDLL cd = new CDLL();
        cd.AddEnd(2);
        cd.AddBeg(1);
        cd.AddEnd(4);
        cd.AddEnd(5);
        cd.AddAfterNode(3, 2);
        cd.show();
        cd.search(4);
        cd.DelBeg();
        cd.DelEnd();
        cd.show();
        cd.search(3);
        cd.DelAfterNode(1);
        cd.show();
        cd.search(2);
    }
}