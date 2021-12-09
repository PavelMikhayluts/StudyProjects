package collections.myHashMap;

import java.util.Iterator;

public class MyHashMapTest {

    public static void main(String[] args) {

        MyHashMap<String, Integer> map = new MyHashMap<String, Integer>();
        map.put("Иван", 2);
        System.out.println("Значение по ключу: " + map.get("Иван"));
        System.out.println(" 1----------------------");
        map.put("Василий", 3);
        System.out.println("Значение по ключу: " + map.get("Василий"));
        System.out.println(" 2----------------------");
        map.put("Виктор", 1);
        System.out.println("Значение по ключу: " + map.get("Виктор"));
        System.out.println(" 3-----------------------");
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 2);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("11", 11);
        map.put("12", 12);
        map.put("13", 13);
        map.put("14",14);
        map.put("15",15);
        map.put("16",16);
        map.put("17",17);
        System.out.println("----------------------");
        System.out.println("Количество элементов таблице: " + map.size());
        System.out.println("Значение по ключу: " + map.get("17"));
        System.out.println("Содержание списка по индексу 3: " + map.hashTable[3]);
        System.out.println("Значение по ключу: " + map.get("7"));
        System.out.println("Значение по ключу: " + map.get("Василий"));
        System.out.println("Значение по ключу: " + map.get("Иван"));
        System.out.println("----------------------");
        Iterator<Integer> iterator = map.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }







    }
}
