import java.util.HashMap;

/**
 * Created by rbhoompally on 1/7/18.
 */
public class NthFib {
    HashMap<Integer, Integer> fibs = new HashMap<>();
    public int getNthFib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int fib;
        if (fibs.containsKey(n)) {
            fib = fibs.get(n);
        } else {
            fib = getNthFib(n - 1) + getNthFib(n - 2);
            fibs.put(n, fib);
        }
        return fib;
    }
}
