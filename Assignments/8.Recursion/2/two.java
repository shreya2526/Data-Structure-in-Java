public class two {
    public static void main(String[] args) {
        two t = new two();
        System.out.println(t.evenSum(5));
    }

    int evenSum(int n){
        int add=0;
        if(n==1)
            return 2*n;
        add=2*n+evenSum(n-1);
        return add;

    }
}
