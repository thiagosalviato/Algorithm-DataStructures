package BinarySearch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] vector = new int[100];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = i * 2;
            System.out.println(vector[i]);
        }

        System.out.println("\nWhich value do you want to search?");
        Scanner reader = new Scanner(System.in);
        int wanted = reader.nextInt();

        int counter = 0;
        boolean found = false;
        int start = 0;
        int end = vector.length - 1;
        int half;
        while(start <= end){
            half = (int) ((start + end) / 2);
            counter++;
            if (vector[half] == wanted){
                found = true;
                break;
            }else if(vector[half] < wanted){
                start = half + 1;
            }else{
                end = half - 1;
            }
        }
        System.out.println("Test quantity: " + counter);
        if (found == true){
            System.out.println("Found.");
        }else{
            System.out.println("Not found.");
        }
    }
}
