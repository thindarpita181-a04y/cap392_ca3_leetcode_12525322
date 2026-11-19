import java.util.LinkedList;
import java.util.List;

class MyHashSet {
    // Use a prime number of buckets to minimize hash collisions
    private static final int BUCKET_COUNT = 769;
    private List<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new LinkedList[BUCKET_COUNT];
        for (int i = 0; i < BUCKET_COUNT; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    // Hash function maps key to a valid bucket index
    private int hash(int key) {
        return key % BUCKET_COUNT;
    }
    
    public void add(int key) {
        int index = hash(key);
        List<Integer> bucket = buckets[index];
        
        // Only add if the key is not already present
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        List<Integer> bucket = buckets[index];
        
        // Cast to Integer so List.remove(Object) is called instead of remove(int index)
        bucket.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }
}
