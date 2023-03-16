public class ArrayIvan<T> {
    private static final int startSize = 1;
    private T[] array;
    private int size;

    public ArrayIvan() {
        this.size = 0;
        this.array = (T[]) new Object[startSize];
    }

    public ArrayIvan(T[] array) {
        this.size = array.length;
        this.array = array;
    }

    public int Length() {
        return array.length;
    }

    public void add(T element) {
        if (this.size == this.array.length) {
            addLength();
        }
        this.array[this.size++] = element;
    }

    private void addLength() {
        int newLen = this.array.length + 8;
        T[] newArr = (T[]) new Object[newLen];

        for (int i = 0; i < this.array.length; i++) {
            newArr[i] = this.array[i];
        }
        this.array = newArr;
    }
    
    public void removeAt(int index) throws Exception {
        if (index > this.size - 1 || index < 0) {
            throw new Exception(String.format("Index %d out of range", index));
        } else {
            int newLen = this.size - 1;
            T[] newArr = (T[]) new Object[newLen];

            int i = 0;
            while (i < index) {
                newArr[i] = this.array[i];
                i++;
            }
            i++;
            while (i < this.size) {
                newArr[i] = this.array[i];
                i++;
            }
            this.array = newArr;
            this.size--;
        }
    }

    /**
     * Если не передашь параметр index, то index = 0.
     */
    public void removeAt() {
        int index = 0;
        int newLen = this.size - 1;
        T[] newArr = (T[]) new Object[newLen];
        
        int i = 1;
        while (i < this.size) {
            newArr[index] = this.array[i];
            i++;
            index++;
        }

        this.array = newArr;
        this.size--;
    }

    public void remove(T element) {
        
    }
}