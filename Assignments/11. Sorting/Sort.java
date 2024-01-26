public class Sort{
    public static void main(String[] args) {
        myArray a = new myArray();
        a.append(30);
        a.append(20);
        a.append(10);
        a.append(50);
        a.append(40);
        for(int i=0;i<a.count();i++)
            System.out.print(a.getValue(i)+" ");
        // System.out.println("Capacity: "+a.getCapacity());
        // a.delete(1);
        // for(int i=0;i<a.count();i++)
        //     System.out.print(a.getValue(i)+"  ");
        // System.out.println("Capacity: "+a.getCapacity());
        // a.bubbleSort();
        // System.out.println("\n\nBubble sort\n");
        // for(int i=0;i<a.count();i++)
        //     System.out.print(a.getValue(i)+" ");

        // a.modifiedBubbleSort();
        // System.out.println("\n\nModified Bubble sort\n");
        // for(int i=0;i<a.count();i++)
        //     System.out.print(a.getValue(i)+" ");

        // a.selectionSort();
        // System.out.println("\n\nSelection sort\n");
        // for(int i=0;i<a.count();i++)
        //     System.out.print(a.getValue(i)+" ");

        // a.insertionSort();
        // System.out.println("\n\nInsertion sort\n");
        // for(int i=0;i<a.count();i++)
        //     System.out.print(a.getValue(i)+" ");

        // a.quickSort(0,a.count()-1);
        // System.out.println("\n\nQuick sort\n");
        // for(int i=0;i<a.count();i++)
        //     System.out.print(a.getValue(i)+" ");

        // a.mergeSort(0,a.count()-1);
        // System.out.println("\n\nMerge sort\n");
        // for(int i=0;i<a.count();i++)
        //     System.out.print(a.getValue(i)+" ");
        
    }
}

interface Sorting{
    void bubbleSort();
    void modifiedBubbleSort();
    void selectionSort();
    void insertionSort();
    void quickSort(int l, int u);
    void mergeSort(int l, int u);
    //void heapSort();
}

class myArray implements Sorting{
    private int lastIndex;
    private int []ptr;

    public myArray(){
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

    public void bubbleSort(){
        int r,i,t;
        for(r=1;r<=count()-1;r++){
            for(i=0;i<=count()-1-r;i++){
                if(ptr[i]>ptr[i+1]){
                    t=ptr[i];
                    ptr[i]=ptr[i+1];
                    ptr[i+1]=t;
                }
            }
        }
    }

    public void modifiedBubbleSort(){
        int r,i,t;
        boolean flag=false;
        for(r=1;r<=count()-1;r++){
            for(i=0;i<=count()-1-r;i++){
                if(ptr[i]>ptr[i+1]){
                    flag=true;
                    t=ptr[i];
                    ptr[i]=ptr[i+1];
                    ptr[i+1]=t;
                }
            }
            if(flag==false)
                break;
        }
    }

    public int minValue(int num){
        int i, min, mi;
        min=ptr[num];
        mi=num;
        for(i=num+1;i<count()-1;i++){
            if(min>ptr[i]){
                min=ptr[i];
                mi=i;
            }
        }
        return mi;
    }

    public void selectionSort(){
        int i,t,min;
        for(i=0;i<=count()-2;i++){
            min=minValue(i);
            t=ptr[i];
            ptr[i]=ptr[min];
            ptr[min]=t;
        }
    }

    public void insertionSort(){
        int i,j,t;
        for(i=1;i<count();i++){
            t=ptr[i];
            for(j=i-1;j>=0;j--){
                if(t<ptr[j])
                    ptr[j+1]=ptr[j];
                else
                    break;
            }
            ptr[j+1]=t;
        }
    }

    public int quick(int left, int right){
        int loc, t;
        loc=left;
        while(left<right){
            while(left<right &&  ptr[loc]<=ptr[right])
                right--;
            if(left==right)
                break;
            t=ptr[loc];
            ptr[loc]=ptr[right];
            ptr[right]=t;
            loc=right;

            while(left<right && ptr[left]<=ptr[loc])
                left++;
            if(left==right)
                break;
            t=ptr[left];
            ptr[left]=ptr[loc];
            ptr[loc]=t;
            loc=left;
            
        }

        return loc;
    }

    public void quickSort(int l, int u){
        int loc;
        loc=quick(l,u);
        if(loc>l)
            quickSort(l, loc-1);
        if(loc<u-l)
            quickSort(loc+1, u);

    }

    public void merging(int l, int n, int u){
        int left[]=new int[n-l+1];
        int right[]=new int[u-n];
        int i,j,k;
        for(i=0;i<n-l+1;i++){
            left[i]=ptr[l+i];        
        }
        for(j=0;j<u-n;j++)
            right[j]=ptr[n+1+j];

        for(i=0,j=0,k=l;i<n-l+1 && j<u-n; k++){
            if(left[i]<right[j]){
                ptr[k]=left[i];
                i++;
            }
            else{
               ptr[k]=right[j];
               j++; 
            }
        }
        while(i<n-l+1){
            ptr[k]=left[i];
            i++;
            k++;
        }
        while(j<u-n){
            ptr[k]=right[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int l, int u){
        int n;
        if(l<u){
            n=(l+u)/2;
            mergeSort(l, n);
            mergeSort(n+1, u);
            merging(l,n,u);
        }        
    }

    // public void heapSort(){
    //     Heap h = new Heap(count());
    //     for(int i=0;i<count();i++)
    //         h.insertion(ptr[i]);
    //     for(int i=count()-1;i>=0;i--)
    //         ptr[i]=h.delete();
    //     h.traverse();
    // }
}

class Heap {
    int lastIndex;
    int[] ptr;

    public Heap(int size) {
        ptr = new int[size];
        lastIndex = -1;
    }

    boolean isFull() {
        return lastIndex + 1 == ptr.length;
    }

    void insertion(int val) {
        if (isFull()) {
            int temp[];
            temp = new int[ptr.length * 2];
            for (int i = 0; i <= lastIndex; i++)
                temp[i] = ptr[i];
            ptr = temp;
        }
        int index, parIndex;
        for (index = lastIndex + 1; index > 0; index = parIndex) {
            parIndex = (index - 1) / 2;
            if (ptr[parIndex] < val) {
                ptr[index] = ptr[parIndex];
            } else
                break;
        }
        ptr[index] = val;
        lastIndex++;
    }

    boolean isEmpty() {
        return lastIndex == -1;
    }

    int top() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Heap is empty");
        }
        return ptr[0];
    }

    int delete() throws ArrayIndexOutOfBoundsException {
        int item, temp, index, lIndex, rIndex;
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("heap is empty");
        } else {
            item = ptr[0];
            temp = ptr[lastIndex];
            lastIndex--;
            index = 0;
            lIndex = 1;
            rIndex = 2;
            //double child
            while (lIndex < lastIndex) {
                if (ptr[lIndex] > ptr[rIndex]){
                    if (temp < ptr[lIndex]) {
                        ptr[index] = ptr[lIndex];
                        index = lIndex;
                    } else
                        break;
                }
                else {
                    if (temp < ptr[rIndex]) {
                        ptr[index] = ptr[rIndex];
                        index = rIndex;
                    } else
                        break;
                }
                lIndex = 2 * index + 1;
                rIndex = 2 * index + 2;
            }
            // single child
            if (lIndex == lastIndex && temp<ptr[lastIndex]) {
                ptr[index]=ptr[lIndex];
                index=lIndex;
            }
            ptr[index]=temp;
            ptr[lIndex]=0;
            lastIndex--;
            return item;
        }
    }

    void traverse(){
        for(int i=0;i<ptr.length;i++)
            System.out.print(" "+ptr[i]);
        System.out.println();
    }
}