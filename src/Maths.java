import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by rbhoompally on 3/17/18.
 */
public class Maths {
    public ArrayList<Integer> primesum(int A) {
        if (A % 2 != 0) {
            // Odd
            return null;
        }

        ArrayList<Integer> output = new ArrayList<>();
        for (int i = A - 1; i >= A / 2; i--) {
            if (isPrime(i) && isPrime(A - i)) {
                output.add(i);
                output.add(A - i);

            }
        }

        return output;
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        int div = (int) (Math.sqrt(num));
        for (int i = 2; i <= div; i++) {
            if (i < num && num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int titleToNumber(String A) {
        if (A == null || A.length() == 0) {
            return 0;
        }

        int value = 0;
        for (int i = 0; i < A.length(); i++) {
            char probe = A.charAt(A.length() - i - 1);
            int valueAtBase = (((int) probe) - ((int) 'A')) + 1;
            value += valueAtBase * Math.pow(26, i);
        }
        return value;
    }

    public int uniquePaths(int A, int B) {
        if (A > B) {
            return nChooseR(A, B);
        } else {
            return nChooseR(B, A);
        }
    }

    private int nChooseR(int a, int b) {
        int n = a + b - 2;
        int r = b - 1;
        int n_r = n - r;
        int factN = 1;
        for (int i = n; i > n_r; i--) {
            factN *= i;
        }
        return factN / factorial(r);
    }

    private int factorial(int n){
        if (n == 0)
            return 1;
        else
            return(n * factorial(n-1));
    }

    public int isPalindrome(int A) {
        if (A < 0) return 0;
        if (A == 0) return 1;
        int length = getLength(A);
        int start = 1;
        int end = length;
        while (start < end) {
            int a = getIntAt(start, A);
            int b = getIntAt(end, A);
            if (a != b) return 0;
            start++;
            end--;
        }
        return 1;
    }

    private int getIntAt(int pos, int a) {
        return (a % (int) Math.pow(10, pos)) / (int) Math.pow(10, pos - 1);
    }

    private int getLength(int a) {
        int length = 0;
        while(a > 0) {
            a = a / 10;
            length++;
        }
        return length;
    }

    public int numbersOfLengthN(ArrayList<Integer> A, int B, int C) {
        ArrayList<Integer> allCombinations = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0 && B == 1) {
                allCombinations.add(A.get(i));
                continue;
            }
            if (A.get(i) > Integer.parseInt(Integer.toString(C).substring(0, 1))) {
                break;
            }
            allCombinations.addAll(allCombinations(A, i, B));
        }

        int count = 0;
        for (Integer i : allCombinations) {
            if (i < C) {
                count++;
            }
        }

        return count;
    }

    private ArrayList<Integer> allCombinations(ArrayList<Integer> A, int pos, int length) {
        Stack<Integer> stack = new Stack();
        stack.push(A.get(pos));

        ArrayList<Integer> allCombinations = new ArrayList<>();
        while(!stack.isEmpty()) {
            int pre = stack.pop();
            if (String.valueOf(pre).length() == length) {
                allCombinations.add(pre);
                continue;
            }
            for (int i = 0; i < A.size(); i++) {
                int post = A.get(i);
                int newValue = (pre * 10) + post;
                stack.push(newValue);
            }
        }
        return allCombinations;
    }
}
