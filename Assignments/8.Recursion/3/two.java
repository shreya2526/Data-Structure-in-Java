public class two {
    public static void main(String[] args) {
        two t = new two();
        t.rev(4566);
    }

    void rev(int n){
        if(n>0){
            System.out.print(n%10+"");
            rev(n/10);
        }
    }
}
