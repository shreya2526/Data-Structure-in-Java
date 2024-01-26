public class one {
    public static void main(String[] args) {
        one o = new one();
        for(int i =0;i<5;i++){
            System.out.print(o.fib(i)+" ");
        }
    }

    int fib(int n) {
        if(n==0 || n==1)
            return n;
        return fib(n-1)+fib(n-2);

    }
}