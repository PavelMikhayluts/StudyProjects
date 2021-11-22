package collections.zadanie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Реализовать итератор (Iterator) по массиву (можно двумерному или однмоерному).
 */

public class ArrayIterator implements Iterator {

    private String[] stringArray;
    private List<String> stringList;
    private int count = 0;

    public static void main(String[] args) {
        ArrayIterator ai = new ArrayIterator();
        ai.iterate();
    }

    public void iterate() {
        stringList = Arrays.asList(stringArray);
        Iterator<String> iter = stringList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    @Override
    public boolean hasNext() {
        return count < stringArray.length;
    }

    @Override
    public Object next() {
        return stringArray[count++];
    }
}
