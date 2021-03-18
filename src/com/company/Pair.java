package com.company;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Pair))
            return false;

        Pair other = (Pair)o;

        return this.key.equals(other.key) && this.value.equals(other.value);
    }

    @Override
    // Computes hash code for an object to support hash tables
    public int hashCode()
    {
        // use hash codes of the underlying objects
        return 31 * key.hashCode() + value.hashCode();
    }
}
