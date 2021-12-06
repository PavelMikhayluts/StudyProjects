package generics;

public class GenDemo {

    public static void main(String[] args) {
        Gen<Integer> iObject;
        iObject = new Gen<>(88);
        iObject.showType();
        // �������� �������� �� ������� iObject. �������� �������� �� ��, ��� ���������� ����� ����� �� ���������
        int v = iObject.getObject();
        System.out.println("��������: " + v);
        System.out.println();

        Gen<String> sObject = new Gen<>("������������ ��������");
        sObject.showType();
        String str = sObject.getObject();
        System.out.println("��������: " + str);
    }
}
