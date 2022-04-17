package ru.gb.naumovets.homeWork1;

public class HomeWorkApp {

    public static void main(String[] args) {

        HomeWorkApp.printThreeWords();
        HomeWorkApp.compareNumbers();

    }

    //Методы

    public static void printThreeWords(){

        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");

    }

    public static void checkSumSign() {

        int a = 5, b = 10;
        int sum = a + b;
        if(sum >= 0 ){
            System.out.println("Сумма положительна");
        } else {
            System.out.println("Сумма отрицательна");
        }

    }

    public static void printColor() {

        int value = 5;
        if(value <= 0){
            System.out.println("Красный");
        } else if(value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if(value > 100) {
            System.out.println("Зеленый");
        }

    }

    public static void compareNumbers() {

        int a = 5, b = 15;
        if(a >= b){
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }

    }


}