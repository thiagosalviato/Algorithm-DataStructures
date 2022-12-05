package LinkedList.Comparation;

import GenericsLinkedList.LinkedList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> vector = new ArrayList<Integer>();

        int limit = 10000000;
        long initialTime = System.currentTimeMillis();
        long finalTime;
        for (int i = 0; i < limit; i++) {
            vector.add(i);
        }
        finalTime = System.currentTimeMillis();
        System.out.println("Addict "+limit+" elements in vector");
        System.out.println(finalTime - initialTime);

        initialTime = System.currentTimeMillis();
        for (int i = 0; i < limit; i++) {
            list.addict(i);
        }
        finalTime = System.currentTimeMillis();
        System.out.println("\n\nAddict "+limit+" elements in list");
        System.out.println(finalTime - initialTime);

        initialTime = System.currentTimeMillis();
        for (int i = 0; i < vector.size(); i++) {
            vector.get(i);
        }
        finalTime = System.currentTimeMillis();
        System.out.println("\n\nRead "+limit+" elements in vector");
        System.out.println(finalTime - initialTime);

        initialTime = System.currentTimeMillis();
        for (int i = 0; i < list.getSize(); i++) {
            list.get(i);
        }
        finalTime = System.currentTimeMillis();
        System.out.println("\n\nRead "+limit+" elements in list");
        System.out.println(finalTime - initialTime);
    }
}
