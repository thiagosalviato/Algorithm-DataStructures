package GenericsLinkedList;

public class Client {

    private String register;
    private String name;

    public Client(String newRegister, String newName){
        this.register = newRegister;
        this.name = newName;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client[" +
                "register='" + register + '\'' +
                ", name='" + name + '\'' +
                ']';
    }
}
