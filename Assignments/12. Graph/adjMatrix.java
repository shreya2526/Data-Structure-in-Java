import java.util.Scanner;

class Graph{
    private int v_count;
    private int e_count;
    private int [][]adj;

    public void createGraph(int vno, int eno){
        v_count=vno;
        e_count=eno;
        adj=new int[v_count][e_count];
        int u,v;
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<v_count;i++){
                System.out.println("enter row num:");
                u=sc.nextInt();
                System.out.println("enter col num:");
                v=sc.nextInt();
                adj[u][v]=1;
                adj[v][u]=1;
        }
        sc.close();
    }

    public void PrintMatrix(){
        System.out.println("\nThe adjacency matrix is");
        for(int i=0;i<v_count;i++){
            for(int j=0;j<e_count;j++){
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void printAdjacentNode(int v){
        System.out.println("\nThe adjacent nodes of "+v+" is");
        if(v<v_count && v>=0){
            for(int i=0;i<v_count;i++){
                if(adj[v][i]==1)
                    System.out.println("v"+i);
            }
        }
    }

    public void isIsolate(int v){
        boolean flag=true;
        
        if(v<v_count && v>=0){
            for(int i=0;i<v_count;i++){
                if(adj[v][i]==1){
                    flag=false;
                    break;
                }
            }
        }
        System.out.println("\nis "+v+" vertex isolated? "+flag);
    }
    
}

public class adjMatrix{
    public static void main(String[] args) {
        Graph g = new Graph();
        g.createGraph(3,3);
        g.PrintMatrix();
        g.printAdjacentNode(2);
        g.isIsolate(1);
    }
}