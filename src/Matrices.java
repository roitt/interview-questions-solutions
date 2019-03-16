/**
 * Created by rbhoompally on 2/22/18.
 */
public class Matrices {
    public void printZigzag(int[][] m) {
        if (m.length == 0 || m[0].length == 0) return;
        traverseUp(0, 0, m);
    }

    private void traverseUp(int row, int col, int[][] m) {
        // Hit the end
        if (row >= m.length && col >= m[0].length) return;

        // Hit the top right
        if (row < 0 && col > m[0].length - 1) {
            traverseDown(row + 2, col - 1, m);
            return;
        }

        // Hit the right
        if (col > m[0].length - 1) {
            traverseDown(row + 2, col - 1, m);
            return;
        }

        // Hit the top
        if (row < 0) {
            traverseDown(row + 1, col, m);
            return;
        }

        // print
        System.out.print(m[row][col] + " ");

        // Recurse
        traverseUp(row - 1, col + 1, m);
    }

    private void traverseDown(int row, int col, int[][] m) {
        // Hit the end
        if (row >= m.length && col >= m[0].length) return;

        // Hit the bottom left
        if (col < 0 && row > m.length - 1) {
            traverseUp(row - 1, col + 2, m);
            return;
        }

        // Hit the left
        if (col < 0) {
            traverseUp(row, col + 1, m);
            return;
        }

        // Hit the bottom
        if (row > m.length - 1) {
            traverseUp(row - 1, col + 2, m);
            return;
        }

        // print
        System.out.print(m[row][col] + " ");

        // Recurse
        traverseDown(row + 1, col - 1, m);
    }
}
