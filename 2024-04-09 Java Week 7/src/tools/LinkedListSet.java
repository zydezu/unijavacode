package tools;

public class LinkedListSet<E> implements ISet<E> {
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
    
    Node<E> top;
    int size;

    public LinkedListSet() {
        top = null;
        size = 0;
    }

    @Override
    public boolean add(E elt) {
        if (contains(elt)) {
            top = new Node<E>(elt, top);
            return false;
        }
        top = new Node<E>(elt, top);
        size++;
        return true;
    }

    @Override
    public void clear() {
        top = null; // garbage collection /?!
        size = 0;
    }

    @Override
    public boolean contains(E elt) {
        Node<E> currentNode = top;
        if (currentNode == null) {
            return false;
        }
        while(currentNode != null) {
            if (currentNode.data == elt) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (top == null);
    }

    @Override
    public boolean remove(E elt) {
        Node<E> currentNode = top;
        if (currentNode == null) {
            return false;
        }
        while(currentNode != null) {
            if (currentNode.data == elt) {
                currentNode = currentNode.next;
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ISet<Integer> intLinkedList = new LinkedListSet<>(); 

        System.err.println(intLinkedList.isEmpty());
        intLinkedList.add(3);
        intLinkedList.add(17);
        intLinkedList.add(12);
        intLinkedList.add(4);
        
        System.err.println(intLinkedList.remove(3));
        System.err.println(intLinkedList.remove(4));
        System.err.println(intLinkedList.contains(12));
        System.err.println(intLinkedList.size());
        
        System.err.println(intLinkedList.isEmpty());

    }    
}
