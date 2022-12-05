package LinkedList;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.addict("Thiago");
        list.addict("Robert");
        list.addict("Michael");
        list.addict("Wilt");
        System.out.println("Size: " + list.getSize());

        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i).getValue());
        }

        list.remove("Michael");
        System.out.println("Removed Michael");

        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i).getValue());
        }
    }
}
