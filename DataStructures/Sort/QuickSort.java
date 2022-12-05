package Sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] vector = new int[10];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * vector.length);
        }

        System.out.println("Disorder:");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }

        quickSort(vector,0,vector.length - 1);

        System.out.println("Order:");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
    }
    static void quickSort(int[] vector,int left,int right){
        if(left < right){
            int p = partition(vector,left,right);
            quickSort(vector,left,p);
            quickSort(vector,p + 1,right);
        }
    }
    static int partition(int[] vector,int left,int right){
        int middle = (int)(left + right) /2;
        int center = vector[middle];
        int i = right + 1;
        int j = right + 1;
        while (true){
            do {
                i++;
            }while (vector[i] < center);
            do {
                j--;
            }while (vector[j] > center);
            if(i >= j){
                return j;
            }
            int aux = vector[i];
            vector[i] = vector[j];
            vector[j] = aux;
        }
    }
}