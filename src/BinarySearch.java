/**
 * Created by rbhoompally on 4/5/18.
 */
public class BinarySearch {
    public int sqrt(int a) {
        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        return sqrt(a, 1, a / 2);
    }

    public int sqrt(int a, long start, long end) {
        if (start >= end) {
            if (start * start > a) {
                return (int) start - 1;
            } else {
                return (int) start;
            }
        }
        long mid = (start + end) / 2;
        long product = mid * mid;
        if (product == a) {
            return (int) mid;
        } else if (product < a) {
            return sqrt(a, mid + 1, end);
        } else {
            return sqrt(a, start, mid - 1);
        }
    }
}
