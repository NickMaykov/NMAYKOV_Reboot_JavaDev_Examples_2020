package ru.sbrf.cu.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

@DisplayName("Нужно поработать с содержимым файлов")
public class FileReadDemo {
    @DisplayName("вывести на консоль lorem.txt")
    @Test
    public void readFileContext() throws IOException {
        try(var input = new BufferedReader(new FileReader("tmp/lorem.txt"))) {
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    @DisplayName("ввести строки в консоле и сохранить строчки одну за одной в файле")
    @Test
    public void writeFileContext() throws IOException{
        var line1 = "Line1 - first line";
        var line2 = "Line2 - second line";
        var line3 = "Line3 - third line";

        try (var bufferedWriter = new BufferedWriter(new FileWriter(new File("tmp/test.txt")))) {
            bufferedWriter.write(line1);
            bufferedWriter.newLine();
            bufferedWriter.write(line2);
            bufferedWriter.newLine();
            bufferedWriter.write(line3);
        }
    }
}
