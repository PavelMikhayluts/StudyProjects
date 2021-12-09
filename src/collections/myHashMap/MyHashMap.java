package collections.myHashMap;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * реализовать класс MyHashMap<K, V> - структуру данных,
 * которая хранит пары ключ-значение.
 * Реализация должна примерно соответствовать понятию хеш-таблицы в Java:
 * набор корзин (bucket'ов), в каждой из которых хранится набор элементов,
 * имеющих одинаковые хеш-коды.
 * Реализовать методы добавления, удаления, поиска элемента в хеш-таблице.
 * Продумать, как будет изменяться хеш-таблица при добавлении большого количества элементов.
 * При наличии времени реализовать итератор по хеш-таблице
 */

public class MyHashMap<K, V> implements MyMap<K, V> {

    public List<Node<K, V>>[] hashTable;
    private int size = 0;
    private float mapLimit;

    public MyHashMap() {
        hashTable = new LinkedList[16];
        mapLimit = hashTable.length * 0.75f;
    }

    private class Node<K, V> {

        private K key;
        private V value;

        public K getKey() {
            return key;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }

        public int hashCode() {
            return ((key.hashCode() * 37) & 0x7FFFFFFF) % hashTable.length;
        }

        public boolean equals(Object obj) {
            if (this == obj) { return true; }
            if (obj instanceof  Node) {
                Node<K, V> node = (Node) obj;
                return (Objects.equals(key, node.getKey()) &&
                        Objects.equals(value, node.getValue()));
            }
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean put(K key, V value) {
        if (size + 1 >= mapLimit ) {
            mapLimit *= 2;
            mapDoubling();
        }
        List<Node<K, V>> nodeList = new LinkedList<>();
        Node<K, V> newNode = new Node<>();
        newNode.setKey(key);
        newNode.setValue(value);
        int index = newNode.hashCode();
        nodeList.add(newNode);

        if (hashTable[index] == null) {
            return simpleAdd(index, nodeList);
        }
        List<Node<K, V>> list = hashTable[index];
        for (Node<K, V> node : list) {
            if (keyExistsButValueNew(node, newNode, node.getValue()) ||
                    collisionProcessing(node, newNode, list)) {
                return true;
            }
        }
        return false;
    }
    private boolean simpleAdd(int index, List<Node<K, V>> nodeList) {
        hashTable[index] = nodeList;
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        Node<K, V> newNode = new Node<>();
        newNode.setKey(key);
        int index = newNode.hashCode();
        List<Node<K, V>> list = hashTable[index];
        for (Node<K, V> node : list) {
            if (newNode.key.equals(node.key)) {
               return node.value;
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        Node<K, V> newNode = new Node<>();
        newNode.setKey(key);
        int index = newNode.hashCode();
        if (hashTable[index] == null) { return false; }
        if (hashTable[index].size() == 1) {
            hashTable[index].remove(0);
            return true;
        }
        List<Node<K, V>> list = hashTable[index];
        for (Node<K, V> node : list) {
            if (key.equals(node.getKey())){
                list.remove(node);
                return true;
            }
        }
        return false;
    }

    private void mapDoubling() {
         List<Node<K, V>>[] oldHashTable = hashTable;
         hashTable = new LinkedList[oldHashTable.length * 2];
         size = 0;
         for (List<Node<K, V>> list : oldHashTable) {
             if (list != null) {
                 for(Node<K, V>node : list)
                 put(node.key, node.value);
             }
         }
        System.out.println("Создана новая хэш таблица!");
    }

    private boolean keyExistsButValueNew(
            Node<K, V> node,
            Node<K, V> newNode,
            V value) {
        if (newNode.getKey().equals(node.getKey()) &&
                !newNode.getValue().equals(node.getValue())) {
            node.setValue(value);
            return true;
        }
        return false;
    }
    private boolean collisionProcessing (
            Node<K, V> node,
            Node<K, V> newNode,
            List<Node<K, V>> list) {
        System.out.println("Коллизия в по индексу: " + newNode.hashCode() + " Ключ: " + newNode.getKey());
        if (newNode.hashCode() == node.hashCode() &&
                !Objects.equals(newNode.key, node.key) &&
                !Objects.equals(newNode.value, node.value)) {
                list.add(newNode);
                size++;
                return true;
        }
        return false;
    }

    @NotNull
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int arrayCounter = 0;
            int nodesCounter = 0;
            Iterator<Node<K, V>> nodeIterator;

            @Override
            public boolean hasNext() {
                if (nodesCounter == size) {
                    return false;
                }
                if (nodeIterator == null ||  !nodeIterator.hasNext()) {
                    if (moveToNextBucket()) {
                        nodeIterator = hashTable[arrayCounter].iterator();
                    } else { return false;}
                }
                return nodeIterator.hasNext();
            }
            private boolean moveToNextBucket() {
                arrayCounter++;
                while (arrayCounter < hashTable.length && hashTable[arrayCounter] == null) {
                    arrayCounter++;
                }
                return arrayCounter < hashTable.length && hashTable[arrayCounter] != null;
            }

            @Override
            public V next() {
                nodesCounter++;
                return nodeIterator.next().getValue();
            }
        };
    }
}
