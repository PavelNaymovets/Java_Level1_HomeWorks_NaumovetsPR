package ru.gb.naumovets.homeWork6;

public abstract class Animal {
    private String name;
    private static int count;

    public Animal(String name){
        this.name = name;
        count++;
    }

    public void run(int distance) {
        System.out.println(getName() + " пробежал(а) " + distance + " м");
    }

    public void swim(int distance) {
        System.out.println(getName() + " проплыл(а) " + distance + " м");
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getCountAnimal(){
        return count;
    }



    public static void main(String[] args) {
        /*
        Пояснение

        В данном случае можно было создать объекты с типом ссылки Animal. Но тогда мне бы пришлось
        создать метод getCount() в вклассе Animal и затем переопределить его в классах наследниках, чтобы он работал как следует.

         */
        Cat catBarsik = new Cat("Барсик");
        Cat catMurzik = new Cat("Мурзик");
        Cat catIvashka = new Cat("Ивашка");
        Dog dogCharli = new Dog("Чарли");

        //Методы run() и swim()
        catBarsik.run(200);
        catBarsik.swim(100);
        dogCharli.run(500);
        dogCharli.swim(10);

        //Подсчет количества котов
        System.out.println("Всего создано объектов котов: " + catBarsik.getCount());
        //Подсчет количества собак
        System.out.println("Всего создано объектов собак: " + dogCharli.getCount());
        //Подсчет количества животных
        System.out.println("Всего создано объектов животных: " + dogCharli.getCountAnimal());

        /*

        Пояснение

        Переменная count имеет ключевое слово static. Статические переменные принадлежат классу, поэтому
        всякий раз, когда создается экземляр класса (запускается конструктор класса) переменная count фиксирует запуск
        конструктора, иными словами показывает количество обращений к коду класса.

        Если же переменную count сделать не статической, то она будет принадлежать экземпляру (инстансу) класса. В таком
        случае она будет фиксировать только создание объекта. За раз можно создать только один объект. Поэтому всякий
        раз при вызове метода, который возвращает значение count, будет возвращена единица, так как больше одного
        объекта за раз не создать.

        */
    }


}