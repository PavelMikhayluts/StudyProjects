package collections.myLinkedList;

public interface Linked<E> {
    int size();
    void addLast(E e);
    void addFirst(E e);
    E getElementByIndex(int counter);
    void deleteElement(Object o);
    boolean contains(E e);
}
