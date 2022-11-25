/*Первый семинар.
        1. Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
        2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

        Пункты реализовать в методе main
        *Пункты реализовать в разных методах*/
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.List;



public class Seminar1 {
    public static void main(String[] args) {

        System.out.println("Случайное целое числов диапазоне от -1000 до 1000:");
        int i = randonumber(-1000,1000);
        System.out.println(i);
        int n_binary_value = OneBinaryValue(i);
        System.out.printf("Номер старшего значащего бита равен %d\n", n_binary_value);
        Integer[] m2 = array_multiple_2(n_binary_value, i);
        Integer[] m1 = array_multiple_1(n_binary_value, i);
        System.out.printf("Все не кратные %d числа в диапазоне от Short.Min_VALUE до i равны\n", n_binary_value, i);
        System.out.printf("Все кратные %d числа в диапазоне от %d до Short.MAX_VALUE равны\n", n_binary_value, i);

        for(int k =0; k<m1.length; k++) {
            System.out.println(m1[k]);
        }


    }
    // метод, позволяющий выбрать и вернуть случайное число в указанном диапазоне
    static int randonumber(int min,int max) {
        Random random = new Random();
        int i = random.nextInt(min,max); //это кидалка случайных чисел!)
        return  i;
    }
    // метод, позволяющий вернуть номер старшего значащего бита при переводе из десятичного в двоичное
    static int OneBinaryValue(int n_decimal) {
        String bin_num = Integer.toBinaryString(n_decimal);
        int i = bin_num.length()-1;
        while((bin_num.charAt(i) == 0) & (i > 0)) {
            i--;
        }
        return i;

    }
    // метод, позволящий увеличить размер изначально заданного массива
    private static Integer[] append(Integer[] arr, int element)
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        list.add(element);

        return list.toArray(new Integer[0]);
    }
    // метод, возвращающий все числа кратные указанному в аргументе функции в указанном диапазоне
    static Integer[] array_multiple_1(int n_multiple, int i_min) {
        Integer[] array = {};
        for(int i = i_min; i<=Short.MAX_VALUE;i++) {
            if (i%n_multiple == 0) {
                array = append(array, i);
            }
        }
        return array;
    }
    // метод, возвращающий все числа не кратные указанному в аргументе функции в указанном диапазоне
    static Integer[] array_multiple_2(int n_multiple, int i_max) {
        Integer[] array = {};
        for(int i = Short.MIN_VALUE; i<=i_max;i++) {
            if (i%n_multiple != 0) {
                array = append(array, i);
            }
        }
        return array;
    }


}
