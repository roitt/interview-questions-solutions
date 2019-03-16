import java.util.Arrays;

/**
 * Created by rbhoompally on 1/7/18.
 */
public class TripleStep {
    public int numberOfWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    private int countWays(int i, int[] memo) {
        if (i < 0) {
            return 0;
        } else if (i == 0) {
            return 1;
        } else {
            if (memo[i] < 0) {
                memo[i] = countWays(i - 3, memo) + countWays(i - 2, memo) + countWays(i - 1, memo);
            }
            return memo[i];
        }
    }
}
