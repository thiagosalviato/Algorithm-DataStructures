package Queue;

import LinkedList.LinkedList;

public class Queue {
        private LinkedList list;

    public Queue(LinkedList list) {
        this.list = new LinkedList();
    }

    public Queue() {
    }

    public void addict(String newValue){
            this.list.addict(newValue);
        }
        public void remove(){
            this.list.remove(this.get());
        }
        public String get(){
            return (String) this.list.getFirst();
        }
}
