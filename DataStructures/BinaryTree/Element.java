package BinaryTree;

public class Element<Type> {

    private Type Value;
    private Element<Type> left;
    private Element<Type> right;

    public Element(Type newValue){
        this.Value = newValue;
        this.left = null;
        this.right = null;
    }

    public Type getValue() {
        return Value;
    }

    public void setValue(Type value) {
        Value = value;
    }

    public Element<Type> getLeft() {
        return left;
    }

    public void setLeft(Element<Type> left) {
        this.left = left;
    }

    public Element<Type> getRight() {
        return right;
    }

    public void setRight(Element<Type> right) {
        this.right = right;
    }
}
