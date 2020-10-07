package ru.sbrf.cu.l02;

import java.util.Scanner;

public class GetData implements InData{

    Scanner in = new Scanner(System.in);

    @Override
    public String getFigure() {
        System.out.println("Введите название фигуры (треугольник, квадрат, прямоугольник): ");
        String type = in.next().toUpperCase();
        return type;
    }

    @Override
    public int[] getTriangleSide() {
        int base;
        int right;
        int left;
        int height;
        System.out.println("Введите длину основания треугольника:");
        base = in.nextInt();
        System.out.println("Введите правую сторону треугольника:");
        right = in.nextInt();
        System.out.println("Введите левую сторону треугольника:");
        left = in.nextInt();
        System.out.println("Введите высоту треугольника: ");
        height = in.nextInt();

        int[] sides = {base,right,left,height};

        return sides;
    }

    @Override
    public int[] getCubeSide() {
        System.out.println("Введите сторону квадрата:");
        int[] sides = {in.nextInt()};
        return sides;
    }

    @Override
    public int[] getRectangleSide() {
        int weight;
        int height;
        System.out.println("Введите длину прямоугольника:");
        weight = in.nextInt();
        System.out.println("Введите ширину прямоугольника:");
        height = in.nextInt();

        int[] sides = {weight,height};

        return sides;
    }
}
