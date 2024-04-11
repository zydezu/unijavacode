package tools;

public interface IStackObject {

    boolean isEmpty();

    boolean push(Object value);

    Object peek();

    Object pop();
}