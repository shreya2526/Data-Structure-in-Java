public class three {
    public static void main(String[] args) {
        three th = new three();
        System.out.println(th.sumSquare(5));
    }

    int sumSquare(int n){
        int sum=0;
        if(n>0){
            sum=(n*n)+sumSquare(n-1);
        }
        return sum;
    }
    
}
