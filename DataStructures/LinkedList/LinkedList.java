package LinkedList;

import java.util.Iterator;

public class LinkedList {

    private Element first;
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

    public Element getLast() {
        return last;
    }

    public void setLast(Element last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addict(String newValue){
        Element newElement = new Element(newValue);
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

    public void remove(String searchValue){
        Element previous = null;
        Element current = this.first;
        for (int i = 0; i < this.getSize(); i++) {
            if(current.getValue().equalsIgnoreCase(searchValue)){
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
