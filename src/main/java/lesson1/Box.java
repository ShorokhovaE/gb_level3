package lesson1;

import java.util.ArrayList;

public class Box <T extends Fruit>{

    private T type;
    private ArrayList<Fruit> fruitInTheBox;
    private Fruit fruit;
    private float weight;

    public Box(T type) {
        this.type = type;
        this.fruitInTheBox = new ArrayList<Fruit>();
    }

    public ArrayList<Fruit> getFruitInTheBox() {
        return fruitInTheBox;
    }

    public void putFruitInTheBox(Fruit fruit) {
        if(fruit.getClass().equals(type.getClass())){
            this.fruit = fruit;
            fruitInTheBox.add(fruit);
            System.out.println("Положили фрукт в корзину");
        } else {
            if(type.getClass().equals(Apple.class)){
                System.out.println("В этой корзине лежат яблоки, сюда нельзя положить апельсины");
            }
            if(type.getClass().equals(Orange.class)){
                System.out.println("В этой корзине лежат апельсины, сюда нельзя положить яблоки");
            }

        }
    }

    public float getWeight(){

        for (Fruit inTheBox : fruitInTheBox) {
                weight += inTheBox.getWeightOfFruit();
        }
        return weight;
    }

    public boolean compare(Box box, float currentBoxWeight){

        return Math.abs(currentBoxWeight - box.getWeight()) < 0.00001;
    }

    public void transferFruitToAnotherBox(Box anotherBox){

        if (anotherBox.type.getClass().equals(type.getClass())){
            anotherBox.getFruitInTheBox().addAll(getFruitInTheBox());
            System.out.println("Пересыпали фрукты из одной корзины в другую");
            getFruitInTheBox().removeAll(getFruitInTheBox());
        } else {
            System.out.println("В корзину можно пересыпать только те же самые фрукты");
        }
    }



}
