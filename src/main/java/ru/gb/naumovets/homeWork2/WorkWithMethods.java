package ru.gb.naumovets.homeWork2;

public class WorkWithMethods {

    public static void main(String[] args) throws Exception {
        System.out.println(WorkWithMethods.ComparisonOfWholeNumbers(11,10));
        System.out.println(WorkWithMethods.PositiveOrNegativeWholeNumber(100));
        System.out.println(WorkWithMethods.PositiveOrNegativeWholeNumberBoolean(0));
        WorkWithMethods.PrintString("Печатаю число раз =",10);
        WorkWithMethods.LeapYear(1357);
        System.out.println(WorkWithMethods.LeapYearBoolean(1357));
        System.out.println(WorkWithMethods.LeapYearBooleanTern(1357));
        System.out.println(WorkWithMethods.LeapYearBooleanSimple(1357));
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

    // Совсем по простому
    public static boolean LeapYearBooleanSimple(int year) {
        System.out.println("Проверим является ли " + year + " год високосным. true - високосный, false - не високосный");
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    // Чуть подробней
    public static boolean LeapYearBoolean(int year) {
        System.out.println("Проверим является ли " + year + " год високосным. true - високосный, false - не високосный");
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    // С ограничением по длине года. Так интересней
    public static void LeapYear(int year) throws IllegalArgumentException{
        try {
            if(String.valueOf(year).length() > 0 && String.valueOf(year).length() <= 4) {
                System.out.println("Проверим является ли " + year + " год високосным");
                if (year % 4 == 0) {
                    if (year % 100 == 0) {
                        if (year % 400 == 0) {
                            System.out.println("Год високосный");;
                        } else {
                            System.out.println("Год не високосный");;
                        }
                    } else {
                        System.out.println("Год високосный");
                    }
                } else {
                    System.out.println("Год не високосный");
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException o){
            System.err.println("Год должен состоять не более чем из 4 цифр. Пожалуйста соблюдайте формат ввода");
        }
    }

    // Через тернарный оператор. Так ещё интересней
    public static boolean LeapYearBooleanTern(int year) {
        System.out.println("Проверим является ли " + year + " год високосным. true - високосный, false - не високосный");
        return year % 4 == 0? (year % 100 == 0? (year % 400 == 0? true: false ) : true) : false;
    }
}
