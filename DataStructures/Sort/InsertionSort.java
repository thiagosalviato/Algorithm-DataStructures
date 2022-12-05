package Sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] vector = new int[10];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * vector.length);
        }

        int aux,j;
        for (int i = 0; i < vector.length; i++) {
            aux = vector[i];
            j = i - 1;
            while(j > 0 && vector[j] > aux){
                vector[j+1] = vector[j];
                j--;
            }
            vector[j + 1] = aux;
        }

        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }
    }
}
