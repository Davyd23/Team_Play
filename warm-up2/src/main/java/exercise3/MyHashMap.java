package exercise3;

import java.util.*;

/**
 * Exercise 3. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 *
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;

    private int capacity;

    public MyHashMap(int capacity) {
        this.capacity = capacity;

        // Initialize buckets list
        buckets = new ArrayList<LinkedList<MyEntry>>();
        for(Integer i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<MyEntry>());
        }
    }

    public String get(String key) {
        // TODO
        int bucketIndex = key.hashCode() % this.capacity;
        if (bucketIndex < 0)
            bucketIndex *= -1;
        LinkedList<MyEntry> bucket = buckets.get(bucketIndex);
        for (MyEntry entry : bucket)
            if (entry.getKey().equals(key))
                return entry.getValue();
        return null;
    }

    public void put(String key, String value) {
        // TODO
        int bucketIndex = key.hashCode() % this.capacity;
        if (bucketIndex < 0)
            bucketIndex *= -1;
        LinkedList<MyEntry> bucket = buckets.get(bucketIndex);
        for (MyEntry entry : bucket)
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        bucket.add(new MyEntry(key, value));
    }

    public Set<String> keySet() {
        // TODO
        Set<String> keySet = new HashSet<String>();
        for (LinkedList<MyEntry> bucket : buckets)
            for (MyEntry entry : bucket)
                keySet.add(entry.getKey());
        return keySet;
    }

    public Collection<String> values() {
        // TODO
        return null;
    }

    public String remove(String key) {
        // TODO Returns the value associated with the key removed from the map or null if the key wasn't found
        return null;
    }

    public boolean containsKey(String key) {
        // TODO
        return false;
    }

    public boolean containsValue(String value) {
        // TODO
        return false;
    }

    public int size() {
        // TODO Return the number of the Entry objects stored in all the buckets
        return 0;
    }

    public void clear() {
        // TODO Remove all the Entry objects from the bucket list
    }

    public Set<MyEntry> entrySet() {
        // TODO Return a Set containing all the Entry objects
        Set<MyEntry> entrySet = new HashSet<MyEntry>();
        for (LinkedList<MyEntry> bucket : buckets)
            for (MyEntry entry : bucket)
                entrySet.add(entry);
        return entrySet;
    }

    public boolean isEmpty() {
        // TODO
        return false;
    }

    public static class MyEntry {
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
