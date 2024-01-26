public class three {
    public static void main(String[] args) {
        three th = new three();
        System.out.println(th.oddSum(5));
    }

    int oddSum(int x){
        int add=0;
        if(x==1)
            return x;
        add=(2*x-1)+oddSum(x-1);
        return add;
    }
}
