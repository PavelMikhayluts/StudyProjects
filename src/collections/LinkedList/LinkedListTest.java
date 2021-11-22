package collections.LinkedList;

import java.util.*;

/**
 * В этой программе демонстрируются операции со связанными списками
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

        //Обьединяем слова из связных списков a и b
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) { aIter.next(); }
            aIter.add(bIter.next());
        }

        System.out.println(a);

        //Удаляем каждое второе слово из связанного списка b
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next(); //Пропустить один элемент
            if (bIter.hasNext()){
                bIter.next();//пройти следущий элемент
                bIter.remove();//удалить этот элемент
            }
        }

        System.out.println(b);

        //Групповая операция удаления из свзного списка а всех элементов из списка b
        a.removeAll(b);

        System.out.println(a);
    }
}
