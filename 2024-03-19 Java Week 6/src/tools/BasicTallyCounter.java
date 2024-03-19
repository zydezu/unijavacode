package tools;

public class BasicTallyCounter implements ITallyCounter {
    protected int counter;
    private int digits;
    protected int maxValue;

    public BasicTallyCounter() {
        this.counter = 0;
        this.digits = 3;
        getMaxValue();
    }

    public BasicTallyCounter(int digits) {
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
