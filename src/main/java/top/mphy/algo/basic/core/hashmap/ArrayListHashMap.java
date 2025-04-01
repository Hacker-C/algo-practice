package top.mphy.algo.basic.core.hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class ArrayListHashMap<K, V> {

    private static final int NOT_FOUND = -1;

    private static final int MAX_SIZE = 100;

    /**
     * 键值对节点 接口定义
     * @param <K>
     * @param <V>
     */
    public interface Entry<K, V> {
        K getKey();
        V getValue();
    }


    /**
     * 键值对节点实现
     * @param <K>
     * @param <V>
     */
    private static class Node<K, V> implements ArrayListHashMap.Entry<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
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
    }

    /**
     * 桶列表，一个桶存放一个结果
     */
    private List<Node<K, V>> buckets;

    public ArrayListHashMap() {
        buckets = new ArrayList<>(MAX_SIZE);
        for (int i = 0; i < MAX_SIZE + 1; i++) {
            buckets.add(null);
        }
    }

    /**
     * 哈希函数：int
     * @param key
     * @return
     */
    private int hashFunc(Integer key) {
        return key % MAX_SIZE;
    }

    /**
     * 哈希函数：String
     * @param key
     * @return
     */
    private int hashFunc(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (31 * hash + key.charAt(i)) % MAX_SIZE; // 使用 31 作为乘数，取模 MAX_SIZE
        }
        return hash;
    }

    /**
     * 哈希函数：Boolean
     * @param key
     * @return
     */
    private int hashFunc(Boolean key) {
        if (key == null) {
            return MAX_SIZE;
        }
        if (key) {
            return 1;
        }
        return 0;
    }

    /**
     * 获取 hash 值
     * @param key
     * @return
     */
    private int getHash(K key) {
        if (key == null) {
            return MAX_SIZE;
        }
        if (key instanceof Integer) {
            return hashFunc((Integer) key);
        }
        if (key instanceof String) {
            return hashFunc((String) key);
        }
        if (key instanceof Boolean) {
            return hashFunc((Boolean) key);
        }
        return NOT_FOUND;
    }

    public V get(K key) {
        int index = getHash(key);
        if (index == NOT_FOUND) return null;
        Node<K, V> node = buckets.get(index);
        if (node == null) return null;
        return node.value;
    }

    public void put(K key, V value) {
        int index = getHash(key);
        if (index == NOT_FOUND) return;
        buckets.set(index, new Node<>(key, value));
    }

    public void remove(K key) {
        int index = getHash(key);
        if (index == NOT_FOUND) return;
        buckets.set(index, null);
    }

    public void clear() {
        for (int i = 0; i < buckets.size(); i++) {
            buckets.set(i, null);
        }
    }

    /**
     * 获取所有键
     * @return
     */
    public List<K> keySet() {
        List<K> list = new ArrayList<>();
        for (Node<K, V> bucket : buckets) {
            if (bucket != null) {
                list.add(bucket.key);
            }
        }
        return list;
    }

    /**
     * 获取所有值
     * @return
     */
    public List<V> valueSet() {
        List<V> list = new ArrayList<>();
        for (Node<K, V> bucket : buckets) {
            if (bucket != null) {
                list.add(bucket.value);
            }
        }
        return list;
    }

    /**
     * 获取所有键值对
     * @return
     */
    public List<ArrayListHashMap.Entry<K, V>> entrySet() {
        List<ArrayListHashMap.Entry<K, V>> list = new ArrayList<>();
        for (ArrayListHashMap.Entry<K, V> bucket : buckets) {
            if (bucket != null) {
                list.add(bucket);
            }
        }
        return list;
    }

    /**
     * 遍历接口
     * @param consumer
     */
    public void forEach(BiConsumer<K, V> consumer) {
        for (Node<K, V> node : buckets) {
            if (node != null) {
                consumer.accept(node.key, node.value);
            }
        }
    }
}
