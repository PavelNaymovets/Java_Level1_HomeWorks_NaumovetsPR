package ru.gb.naumovets.homeWork3;

import java.util.Arrays;
import java.util.Random;

public class WorkWithMassives {

    public static void main(String[] args) {
        //Задание 1. Создать целочисленный массив из 0 и 1. Заменить 0 на 1 и 1 на 0 с помощью цикла и условия.
        int [] arr_whole_numbers = new int [10];
        for (int i = 0; i < arr_whole_numbers.length; i++) {
            arr_whole_numbers[i] = new Random().nextInt(2);
        }
        System.out.println(Arrays.toString(arr_whole_numbers));

        for (int i = 0; i < arr_whole_numbers.length; i++) {
            if(arr_whole_numbers[i] == 1){
                arr_whole_numbers[i] = 0;
            } else {
                arr_whole_numbers[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr_whole_numbers));

        //Задание 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 ... 100;
        int[] arr = new int[100];
        for (int i = 0, j = 1; i < arr.length; i++, j++) {
            arr[i] = j;
        }
        System.out.println(Arrays.toString(arr));

        //Задание 3.Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        // и числа меньшие 6 умножить на 2;
        int[] arr_1 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr_1));
        for (int i = 0; i < arr_1.length; i++) {
            if(arr_1[i] < 6){
                arr_1[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr_1));

        //Задание 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        int[][] two_dimensional_array = new int [10][10];
        for (int i = 0, k = two_dimensional_array.length - 1; i < two_dimensional_array.length; i++, k--) {
            for (int j = 0; j < two_dimensional_array[i].length; j++) {
                if(i == j){
                    two_dimensional_array[i][j] = 1;
                }
            }
            two_dimensional_array[i][k] = 1;
        }

        for (int[] row: two_dimensional_array) {
            for (int column: row) {
                if(column == 1){
                    System.out.print("\u001B[33m");
                } else{
                    System.out.print("\u001B[0m");
                }
                System.out.printf("%3d", column);
            }
            System.out.println();
        }
        System.out.print("\u001B[0m");

        //Задание 5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий
        // одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
        int [] mass = giveMassive(10,1);
        System.out.println(mass.length);
        System.out.println(Arrays.toString(mass));

        //Задание 6. *Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
        int[] arr_2 = new int[10];
        for (int i = 0; i < arr_2.length; i++) {
            arr_2[i] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(arr_2));
        maxMinElements(arr_2);

        //Задание 7.** Написать метод, в который передается не пустой одномерный целочисленный массив,
        //метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
        //массива равны.
        int[] arr_3 = new int[5];
        for (int i = 0; i < arr_3.length; i++) {
            arr_3[i] = new Random().nextInt(3);
        }
        System.out.println(Arrays.toString(arr_3));
        System.out.println(isEqualSum(arr_3));

        //Задание 8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть
        //положительным, или отрицательным), при этом метод должен сместить все элементы массива
        //на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться
        //вспомогательными массивами.
        int[] arr_4 = new int[5];
        for (int i = 0; i < arr_4.length; i++) {
            arr_4[i] = i;
        }
        System.out.println(Arrays.toString(arr_4));
        offsetElements(arr_4, 1);
    }

    //Задание 5.
    public static int[] giveMassive(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }

    //Задание 6.
    public static void maxMinElements(int[] arr){
        Arrays.sort(arr);
        System.out.println("Минимальный элемент массива " + arr[0] + "\n" + "Максимальный элемент массива " + arr[arr.length-1]);
    }

    //Задание 7.
    public static boolean isEqualSum(int [] arr){
        int sum_left = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum_left += arr[i];
            int sum_right = 0;
            for (int j = i+1; j < arr.length; j++) {
                sum_right += arr[j];
            }
            if(sum_left == sum_right){
                return true;
            }
        }
        return false;
    }

    //Задание 8.
    public static void offsetElements(int[] arr, int n){
        int buff_next = 0;
        int buff_current = 0;
        if(n > 0){
            for (int i = 0; i < arr.length; i++) {
                System.out.println(i);
                if(i == 0){
                    buff_next = arr[i + n];// = 1
                    arr[i + n] = arr[i]; //1 = 0
                    System.out.println(Arrays.toString(arr));
                } else if(i < arr.length - 1) {
                    buff_current = arr[i + n];// = 2
                    arr[i + n] = buff_next;// = 1
                    buff_next = buff_current; //= 2
                    System.out.println(Arrays.toString(arr));
                } else if(i == arr.length - 1){
                    arr[0] = buff_next;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
