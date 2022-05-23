package ru.gb.naumovets.homeWork8;

import javax.swing.*;
import java.awt.*;

/*
Согласно задания нужно написать программу калькулятор, которая способна выполнять базовые арифметические
операции (+, -, /, *).

При планировании программы было принято решение разделить визуальную и обрабатывающую части на отдельные
классы Calculator и CalculatorEngine соответствеено.

Класс Calculator содержит визуальную часть.
Кдасс CalculatorEngine содержит обрабатывающую часть.

Класс CalculatorEngine реализует интерфейс java.awt.ActionListener в котором объявлен только один метод
actionPerformed(ActionEvent). Сделано это для того, чтобы обарабатывать события нажатия на кнопку. JVM
вызывает метод actionPerformed(ActionEvent) в классе, который реализует интерфейс java.awt.ActionListener
всякий раз, когда кто-то наживает на кнопку. Есть и другие обработчики событий, но в данном примере они нас
не интересуют, так как функционал калькулятора ограничен нажатием на кнопки по заданию.
 */

public class Calculator {

    //Объявим и инициализируем компоненты окна, которые в дальнейшем будут добавлены на панель.

    //Создадим 10 цифр от 0 до 9
    JButton button_0 = new JButton("0");
    JButton button_1 = new JButton("1");
    JButton button_2 = new JButton("2");
    JButton button_3 = new JButton("3");
    JButton button_4 = new JButton("4");
    JButton button_5 = new JButton("5");
    JButton button_6 = new JButton("6");
    JButton button_7 = new JButton("7");
    JButton button_8 = new JButton("8");
    JButton button_9 = new JButton("9");

    //Создадим кнопку "." для ввода чисел с плавающей точкой и "=" для получения результата вычисления
    JButton buttonPoint = new JButton(".");
    JButton buttonEqual = new JButton("=");

    //Создадим кнопки для 4 базовых операций (+,-,/,*), кнопку сброса результата и удаления последнего элемента
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonDivide = new JButton("/");
    JButton buttonMultiply = new JButton("*");
    JButton buttonCancel = new JButton("CE");
    JButton buttonRow = new JButton("←");

    //Создадим однострочное текстовое поле (шириной в 30 элементов) на котором будут выводится значения нажатых клавиш и
    //результат вычислений.
    JTextField displayField = new JTextField(30);

    //Создадим основную панель, на которой будут размещены кнопки и поле для ввода значений по кнопкам. Далее,
    //по коду, панель с элементами будет установлена в диалоговое окно.
    JPanel windowContent = new JPanel();

    //Конструктор. Опишем логику размещения кнопок на основной панели(windowContent) через создание подпанелей и
    //привяжем действия к конпкам через добавление слушателя(ActionListener), который обрабатывает события (нажатие
    // на клавишу) определенным образом.
    public Calculator(){
        //Создадим схему расположения элементов на основной панели(windowContent)
        BorderLayout border = new BorderLayout();

        //Применим схему расположения элементов к основной панели(windowContent)
        windowContent.setLayout(border);

        //Добавим текстовое поле(displayField) в верхнюю часть окна
        windowContent.add(displayField, "North");

        //Установим первоначальную ширины и высоту текстового поля
        displayField.setPreferredSize(new Dimension(600,30));

        //Создаем подпанель со схемой расположения GridLayout с 12 кнопками - 10 цифр, и кнопки точка и ровно
        JPanel panel_1 = new JPanel();
        GridLayout grid_1 = new GridLayout(4,3, 2, 2);

        //Установим схему расположения элементов на подпанель и расположим элементы
        panel_1.setLayout(grid_1);
        panel_1.add(button_1);
        panel_1.add(button_2);
        panel_1.add(button_3);
        panel_1.add(button_4);
        panel_1.add(button_5);
        panel_1.add(button_6);
        panel_1.add(button_7);
        panel_1.add(button_8);
        panel_1.add(button_9);
        panel_1.add(button_0);

        panel_1.add(buttonPoint);
        panel_1.add(buttonEqual);

        //Добавим подпанель panel_1 на основную панель windowContent в центр
        windowContent.add(panel_1,"Center");

        //Создаем подпанель со схемой расположения GridLayout с 4 кнопками - +, -, /, *
        JPanel panel_2 = new JPanel();
        GridLayout grid_2 = new GridLayout(6,1, 2, 2);

        //Установим схему расположения элементов на подпанель и расположим элементы
        panel_2.setLayout(grid_2);
        panel_2.add(buttonCancel);
        panel_2.add(buttonRow);
        panel_2.add(buttonPlus);
        panel_2.add(buttonMinus);
        panel_2.add(buttonMultiply);
        panel_2.add(buttonDivide);

        //Добавляем подпанель panel_2 на основную панель windowContent в правую часть окна
        windowContent.add(panel_2,"East");

        //Создадим диалоговое окно (фрайм)  сназванием "Calculator" и добавим в него содержимое основной панели
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(windowContent);

        //Установим размеры окна так, чтобы уместились все компоненты
        frame.pack();

        //Покажем окно
        frame.setVisible(true);

        //Создадим экземпляр слушателя событий.

        /*
        Класс Calculator создает экземпляр класса CalculatorEngine, и передает в конструктор ссылку на себя,
        через ключевое слово this. Эта ссылка указывает на место в куче, где хранится экземпляр класса Calculator.
        Конструктор CalculatorEngine сохранит значение ссылки в переменной parent класса CalculatorEngine, чтобы потом
        использовать его в методе actionPerformed() для доступа к дисплею калькулятора.
        */

        CalculatorEngine calcEngine = new CalculatorEngine(this);

        //Добавим экземпляр слушателя событий к каждой кнопке.
        button_0.addActionListener(calcEngine);
        button_1.addActionListener(calcEngine);
        button_2.addActionListener(calcEngine);
        button_3.addActionListener(calcEngine);
        button_4.addActionListener(calcEngine);
        button_5.addActionListener(calcEngine);
        button_6.addActionListener(calcEngine);
        button_7.addActionListener(calcEngine);
        button_8.addActionListener(calcEngine);
        button_9.addActionListener(calcEngine);

        buttonPoint.addActionListener(calcEngine);
        buttonPlus.addActionListener(calcEngine);
        buttonMinus.addActionListener(calcEngine);
        buttonDivide.addActionListener(calcEngine);
        buttonMultiply.addActionListener(calcEngine);
        buttonEqual.addActionListener(calcEngine);
        buttonCancel.addActionListener(calcEngine);
        buttonRow.addActionListener(calcEngine);
    }
}
