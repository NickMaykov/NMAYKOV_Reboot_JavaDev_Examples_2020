package ru.sbrf.cu.l02;

import java.util.Scanner;

public class Cube implements Figure{
    int Perimeter;
    int Area;
    int base;
    Scanner in = new Scanner(System.in);

    @Override
    public String getName() {
        return "Квадрат";
    }

    @Override
    public Integer perimeter() {
        System.out.println("Введите сторону квадрата:");
        base = in.nextInt();
        Perimeter = 4*base;
        return Perimeter;
    }

    @Override
    public Integer area() {
        Area = base*base;
        return Area;
    }
}
