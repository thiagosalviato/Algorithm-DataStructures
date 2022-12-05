package Queue;

public class Main {
    public static void main(String[] args) {

        Queue queue = new Queue();

        queue.addict("Thiago");
        queue.addict("Anna");
        queue.addict("Robert");
        System.out.println("First in line: " + queue.get());
    }
}
