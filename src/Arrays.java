import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rbhoompally on 2/23/18.
 */
public class Arrays {
    public int[][] zeroRowAndCol(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[][]{};
        }

        int[] rowZeros = new int[matrix.length];
        int[] colZeros = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowZeros[i] = -1;
                    colZeros[j] = -1;
                }
            }
        }

        for (int i = 0; i < rowZeros.length; i++) {
            if (rowZeros[i] == -1) {
                // nullify the row
                for (int c = 0; c < matrix[0].length; c++) {
                    matrix[i][c] = 0;
                }
            }
        }

        for (int i = 0; i < colZeros.length; i++) {
            if (colZeros[i] == -1) {
                // nullify the row
                for (int r = 0; r < matrix.length; r++) {
                    matrix[r][i] = 0;
                }
            }
        }

        return matrix;
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        if (A == null || A.size() == 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> output = new ArrayList<>();
        long prevSum = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) < 0) continue;
            ArrayList<Integer> current = new ArrayList<>();

            long sum = A.get(i);
            current.add((int) sum);

            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(j) < 0) break;

                current.add(A.get(j));
                sum += A.get(j);
            }

            if (sum > prevSum) {
                prevSum = sum;
                output = new ArrayList<>(current);
            } else if (sum == prevSum) {
                if (output.size() < current.size()) {
                    output = new ArrayList<>(current);
                }
            }
        }

        if (output.size() == 0) {
            if (A.get(A.size() - 1) > 0) {
                output.add(A.get(A.size() - 1));
            }
        }

        if (output.size() == 1) {
            if (A.get(A.size() - 1) > output.get(0)) {
                output = new ArrayList<>();
                output.add(A.get(A.size() - 1));
            }
        }

        return output;
    }

    public int solve(ArrayList<Integer> A) {
        if (A == null  && A.size() == 0) return -1;

        Collections.sort(A);

        for (int i = 0; i < A.size() - 1; i++) {
            int next = A.get(i + 1);
            int current = A.get(i);
            int greater = A.size() - i - 1;
            if (next > current && current == greater) {
                return 1;
            }
        }

        return -1;
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (newInterval.start > newInterval.end) {
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }

        int start;
        for (start = 0; start < intervals.size(); start++) {
            Interval probe = intervals.get(start);
            if (newInterval.start <= probe.end) {
                break;
            }
        }

        int end;
        for (end = start; end < intervals.size(); end++) {
            Interval probe = intervals.get(end);
            if (newInterval.end <= probe.end) {
                break;
            }
        }

        int mergedStart = start;
        if (start >= 0 && start < intervals.size()) {
            mergedStart = Math.min(newInterval.start, intervals.get(start).start);
        }

        int mergedEnd = end;
        if (end >= 0 && end < intervals.size()) {
            if (newInterval.end >= intervals.get(end).start) {
                mergedEnd = Math.max(newInterval.end, intervals.get(end).end);
            } else {
                --end;
                if (end >= 0) {
                    mergedEnd = Math.max(newInterval.end, intervals.get(end).end);
                }
            }
        }

        Interval interval = new Interval(mergedStart, mergedEnd);

        ArrayList<Interval> newIntervals = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (i < start && i > end) {
                newIntervals.add(intervals.get(i));
            }
        }

        newIntervals.set(start, interval);
        return intervals;
    }

    public String largestNumber(final List<Integer> A) {
        if (A == null) {
            return null;
        }

        Collections.sort(A, new LargestNumberComparator());
        StringBuffer stringBuffer = new StringBuffer();
        boolean allZeroes = true;
        for (Integer item: A) {
            if (item != 0) {
                allZeroes = false;
            }
            stringBuffer.append(String.valueOf(item));
        }

        return allZeroes ? "0" : stringBuffer.toString();
    }

    public int firstMissingPositive(ArrayList<Integer> A) {
        if (A == null) {
            return 0;
        }

        int[] toN = new int[A.size() + 1];

        for (Integer i: A) {
            if (i <= A.size()) {
                toN[i] = toN[i] + 1;
            }
        }

        for (int i = 1; i <= toN.length; i++) {
            if (toN[i] == 0) {
                return i;
            }
        }

        return A.size() + 1;
    }

    class LargestNumberComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            long a = Long.parseLong(String.valueOf(o1) + String.valueOf(o2));
            long b = Long.parseLong(String.valueOf(o2) + String.valueOf(o1));
            return a == b ? 0 : (a < b) ? 1 : -1;
        }
    }
}
