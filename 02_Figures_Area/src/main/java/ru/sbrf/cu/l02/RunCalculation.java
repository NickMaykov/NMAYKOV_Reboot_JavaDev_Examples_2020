package ru.sbrf.cu.l02;
import java.util.Scanner;

public class RunCalculation {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название фигуры (треугольник, квадрат, прямоугольник): ");
        String type = in.next().toUpperCase();
        switch (type){
            case ("ТРЕУГОЛЬНИК"):
                Figure figure1 = new Triangle();
                System.out.println("Название: "+figure1.getName()+"; Периметр = "+figure1.perimeter()+"; Площадь = "+figure1.area());
                break;
            case ("КВАДРАТ"):
                Figure figure2 = new Cube();
                System.out.println("Название: "+figure2.getName()+"; Периметр = "+figure2.perimeter()+"; Площадь = "+figure2.area());
                break;
            case ("ПРЯМОУГОЛЬНИК"):
                Figure figure3 = new Rectangle();
                System.out.println("Название: "+figure3.getName()+"; Периметр = "+figure3.perimeter()+"; Площадь = "+figure3.area());
                break;
            default:
                System.out.println("Вы ввели недопустимую фигуру!");
        }

    }
}
