package ru.sbrf.cu.l02;
import java.util.Scanner;

public class RunCalculation {
    public static void main(String args[]){
        InData figure = new GetData();
        switch (figure.getFigure()){
            case ("ТРЕУГОЛЬНИК"):
                Figure figure1 = new Triangle();
                figure1.getSide();
                System.out.println("Название: "+figure1.getName()+"; Периметр = "+figure1.getPerimeter()+"; Площадь = "+figure1.getArea());
                break;
            case ("КВАДРАТ"):
                Figure figure2 = new Cube();
                figure2.getSide();
                System.out.println("Название: "+figure2.getName()+"; Периметр = "+figure2.getPerimeter()+"; Площадь = "+figure2.getArea());
                break;
            case ("ПРЯМОУГОЛЬНИК"):
                Figure figure3 = new Rectangle();
                figure3.getSide();
                System.out.println("Название: "+figure3.getName()+"; Периметр = "+figure3.getPerimeter()+"; Площадь = "+figure3.getArea());
                break;
            default:
                System.out.println("Вы ввели недопустимую фигуру!");
        }
    }
}
