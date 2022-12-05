package LinkedList;

public class Element {

    private String value;
    private Element next;

    public Element(String newValue){
        this.value = newValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }
}
