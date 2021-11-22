package inOut;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WalkThroughTree extends SimpleFileVisitor<Path> {

    private List<String> fileList = new ArrayList<>();//Коллекция для хранения имен файлов
    private List<String> contentList = new ArrayList<>(); //Коллекция для хранения и сортировки строк из файлов

    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
        List<String> lines = Files.readAllLines(file);
        for (String s : lines) {
            if (s.contains(".txt")) {
                fileList.add(file.toAbsolutePath().toString());
            }
            // Читаем содержимое файлов, записываем строки в contentList
            for (String paths : lines) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(paths))) {
                    String s1;
                    while ((s1 = bufferedReader.readLine()) != null) {//Читаем все строчки в файле
                        contentList.add(s1);//Добавляем в contentList
                    }
                } catch (IOException e) {
                    System.out.println("Файл не найден.");
                }
            }
            //Сортируем строки в алфавитном порядке
            Collections.sort(contentList);

            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(file.toString() + File.separator + "Новый файл.txt", false))) {
                for (int i = 0; i < contentList.size(); i++) {
                    String newS = contentList.get(i);
                    String replaceN = newS.replace("\\n", "");// Удаляем \n в конце строки
                    bufferedWriter.write(replaceN);
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
            } catch (IOException ex) {
                System.out.println("Не удалось записать файл.");
            }
        }
        return FileVisitResult.CONTINUE;
    }
}




