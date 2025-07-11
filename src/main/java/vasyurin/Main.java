package main.java.vasyurin;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        HashMap myHash = new HashMap<>(16);
        for (int i = 0; i < myHash.size; i++) {
            myHash.put(i, "Значка" + i);
        }
        for (int i = 0; i < myHash.size; i++) {
            System.out.println(myHash.get(i));
        }

        java.util.HashMap hashMap = new java.util.HashMap(15);

        IntStream.rangeClosed(0, 15).forEach(i -> {
            hashMap.put(i, "Значение" + i);
        });

        hashMap.forEach((k, v) -> {
            System.out.println(k + "->" + v);
        });


    }
}