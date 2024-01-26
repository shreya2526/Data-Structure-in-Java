class queue {
    int[] q;
    int f, r;

    public queue(int size) {
        q = new int[size];
        f = 0;
        r = -1;
    }

    public void enqueue(int x) {
        try {
            q[r + 1] = x;
            r++;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Queue is full");
        }
    }

    public void dequeue() {
        System.out.println("deleted element=" + q[f]);
        int i = 0;
        for (i = 0; i < r; i++) {
            q[i] = q[i + 1];
        }
        q[r] = 0;
        r--;
    }

    public int rearVal() {
        return q[r];
    }

    public int frontVal() {
        return q[f];
    }

    public void show() {
        if (underflow())
            System.out.println("queue is empty");
        else {
            System.out.println("queue elements:");
            for (int i = 0; i < q.length; i++)
                System.out.print(q[i] + " ");
            System.out.println();
        }
    }

    public boolean underflow() {
        if (r == -1)
            return true;
        else
            return false;
    }

    public boolean overflow() {
        if (r >= q.length)
            return true;
        else
            return false;
    }

    public int count() {
        int c = 0;
        for (int i = 0; i <= r; i++) {
            if (q[i] != 0)
                c++;
        }
        return c;
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
        queue q = new queue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.show();
        q.enqueue(60);
        System.out.println("Total elements in queue: " + q.count());
        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.show();

        System.out.println("last element in queue is: " + q.rearVal());
        System.out.println("first element in queue is: " + q.frontVal());
        System.out.println("Total elements in queue: " + q.count());

        q.dequeue();
        q.dequeue();
        System.out.println("Total elements in queue: " + q.count());
        q.show();
    }
}
