import java.util.Scanner;

public class adjList {
    public static void main(String[] args) {
        GraphList gl = new GraphList();
        gl.createGraph(5);
        gl.printGraph();
    }
}

class GraphList{
    private int v_count;
    private adjlist []arr;

    class adjlist{
        private node start;
        private int vertex;

        public adjlist(int v){
            vertex=v;
            start=null;
        }

        public node getStart() {
            return start;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public void addNode(int v, int data){
            node n = new node();
            n.setItem(data);
            n.setVertex(v);
            n.setNext(start);
            start=n;
        }

        public void removeFirstNode(){
            if(start!=null){
                start=start.getNext();
            }
        }

        public void printList(){
            node temp=start;
            while(temp!=null){
                System.out.println("(V"+temp.getVertex()+" "+temp.getItem()+")");
                temp=temp.next;
            }
        }


    }

    class node{
        int item;
        int vertex;
        node next;

        public int getItem(){
            return item;
        }

        public void setItem(int item){
            this.item=item;
        }

        public int getVertex(){
            return vertex;
        }

        public void setVertex(int v){
            this.vertex=v;
        }

        public node getNext(){
            return next;
        }

        public void setNext(node n){
            next=n;
        }
    }

    public GraphList(){
        v_count=0;
        arr=null;
    }

    public int getV_count(){
        return v_count;
    }

    public void createGraph(int vno){
        v_count=vno;
        arr=new adjlist[v_count];
        Scanner sc = new Scanner(System.in);
        int n, v, data;
        for(int i=0;i<v_count;i++){
            arr[i]=new adjlist(v_count);
            arr[i].setVertex(i);
            System.out.println("how many adjancent node of v"+i+":");
            n=sc.nextInt();
            for(int j=0;j<n;j++){
                System.out.println("Enter vertex no: ");
                v=sc.nextInt();
                System.out.println("Enter data to store:");
                data=sc.nextInt();
                arr[i].addNode(v, data);
            }
        }
    }

    public void printGraph(){
        System.out.println("\nGraph:");
        for(int i=0;i<v_count;i++){
            System.out.println();
            arr[i].printList();
        }
    }
}