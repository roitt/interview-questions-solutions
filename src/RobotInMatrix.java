import java.util.*;

/**
 * Created by rbhoompally on 2/8/18.
 */
public class RobotInMatrix {
    public List<Point> findPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }

        List<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (hasPath(matrix, matrix.length - 1, matrix[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    private boolean hasPath(int[][] matrix, int r, int c, List<Point> path, HashSet<Point> failedPoints) {
        // Out of bounds
        if (r < 0 || c < 0 || matrix[r][c] == -1) {
            return false;
        }

        Point p = new Point(r, c);

        if (failedPoints.contains(p)) {
            return false;
        }

        boolean isAtOrigin = (r == 0) && (c == 0);

        if (isAtOrigin || hasPath(matrix, r - 1, c, path, failedPoints) || hasPath(matrix, r, c - 1, path, failedPoints)) {
            path.add(p);
            return true;
        } else {
            failedPoints.add(p);
            return false;
        }
    }
}
