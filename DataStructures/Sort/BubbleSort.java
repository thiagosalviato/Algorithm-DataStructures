package Sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] vector = new int[100];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * vector.length);
        }

        long start = System.currentTimeMillis();
        long end;
        int aux;
        for (int i = 0; i < vector.length; i++) {
            for (int j = i + 1; j < vector.length; j++) {
                if(vector[i] > vector[j]){
                    aux = vector[j];
                    vector[j] = vector[i];
                    vector[i] = aux;
                }
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Time: " + (end-start));

        System.out.println("\n");
        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }
    }
}
