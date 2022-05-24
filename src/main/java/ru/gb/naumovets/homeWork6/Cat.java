package ru.gb.naumovets.homeWork6;

public class Cat extends Animal{

    private int staminaForRun = 200;
    private static int count;


    public Cat(String name){
        super(name);
        count++;
    }

    @Override
    public void run(int distance){
        if(distance > staminaForRun) {
            System.out.println("Кот(шка) устал(а). Он(она) не может пробежать больше чем " + staminaForRun + " м. Пожалуйста, укажите дистанцию поменьше");
        } else {
            super.run(distance);
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты и кошки не умеют плавать");
    }

    public static int getCount(){
        return count;
    }

}
