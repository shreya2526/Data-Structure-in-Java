public class heap {
    public static void main(String[] args) {
        HeapBody h = new HeapBody(5);
        h.insertion(35);
        h.insertion(90);
        h.insertion(60);
        h.insertion(45);
        h.insertion(50);
        h.insertion(100);
        h.traverse();
        h.delete();
        h.traverse();

    }
}

class HeapBody {
    int lastIndex;
    int[] ptr;

    public HeapBody(int size) {
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