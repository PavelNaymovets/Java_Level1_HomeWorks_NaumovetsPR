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

    //Добавил геттер

    public int getAge(){
        return this.age;
    }

    // Заоверрайдил метод toString() класса Object.

    @Override
    public String toString(){
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
