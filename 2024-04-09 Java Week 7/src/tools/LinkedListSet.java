package tools;

public class LinkedListSet<E> implements ISet<E> {
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
            if (currentNode == elt) {
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
            if (currentNode == elt) {
                currentNode = currentNode.next;
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
}
