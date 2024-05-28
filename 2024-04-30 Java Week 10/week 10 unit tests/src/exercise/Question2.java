package exercise;

public class Question2 {
    public static int rodCutting(int[] p, int n) {
        if (n < 0)
            throw new IllegalArgumentException("n is less than zero");
        if (p.length <= n)
            throw new IllegalArgumentException("the length of p isn't more than n");
        for (int i : p) {
            if (i <= 0) {
                throw new IllegalArgumentException("A price in p is less or equal to zero");
            }
        }

        int[] r = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            r[i] = -1;
        }
        return memoizedCutRodAux(p, n, r);
    }

    private static int memoizedCutRodAux(int[] p, int n, int[] r) {
        if (r[n] >= 0) {
            return r[n];
        }
        int q;
        if (n == 0) {
            q = 0;
        } else {
            q = -1;
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, p[i] + memoizedCutRodAux(p, n - i, r));
            }
        }
        r[n] = q;
        return q;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5,6,7,8}; // Example prices
        int n = 5; // Length of the rod
        System.out.println("Maximum profit: " + rodCutting(prices, n));
    }
}
