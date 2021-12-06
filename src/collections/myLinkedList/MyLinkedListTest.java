package collections.myLinkedList;

import java.util.Iterator;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addLast("String");
        list.addLast("ABC");
        list.addFirst("123");
        System.out.println(list);
        System.out.println(list.size);
        System.out.println(list.getElementByIndex(0));
        System.out.println(list);
        System.out.println(list.getElementByIndex(1));
        System.out.println(list);
        list.deleteElement("String");
        System.out.println(list);
        System.out.println(list.contains("123"));
        Iterator<String> it = list.iterator();
        System.out.print("Работает итератор: ");
        while (it.hasNext()) {
            System.out.print(" ");
            System.out.print(it.next());
        }

    }
}
