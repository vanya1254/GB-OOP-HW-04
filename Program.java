import java.util.Arrays;

/**
 * Реализовать класс для работы с одномерными динамическими массивами
 * произвольных данных(произвольного типа). Класс будет иметь следующие
 * конструкторы:
 * 1. Конструктор без параметров – конструктор по умолчанию, проводяющий базовую
 * иницаилизацию массива
 * 2. Конструктор с параметром T[] – конструктор, который проводит инициализацию
 * и заполняет массив данными, пришедшими из параметра
 * Так же класс будет иметь следующие публичные методы:
 * 1. Вставка в массив                                          +
 * 2. Удаление элемента по индексу                              +
 * 3. Удаление всех элементов с заданным значением              +
 * 4. Поиск минимума                                            +++
 * 5. Поиск максимума                                           +++
 * 6. Поиск суммы элементов массива                             ++++
 * 7. Поиск произведения элементов массива                      ++
 * 8. Поиск индекса заданного элемента в массиве, если такого элемента в массиве
 * нет то возвращать -1                                         +
 * 9. Проверка наличия элемента в массиве. Возвращает true, если элемент в
 * массиве есть, false – нет.                                   +
 * 10. Пузырьковая сортировка                                   +
 * 11. Сортировка простыми вставками                            +
 * 12. Сортировка простым выбором                               +
 * 13. Получение элемента массива по индексу                    +
 * 14. Задание значения элементу массива с заданным индексом    +
 * 15. Печать массива на экран                                  +
 * 16. Длинна массива                                           +
 * Так же класс должен содержать следующие приватные поля:
 * 1. Сам массив произвольных данных.
 * 2. Длинну массива
 * Так же массив должен содержать следующие перегруженные операторы:
 * 1. Оператор, получающий элемент по заданному индексу
 * 2. Оператор, позволяющий установить значение элемента по заданному индексу
 * Так же в случае, если могут произойти ошибки или некорретная работа в
 * конструкторах или методах, необходимо использовать механизм исключений для
 * обработки возможных ошибок.
 */

public class Program {
    public static void main(String[] args) throws Exception {
        // Integer[] sf = new Integer[10];
        // sf[0] = 2;
        // sf[1] = 5;
        // sf[2] = 3;
        // sf[3] = 7;
        // sf[4] = 3;
        // sf[5] = 1;

        // System.out.println(Arrays.toString(sf));

        ArrayIvan<Integer> array = new ArrayIvan<>();
        array.add(37);
        array.add(47);
        array.add(27);
        array.add(55);
        array.add(87);
        array.add(12);
        array.add(51);
        array.add(12);
        array.add(12);
        array.add(12);
        array.add(88);
        array.add(2);
        array.show();

        System.out.println(array.min());

        System.out.println(array.max());

        System.out.println(array.sum());

        System.out.println(array.get(1));

        array.set(1, 9);
        System.out.println(array.get(1));

        array.show();
        System.out.println(array.size());
        
        array.removeAt();
        // array.removeAt(5);
        array.show();

        array.show();
        array.bubbleSort();
        array.show();

        System.out.println(array.contains(55));

        System.out.println(array.findAt(55));

        array.remove(55);
        array.show();

        array.set(0, 55);//заменяет по индексу
        array.show();



        ArrayIvan<String> stringList = new ArrayIvan<>();
        stringList.add("Компьютер");
        stringList.add("Монитор");
        stringList.add("Мышка");
        stringList.add("Клавиатура");
        stringList.add("Колонка");
        stringList.add("Провод");
        stringList.add("Коврик");
        stringList.add("Флешка");
        stringList.add("Пульт");
        stringList.add("Планшет");
        stringList.add("Телефон");
        stringList.add("Очки");
        stringList.show();

        stringList.removeAt(1);
        stringList.show();

        System.out.println(stringList.sum());
        System.out.println(stringList.sum("||"));

        System.out.println(stringList.max());

        System.out.println(stringList.min());

        System.out.println(stringList.contains("Провод"));

        System.out.println(stringList.findAt("Провод"));
        
        stringList.bubbleSort();
        stringList.show();

        stringList.remove("Провод");
        stringList.show();

        stringList.set(0, "Провод");//заменяет по индексу
        stringList.show();
        
    }
}