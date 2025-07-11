package main.java.vasyurin;

public class HashMap<Key, Value> {


    public static class Node<Key, Value> {
        Key key;
        Value value;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;
    Node<Key, Value>[] table;

    HashMap(int size) {
        this.size = size;
        table = new Node[size];
    }


    public void put(Key key, Value value) {

        int hash = key.hashCode();
        table[hash % size] = new Node<>(key, value);


    }

    public Value get(Key key) {
        try {
            int hash = key.hashCode();
            return table[hash % size].value;

        } catch (NullPointerException e) {
            System.out.println("Значение не найденно " + e);
            throw e;
        }


    }

    public void remove(Key key) {
        table[key.hashCode() % size] = null;
    }

}
