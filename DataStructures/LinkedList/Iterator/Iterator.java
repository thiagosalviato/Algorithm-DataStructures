package LinkedList.Iterator;


import GenericsLinkedList.Element;

public class Iterator<Type> {
        Element<Type> element;

        public Iterator(Element<Type> current){
            this.element = current;
        }

        public boolean haveNext(){
            if(element.getNext() == null){
                return false;
            }else {
                return true;
            }
        }

        public Element<Type> getNext(){
            return element.getNext();
        }
}