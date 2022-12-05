package Sort;

public class Recursion {
    public static void main(String[] args) {
        int[] vector = new int[10];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * vector.length);
        }

        System.out.println("Vector");
        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }

        System.out.println("Sum: ");
        System.out.println(sum(0,0,vector));
    }

    private static int sum(int sum,int position,int[] vector){
        if(position < vector.length) {
            sum = sum + vector[position];
            return sum(sum,position + 1, vector);
        }else {
            return sum;
        }
    }
}
