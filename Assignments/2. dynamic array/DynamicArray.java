class arrays{
    private int lastIndex;
    private int []ptr;

    public arrays(){
        lastIndex=-1;
        ptr=new int[1];
    }

    public void DoubleSize(){
        try{
            int[] ptr1 = new int[2*ptr.length];
            for(int i=0;i<=lastIndex;i++){
                ptr1[i]=ptr[i];
            }
            ptr=ptr1;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array size is full");
        }
    }

    public void HalfSize(){
        try{
            int[] ptr1 = new int[ptr.length/2];
            for(int i=0;i<=lastIndex;i++){
                ptr1[i]=ptr[i];
            }
            ptr=ptr1;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array size is full");
        }
    }

    public void append(int data){
        try{
            
            if(lastIndex+1==ptr.length){
                DoubleSize();
            }
            ptr[lastIndex+1]=data;
            lastIndex++;
            
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
    public void insert(int index, int data){
        try{
            if(index<0 || index>lastIndex+1){
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
            if(lastIndex+1==ptr.length)
                DoubleSize();
            for(int i=lastIndex;i>=index;i--){
                ptr[i+1]=ptr[i];
            }
            ptr[index]=data;
            lastIndex++;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
    public void edit(int index,int newData){
        try{
            if (index < 0 || index > lastIndex + 1)
                throw new ArrayIndexOutOfBoundsException("Invalid Index");
            ptr[index]=newData;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(int index){
        try{
            if(index<0 || index>lastIndex+1){
                throw new ArrayIndexOutOfBoundsException("Invalid index");
            }
            for(int i = index; i<lastIndex;i++){
                ptr[i]=ptr[i+1];
            }
            lastIndex--;
            if(ptr.length>1 && lastIndex+1==ptr.length/2)
                HalfSize();
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

    public int getValue(int index){
        try{
            if(index<0 || index>lastIndex+1)
                throw new ArrayIndexOutOfBoundsException("Invalid index");
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

public class DynamicArray{
    public static void main(String[] args) {
        arrays a = new arrays();
        a.append(10);
        a.append(20);
        a.append(30);
        a.append(40);
        a.append(50);
        for(int i=0;i<a.count();i++)
            System.out.print(a.getValue(i)+" ");
        System.out.println("Capacity: "+a.getCapacity());
        a.delete(1);
        for(int i=0;i<a.count();i++)
            System.out.print(a.getValue(i)+"  ");
        System.out.println("Capacity: "+a.getCapacity());
    }
}