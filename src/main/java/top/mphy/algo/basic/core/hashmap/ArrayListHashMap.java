package top.mphy.algo.basic.core.hashmap;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class ArrayListHashMap<K, V> {

    private static final int NOT_FOUND = -1;
    
    
    private static final int MAX_SIZE = 100;


    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 列表实现哈希表
     */
    private List<Pair<K, V>> buckets;

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
        if (key == null) return MAX_SIZE;
        return key % MAX_SIZE;
    }

    /**
     * 哈希函数：String
     * @param key
     * @return
     */
    private int hashFunc(String key) {
        if (key == null) {
            return MAX_SIZE; // 如果字符串为 null，返回 MAX_SIZE
        }
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (31 * hash + key.charAt(i)) % MAX_SIZE; // 使用 31 作为乘数，取模 MAX_SIZE
        }
        return hash;
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
        return NOT_FOUND;
    }

    public V get(K key) {
        int index = getHash(key);
        if (index == NOT_FOUND) return null;
        Pair<K, V> pair = buckets.get(index);
        if (pair == null) return null;
        return pair.value;
    }

    public void put(K key, V value) {
        int index = getHash(key);
        if (index == NOT_FOUND) return;
        buckets.set(index, new Pair<>(key, value));
    }

    public void remove(K key) throws OperationNotSupportedException {
        if (key instanceof Integer) {
            int index = getHash(key);
            if (index == NOT_FOUND) return;
            buckets.set(index, null);
            return;
        }
        throw new OperationNotSupportedException("only support int for key");
    }

    /**
     * 获取所有键
     * @return
     */
    public List<K> keySet() {
        List<K> list = new ArrayList<>();
        for (Pair<K, V> bucket : buckets) {
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
        for (Pair<K, V> bucket : buckets) {
            if (bucket != null) {
                list.add(bucket.value);
            }
        }
        return list;
    }

    /**
     * 遍历接口
     * @param consumer
     */
    public void forEach(BiConsumer<K, V> consumer) {
        for (Pair<K, V> pair : buckets) {
            if (pair != null) {
                consumer.accept(pair.key, pair.value);
            }
        }
    }
}
