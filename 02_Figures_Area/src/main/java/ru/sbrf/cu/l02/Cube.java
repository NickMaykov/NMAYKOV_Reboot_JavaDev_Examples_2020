package ru.sbrf.cu.l02;

public class Cube implements Figure{

    int[] sides;

    @Override
    public String getName() {
        return "Квадрат";
    }

    @Override
    public int[] getSide() {
        GetData getSide = new GetData();
        sides = getSide.getCubeSide();
        return sides;
    }

    @Override
    public Integer getPerimeter() {
        return 4*sides[0];
    }

    @Override
    public Integer getArea() {
        return sides[0]*sides[0];
    }
}
