class SLL{
    node start;

    class node{
        int data;
        node next;

        void setData(int val){
            data=val;
        }

        int getData(){
            return data;
        }
    }

    Boolean isEmpty(){
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
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=n;
        }
    }

    void AddAfterIndex(int val, int ind){
        node n = new node();
        n.data=val;
        if(isEmpty())
            start=n;
        else{
            int ci=0;
            node temp=start;
            while(temp!=null && ci<ind-1){
                temp=temp.next;
                ci++;
            }
            n.next=temp.next;
            temp.next=n;
        }
    }

    void DelBeg(){
        if(isEmpty())
            System.out.println("List is empty");
        else{
            start=start.next;
        }
    }

    void DelEnd(){
        if(isEmpty())
            System.out.println("List is empty");
        else{
            node head=start;
            node f = head;
            while(head.next!=null){
                f=head;
                head=head.next;
            }
            f.next=null;
        }
    }

    void Delvalue(int val){
        if(isEmpty())
            System.out.println("List is empty");
        else{
            node temp = start;
            node f = temp;
            while(temp.data!=val){
                f=temp;
                temp=temp.next;
            }
            f.next=temp.next;
        }
    }

    void show(){
        node temp=start;
        while(temp!=null){
            System.out.print(" "+temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
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
            if(temp.data==val)
                System.out.println(val+" element has found in "+ci+"th position");
            else
                System.out.println(val+" element has not found");
        }
    }
    
}

public class SinglyLinkedList{
    public static void main(String[] args) {
       SLL s = new SLL();
        s.AddEnd(3);
        s.AddBeg(2); 
        s.AddBeg(1);
        s.AddAfterIndex(4, 2);
        s.AddEnd(4);
        s.show();
        s.search(1);
        //s.DelBeg();
        //s.show();
        s.Delvalue(4);
        s.show();

    }
}