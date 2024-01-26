class Stack {
    private int top;
    private int ptr[];

    public Stack(int n) {
        top = -1;
        ptr = new int[n];
    }

    void push(int x) {

        try {
            ptr[top+1] = x;
            top++;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    int pop(){
        int x=0;
        try{
            x=ptr[top];
            top--;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return x;
    }

    int peek(){
        int x=0;
        try{
            x=ptr[top];
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return x;
    }

    boolean isEmpty(){
        if(top==-1)
            return true;
        return false;
    }

    boolean isFull(){
        if(top==ptr.length-1)
            return true;
        return false;
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("First element of stack: "+s.peek());
        System.out.println("Deleted element: "+s.pop());
        System.out.println("First element of stack: "+s.peek());
        System.out.println("Is stack full? "+s.isFull());
        s.pop();
        s.pop();
        System.out.println("Is stack empty? "+s.isEmpty());

    }
}