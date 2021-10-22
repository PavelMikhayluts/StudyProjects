package javaForBeginnersIO;
import java.io.*;

/**
 * ���������� �������, ������������ �������� ���� ��� �������� ����������.
 * � ������ Help ����������� ���� �� ���������� �����������,������������ ����� ��������� ����,
 * � ����� ������������ ���������� ����������.
*/

public class Help {
    String helpFile; // ��� ����������� �����

    Help(String fname){ //������� ������������ ���� ��� ����������� ��������� ��������� ������ ���������� ������
        helpFile=fname;} // �� ������ ����.

    //���������� ���������� ���������� �� ��������� ����.
    boolean helpOn(String what){
        int ch;
        String topic,info;

        //������� ���������� ����
        try (BufferedReader helpRdr=new BufferedReader(new FileReader(helpFile))){
            do{
                //������ ������� � ����� �� ��� ��� ���� �� ���������� ������ #
                ch=helpRdr.read();
                // ��������� ��������� �� ��������� ������
                if(ch=='#'){
                    topic=helpRdr.readLine();
                       if (what.compareTo(topic)==0) {//����� ������ ���� �� ���������
                           do {
                               info = helpRdr.readLine();
                               if (info!= null) {
                                   System.out.println(info);
                               }
                           } while ((info != null) && (info.compareTo("")!= 0));
                           return true;

                    }
                }
            }while (ch!=-1);
        }catch (IOException exc){
            System.out.println("������ ��� ������� � ����� �������.");
            return false;
        }
            return false; // ������ ��������� �� ������.

    }

    //�������� ���� ������� �� ������������
    String getSelection(){
        String topic="";
        BufferedReader br=new BufferedReader((new InputStreamReader(System.in)));
        System.out.println("������� ����: ");
        try {
            topic= br.readLine();
        }catch(IOException exc){
            System.out.println("������ ��� ������ � �������");
        }
        return topic;
    }




}
