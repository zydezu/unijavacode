package tools;

public interface ITallyCounter {
    public int increment() throws InvalidOperationException;

    public int read();

    public void reset();

    public String toString();
}