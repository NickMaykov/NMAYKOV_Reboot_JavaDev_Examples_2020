package ru.sbrf.cu.l02;
import java.util.Scanner;

public class FigureArea {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        double base = 0;
        double height = 0;
        double perimeter = 0;
        double area = 0;

        System.out.println("Введите название фигуры: ");
        String figure = scanner.next().toUpperCase();
        switch (figure){
            case ("ТРЕУГОЛЬНИК"):
                System.out.println("Треугольник прямоугольный (Да/Нет)?:");
                String answer = scanner.next().toUpperCase();
                if (answer.equals("ДА")){
                    System.out.println("Введите длину основания треугольника:");
                    base = scanner.nextDouble();
                    System.out.println("Введите высоту треугольника:");
                    height = scanner.nextDouble();
                    System.out.println("Введите гипотенузу треугольника:");
                    Double hypo = scanner.nextDouble();
                    perimeter = base + height + hypo;
                }
                else {
                    System.out.println("Введите длину основания треугольника:");
                    base = scanner.nextDouble();
                    System.out.println("Введите правую сторону треугольника:");
                    Double right = scanner.nextDouble();
                    System.out.println("Введите левую сторону треугольника:");
                    Double left = scanner.nextDouble();
                    System.out.println("Введите высоту треугольника:");
                    height = scanner.nextDouble();
                    perimeter = base + right + left;
                }
                area = (base * height)/2;
                System.out.println("Периметр = "+perimeter+" Площадь = "+area);
            break;
            case ("КВАДРАТ"):
                System.out.println("Введите сторону квадрата:");
                base = scanner.nextDouble();
                perimeter = base * 4;
                area = base * base;
                System.out.println("Периметр = "+perimeter+" Площадь = "+area);
            break;
            case ("ПРЯМОУГОЛЬНИК"):
                System.out.println("Введите длину прямоугольника:");
                base = scanner.nextDouble();
                System.out.println("Введите ширину прямоугольника:");
                height = scanner.nextDouble();
                perimeter = (base + height) * 2;
                area = base * height;
                System.out.println("Периметр = "+perimeter+" Площадь = "+area);
            break;
            default:
                System.out.println("Вы ввели недопустимую фигуру!");
        }
    }
}
