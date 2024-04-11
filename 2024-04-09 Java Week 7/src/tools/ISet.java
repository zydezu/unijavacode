package tools;

public interface ISet<E> {

    boolean add(E elt);

    void clear();

    boolean contains(E elt);

    boolean isEmpty();

    boolean remove(E elt);

    int size();
}
