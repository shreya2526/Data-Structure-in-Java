public class three {
    public static void main(String[] args) {
        three th = new three();
        th.OddPrintN(5);
    }

    public void OddPrintN(int x) {
        if(x>0){
            OddPrintN(x-1);
            System.out.println(x*2-1);
        }

    }
}