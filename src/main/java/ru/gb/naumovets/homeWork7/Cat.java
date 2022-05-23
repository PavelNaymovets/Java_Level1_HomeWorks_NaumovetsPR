package ru.gb.naumovets.homeWork7;

public class Cat {

    private String name;
    private int appetite;

    //Поле сытость. Если коту хватило еды, чтобы покушать, то он сыт (satiety = true)
    private boolean satiety;

    //Конструктор кота
    public Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
    }

    //Метод, который позволяет коту кушать. Уменьшает количество еды в тарелке на величину аппетита кота
    public void eat(Plate plate){
        if(plate.getFood() >= appetite && !satiety){
            plate.decreaseFood(appetite);
            satiety = true;
        }
    }

    //Метод возвращает информацию о сытости кота. True = сыт, false = голоден
    public boolean getSatiety(){
        return satiety;
    }

    //Метод возвращает имя кота
    public String getName(){
        return name;
    }
}
