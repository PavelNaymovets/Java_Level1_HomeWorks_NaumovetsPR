package ru.gb.naumovets.homeWork6;

public class Dog extends Animal{

    private int staminaForRun = 500;
    private int staminaForSwim = 10;
    private static int count;

    public Dog(String name){
        super(name);
        count++;
    }

    @Override
    public void run(int distance){
        if(distance > staminaForRun) {
            System.out.println("Пес(собака) устал(а). Он(она) не может пробежать больше чем " + staminaForRun + " м. Пожалуйста, укажите дистанцию поменьше");
        } else {
            super.run(distance);
        }
    }

    @Override
    public void swim(int distance){
        if(distance > staminaForSwim) {
            System.out.println("Пес(собака) устал(а). Он(она) не может проплыть больше чем " + staminaForSwim + " м. Пожалуйста, укажите дистанцию поменьше");
        } else {
            super.swim(distance);
        }
    }

    public static int getCount(){
        return count;
    }

}
