package tools;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
        this.next = null;
    }

    Node(T data, Node<T> tail){
        this.data = data;
        this.next = tail;
    }

    @Override
    public String toString() {
        return "Node: " + this.data;
    }
}