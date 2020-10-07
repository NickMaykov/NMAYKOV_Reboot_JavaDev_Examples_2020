package ru.sbrf.cu.l02;

public class Rectangle implements Figure{

    int[] sides;

    @Override
    public String getName() {
        return "Прямоугольник";
    }

    @Override
    public int[] getSide() {
        GetData getSide = new GetData();
        sides = getSide.getRectangleSide();
        return sides;
    }

    @Override
    public Integer getPerimeter() {
        return (sides[0] + sides[1])*2;
    }

    @Override
    public Integer getArea() {
        return sides[0]*sides[1];
    }
}
