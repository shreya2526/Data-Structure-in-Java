class DLL{
    node start;

    class node{
        int data;
        node prev;
        node next;
    }

    boolean isEmpty(){
        if(start==null)
            return true;
        return false;
    }

    void AddBeg(int val){
        node n = new node();
        n.data=val;
        if(isEmpty())
            start=n;
        else{
            n.next=start;
            start.prev=n;
            start=n;
        }
    }

    void AddEnd(int val){
        node n = new node();
        n.data=val;
        if(isEmpty())
            start=n;
        else{
            node temp=start;
            while(temp.next!=null)
                temp=temp.next;
            temp.next=n;
            n.prev=temp;
        }
        
    }

    void search(int val){
        if(isEmpty())
            System.out.println("List is empty");
        else{
            node temp=start;
            int ci=1;
            while(temp.data!=val){
                temp=temp.next;
                ci++;
            }
            try{
                if(temp.data==val)
                    System.out.println(val+" element has benn found at "+ci+"th position");
                else
                    System.out.println("not found");
            }
            catch(NullPointerException n){
                System.out.println(n.getMessage());
            }
        }
    }

    void AddAfterIndex(int val, int index){
        node n = new node();
        n.data=val;
        if(isEmpty())
            start=n;
        else{
            node temp=start;
            int ci=0;
            while(temp!=null && ci<index-1){
                temp=temp.next;
                ci++;
            }
            n.prev=temp;
            n.next=temp.next;
            temp.next.prev=n;
            temp.next=n;
        }
    }

    void DelBeg(){
        if(isEmpty())
            System.out.println("List is empty");
        else
            start=start.next;
    }

    void DelEnd(){
        if(isEmpty())
            System.out.println("List is empty");
        else{
            node temp=start;
            while(temp.next!=null)
                temp=temp.next;
            temp.prev.next=null;
            temp.prev=null;
        }
    }

    void DelValue(int val){
        if(isEmpty())
            System.out.println("List is empty");
        else{
            node temp=start;
            node f = temp;
            while(temp.data!=val){
                f=temp;
                temp=temp.next;
            }
            f.next=temp.next;
            temp.next.prev=f;
            temp.prev=temp.next=null;
        }
    }

    void show(){
        node temp=start;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}


public class DoublyLinkedList{
    public static void main(String[] args) {
        DLL d = new DLL();
        d.AddBeg(2);
        d.AddBeg(3);
        d.AddEnd(1);
        d.AddEnd(2);
        d.AddAfterIndex(4, 2);
        d.show();
        d.search(4);
        d.DelValue(2);
        d.show();
    }
}