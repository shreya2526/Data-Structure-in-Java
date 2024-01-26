class CSLL {
    node last;

    class node {
        int data;
        node next;
    }

    void AddBeg(int val) {

        node n = new node();
        n.data = val;

        if (isEmpty()) {
            n.next = n;
            last = n;
        } else {
            n.next = last.next;
            last.next = n;
            last = n.next;
        }
    }

    void AddEnd(int val) {
        node n = new node();
        n.data = val;
        if (isEmpty())
            n.next = n;
        else {
            n.next = last.next;
            last.next = n;
        }
        last = n;
    }

    void AddAfterNode(int val, node t) {
        if (t != null) {
            node n = new node();
            n.data = val;
            n.next = t.next;
            t.next = n;
            if (t == last)
                last = n;
        }
    }

    node search(int val){
        try{
            node t;
            t=last.next;
            do{
                if(t.data==val)
                    return t;
                t=t.next;
            }while(t!=last.next);
            return null;
        }
        catch(NullPointerException e){
            return null;
        }
    }

    void DelBeg() {
        if (isEmpty())
            System.out.println("List is empty");
        else {
            if (last.next == last)
                last = null;
            else
                last.next = last.next.next;
        }
    }

    void DelEnd(){
        if(last!=null){
            if(last.next==last)
                last=null;
            else{
                node t = last.next;
                while(t.next!=last)
                    t=t.next;
                t.next=last.next;
                last=t;
            }
        }
    }

    void DelNode(int val){
        node t = search(val);
        if(t!=null){
            if(last.next==last)
                last=null;
            else{
                if(t==last)
                    DelEnd();
                else{
                    node temp=last.next;
                    while(temp.next!=t)
                        temp=temp.next;
                    temp.next=t.next;
                }
            }
        }
    }

    void show() {
        node temp = last.next;
        System.out.println("Linked List elements are:");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println();
    }

    boolean isEmpty() {
        if (last == null)
            return true;
        return false;
    }
}

public class CircularSinglyLinkedList {
    public static void main(String[] args) {
        CSLL cl = new CSLL();
        cl.AddBeg(2);
        cl.AddBeg(1);
        cl.AddEnd(4);
        cl.AddEnd(5);
        cl.AddAfterNode(3, cl.last.next.next);
        cl.show();
        cl.DelBeg();
        cl.DelEnd();
        cl.DelNode(3);
        cl.show();
    }
}
