package ru.sbrf.cu.l02;

import java.util.Scanner;

public class Rectangle implements Figure{
    int Perimeter;
    int Area;
    int weight;
    int height;
    Scanner in = new Scanner(System.in);
    @Override
    public String getName() {
        return "Прямоугольник";
    }

    @Override
    public Integer perimeter() {
        System.out.println("Введите длину прямоугольника:");
        weight = in.nextInt();
        System.out.println("Введите ширину прямоугольника:");
        height = in.nextInt();
        Perimeter = (weight + height)*2;
        return Perimeter;
    }

    @Override
    public Integer area() {
        Area = weight*height;
        return Area;
    }
}
