public class four {
    public static void main(String[] args) {
        four f = new four();
        System.out.println(f.fact(6));
    }

    int fact(int n){
        int f=1;
        if(n==1)
            return n;
        f=n*fact(n-1);
        return f;
    }
}
