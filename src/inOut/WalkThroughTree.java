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

    private List<String> fileList = new ArrayList<>();//��������� ��� �������� ���� ������
    private List<String> contentList = new ArrayList<>(); //��������� ��� �������� � ���������� ����� �� ������

    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
        List<String> lines = Files.readAllLines(file);
        for (String s : lines) {
            if (s.contains(".txt")) {
                fileList.add(file.toAbsolutePath().toString());
            }
            // ������ ���������� ������, ���������� ������ � contentList
            for (String paths : lines) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(paths))) {
                    String s1;
                    while ((s1 = bufferedReader.readLine()) != null) {//������ ��� ������� � �����
                        contentList.add(s1);//��������� � contentList
                    }
                } catch (IOException e) {
                    System.out.println("���� �� ������.");
                }
            }
            //��������� ������ � ���������� �������
            Collections.sort(contentList);

            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(file.toString() + File.separator + "����� ����.txt", false))) {
                for (int i = 0; i < contentList.size(); i++) {
                    String newS = contentList.get(i);
                    String replaceN = newS.replace("\\n", "");// ������� \n � ����� ������
                    bufferedWriter.write(replaceN);
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
            } catch (IOException ex) {
                System.out.println("�� ������� �������� ����.");
            }
        }
        return FileVisitResult.CONTINUE;
    }
}




