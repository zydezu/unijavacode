package tools;

public class BetterTallyCounter extends BasicTallyCounter implements IAdvancedCounter {
    public BetterTallyCounter() {
        super();    
    }

    public BetterTallyCounter(int digits) {
        super(digits);
    }
    
    public int increment() throws InvalidOperationException {
        if (super.read() == super.maxValue) throw new InvalidOperationException("Counter is at max value");
        return super.increment();
    }

    public int decrement() throws InvalidOperationException {
        if (super.read() == 0) throw new InvalidOperationException("Counter cannot be negative");
        this.counter--;
        return super.read();
    }

    @Override
    public String toString() {
        return String.format("%03d", super.read());
    }
}
