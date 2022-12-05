package GenericsLinkedList;

public class Integers {
    public static void main(String[] args) {

        LinkedList<Integer> numbers = new LinkedList<Integer>();
        numbers.addict(3);
        numbers.addict(4);
        numbers.addict(5);

        System.out.println("Size: " + numbers.getSize());
        for (int i = 0; i < numbers.getSize(); i++) {
            System.out.println(numbers.get(i).getValue());
        }
    }
}
