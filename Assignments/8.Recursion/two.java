public class two{
    public static void main(String[] args) {
        two t = new two();
        t.printN(5);
    }

    public void printN(int x){
        if(x==1)
            System.out.println(1);
        else{
            System.out.println(x);
            printN(x-1);
        }
    }
}