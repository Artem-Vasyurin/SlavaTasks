package vasyurin;

import java.util.ArrayList;

public class HashMap<Key, Value> {


    public static class Node<Key, Value> {
        Key key;
        Value value;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;

    public int getSize() {
        return size;
    }

    ArrayList<Node<Key, Value>>[] arrlist;

    HashMap(int size) {
        this.size = size;
        arrlist = new ArrayList[size];
        for (int i = 0; i < arrlist.length; i++) {
            arrlist[i] = new ArrayList<>();
        }
    }


    public void put(Key key, Value value) {

        int hash = key.hashCode();
        arrlist[hash % size].add(new Node<>(key, value));

        Resize();


    }

    private void Resize() {
        int sum = 0;
        double val = (int) (size * 0.75);
        for (ArrayList<Node<Key, Value>> x : arrlist) {
            sum += x.size();
        }
        if (sum >= val) {

            int newSize = size * 2;
            ArrayList<Node<Key, Value>>[] arrlist2 = new ArrayList[newSize];

            for (int i = 0; i < arrlist2.length; i++) {
                arrlist2[i] = new ArrayList<>();
            }
            for (ArrayList<Node<Key, Value>> y : arrlist) {
                for (Node<Key, Value> z : y) {
                    int newHash = z.key.hashCode();
                    arrlist2[newHash % newSize].add(z);
                }
            }
            size = newSize;
            arrlist = arrlist2;
        }
    }

    public Value get(Key key) {
        try {
            int hash = key.hashCode();
            Value val = null;
            for (Node<Key, Value> x : arrlist[hash % size]) {
                if (x.key.equals(key)) {
                    val = x.value;
                }
            }
            return val;

        } catch (NullPointerException e) {
            System.out.println("Значение не найденно " + e);
            throw e;
        }

    }

    public void remove(Key key) {
        int hash = key.hashCode();
        for (Node<Key, Value> x : arrlist[hash % size]) {

            if (x.key.equals(key)) {
                arrlist[hash % size].remove(x);
                break;
            }
        }
    }
}
