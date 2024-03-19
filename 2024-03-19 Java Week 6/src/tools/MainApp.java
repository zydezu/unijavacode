package tools;

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) throws InvalidOperationException {
        BasicTallyCounter tally1 = new BasicTallyCounter(3);
        for (int i = 0; i < 100; i++) {
            System.err.println(tally1.increment());
        }
        System.err.println(tally1);
        
        BetterTallyCounter tally = new BetterTallyCounter(3);
        for (int i = 0; i < 100; i++) {
            System.err.println(tally.increment());
        }
        tally.decrement();
        System.err.println(tally);

        ArrayList<BasicTallyCounter> mList = new ArrayList<BasicTallyCounter>();
        mList.add(tally);
        mList.add(tally1);

        System.err.println(mList.get(0).read() + mList.get(1).read());
    }
}
