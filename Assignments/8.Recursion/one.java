public class one{
    public static void main(String[] args) {
        one o = new one();
        o.printN(5);
    }

    public void printN(int x){
        if(x==1)
            System.out.println(1);
        else{
            printN(x-1);
            System.out.println(x);
        }
    }
}