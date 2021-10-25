package addTask_HashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class MyHashMap<K, V> {
    private int size;
    private MyNode<K, V>[] table = new MyNode[10];

    public int getCap() {
        return table.length;
    }

    private int hash(K key) {
        return key != null ? Math.abs(key.hashCode() % table.length) : 0;
    }

    public int size() {
        return size;
    }

    private MyNode<K, V>[] resize() {
        if ((double) size / table.length > 0.75) {
            var oldTable = table;
            table = new MyNode[table.length * 2];
            size = 0;

            for (MyNode<K, V> node : oldTable) {
                while (node != null) {
                    put(node.key, node.value);
                    node = node.next;
                }
            }
        }

        return table;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        if (size != 0) {
            Arrays.fill(table, null);
            size = 0;
        }
    }

    public V put(K key, V value) {
        resize();

        var index = hash(key);

        if (table[index] == null) {
            table[index] = new MyNode<>(key, value);
            size++;
            return value;
        }

        var node = table[index];

        while (node != null) {

            if ((node.key == null && key == null) || (node.key != null && node.key.equals(key))) {
                V oldValue = node.getValue();
                node.setValue(value);
                return oldValue;
            }

            node = node.next;
        }

        table[index] = new MyNode<>(key, value, table[index]);

        size++;
        return value;
    }

    public V get(K key) {
        var index = hash(key);

        var node = table[index];

        while (node != null) {
            if ((node.key != null && node.getKey().equals(key)) || (node.key == null && key == null)) {
                return node.value;
            }
            node = node.next;
        }

        return null;
    }

    public Set<MyNode<K, V>> entrySet() {
        HashSet<MyNode<K, V>> set = new HashSet<>();
        if (size > 0) {
            for (MyNode<K, V> node : table) {
                while (node != null) {
                    set.add(node);
                    node = node.next;
                }
            }
        }
        return set;
    }

    public Set<K> keySet() {
        HashSet<K> set = new HashSet<>();
        if (size > 0) {
            for (MyNode<K, V> node : table) {
                while (node != null) {
                    set.add(node.getKey());
                    node = node.next;
                }
            }
        }
        return set;
    }

    public boolean containsKey(K key) {
        var node = table[hash(key)];

        if (size != 0 && node != null) {
            while (node != null) {
                if ((node.key == null && key == null) || (node.key != null && node.key.equals(key))) {
                    return true;
                }
                node = node.next;
            }
        }

        return false;
    }

    public boolean containsValue(V value) {
        if (size != 0) {
            for (var node : table) {
                while (node != null) {
                    if ((node.value == null && value == null) || (node.value != null && node.value.equals(value))) {
                        return true;
                    }
                    node = node.next;
                }
            }
        }

        return false;
    }

    public V remove(K key) {
        var index = hash(key);
        var node = table[index];

        if (size != 0 && node != null) {

            if ((node.key == null && key == null) || (node.key != null && node.key.equals(key))) {
                table[index] = node.next;
                size--;
                return node.value;
            }

            if (node.next != null) {

                while ((node.next.key != null && !node.next.key.equals(key)) || (node.next.key == null && key != null)) {
                    node = node.next;
                }

                var nodeToRemove = node.next;

                node.next = node.next.next;
                size--;
                return nodeToRemove.value;
            }
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
            while (node != null) {
                str.append(node.getKey()).append("=").append(node.getValue()).append(", ");
                node = node.next;
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
