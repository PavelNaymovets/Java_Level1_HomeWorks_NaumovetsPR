package ru.gb.naumovets.homeWork3;

import java.util.Arrays;
import java.util.Random;

public class WorkWithMassives {

    public static void main(String[] args) {
        //Ex. 1.
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

        //Ex. 2.
        int[] arr = new int[100];
        for (int i = 0, j = 1; i < arr.length; i++, j++) {
            arr[i] = j;
        }
        System.out.println(Arrays.toString(arr));

        //Ex. 3.
        int[] arr_1 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr_1));
        for (int i = 0; i < arr_1.length; i++) {
            if(arr_1[i] < 6){
                arr_1[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr_1));

        //Ex. 4.
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

        //Ex. 5.
        int [] mass = giveMassive(10,1);
        System.out.println(mass.length);
        System.out.println(Arrays.toString(mass));

        //Ex. 6.
        int[] arr_2 = new int[10];
        for (int i = 0; i < arr_2.length; i++) {
            arr_2[i] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(arr_2));
        maxMinElements(arr_2);

        //Ex. 7.
        int[] arr_3 = new int[5];
        for (int i = 0; i < arr_3.length; i++) {
            arr_3[i] = new Random().nextInt(3);
        }
        System.out.println(Arrays.toString(arr_3));
        System.out.println(isEqualSum(arr_3));

        //Ex. 8.
        int[] arr_4 = new int[10];
        for (int i = 0; i < arr_4.length; i++) {
            arr_4[i] = i;
        }
        System.out.println(Arrays.toString(arr_4));
        offsetElements(arr_4, 1);
    }

    //Ex. 5.
    public static int[] giveMassive(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }

    //Ex. 6.
    public static void maxMinElements(int[] arr){
        Arrays.sort(arr);
        System.out.println("Минимальный элемент массива " + arr[0] + "\n" + "Максимальный элемент массива " + arr[arr.length-1]);
    }

    //Ex. 7.
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

    //Ex.8.
    public static void offsetElements(int[] arr, int n){
        int buff_next = 0;
        int buff_current = 0;
        if(n > 0){
            for (int i = 0; i < arr.length; i++) {
                System.out.println(i);
                if(i == 0){
                    buff_next = arr[i + n];
                    arr[i + n] = arr[i];
                    System.out.println(Arrays.toString(arr));
                } else if(i < arr.length - 1) {
                    buff_current = arr[i + n];
                    arr[i + n] = buff_next;
                    buff_next = buff_current;
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
