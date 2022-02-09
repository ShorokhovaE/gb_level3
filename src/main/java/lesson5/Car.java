package lesson5;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable{

    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private static CyclicBarrier cyclicForStart = getCyclicForStart(lesson5.CARS_COUNT);

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            lesson5.waitAllCarStarts.countDown();
            cyclicForStart.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            if(i == (race.getStages().size() - 1)){
                lesson5.waitAllCarFinish.countDown();
                if(lesson5.waitAllCarFinish.getCount() == (lesson5.CARS_COUNT - 1)){
                    System.out.println(this.name + " WIN");
                };
            }
        }
    }

    public static CyclicBarrier getCyclicForStart(int count){
        return new CyclicBarrier(count);
    }

}
