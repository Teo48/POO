package Task1;

public class MyHashMap<T, V> {
    private hashNode<T, V> [] nodes;

    public MyHashMap(int size) {
        nodes = new hashNode[size];
    }

    private int getIndex(T key){
        int hash = key.hashCode() % nodes.length;
        if(hash < 0){
            hash += nodes.length;
        }
        return hash;
    }

    public void put(T key, V data) {
        int hash = getIndex(key);

        for(hashNode<T, V> node = nodes[hash]; node != null; node = node.next){
            if((hash == node.hash) && key.equals(node.key)){
                node.data = data;
            }
        }

        hashNode<T, V> node = new hashNode<>(key, data, nodes[hash], hash);
        nodes[hash] = node;
    }

    public V get(T key) {
        int hash = getIndex(key);

        for(hashNode<T, V> node = nodes[hash]; node != null; node = node.next){
            if(key.equals(node.key))
                return node.data;
        }

        return null;
    }

    static class hashNode<T,V> {
        final T key;
        V data;
        hashNode<T, V> next;
        final int hash;

        public hashNode(T k, V v, hashNode<T, V> n, int h) {
            key = k;
            data = v;
            next = n;
            hash = h;
        }
    }


}


