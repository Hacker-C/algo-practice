package top.mphy.algo.basic.core.hashmap;

import java.util.Collection;

/**
 * Set 接口
 *
 * @author MurphyChen
 * @since 2025/4/1 23:05
 */
public interface ISet<E> {
        int size();

        boolean isEmpty();

        void add(E e);

        void remove(E e);

        void clear();
}
