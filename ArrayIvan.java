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
        int count = 0;

        for (T t : this.array) {
            if (t == element) {
                t = null;
                count++;
            }
        }

        int newLen = this.size - count;
        T[] newArr = (T[]) new Object[newLen];
        int index = 0;

        for (int i = 0; i < this.size; i++) {
            if (this.array[i] != null) {
                newArr[index] = this.array[i];
                index++;
            }
        }

        this.array = newArr;
        this.size -= count;
    }

    /**
     * @return
     * 0 - String[]
     * 1 - Integer[]
     * 2 - Double[]
     * null - if not types of theese
     */
    private Integer checkType() {
        if (this.array instanceof String[]) {
            return 0;
        } else if (this.array instanceof Integer[]) {
            return 1;
        } else if (this.array instanceof Double[]) {
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

        for (String str : (String[]) this.array) {
            if (str != null && countMin > str.length()) {
                countMin = str.length();
                min = str;
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

        for (Integer num : (Integer[]) this.array) {
            if (num != null && min > num) {
                min = num;
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

        for (Double num : (Double[]) this.array) {
            if (num != null && min > num) {
                min = num;
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

        for (String str : (String[]) this.array) {
            if (str != null && countMax < str.length()) {
                countMax = str.length();
                max = str;
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

        for (Integer num : (Integer[]) this.array) {
            if (num != null && max < num) {
                max = num;
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

        for (Double num : (Double[]) this.array) {
            if (num != null && max < num) {
                max = num;
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

        for (StringBuilder str : (StringBuilder[]) this.array) {
            if (str != null) {
                sum.append(str);
                sum.append(" ");
            }
        }
        return (T) sum;
    }
    
    /**
     * @return
     * Вернет конкантенацию всех строк array с указанным разделителем String sep.
     * (T) String
     */
    private T sumString(String sep) {
        StringBuilder sum = new StringBuilder();

        for (StringBuilder str : (StringBuilder[]) this.array) {
            if (str != null) {
                sum.append(str);
                sum.append(sep);
            }
        }
        return (T) sum;
    }

    /**
     * @return
     * Вернет сумму всех элементов.
     * (T) Integer
     */
    private T sumInteger() {
        Integer sum = 0;
        
        for (Integer num : (Integer[]) this.array) {
            if (num != null) {
                sum += num;
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

        for (Double num : (Double[]) this.array) {
            if (num != null) {
                sum += num;
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

        for (Integer num : (Integer[]) this.array) {
            if (num != null) {
                mult *= num;
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

        for (Double num : (Double[]) this.array) {
            if (num != null) {
                mult *= num;
            }
        }

        return (T) mult;
    }

    public T find(T element) {
        
    }
}