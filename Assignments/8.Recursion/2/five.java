public class five{
    public static void main(String[] args) {
        five fi = new five();
        System.out.println(fi.sumDigit(36738789));
    }

    int sumDigit(int n){
        int add=0;
        if(n>0){
            int n1=n%10;
            add=n1+sumDigit(n/10);
        }
        return add;
    }
}