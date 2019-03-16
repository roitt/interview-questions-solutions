/**
 * Created by rbhoompally on 1/12/18.
 */
public class MergeArrays {
    public void merge(int[] a, int[] b) {
        int k = a.length - 1;
        int j = b.length - 1;
        int i = k - b.length;

        while (i >= 0 && j >= 0) {
            if (a[i] >= b[j]) {
                a[k] = a[i];
                i--;
            } else {
                a[k] = b[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            a[k] = b[j];
            k--;
            j--;
        }
    }
}
