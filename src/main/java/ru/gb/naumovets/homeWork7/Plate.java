package ru.gb.naumovets.homeWork7;

public class Plate {

    private int plateFood;

    //Конструктор класса
    public Plate(int food){
        this.plateFood = food;
    }

    //Метод уменьшиающий количество еды в тарелке, где eatFoodQuantity = аппетиту кота
    public void decreaseFood(int eatFoodQuantity){
        if(plateFood >= eatFoodQuantity){
            plateFood -= eatFoodQuantity;
        }
    }

    //Метод, который вывод информацию о количестве еды в тарелке
    public void info(){
        System.out.println("Количество еды в тарелке: " + plateFood);
    }

    //Метод, который возвращает количество еды в тарелке
    public int getFood(){
        return plateFood;
    }

    //Метод, который добавляет еду в тарелку
    public void putFoodInPlate(int quantityFood){
        if(quantityFood < 0){
            System.err.println("Нельзя брать еду из тарелки");
        } else{
            plateFood += quantityFood;
        }
    }
}
