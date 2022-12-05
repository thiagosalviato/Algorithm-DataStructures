package LinearSearch;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {

        int[] vector = new int[8];

        for (int i = 0; i < vector.length; i++) {
               vector[i] = (int) (Math.random() * 10);
            System.out.println(vector[i]);
        }
        boolean found = false;

        while (found == false){
            System.out.println("\nWhich value do you want to search?");
            Scanner reader = new Scanner(System.in);
            int wanted = reader.nextInt();

            for (int i = 0; i < vector.length; i++) {
                if(vector[i] == wanted){
                    found = true;
                    break;
                }
            }
            if(found){
                System.out.println("Found.");
            } else {
                System.out.println("Not found.");
            }
        }



    }
}
