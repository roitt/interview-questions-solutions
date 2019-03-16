import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by rbhoompally on 1/15/18.
 */
public class Permutations {
    public boolean isPermutation(String a, String b) {
        if (a == null && b == null) { return true;}
        if (a == null || b == null) { return false;}
        if (a.length() != b.length()) {return false;}

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<a.length(); i++) {
            char current = a.charAt(i);
            if (map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }

        for (int i=0; i<b.length(); i++) {
            char current = b.charAt(i);
            if (map.containsKey(current)) {
                int c = map.get(current);
                if (c == 0) {
                    return false;
                }
                map.put(current, c - 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public List<String> allBinaryStrings(String binary) {
        ArrayList<String> output = new ArrayList<>();
        allBinaryStrings(binary, 0, output);
        return output;
    }

    private void allBinaryStrings(String binary, int index, List<String> output) {
        if (index >= binary.length()) {
            output.add(binary);
            return;
        }

        char probe = binary.charAt(index);
        if (probe == 'A') {
            String zero = binary.substring(0, index) + "0" + (index < binary.length() ? binary.substring(index + 1) : "");
            String one = binary.substring(0, index) + "1" + (index < binary.length() ? binary.substring(index + 1) : "");
            allBinaryStrings(zero, index + 1, output);
            allBinaryStrings(one, index + 1, output);
        } else {
            allBinaryStrings(binary, index + 1, output);
        }
    }

    public List<String> allBinaryStringIterative(String binary) {
        if (binary == null || binary.length() == 0) {
            return new ArrayList<>();
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(binary);

        for (int i = 0; i < binary.length(); i++) {
            ArrayList<String> newProbes = new ArrayList<>();
            while(!queue.isEmpty()) {
                String probe = queue.poll();
                if (probe.charAt(i) == 'A') {
                    newProbes.add(probe.substring(0, i) + "0" + (i < binary.length() ? probe.substring(i + 1) : ""));
                    newProbes.add(probe.substring(0, i) + "1" + (i < binary.length() ? probe.substring(i + 1) : ""));
                } else {
                    newProbes.add(probe);
                }
            }
            queue.addAll(newProbes);
        }

        return new ArrayList<>(queue);
    }

    public void printAllBinaryStringsIterative(String binary) {
            int n = binary.length();
            if(n==0) {
                System.out.println("Lenght is 0");
            } else {
                if(binary.indexOf('A') != -1) {
                    int i = binary.indexOf('A');
                    String replacedStr = binary.substring(0, i) + "0" + (i < binary.length() ? binary.substring(i + 1) : "");
                    printAllBinaryStringsIterative(replacedStr);
                    printAllBinaryStringsIterative(binary.substring(0, i) + "1" + (i < binary.length() ? binary.substring(i + 1) : ""));
                } else { //1001,1101, 1111,  1011
                    System.out.println("possible combination" + binary);
                }
            }
        }
}
