package collections.zadanie;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * �������� ����� ����������, ������ � �������� �������� �� ���������
 * � LinkedList, ArrayList, HashSet. �������� ����� � ������� ����� � ���,
 * ����� ��������� �������� ������� ��� ����� ������.
 */

public class CollectionsTest {


    private List<String> testLinkedList = new LinkedList<>();
    private List<String> testArrayList = new ArrayList<>();
    private Set<String> testHashSet = new HashSet<>();
    private long start;
    private long end;
    private long totalTime;


    public static void main(String[] args) {
        CollectionsTest collectionsTest = new CollectionsTest();
        collectionsTest.linkedListTest();
        collectionsTest.arrayListTest();
        collectionsTest.hashSetTest();
    }

    //��������� LinkedList
    private void linkedListTest() {
        //��������� ������� � �������� �����
        buildCollection(testLinkedList);
        System.out.println("����� ���������� �������� � LinkedList ����������: " + totalTime);

        //������� �������� ���������� �� ���������
        collectionIterator(testLinkedList);
        System.out.println("����� ������ �������� ����� �������� � LinkedList ����������: " + totalTime);

        //������� ��� �������� ��������� �� �������
        findByIndex(testLinkedList);
        System.out.println("����� ������ �������� �� ������� � LinkedList ����������: " + totalTime);

        //������� ������� ����� ��������
        deleteElements(testLinkedList);
        System.out.println("����� �������� �������� ����� �������� � LinkedList ����������: " + totalTime);

        //������� ��� ������� �� �������
        deleteByIndex(testLinkedList);
        System.out.println("����� �������� �������� �� ������� � LinkedList ����������: " + totalTime);
        System.out.println();
    }

    //��������� ArrayList
    private void arrayListTest() {
        //��������� ������� � �������� �����
        buildCollection(testArrayList);
        System.out.println("����� ���������� �������� � ArrayList ����������: " + totalTime);

        //������� �������� ���������� �� ���������
        collectionIterator(testArrayList);
        System.out.println("����� ������ �������� ����� �������� � ArrayList ����������: " + totalTime);

        //������� ��� �������� ��������� �� �������
        findByIndex(testArrayList);
        System.out.println("����� ������ �������� �� ������� � ArrayList ����������: " + totalTime);

        //������� ������� ����� ��������
        deleteElements(testArrayList);
        System.out.println("����� �������� �������� ����� �������� � ArrayList ����������: " + totalTime);

        //������� ��� ������� �� �������
        deleteByIndex(testArrayList);
        System.out.println("����� �������� �������� �� ������� � ArrayList ����������: " + totalTime);
        System.out.println();
    }

    //��������� HashSet
    private void hashSetTest() {
        //��������� ������� � �������� �����
        buildCollection(testHashSet);
        System.out.println("����� ���������� �������� � HashSet ����������: " + totalTime);

        //������� ��� �������� ���������
        collectionIterator(testHashSet);
        System.out.println("����� ������ �������� � HashSet ����������: " + totalTime);

        //������� ��� �������� ���������
        deleteElements(testHashSet);
        System.out.println("����� �������� �������� � HashSet ����������: " + totalTime);
    }

    //////////////////////////////////////////////////////////////////////

    private void buildCollection(Collection<String> collection) {
        try {
            Scanner in = new Scanner(new FileInputStream("C:\\Users\\Admin\\Desktop\\���� ���������.txt"));
            System.out.println("�������� �������� ������ " + collection.getClass() + ":");
            start = System.currentTimeMillis();
            while (in.hasNext()) {
                String word = in.next();
                collection.add(word);
            }
        } catch (FileNotFoundException e) { e.printStackTrace(); }
        end = System.currentTimeMillis();
        totalTime = end - start;
    }
    private void collectionIterator(Collection<String> collection) {
        Iterator<String> iterator = collection.iterator();
        start = System.currentTimeMillis();
        while (iterator.hasNext()) {
            String s = iterator.next();
        }
        end = System.currentTimeMillis();
        totalTime = end - start;
    }
    private void deleteElements(Collection<String> collection) {
        Iterator<String> iterator = collection.iterator();
        start = System.currentTimeMillis();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        end = System.currentTimeMillis();
        totalTime = end - start;
    }
    private void findByIndex(List<String> collection) {
        start = System.currentTimeMillis();
        for (String s : collection) {
        }
        end = System.currentTimeMillis();
        totalTime = end - start;
    }
    private void deleteByIndex(List<String> collection) {
        start = System.currentTimeMillis();
        for (int i = 0; i < collection.size(); i++) {
            collection.remove(i);
        }
        end = System.currentTimeMillis();
        totalTime = end - start;
    }


}



