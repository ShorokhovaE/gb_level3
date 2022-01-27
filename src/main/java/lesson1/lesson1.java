package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lesson1 {

    public static void main(String[] args) {

//        Задача № 3

//        Box<Apple> appleBox = new Box<Apple>(new Apple());
//        Box<Orange> orangeBox = new Box<Orange>(new Orange());
//        Box<Apple> appleBox1 = new Box<Apple>(new Apple());


//        appleBox.putFruitInTheBox(new Apple());
//        appleBox.putFruitInTheBox(new Apple());
//        appleBox.putFruitInTheBox(new Apple());


//        orangeBox.putFruitInTheBox(new Orange());
//        orangeBox.putFruitInTheBox(new Orange());
//        orangeBox.putFruitInTheBox(new Orange());


//        appleBox.putFruitInTheBox(new Apple());
//        appleBox.putFruitInTheBox(new Orange());

//        System.out.println("Вес корзины с яблоками: " + appleBox.getWeight());
//        System.out.println("Вес корзины с апельсинами: " + orangeBox.getWeight());
//
//            Проверка пункта e
//        System.out.println(appleBox.compare(orangeBox, appleBox.getWeight()));


//        appleBox1.putFruitInTheBox(new Apple());
//        appleBox1.putFruitInTheBox(new Apple());
//
//        appleBox.transferFruitToAnotherBox(appleBox1);
//        appleBox.transferFruitToAnotherBox(orangeBox);


//        Задание 1 и 2

//        String[] str = new String[5];
//        str[0] = "A ";
//        str[1] = "B ";
//        str[2] = "C ";
//        str[3] = "D ";
//        str[4] = "E ";
//
//        changeArraysElm(1,2,str);
//
//        System.out.println(transformationToList(str));
    }

    //Задание №1
    public static <T> void changeArraysElm(int index2, int index1, T[] array){
        T first = array[index1];

        array[index1] = array[index2];
        array[index2] = first;

        System.out.println(Arrays.toString(array));
    }


    //Задание №2
    public static <T> List<T> transformationToList(T[] array){

        return Arrays.asList(array);
    }

}
