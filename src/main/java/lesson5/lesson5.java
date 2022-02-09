package lesson5;

import java.util.concurrent.CountDownLatch;

public class lesson5 {

    public static final int CARS_COUNT = 4;
    final static CountDownLatch waitAllCarStarts = getWaitAllCarStarts();
    final static CountDownLatch waitAllCarFinish = getWaitAllCarFinish();

    public static void main(String[] args) {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));

        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            waitAllCarStarts.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            waitAllCarFinish.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static CountDownLatch getWaitAllCarStarts(){
        return new CountDownLatch(CARS_COUNT);
    }

    private static CountDownLatch getWaitAllCarFinish(){
        return new CountDownLatch(CARS_COUNT);
    }

}
