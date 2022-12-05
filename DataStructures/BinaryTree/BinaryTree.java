package BinaryTree;

import BinaryTree.Element;

public class BinaryTree<Type> {

    private Element<Type> root;

    public BinaryTree(){
        this.root = null;
    }

    public void addict(Type value){
        Element<Type> newElement = new Element<Type>(value);
        if(root == null){
            this.root = newElement;
        }else {
            Element<Type> current = this.root;
            while (true){
                if (current.getValue().compareTo(newElement.getValue()) == -1) {
                    if(current.getRight() != null){
                        current = current.getRight();
                    }else {
                        current.setRight(newElement);
                    }
                } else {
                    if (current.getLeft() != null){
                        current = current.getLeft();
                    } else{
                        current.setLeft(newElement);
                        break;
                    }
                }
            }
        }
    }

    public void InOrder(Element<Type> current){
        if(current != null) {
            InOrder(current.getLeft());
            System.out.println(current);
            InOrder(current.getRight());
        }
    }

    public void PreOrder(Element<Type> current){
        if(current != null) {
            System.out.println(current.getValue());
            PreOrder(current.getLeft());
            PreOrder(current.getRight());
        }
    }

    public void AfterOrder(Element<Type> current){
        if(current != null) {
            PreOrder(current.getLeft());
            PreOrder(current.getRight());
            System.out.println(current.getValue());
        }
    }
    public void remove(Type value){
        Element<Type> current = this.root;
        Element<Type> currentFather = null;
        while (true){
            if(current.getValue().equals(value)){
                break;
            }else if(current.getValue().compareTo(current.getValue()) == -1){
                currentFather = current;
                current = current.getLeft();
            }else{
                currentFather = current;
                current = current.getRight();
            }
        }
        if(current != null){
            if(current.getRight() != null){
                Element<Type> substitute = current.getRight();
                Element<Type> substituteFather = current;
                while (substitute.getLeft() != null ){
                    substituteFather = substitute;
                    substitute = substitute.getLeft();
                }
                substitute.setLeft(current.getLeft());
                if (currentFather != null) {
                    current.setValue(substitute.getValue());
                    if (substitute.getValue().compareTo(substituteFather.getValue()) == -1) {
                        substituteFather.setRight(substitute);
                    } else {
                        substituteFather.setLeft(substitute);
                    }
                } else{
                    this.root = substitute;
                }
            } else if (current.getLeft() != null) {
                Element<Type> substitute = current.getLeft();
                Element<Type> substituteFather = current;
                while (substitute.getRight() != null ){
                    substituteFather = substitute;
                    substitute = substitute.getRight();
                }
                if (currentFather != null) {
                    current.setValue(substitute.getValue());
                    if (substitute.getValue().compareTo(substituteFather.getValue()) == -1) {
                        substituteFather.setRight(substitute);
                    } else {
                        substituteFather.setLeft(substitute);
                    }
                }else{
                    this.root = substitute;
                }
            }else {
                if (currentFather != null) {
                    if (current.getValue().compareTo(currentFather.getValue()) == -1) {
                        currentFather.setRight(null);
                    } else {
                        currentFather.setLeft(null);
                    }
                }else{
                    this.root = null;
                }
            }
            return true;
        }else{
            return false;
        }

    }

    public Element<Type> getRoot() {
        return root;
    }
}
