public class five {
    public static void main(String[] args) {
        five fi = new five();
        fi.DecToOct(25);
    }

    void DecToOct(int n){
        if(n>0){
            DecToOct(n/8);
            System.out.print(n%8);
        }
    }
}
