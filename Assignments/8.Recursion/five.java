public class five {
    public static void main(String[] args) {
        five fi = new five();
        fi.EvenPrintN(5);
    }

    public void EvenPrintN(int x) {
        if(x>0){
            EvenPrintN(x-1);
            System.out.println(x*2);   
        }
    }
}