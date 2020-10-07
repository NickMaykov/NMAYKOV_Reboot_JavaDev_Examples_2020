package ru.sbrf.cu.l02;

public class Triangle implements Figure{

    int[] sides;

    @Override
    public String getName() {
        return "Треугольник";
    }

    @Override
    public int[] getSide() {
        GetData getSide = new GetData();
        sides = getSide.getTriangleSide();
        return sides;
    }

    @Override
    public Integer getPerimeter() {
        return sides[0]+sides[1]+sides[2];
    }

    @Override
    public Integer getArea() {
        return (sides[0]*sides[3])/2;
    }
}
