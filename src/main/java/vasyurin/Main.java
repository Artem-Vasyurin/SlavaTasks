package main.java.vasyurin;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        HashMap myHash = new HashMap(4);

        myHash.put("A", 1);
        myHash.put("B", 2);
        System.out.println(myHash.getSize());
        myHash.put("C", 3);
        myHash.put("D", 4);
        System.out.println(myHash.get("D"));
        System.out.println(myHash.getSize());
        myHash.remove("D");
        myHash.remove("A");
        myHash.put("D", 4);
        myHash.put("й", 4);
        myHash.put("5", 452);
        myHash.put("553", 4);
        System.out.println(myHash.getSize());
        System.out.println(myHash.get("5"));







    }
}