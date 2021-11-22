package collections.zadanie;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Замерить время добавления, поиска и удаления объектов из коллекции
 * в LinkedList, ArrayList, HashSet. Сравнить время и сделать вывод о том,
 * какая коллекция работает быстрее для какой задачи.
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

    //Тестируем LinkedList
    private void linkedListTest() {
        //Добавляем обьекты и замеряем время
        buildCollection(testLinkedList);
        System.out.println("Время добавления обьектов в LinkedList составляет: " + totalTime);

        //Находим проходим итератором по коллекции
        collectionIterator(testLinkedList);
        System.out.println("Время поиска обьектов через итератор в LinkedList составляет: " + totalTime);

        //Находим все элементы коллекции по индексу
        findByIndex(testLinkedList);
        System.out.println("Время поиска обьектов по индексу в LinkedList составляет: " + totalTime);

        //удаляем обьекты через итератор
        deleteElements(testLinkedList);
        System.out.println("Время удаления обьектов через итератор в LinkedList составляет: " + totalTime);

        //Удаляем все обьекты по индексу
        deleteByIndex(testLinkedList);
        System.out.println("Время удаления обьектов по индексу в LinkedList составляет: " + totalTime);
        System.out.println();
    }

    //Тестируем ArrayList
    private void arrayListTest() {
        //Добавляем обьекты и замеряем время
        buildCollection(testArrayList);
        System.out.println("Время добавления обьектов в ArrayList составляет: " + totalTime);

        //Находим проходим итератором по коллекции
        collectionIterator(testArrayList);
        System.out.println("Время поиска обьектов через итератор в ArrayList составляет: " + totalTime);

        //Находим все элементы коллекции по индексу
        findByIndex(testArrayList);
        System.out.println("Время поиска обьектов по индексу в ArrayList составляет: " + totalTime);

        //удаляем обьекты через итератор
        deleteElements(testArrayList);
        System.out.println("Время удаления обьектов через итератор в ArrayList составляет: " + totalTime);

        //Удаляем все обьекты по индексу
        deleteByIndex(testArrayList);
        System.out.println("Время удаления обьектов по индексу в ArrayList составляет: " + totalTime);
        System.out.println();
    }

    //Тестируем HashSet
    private void hashSetTest() {
        //ДОбавляем обьекты и замеряем время
        buildCollection(testHashSet);
        System.out.println("Время добавления обьектов в HashSet составляет: " + totalTime);

        //Находим все элементы коллекции
        collectionIterator(testHashSet);
        System.out.println("Время поиска обьектов в HashSet составляет: " + totalTime);

        //Удаляем все элементы коллекции
        deleteElements(testHashSet);
        System.out.println("Время удаления обьектов в HashSet составляет: " + totalTime);
    }

    //////////////////////////////////////////////////////////////////////

    private void buildCollection(Collection<String> collection) {
        try {
            Scanner in = new Scanner(new FileInputStream("C:\\Users\\Admin\\Desktop\\Тест коллекций.txt"));
            System.out.println("Измеряем скорость работы " + collection.getClass() + ":");
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



