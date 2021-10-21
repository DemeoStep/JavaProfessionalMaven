package addTask_HashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class MyHashMap<K, V> {
    private int size;
    private int modCount;
    private final MyNode<K, V>[] table = new MyNode[10];

    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        if (size != 0) {
            modCount++;
            Arrays.fill(table, null);
            size = 0;
        }
    }

    public V put(K key, V value) {
        var index = hash(key);

        if (table[index] == null) {
            table[index] = new MyNode<>(key, value);
            size++;
            modCount++;
            return value;
        }

        var node = table[index];

        while (node != null) {
            if (node.getKey().equals(key)) {
                V oldValue = node.getValue();
                node.setValue(value);
                return oldValue;
            }

            node = node.next;
        }

        table[index] = new MyNode<>(key, value, table[index]);

        size++;
        modCount++;
        return value;
    }

    public V get(K key) {
        if (table[hash(key)] != null) {
            var node = table[hash(key)];
            while (node != null) {
                if (node.key.equals(key)) {
                    return node.value;
                }
                node = node.next;
            }
        }

        return null;
    }

    public Set<MyNode<K, V>> entrySet() {
        HashSet<MyNode<K, V>> set = new HashSet<>();
        if (size > 0) {
            for (MyNode<K, V> node : table) {
                if (node != null) {
                    while (node != null) {
                        set.add(node);
                        node = node.next;
                    }
                }
            }
        }
        return set;
    }

    public Set<K> keySet() {
        HashSet<K> set = new HashSet<>();
        if (size > 0) {
            for (MyNode<K, V> node : table) {
                if (node != null) {
                    while (node != null) {
                        set.add(node.getKey());
                        node = node.next;
                    }
                }
            }
        }
        return set;
    }

    public boolean containsKey(K key) {
        return keySet().contains(key);
    }

    public boolean containsValue(V value) {
        return entrySet().stream().anyMatch(e -> e.getValue().equals(value));
    }

    public V remove(K key) {
        if (size != 0 && containsKey(key)) {
            modCount++;
            size--;

            var index = hash(key);
            var node = table[index];
            var nodeToRemove = get(key);

            if (node.key.equals(key)) {
                table[index] = node.next;
                return nodeToRemove;
            }

            while (!node.next.key.equals(key)) {
                node = node.next;
            }

            node.next = node.next.next;
            return nodeToRemove;
        }

        return null;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "{}";
        }

        StringBuilder str = new StringBuilder("{");

        for (MyNode<K, V> node : table) {
            if (node != null) {
                while (node != null) {
                    str.append(node.getKey()).append("=").append(node.getValue()).append(", ");
                    node = node.next;
                }
            }
        }
        
        str = new StringBuilder(str.substring(0, str.length() - 2));
        str.append("}");

        return str.toString();
    }

    private static class MyNode<K, V> implements Entry<K, V> {
        private final K key;
        private V value;
        private MyNode<K, V> next;

        public MyNode(K key, V value, MyNode<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public MyNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V v) {
            value = v;
            return value;
        }

        @Override
        public String toString() {
            return "MyNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
