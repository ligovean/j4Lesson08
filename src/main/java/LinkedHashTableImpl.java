import java.util.LinkedList;

public class LinkedHashTableImpl<K,V> implements HashTable<K,V>{


    private static class Node<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

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
    }

    private LinkedList<Node<K, V>>[] data;
    private int size;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public LinkedHashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new LinkedList[maxSize];
        init(data);
    }

    private void init(LinkedList<Node<K,V>>[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList<>();
        }
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    public boolean put(K key, V value) {
        int index = hashFunc(key);
        Node<K, V> node = getNodeOrNull(key);
        if (node != null) {
            node.setValue(value);
        }
        else {
            data[index].addLast(new Node<>(key, value));
            size++;
        }
        return true;
    }

    public V get(K key) {
        Node<K, V> node = getNodeOrNull(key);
        if (node != null) return node.getValue();
        return null;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }


    private Node<K, V> getNodeOrNull(K key) {
        int index = hashFunc(key);
        for (Node<K, V> node : data[index]) {
            if (node.getKey().equals(key)) {
                return node;
            }
        }
        return null;
    }


    public V remove(K key) {
        Node<K, V> node = getNodeOrNull(key);
        if (node != null) {
            data[hashFunc(key)].remove(node);
            size--;
            return node.getValue();
        }
        return null;
    }

    public void display() {
        System.out.println("--------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(i + " = " + data[i]);
            System.out.println();
        }
        System.out.println("--------------");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }
}
