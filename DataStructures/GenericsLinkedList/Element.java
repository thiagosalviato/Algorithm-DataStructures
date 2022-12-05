package GenericsLinkedList;

public class Element<Type> {

    private Type value;
    private Element<Type> next;

    public Element(Type newValue){
        this.value = newValue;
    }

    public Type getValue() {
        return value;
    }

    public void setValue(Type value) {
        this.value = value;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }
}
