package Vector;

public class Main {
    public static void main(String[] args) {

        int[] vector = new int[10];
        vector[0] = 3;
        vector[1] = 4;
        vector[2] = 8;
        vector[3] = 13;
        vector[4] = 51;
        vector[5] = 33;
        System.out.println("Printing...");
        System.out.println(vector[5]);

        System.out.println("\nPrinting...");
        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }
    }
}
