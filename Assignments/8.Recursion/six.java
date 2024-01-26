public class six {
    public static void main(String[] args) {
        six s = new six();
        s.EvenPrintN(5);
    }

    public void EvenPrintN(int x) {
        if (x>0){
            System.out.println(x*2);
            EvenPrintN(x-1);
        }

    }
}