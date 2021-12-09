package collections.myHashMap;

public interface MyMap<K, V> extends Iterable<V> {
    public int size();
    public boolean put(K key, V value);
    public V get(K key);
    public boolean remove(K key);
}
