public class one{
    public static void main(String[] args){
        one o = new one();
        System.out.println(o.sumN(5));
    }

    int sumN(int x){
        int add=0;
        if(x==1)
            return 1;
        add=x+sumN(x-1);
        return add;
    }
}