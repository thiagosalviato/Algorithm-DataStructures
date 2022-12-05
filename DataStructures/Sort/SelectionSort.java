package Sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] vector = new int[10];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * vector.length);
        }

        int minor_position, aux;
        for (int i = 0; i < vector.length; i++) {
            minor_position = i;
            for (int j = 0; j < vector.length; j++) {
                if(vector[j] < vector[minor_position]){
                    minor_position = j;
                }
            }
            aux = vector[minor_position];
            vector[minor_position] = vector[i];
            vector[i] = aux;
        }

        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }
    }
}
