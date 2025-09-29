package 数据结构;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private LinkedHashMap<Integer, Integer> cacheMap = new LinkedHashMap<>();
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cacheMap.get(key);
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            cacheMap.put(key, value);
            makeRecently(key);
            return;
        }

        if (cacheMap.size() == capacity) {
            int removeKey = cacheMap.keySet().iterator().next();
            cacheMap.remove(removeKey);
        }

        cacheMap.put(key, value);
    }
    /** 将key变为最近使用 */
    private void makeRecently(int key) {
        Integer value = cacheMap.get(key);
        cacheMap.remove(key);
        cacheMap.put(key, value);
    }

}
