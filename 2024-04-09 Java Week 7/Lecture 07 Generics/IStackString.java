package tools;

public interface IStackString {

    boolean isEmpty();

    boolean push(String value);

    String peek();

    String pop();
}