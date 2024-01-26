public class four {
    public static void main(String[] args) {
        four f = new four();
        f.DecToBin(33);
    }

    void DecToBin(int n){
        if(n>0){
            DecToBin(n/2);
            System.out.print(n%2);
        }
    }
}
