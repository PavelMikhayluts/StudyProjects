package inOut;
/**
 * Содержажийся в классе метод fileSearch обходит все папки указанного каталога, создает List с именами файлов
 * .txt, содержащийся в этих папках. Читает все строки из этих файлов, сохраняет их в List, сортирует их по алфавиту.
 * Создает в корне папки файл и записывает туда все строки.
 * 30/10/2021
 * Михайлуц Павел Николаевич
 */

import java.io.*;
import java.util.*;

public class FileManager {


    private String path; //путь к каталогу
    private List<String> fileList = new ArrayList<>(); //Коллекция для хранения имен файлов
    private List<String> contentList = new ArrayList<>(); //Коллекция для хранения и сортировки строк из файлов


    public void fileSearch(String path)  {

        list(path); //рекурсивно обходим каталог

        // Читаем содержимое файлов, записываем строки в contentList
        for (String string : fileList) {
            //проверяем файлы на соответствие маске
            if (string.endsWith(".txt")) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(string))) {
                    String s;
                    while ((s = bufferedReader.readLine()) != null) {//Читаем все строчки в файле
                        contentList.add(s);//Добавляем в contentList
                    }
                } catch (IOException e) {
                    System.out.println("Файл не найден.");
                }
            }
        }

        //Сортируем строки в алфавитном порядке
        Collections.sort(contentList);


        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(path + File.separator + "Новый файл.txt", false))) {
            for (int i = 0; i < contentList.size(); i++) {
                String newS = contentList.get(i);
                String replaceN = newS.replace("\\n", "");// Удаляем \n в конце строки
                bufferedWriter.write(replaceN);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        }catch (IOException ex) {
            System.out.println("Не удалось записать файл.");
        }
    }

    private void list(String dirPath) {

        File file = new File(dirPath);
        String[] dirList = file.list(); //Заполняем массив списком имен содержимого каталога

    /* Обрабатываем содержимое каталога в цикле. Создаем для каждого обнаруженного файла или каталога обьект
    класса File. Мы создаем ArrayList и ,если мы обнаруживаем файл, то мы помещаем туда строку с полным путем
    к файлу, комбинируя его из пути к каталогу dir И имени каталога.
    При обнаружении каталога метод list() вызывает сам себя, передавая себе через параметр полный путь
    к обнаруженному каталогу.*/
        int i;
        for (i = 0; i < dirList.length; i++) {
            File f1 = new File(dirPath + File.separator + dirList[i]);//записать параметр в отдельное выражение

            if(f1.isFile()) {//Если файл,то сохраняем в List строку с его адресом
                if (!dirList[i].startsWith("Новый")) { //Исключаем из списка "Новый файл"
                    fileList.add(dirPath + File.separator + dirList[i]);//Сделать коллекцию типа файл
                }
            } else {//Если каталог, то обходим его дальше
                list(dirPath + File.separator + dirList[i]);
            }
        }
    }
}

