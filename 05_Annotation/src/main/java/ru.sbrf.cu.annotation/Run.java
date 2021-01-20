package ru.sbrf.cu.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Run {
    private int errorCount;

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Run run = new Run();

        Class<?> clazz = Annotation.class;
        Constructor constructor = clazz.getConstructor(int.class, String.class, int.class);

        List<Method> before = new ArrayList<>();
        List<Method> test = new ArrayList<>();
        List<Method> after = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods()){
            if (method.isAnnotationPresent(Before.class)) {
                before.add(method);
            }
            if (method.isAnnotationPresent(Test.class)) {
                test.add(method);
            }
            if (method.isAnnotationPresent(After.class)) {
                after.add(method);
            }
        }

        for (Method method : test) {
            Object object = constructor.newInstance(122, "правда", 1000);
            before.forEach(beforeMethod -> {
                run.callMethod(beforeMethod, object);
            });
            run.callMethod(method, object);
            after.forEach(afterMethod -> {
                run.callMethod(afterMethod, object);
            });

        }

        System.out.println("Всего тестов: " + test.size());
        System.out.println("Упало с ошибкой: " + run.getErrorCount());
    }

    public Object callMethod(Method method, Object object){
        Object result = "";
        try {
            result = method.invoke(object);
        } catch (IllegalAccessException e) {
            printError("Ошибка в callMethod " + method + " ,текст ошибки: " + e.toString());
        } catch (InvocationTargetException e) {
            printError("Ошибка в callMethod " + method + " ,текст ошибки: " + e.toString());
        } catch (Exception e) {
            printError("Непредвиденная ошибка в callMethod " + method + " ,текст ошибки: " + e.toString());
        }
        return result;
    }

    private void printError(String text){
        System.out.println(text);
        errorCount++;
    }

    public int getErrorCount(){
        return errorCount;
    }
}
