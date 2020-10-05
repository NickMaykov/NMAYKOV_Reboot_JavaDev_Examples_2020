package ru.sbrf.cu.l02;

import java.util.Scanner;

public class Triangle implements Figure{
    int Perimeter;
    int Area;
    int base;
    int right;
    int left;
    int height;
    Scanner in = new Scanner(System.in);
    @Override
    public String getName() {
        return "Треугольник";
    }

    @Override
    public Integer perimeter() {
        System.out.println("Введите длину основания треугольника:");
        base = in.nextInt();
        System.out.println("Введите правую сторону треугольника:");
        right = in.nextInt();
        System.out.println("Введите левую сторону треугольника:");
        left = in.nextInt();
        Perimeter = base + right + left;
        return Perimeter;
    }

    @Override
    public Integer area() {
        System.out.println("Введите высоту треугольника: ");
        height = in.nextInt();
        Area = (base * height)/2;
        return Area;
    }
}
