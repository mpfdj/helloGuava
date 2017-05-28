package generics.com.oracle.docs;

public class GenericType {

    private interface Pair<K, V> {  // Generic types are SCOPED to interface
        K getKey();
        V getValue();
    }

    private class OrderedPair<K, V> implements Pair<K, V> {  // Implementing a generic interface
        private K key;
        private V value;

        public OrderedPair(K key, V value) {
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

    public static void main(String args[]) {
        GenericType outer = new GenericType();
        OrderedPair<String, Integer> p1 = outer.new OrderedPair<>("Even", 2);
        OrderedPair<String, String>  p2 = outer.new OrderedPair<>("Hello", "World");
    }
}