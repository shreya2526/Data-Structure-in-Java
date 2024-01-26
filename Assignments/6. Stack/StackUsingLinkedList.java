class Stack{
    private Node top;
    class Node{
        private int data;
        private Node next;
    }

    void push(int x){
        Node n = new Node();
        n.data=x;
        n.next=top;
        top=n;
    }

    int peek(){
        int x=0;
        try{
            x=top.data;
        }
        catch(NullPointerException e){
            System.out.println("Stack is empty");
        }
        return x;
    }

    int pop(){
        int x = 0;
        try{
            x=top.data;
            top=top.next;
        }
        catch(NullPointerException e){
            System.out.println("Stack Underflow");
        }
        return x;
    }

    boolean isEmpty(){
        return top==null;
    }

    void reverse(){
        Stack temp = new Stack();
        while(!isEmpty())
            temp.push(pop());
        
        Stack t = new Stack();
        while(!temp.isEmpty())
            t.push(temp.pop());
        
        while(!t.isEmpty())
            push(t.pop());
    }

    //other technique to reverse
    /* 
    public static Stack reverse(Stack s){
        Stack temp = new Stack();
        while(!s.isEmpty()){
            temp.push(s.pop());
        }
        return temp;
    }*/
}

public class StackUsingLinkedList {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("top item: "+s.peek());
        s.reverse();
        System.out.println("Top item after reversing: "+s.peek());
        /* 
        s=Stack.reverse(s); 
        System.out.println("Top item after reversing: "+s.peek());
        */
    }
}
