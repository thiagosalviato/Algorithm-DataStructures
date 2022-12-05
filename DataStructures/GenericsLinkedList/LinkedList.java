package GenericsLinkedList;

public class LinkedList<Type>{

    private Element<Type> first;
    private Element last;
    private int size;

    public LinkedList(){
        this.size = 0;
    }

    public Object getFirst() {
        return first;
    }

    public void setFirst(Element first) {
        this.first = first;
    }

    public Element<Type> getLast() {
        return last;
    }

    public void setLast(Element<Type> last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addict(Type newValue){
        Element<Type> newElement = new Element<Type>(newValue);
        if (this.first == null && this.last == null){
            this.first = newElement;
            this.last = newElement;
            this.size++;
        }else{
            this.last.setNext(newElement);
            this.last = newElement;
            this.size++;
        }
    }

    public void remove(Type searchValue){
        Element<Type> previous = null;
        Element<Type> current = this.first;
        for (int i = 0; i < this.getSize(); i++) {
            if(current.getValue().equals(searchValue)){
                if(current == first && current == last){
                    this.first = null;
                    this.last = null;
                }
                if(current == first){
                    this.first = current.getNext();
                    current.setNext(null);
                } else if(current == last){
                    this.last = previous;
                    previous.setNext(null);
                }else {
                    previous.setNext(current.getNext());
                    current = null;
                }
                previous.setNext(current.getNext());
                current = null;
                this.size--;
                break;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public Element get(int position){
        Element current = this.first;
        for (int i = 0; i < position; i++) {
            if (current.getNext() != null){
                current = current.getNext();
            }
        }
        return current;
    }
}
