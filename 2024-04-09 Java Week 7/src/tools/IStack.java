package tools;

public interface IStack<T> {

    boolean isEmpty();

    boolean push(T value);

    T peek();

    T pop();
}