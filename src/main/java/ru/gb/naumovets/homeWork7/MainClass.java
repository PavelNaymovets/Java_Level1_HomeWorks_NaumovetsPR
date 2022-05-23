package ru.gb.naumovets.homeWork7;


public class MainClass {

    public static void main(String[] args) {
        //Пример для 1-3 задания
        Cat cat = new Cat("Barsik", 10);
        Plate plate = new Plate(100);
        plate.info();
        cat.eat(plate);
        System.out.println(cat.getSatiety() ? cat.getName() + ": сыт" : cat.getName() + ": голоден");
        plate.info();

        System.out.println();

        //Пример для 4 задания
        Plate bigPlate = new Plate(10);
        Cat [] cats = new Cat[]{
                new Cat("Murzik", 5),
                new Cat("Kolka", 10),
                new Cat("Rizhik", 15),
                new Cat("Ivashka", 3),
                new Cat("Antonshka", 7)
        };

        bigPlate.info();

        for (Cat oneCat: cats) {
            oneCat.eat(bigPlate);
        }


        for (Cat oneCat: cats) {
            System.out.println(oneCat.getSatiety() ? oneCat.getName() + ": сыт" : oneCat.getName() + ": голоден");
        }

        bigPlate.info();

        System.out.println();

        //Пример для 5 задания. Добавляем еду в тарелку. Те коты, что уже покушали (сыты) - не едят.
        bigPlate.putFoodInPlate(40);

        bigPlate.info();

        for (Cat oneCat: cats) {
            oneCat.eat(bigPlate);
        }

        for (Cat oneCat: cats) {
            System.out.println(oneCat.getSatiety() ? oneCat.getName() + ": сыт" : oneCat.getName() + ": голоден");
        }

        bigPlate.info();

        System.out.println();

        //Пример для 5 задания с добавлением отрицательного количеством еды. Метод putFoodInPlate не забирает еду
        // из тарелки
        bigPlate.putFoodInPlate(-40);

        bigPlate.info();

        for (Cat oneCat: cats) {
            oneCat.eat(bigPlate);
        }

        for (Cat oneCat: cats) {
            System.out.println(oneCat.getSatiety() ? oneCat.getName() + ": сыт" : oneCat.getName() + ": голоден");
        }

        bigPlate.info();
    }
}
