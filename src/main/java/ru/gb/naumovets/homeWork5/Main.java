package ru.gb.naumovets.homeWork5;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivan","Ivanov", "Ivanovich", "Engineer", "i@mail.ru","8(800)535-35-35", 20000, 30);
        employees[1] = new Employee("Andrey","Sidorov", "Pavlovich", "Waiter", "a@mail.ru","8(911)545-55-05", 5000, 40);
        employees[2] = new Employee("Maksim","Saveliev", "Sergeevich", "Cashier", "m@mail.ru","8(912)536-99-80", 4000, 50);
        employees[3] = new Employee("Sergey","Chyiko", "Stepanovich", "House keeper", "s@mail.ru","8(931)500-00-08", 3000, 55);
        employees[4] = new Employee("Stepan","Roshin", "Grigorievich", "Financial adviser", "step@mail.ru","8(911)256-44-44", 25000, 45);

        HandlingOfEmployees.printEmployees(employees, 40);

    }

}
