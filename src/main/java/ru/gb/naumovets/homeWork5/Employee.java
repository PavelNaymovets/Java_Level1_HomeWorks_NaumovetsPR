package ru.gb.naumovets.homeWork5;

import java.text.NumberFormat;
import java.util.Locale;

public class Employee {

    private String name;
    private String surname;
    private String middleName;
    private String jobPosition;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String name, String surname, String middleName, String jobPosition, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.jobPosition = jobPosition;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivan","Ivanov", "Ivanovich", "Engineer", "i@mail.ru","8(800)535-35-35", 20000, 30);
        employees[1] = new Employee("Andrey","Sidorov", "Pavlovich", "Waiter", "a@mail.ru","8(911)545-55-05", 5000, 40);
        employees[2] = new Employee("Maksim","Saveliev", "Sergeevich", "Cashier", "m@mail.ru","8(912)536-99-80", 4000, 50);
        employees[3] = new Employee("Sergey","Chyiko", "Stepanovich", "House keeper", "s@mail.ru","8(931)500-00-08", 3000, 55);
        employees[4] = new Employee("Stepan","Roshin", "Grigorievich", "Financial adviser", "step@mail.ru","8(911)256-44-44", 25000, 45);

        for (Employee person: employees) {
            if(person.age > 40){
                System.out.println(person.printEmployee() + "\n");
            }
        }
    }

    // Можно было заоверрайдить метод toString() класса Object. Но так, как сейчас предполагается, что мы его не знаем, пишу такой.

    public String printEmployee(){
        return ("Name: " + name + "\n"
                + "Surname: " + surname + "\n"
                + "Middle name: " + middleName + "\n"
                + "Job position: " + jobPosition + "\n"
                + "email: " + email + "\n"
                + "Phone number: " + phoneNumber + "\n"
                + "Salary: " + getCurrency(salary) + "\n"
                + "Age: " + age);
    }

    private String getCurrency(int salary){
        return NumberFormat.getCurrencyInstance(Locale.US).format(salary);
    }
}
