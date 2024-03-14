package tools;

public class TallyCounter {
    private int counter;
    private int digits;
    private int maxValue;

    public TallyCounter() {
        this.counter = 0;
        this.digits = 3;
        getMaxValue();
    }

    public TallyCounter(int digits) {
        this.digits = digits;
        getMaxValue();
    }

    private void getMaxValue() {
        this.maxValue = (int) (Math.pow(10.0, this.digits))-1;
    }

    public int increment() throws InvalidOperationException {
        if (this.counter == this.maxValue) throw new InvalidOperationException("Counter is at max value");
        this.counter++;
        return this.counter;
    }

    public int decrement() throws InvalidOperationException {
        if (this.counter == 0) throw new InvalidOperationException("Counter cannot be negative");
        this.counter--;
        return this.counter;
    }

    public int read() {
        return this.counter;
    }

    public void reset() {
        this.counter = 0;
    }

    public String toString() {
        return String.format("%03d", this.counter);
    }
}
