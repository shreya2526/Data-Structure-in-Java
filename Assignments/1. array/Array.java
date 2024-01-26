class arrayDS{
    private int lastIndex;
    private int[] ptr;
    
    public arrayDS(int size){
        lastIndex=-1;
        ptr=new int[size];
    } 

    public void append(int data){
        try{
            ptr[lastIndex+1]=data;
            lastIndex++;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array size is full");
        }
    }

    public void insert(int index, int data){
        try{
            if(index<0 || index>lastIndex+1)
                throw new ArrayIndexOutOfBoundsException("Invalid index");
            for(int i=lastIndex; i>=index; i--)
                ptr[i+1]=ptr[i];
            ptr[index]=data;
            lastIndex++;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        
    }

    public void edit(int index, int newData){
        try{
            if(index<0 || index>lastIndex)
                throw new ArrayIndexOutOfBoundsException("Invalid index");
            ptr[index]=newData;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(int index){
        try{
            if(index<0 || index>lastIndex)
                throw new ArrayIndexOutOfBoundsException("Invalid index");
            for(int i=index; i<lastIndex; i++)
                ptr[i]=ptr[i+1];
            lastIndex--;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public int count(){
        return lastIndex+1;
    }

    public boolean isEmpty(){
        return lastIndex==-1;
    }

    public boolean isFull(){
        return lastIndex+1==ptr.length;
    }

    public int getValue(int index){
        try{
            if(index<0 || index>lastIndex)
                throw new ArrayIndexOutOfBoundsException("invalid index");
            return ptr[index];
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int getCapacity(){
        return ptr.length;
    }
}

public class Array{
    public static void main(String[] args) {
        arrayDS arr = new arrayDS(4);
        arr.append(10);
        arr.append(20);
        arr.insert(0, 30);
        arr.insert(1, 40);
        arr.append(50);
        for(int i=0; i<arr.count();i++)
            System.out.print(arr.getValue(i)+" ");
    }
}