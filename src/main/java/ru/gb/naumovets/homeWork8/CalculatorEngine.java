package ru.gb.naumovets.homeWork8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngine implements ActionListener {

    //Ссылка на окно калькулятора. Нужная для доступа к дисплею калькулятора.
    Calculator parent;

    //Создадим переменные, которые будут хранить выбранную арифметическую операцию (+, -, *, /).
    char selectedAction = ' ';

    //Создадим переменную, которая будет хранить левый операнд выбранной арифметической операции. Выбран тип double
    // так как есть вероятность ввода пользователем числа с плавающей точкой
    double currentResult = 0;

    //Конструтктор сохраняет ссылку на окно калькулятора в переменной parent экземпляра класса CalculatorEngine
    CalculatorEngine(Calculator parent){
        this.parent = parent;
    }

    //Реализуем метод actionPerformed(ActionEvent e) для обработки событий (нажатий на кнопки калькулятора).
    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         Когда событие произойдет, JVM вызовет метод actionPerformed(ActionEvent e) и передаст ему необходимую
         информацию о событии через аргумент ActionEvent e.

         Для того, чтобы определить какая кнопка была нажата нужно у переменной e вызвать метод .getSource() класса
         ActionEvent. Метод getSource() возвращает данные об объекте-событии как экземпляр типа Object. Так сделано для
         того, чтобы метод работал для любых компонентов. Но мы знаем, что в нашем калькуляторе единственной причиной
         события могут быть только нажатые кнопки. Поэтому приводим тип возвращаемого объекта класса Object к типу JButton.

         Получим данные об объекте-событии, источник. То есть то, что стало причиной события. Какая кнопка была нажата
         */
        JButton clickedButton = (JButton) e.getSource();

        //Запишем первоначальные данные с дисплея калькулятора в переменную
        String displayFieldText = parent.displayField.getText();

        //Создадим перменную для получения числа с дисплея калькулятора
        double displayValue = 0;

        //Нас не интересует значения дисплея калькулятора, если он пустой. Напишем условие позволяющее получить число с
        // дисплея калькулятора, если он не пустой.

        if(!"".equals(displayFieldText)){
            displayValue = Double.parseDouble(displayFieldText);
        }

        //Создам переменную класса Object для записи объекта-события, который вызвал событие.
        Object sourceAction = e.getSource();

        /*
        Определю истояник объекта-события арифметической операции (кнопку арифметической операции на которую нажал
        пользователь). Для этого сравню ссылку на объект-событие, которую вернет метод .getSourse(), со ссылкой уже
        имеющейся кнопки на панели калькулятора. Если эти ссылки указывают на один и тот же объект, значит действие
        было выполнено текущей кнопкой.

        Далее опишу логику благодаря которой программа запомнит арифметическую операцию кнопки, которая была нажата,
        сохранит левый операнд и очистит дисплей для ввода нового числа
         */

        if(sourceAction == parent.buttonPlus){
            selectedAction = '+';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if(sourceAction == parent.buttonMinus){
            selectedAction = '-';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if(sourceAction == parent.buttonDivide){
            selectedAction = '/';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if(sourceAction == parent.buttonMultiply){
            selectedAction = '*';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if(sourceAction == parent.buttonCancel){
            selectedAction = ' ';
            currentResult = 0;
            parent.displayField.setText("");
        } else if(sourceAction == parent.buttonRow){
            selectedAction = ' ';
            String resultAction = displayFieldText.substring(0,displayFieldText.length() - 1);
            parent.displayField.setText(resultAction);
        } else if(sourceAction == parent.buttonEqual){
            /*
            Далее описана логика совершения арифметической операции, в зависимости от выбранной арифметической операции.
            В каждой операции обновляется переменная, которая хранит левый операнд. Затем эта же переменная выводится
            на дисплей
             */

            if(selectedAction == '+'){
                currentResult += displayValue;
                //Кастим результат вычисления в строку, добавляем его к пустой строке и выводим результат
                parent.displayField.setText("" + currentResult);
            } else if(selectedAction == '-'){
                currentResult -= displayValue;
                parent.displayField.setText("" + currentResult);
            } else if(selectedAction == '/'){
                currentResult /= displayValue;
                parent.displayField.setText("" + currentResult);
            } else if(selectedAction == '*'){
                currentResult *= displayValue;
                parent.displayField.setText("" + currentResult);
            }

        } else{
            //Цифровые кнопки. Присоединим надпись на цифровой кнопке к надписи в дисплее для ввода числа.
            String clickedButtonLabel = clickedButton.getText();
            parent.displayField.setText(displayFieldText + clickedButtonLabel);
        }
    }
}
