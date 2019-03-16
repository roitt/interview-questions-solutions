import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rbhoompally on 3/9/19.
 */
public class ShortestPathInMatrix {
    class Coordinate {
        int x;
        int y;
        int val;
        List<Coordinate> trail;

        Coordinate(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
            trail = new ArrayList<>();
            trail.add(this);
        }

        void addToTrail(List<Coordinate> cs) {
            trail.addAll(cs);
        }
    }

    public List<Coordinate> findShortestPath(int[][] input, int startX, int startY, int endX, int endY) {
        if (input == null || input.length == 0) {
            return null;
        }

        Coordinate end = null;
        boolean[][] visited = new boolean[input[0].length][input.length];
        Queue<Coordinate> q = new LinkedList<>();
        Coordinate start = new Coordinate(startX, startY, input[startX][startY]);
        q.add(start);

        while (!q.isEmpty()) {
            Coordinate next = q.poll();

            if (next.val != 1) continue;
            if (visited[next.x][next.y]) continue;

            if (next.x == endX && next.y == endY) {
                end = next;
                break;
            }

            visited[next.x][next.y] = true;

            // Get adjacent coordinates
            List<Coordinate> adjacents = getAdjacents(input, next);
            q.addAll(adjacents);
        }

        return end == null? null : end.trail;
    }

    private List<Coordinate> getAdjacents(int[][] input, Coordinate c) {
        List<Coordinate> adjacents = new ArrayList<>();

        // Top, if exists
        if (c.x - 1 > 0) {
            Coordinate top = new Coordinate(c.x - 1, c.y, input[c.x - 1][c.y]);
            top.addToTrail(c.trail);
            adjacents.add(top);
        }

        // Right, if exists
        if (c.y + 1 < input.length) {
            Coordinate right = new Coordinate(c.x, c.y + 1, input[c.x][c.y + 1]);
            right.addToTrail(c.trail);
            adjacents.add(right);
        }

        // Down, if exists
        if (c.x + 1 < input[0].length) {
            Coordinate down = new Coordinate(c.x + 1, c.y, input[c.x + 1][c.y]);
            down.addToTrail(c.trail);
            adjacents.add(down);
        }

        // Left, if exists
        if (c.y - 1 > 0) {
            Coordinate left = new Coordinate(c.x, c.y - 1, input[c.x][c.y - 1]);
            left.addToTrail(c.trail);
            adjacents.add(left);
        }

        return adjacents;
    }
}
