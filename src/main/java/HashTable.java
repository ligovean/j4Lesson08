public interface HashTable<K, V> {

    boolean put(K key, V value);

    V get(K key);

    boolean contains(K key);

    V remove(K key);

    void display();


    interface Entry<K, V> {
        K getKey();
        V getValue();

        void setKey(K key);
        void setValue(V value);
    }

    int size();
    boolean isEmpty();
    boolean isFull();
}
