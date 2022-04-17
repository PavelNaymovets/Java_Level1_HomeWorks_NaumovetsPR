package ru.gb.naumovets.homeWork2;

public class WorkWithMethods {

    public static void main(String[] args) {
        System.out.println(WorkWithMethods.ComparisonOfWholeNumbers(11,10));
        System.out.println(WorkWithMethods.PositiveOrNegativeWholeNumber(100));
        System.out.println(WorkWithMethods.PositiveOrNegativeWholeNumberBoolean(0));
        WorkWithMethods.PrintString("Печатаю число раз =",10);

    }

    //Методы

    public static boolean ComparisonOfWholeNumbers(int a, int b){
        return (a + b) > 10 && (a + b) <=20;
    }

    public static String PositiveOrNegativeWholeNumber(int a){
        return a >= 0 ? "Введенное число положительное" : "Введенное число отрицательное";
    }

    public static boolean PositiveOrNegativeWholeNumberBoolean(int a){
        return a < 0;
    }

    public static void PrintString(String string, int i){
        for (int j = 0; j < i; j++) {
            System.out.println(string);
        }
    }

    public static boolean LeapYear(){
        return true;
    }
}
