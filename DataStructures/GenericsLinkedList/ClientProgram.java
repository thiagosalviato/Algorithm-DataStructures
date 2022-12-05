package GenericsLinkedList;

public class ClientProgram {
    public static void main(String[] args) {

        LinkedList<Client> clients = new LinkedList<Client>();
        clients.addict(new Client("1234","Thiago"));
        clients.addict(new Client("1235","Anna"));
        clients.addict(new Client("1236","Robert"));

        System.out.println("Size: " + clients.getSize());
        for (int i = 0; i < clients.getSize(); i++) {
            System.out.println(clients.get(i).getValue());
        }
    }
}
