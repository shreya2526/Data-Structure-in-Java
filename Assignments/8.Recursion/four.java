public class four {
    public static void main(String[] args) {
        four f = new four();
        f.OddPrintN(5);
    }

    public void OddPrintN(int x) {
        if (x>0){
            System.out.println(x*2-1);
            OddPrintN(x-1);
        }

    }
}