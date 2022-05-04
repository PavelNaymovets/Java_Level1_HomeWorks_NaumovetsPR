package ru.gb.naumovets.homeWork5;

public class HandlingOfEmployees {

    //Метод печатает данные рабочих возраст которых больше age

    public static void printEmployees(Employee[] employees, int age){
        for (Employee person: employees) {
            if(person.getAge() > age){
                System.out.println(person + "\n");
            }
        }
    }

}
