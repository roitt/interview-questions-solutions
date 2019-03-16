/**
 * Created by rbhoompally on 2/27/18.
 */
public class MagicIndex {
    public int magicIndex(int[] a) {
        if (a == null || a.length == 0) {
            return  -1;
        }

        return magicIndex(a, 0, a.length - 1);
    }

    private int magicIndex(int[] a, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (a[mid] == mid) {
            return mid;
        } else {
            if (a[a[mid]] == a[mid]) {
                return a[mid];
            }

            if (a[mid] > mid) {
                return magicIndex(a, start, mid - 1);
            } else {
                return magicIndex(a, mid + 1, end);
            }
        }
    }
}
