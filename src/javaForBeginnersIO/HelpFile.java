package javaForBeginnersIO;

/**
 * ������������ ������ ���������� ������� �� ������ �����
 */

public class HelpFile {
    public static void main(String[] args) {
        // �������� � ����������� ���� � ������ ����� � ���� ������
        Help helpObj=new Help("C:\\Users\\Admin\\Desktop\\HelpFile.txt");

        String topic;

        System.out.println("�������������� ���������� ��������.\n"+
                "��� ������ �� ������� ������� 'stop'.");
        do{
            topic=helpObj.getSelection();
            if (!helpObj.helpOn(topic)){
                System.out.println("��������� �� ������. \n");
            }
        }while(topic.compareTo("stop")!=0);
    }
}
