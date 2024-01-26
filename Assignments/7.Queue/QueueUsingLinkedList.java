class QL{
    node front;
    node rear;

    public QL(){
        front=null;
        rear=null;
    }

    class node{
        int data;
        node next;
    }

    public void Enqueue(int val){
        node n =new node();
        n.data=val;
        if(Underflow()){
            rear=n;
            front=n;
        }
        else{
            rear.next=n;
            rear=n;
        }
    }

    public void Dequeue(){
        if(Underflow())
            System.out.println("Queue underflow");
        else
            front=front.next;
    }

    boolean Underflow(){
        return rear==null && front==null;
    }

    public int frontVal(){
        return front.data;
    }

    public int rearVal(){
        return rear.data;
    }

    public int count(){
        int c=0;
        node temp=front;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        return c;
    }

    public void show(){
        node temp=front;
        System.out.println("Queue items are:");
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}

public class QueueUsingLinkedList {
    public static void main(String[] args) {
        QL q = new QL();
        
        q.Enqueue(10);
        q.Enqueue(20);
        q.Enqueue(30);
        System.out.println("Oldest value: "+q.frontVal());
        System.out.println("Newest value: "+q.rearVal());
        System.out.println("Total number of elements in Queue is: "+q.count());
        q.show();

        q.Dequeue();
        q.Dequeue();
        System.out.println("Oldest value: "+q.frontVal());
        System.out.println("Newest value: "+q.rearVal());
        System.out.println("Total number of elements in Queue is: "+q.count());
        q.show();
    }
}
