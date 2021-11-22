package inOut;
/**
 * ������������ � ������ ����� fileSearch ������� ��� ����� ���������� ��������, ������� List � ������� ������
 * .txt, ������������ � ���� ������. ������ ��� ������ �� ���� ������, ��������� �� � List, ��������� �� �� ��������.
 * ������� � ����� ����� ���� � ���������� ���� ��� ������.
 * 30/10/2021
 * �������� ����� ����������
 */

import java.io.*;
import java.util.*;

public class FileManager {


    private String path; //���� � ��������
    private List<String> fileList = new ArrayList<>(); //��������� ��� �������� ���� ������
    private List<String> contentList = new ArrayList<>(); //��������� ��� �������� � ���������� ����� �� ������


    public void fileSearch(String path)  {

        list(path); //���������� ������� �������

        // ������ ���������� ������, ���������� ������ � contentList
        for (String string : fileList) {
            //��������� ����� �� ������������ �����
            if (string.endsWith(".txt")) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(string))) {
                    String s;
                    while ((s = bufferedReader.readLine()) != null) {//������ ��� ������� � �����
                        contentList.add(s);//��������� � contentList
                    }
                } catch (IOException e) {
                    System.out.println("���� �� ������.");
                }
            }
        }

        //��������� ������ � ���������� �������
        Collections.sort(contentList);


        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(path + File.separator + "����� ����.txt", false))) {
            for (int i = 0; i < contentList.size(); i++) {
                String newS = contentList.get(i);
                String replaceN = newS.replace("\\n", "");// ������� \n � ����� ������
                bufferedWriter.write(replaceN);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        }catch (IOException ex) {
            System.out.println("�� ������� �������� ����.");
        }
    }

    private void list(String dirPath) {

        File file = new File(dirPath);
        String[] dirList = file.list(); //��������� ������ ������� ���� ����������� ��������

    /* ������������ ���������� �������� � �����. ������� ��� ������� ������������� ����� ��� �������� ������
    ������ File. �� ������� ArrayList � ,���� �� ������������ ����, �� �� �������� ���� ������ � ������ �����
    � �����, ���������� ��� �� ���� � �������� dir � ����� ��������.
    ��� ����������� �������� ����� list() �������� ��� ����, ��������� ���� ����� �������� ������ ����
    � ������������� ��������.*/
        int i;
        for (i = 0; i < dirList.length; i++) {
            File f1 = new File(dirPath + File.separator + dirList[i]);//�������� �������� � ��������� ���������

            if(f1.isFile()) {//���� ����,�� ��������� � List ������ � ��� �������
                if (!dirList[i].startsWith("�����")) { //��������� �� ������ "����� ����"
                    fileList.add(dirPath + File.separator + dirList[i]);//������� ��������� ���� ����
                }
            } else {//���� �������, �� ������� ��� ������
                list(dirPath + File.separator + dirList[i]);
            }
        }
    }
}

