package top.mphy.algo.basic.core.hashmap;

/**
 * HashSet based on HashMap
 *
 * @author MurphyChen
 * @since 2025/4/1 23:01
 */
public class ArrayListHashSet<E> implements ISet<E> {

    private static final Object PRESENT = new Object();

    private final ArrayListHashMap<E, Object> hashMap;

    public ArrayListHashSet() {
        hashMap = new ArrayListHashMap<>();
    }

    @Override
    public int size() {
        return hashMap.keySet().size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(E e) {
        check(e);
        hashMap.put(e, PRESENT);
    }

    @Override
    public void remove(E e) {
        check(e);
        hashMap.remove(e);
    }

    @Override
    public void clear() {
        hashMap.clear();
    }

    private void check(E e) {
        if (!(e instanceof Integer || e instanceof String || e instanceof Boolean)) {
            throw new IllegalArgumentException("Element type must be Integer、String or Boolean");
        }
    }
}
