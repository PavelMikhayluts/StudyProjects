package collections.myLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * реализовать класс связного списка.
 * Он должен поддерживать методы добавления объекта в конец и начало списка,
 * добавление по индексу, доступ по индексу, удаление элемента, размер списка,
 * проверка вхождения элемента в список (contains).реализовать также итератор по списку
 */

public class MyLinkedList<E> implements Linked<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    int size;

    public MyLinkedList() {
        firstNode = new Node<>();
        lastNode = new Node<>();
        firstNode.setNextElement(lastNode);
        lastNode.setPreviousElement(firstNode);
    }

    private static class Node<E> {

        Node() {}

        private E value;//Значение которое мы храним в ноде
        private Node<E> nextElement;
        private Node<E> previousElement;

        // Генерируем геттеры и сеттеры
        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<E> getPreviousElement() {
            return previousElement;
        }

        public void setPreviousElement(Node<E> previousElement) {
            this.previousElement = previousElement;
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addLast(E e) {
        Node<E> prev = lastNode;
        prev.setValue(e);
        lastNode = new Node<>();
        lastNode.setPreviousElement(prev);
        prev.setNextElement(lastNode);
        size++; // Увеличиваем значение счетчика элементов
    }

    @Override
    public void addFirst(E e) {
        Node<E> next = firstNode;
        next.setValue(e);
        firstNode = new Node<>();
        firstNode.setNextElement(next);
        next.setPreviousElement(firstNode);
        size++;
    }

    @Override
    public E getElementByIndex(int counter) {
        /* Cоздаем ссылку target,которая указывает на первую ноду списка.
        Через цикл, вызывая и присваивая target каждый раз ссылку на cледующую ноду,
        доходим до нужной нам ноды и получаем от нее значение */
        Node<E> target = firstNode.getNextElement();
        for (int i = 0; i < counter; i++) {
            target = getNextNode(target);
        }
        return target.getValue();
    }

    private Node<E> getNextNode(Node<E> current) {
        return current.getNextElement();
    }

    public void deleteElement(Object o) {
        for (Node<E> x = firstNode; x != null; x = x.nextElement) {
            if (o.equals(x.value)) {
                E element = x.value;
                Node<E> next = x.nextElement;
                Node<E> prev = x.previousElement;
                if (prev == null) {
                    firstNode = next;
                } else {
                    prev.nextElement = next;
                    x.previousElement = null;
                }
                next.previousElement = prev;
                x.nextElement = null;
                x.value = null;
                size--;
            }

        }
    }

    @Override
    public boolean contains(E e) {
        for (Node<E> x = firstNode; x != null; x = x.nextElement) {
            if (e.equals(x.value)) {
                return true;
            }
        }
        return false;
    }
    public String toString() {
        StringBuilder s1 = new StringBuilder();
        Iterator it = iterator();
        while (it.hasNext()) {
            String s2 = String.valueOf(it.next()) + " ";
            s1 = s1.append(s2);
        }
        String string = s1.toString();
        return  string;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int count = 0;
            Node<E> currentNode;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                if (currentNode == null) {
                    currentNode = firstNode.getNextElement();
                } else {
                    currentNode = currentNode.getNextElement();
                }
                count++;
                return currentNode.getValue();
            }
        };
    }
}

