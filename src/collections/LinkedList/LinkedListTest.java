package collections.LinkedList;

import java.util.*;

/**
 * � ���� ��������� ��������������� �������� �� ���������� ��������
 * @version 1.1 2021-11-06
 * @author Mikhayluts Pavel
 */

public class LinkedListTest {

    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        //���������� ����� �� ������� ������� a � b
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) { aIter.next(); }
            aIter.add(bIter.next());
        }

        System.out.println(a);

        //������� ������ ������ ����� �� ���������� ������ b
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next(); //���������� ���� �������
            if (bIter.hasNext()){
                bIter.next();//������ �������� �������
                bIter.remove();//������� ���� �������
            }
        }

        System.out.println(b);

        //��������� �������� �������� �� ������� ������ � ���� ��������� �� ������ b
        a.removeAll(b);

        System.out.println(a);
    }
}
