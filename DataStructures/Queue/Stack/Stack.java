package Queue.Stack;

import LinkedList.LinkedList;

public class Stack {
    private LinkedList list;

    public Stack(){
        this.list = new LinkedList();
    }
    public void addict(String newValue){
        this.list.addict(newValue);
    }
    public void remove(){
        this.list.remove(this.get());
    }
    public String get() {
        return (String) this.list.getFirst();
    }
}
