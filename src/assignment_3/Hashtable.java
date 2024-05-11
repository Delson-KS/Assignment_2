package assignment_3;

public class Hashtable<K,V> {
    private HashNode<K , V>[] buckets;
    private int M = 13;
    private Double loadFactor = 0.83;
    private int size = 0;

    public Hashtable(){
        this.buckets = new HashNode[M];
    }

    public Hashtable(int initialCapacity){
        this.M = (int) (initialCapacity * loadFactor);
        this.buckets = new HashNode[M];
    }

    public int getM() {
        return M;
    }

    public int countElements(int index){
        int count = 0;
        HashNode<K, V> temp = buckets[index];
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    private int hash(K key) {
        int index = (key.hashCode() & 0x7fffffff) % M;
        return index ;
    }

    private void increaseCapacity() {
        M = M * 2;
        HashNode<K , V>[] temp = buckets;
        buckets = new HashNode[M];
        for(int i = 0 ; i < temp.length ; i++) {
            if(temp[i] != null) {
                HashNode<K , V> node = temp[i];
                while(node != null) {
                    rehashPut(node.key , node.value);
                    node = node.next;
                }
            }
        }
    }

    public void put(K key , V value) {
        if((double) size / M > loadFactor) {
            increaseCapacity();
        }
        int index = hash(key);
        HashNode<K , V> newNode = new HashNode<>(key , value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }
    public void rehashPut(K key , V value) {
        int index = hash(key);
        HashNode<K , V> newNode = new HashNode<>(key , value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> node = buckets[index];
        while(node != null) {
            if(node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> temp = buckets[index];
        HashNode<K, V> prev = null;
        while(temp != null) {
            if(temp.key.equals(key)) {
                if(prev == null) {
                    buckets[index] = temp.next;
                }
                else {
                    prev.next = temp.next;
                }
                size--;
                return temp.value;
            }
            prev = temp;
            temp = temp.next;
        }
        return null;
    }

    public boolean contains(K key) {
        return get(key) != null ;
    }

    public K getKey(V value) {
        for(int i = 0 ; i < M ; i++) {
            HashNode<K, V> node = buckets[i];
            while(node != null) {
                if(node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }

    public int size(){
        return size;
    }

    public class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " : " + value + "}";
        }
    }
}
