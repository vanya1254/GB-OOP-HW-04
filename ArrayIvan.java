

public class ArrayIvan<T> {
    private static final int startSize = 1;
    private T[] array;
    private int size;

    public ArrayIvan() {
        this.size = 0;
        this.array = (T[]) new Object[startSize];
        // this.array = (T[]) Array.newInstance(getClass(), this.startSize);
    }
    
    public ArrayIvan(T[] array) {
        this.array = array;
        this.size = array.length;
    }

    public void add(T element) {
        if (this.size == this.array.length) {
            addLength();
        }
        this.array[this.size++] = element;
    }

    private void addLength() {
        int newLen = this.array.length + 1;
        T[] newArr = (T[]) new Object[newLen];

        for (int i = 0; i < this.array.length; i++) {
            newArr[i] = this.array[i];
        }
        this.array = newArr;
    }
    
    public void removeAt(int index) throws Exception {
        if (index > this.size || index < 0) {
            throw new Exception(String.format("Index %d out of range", index));
        } else {
            int newLen = this.array.length - 1;
            T[] newArr = (T[]) new Object[newLen];

            int i = 0;
            while (i < index) {
                newArr[i] = this.array[i];
                i++;
            }
            i++;
            while (i < this.size) {
                newArr[i - 1] = this.array[i];
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

    public void remove(T element) throws Exception {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == element) {
                removeAt(i);
                i--;
            }
        }
    }

    /**
     * @return
     * 0 - String[]
     * 1 - Integer[]
     * 2 - Double[]
     * null - if not types of theese
     */
    private Integer checkType() {
        if (this.array[0] instanceof String) {
            return 0;
        } else if (this.array[0] instanceof Integer) {
            return 1;
        } else if (this.array[0] instanceof Double) {
            return 2;
        }
        return null;
    }

    /**
     * @return
     * Вернет либо минимальное число массива, либо кротчайшую строку.
     * String, Integer, Double, else null.
     */
    public T min() {
        T min;
        if (checkType() == 0) {
            min = minString();
        } else if (checkType() == 1) {
            min = minInteger();
        } else if (checkType() == 2) {
            min = minDouble();
        } else min = null;

        return min;
    }

    /**
     * @return
     * Вернет самую короткую строку в array.
     * (T) String
     */
    private T minString() {
        String min = (String) this.array[0];
        int countMin = min.length();

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null && countMin > ((String) this.array[i]).length()) {
                countMin = ((String) this.array[i]).length();
                min = (String) this.array[i];
            }
        }
        return (T) min;
    }

    /**
     * @return
     * Вернет минимальный элемент.
     * (T) Integer
     */
    private T minInteger() {
        Integer min = (Integer) this.array[0];

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null && min > (Integer) this.array[i]) {
                min = (Integer) this.array[i];
            }
        }

        return (T) min;
    }

    /**
     * @return
     * Вернет минимальный элемент.
     * (T) Double
     */
    private T minDouble() {
        Double min = (Double) this.array[0];

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null && min > (Double) this.array[i]) {
                min = (Double) this.array[i];
            }
        }

        return (T) min;
    }


        /**
     * @return
     * Вернет либо максимальное число массива, либо самую длинную строку.
     * String, Integer, Double, else null.
     */
    public T max() {
        T max;
        if (checkType() == 0) {
            max = maxString();
        } else if (checkType() == 1) {
            max = maxInteger();
        } else if (checkType() == 2) {
            max = maxDouble();
        } else max = null;

        return max;
    }

    /**
     * @return
     * Вернет самую длинную строку в array.
     * (T) String
     */
    private T maxString() {
        String max = (String) this.array[0];
        int countMax = max.length();

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null && countMax < ((String) this.array[i]).length()) {
                countMax = ((String) this.array[i]).length();
                max = (String) this.array[i];
            }
        }
        return (T) max;
    }

    /**
     * @return
     * Вернет максимальный элемент.
     * (T) Integer
     */
    private T maxInteger() {
        Integer max = (Integer) this.array[0];

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null && max < (Integer) this.array[i]) {
                max = (Integer) this.array[i];
            }
        }

        return (T) max;
    }

    /**
     * @return
     * Вернет максимальный элемент.
     * (T) Double
     */
    private T maxDouble() {
        Double max = (Double) this.array[0];

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null && max < (Double) this.array[i]) {
                max = (Double) this.array[i];
            }
        }

        return (T) max;
    }

    /**
     * @return
     * Вернет либо сумму всех чисел массива, либо конкантенацию строк с разделителем.
     * String, Integer, Double, else null.
     */
    public T sum() {
        T sum;
        if (checkType() == 0) {
            sum = sumString();
        } else if (checkType() == 1) {
            sum = sumInteger();
        } else if (checkType() == 2) {
            sum = sumDouble();
        } else sum = null;

        return sum;
    }

    public T sum(String sep) {
        T sum;
        if (checkType() == 0) {
            sum = sumString(sep);
        } else sum = null;

        return sum;
    }

    /**
     * @return
     * Вернет конкантенацию всех строк array с разделителем " ".
     * (T) String
     */
    private T sumString() {
        StringBuilder sum = new StringBuilder();

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null) {
                sum.append(this.array[i]);
                sum.append(" ");
            }
        }
        return (T) sum.toString();
    }
    
    /**
     * @return
     * Вернет конкантенацию всех строк array с указанным разделителем String sep.
     * (T) String
     */
    private T sumString(String sep) {
        StringBuilder sum = new StringBuilder();

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null) {
                sum.append(this.array[i]);
                sum.append(sep);
            }
        }
        return (T) sum.toString();
    }

    /**
     * @return
     * Вернет сумму всех элементов.
     * (T) Integer
     */
    private T sumInteger() {
        Integer sum = 0;
        
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null) {
                sum += (Integer) this.array[i];
            }
        }

        return (T) sum;
    }

    /**
     * @return
     * Вернет сумму всех элементов.
     * (T) Double
     */
    private T sumDouble() {
        Double sum = 0.0;

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null) {
                sum += (Double) this.array[i];
            }
        }

        return (T) sum;
    }

    /**
     * @return
     * Вернет произведение всех чисел массива.
     * Integer, Double, else null.
     * @throws Exception
     * Тип данных String не может быть умножен на String.
     */
    public T mult() throws Exception {
        T mult;
        if (checkType() == 0) {
            throw new Exception("The String cannot be multiplied");
        } else if (checkType() == 1) {
            mult = multInteger();
        } else if (checkType() == 2) {
            mult = multDouble();
        } else mult = null;

        return mult;
    }

    /**
     * @return
     * Вернет произведение всех элементов.
     * (T) Integer
     */
    private T multInteger() {
        Integer mult = 1;

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null) {
                mult *= (Integer) this.array[i];
            }
        }

        return (T) mult;
    }

    /**
     * @return
     * Вернет произведение всех элементов.
     * (T) Double
     */
    private T multDouble() {
        Double mult = (double) 1;

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null) {
                mult *= (Double) this.array[i];
            }
        }

        return (T) mult;
    }

    /**
     * @return
     * Вернет индекс первого совпадения.
     * String, Integer, Double, else null.
     */
    public Integer findAt(T element) {
        Integer index = 0;

        for (T t : this.array) {
            if (t != null && t == element) {
                return index;
            }
            index++;
        }

        return -1;
    }

    /**
     * @return
     * Вернет True или False.
     * В зависимости от того содержится ли element в массиве.
     */
    public Boolean contains(T element) {
        
        for (T t : this.array) {
            if (t != null && t == element) {
                return true;
            }
        }

        return false;
    }

    private void toSwap(int i, int j) {
        T temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }

    public void bubbleSort() throws Exception {
        if (this.array[0] instanceof Comparable) {
            for (int i = 0; i < this.size - 1; i++) {
                for(int j = 0; j < this.size - i - 1; j++) {
                    Comparable<T> elem = (Comparable) this.array[j];
                    T nextElem = this.array[j + 1];

                    if (elem.compareTo(nextElem) > 0) {
                        toSwap(j, j + 1);
                    }
                }
            }
        } else throw new Exception("Noncomparable type");
    }
    
    public void insertionSort() throws Exception {
        if (this.array[0] instanceof Comparable) {
            for (int i = 1; i < this.size; i++) {
                for (int j = i; j > 0; j--) {
                    Comparable<T> elem = (Comparable) this.array[j];
                    T prevElem = this.array[j - 1];

                    if (elem.compareTo(prevElem) < 0) {
                        toSwap(j, j - 1);
                    } else break;
                }
            }
        } else throw new Exception("Noncomparable type");
    }

    public void selectionSort() throws Exception {
        T min;
        if (this.array[0] instanceof Comparable) {
            for (int i = 0; i < this.size; i++) {
                min = this.array[i];
                int minInd = i;

                for (int j = i; j < this.size; j++) {
                    Comparable<T> elem = (Comparable) this.array[j];
                    if (elem.compareTo(min) < 0) {
                        min = this.array[j];
                        minInd = j;
                    }
                }

                if (i != minInd) {
                    toSwap(i, minInd);
                }                
            }
        } else throw new Exception("Noncomparable type");
    }

    public T get(int index) {
        return this.array[index];
    }

    public void set(int index, T element) {
        this.array[index] = element;
    }

    public int size() {
        // int count = 0;
        // for (T t : this.array) {
        //     if (t == null) {
        //         count++;
        //     }
        // }
        return this.size;
    }

    public void show() {
        System.out.print("[");
        for (int i = 0; i < this.size; i++) {
            if (i != this.size - 1)
                System.out.print(this.array[i] + ", ");
            else
                System.out.print(this.array[i]);
        }
        System.out.print("]\n");
    }
}