import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhoompally on 2/27/18.
 */
public class AllSubsets {
    public List<List<Integer>> allSubsets(List<Integer> set) {
        if (set == null) {
            return null;
        }
        List<List<Integer>> allSubsets = new ArrayList<>();

        for (Integer t: set) {
            List<List<Integer>> newItems = new ArrayList<>();
            for (List<Integer> j: allSubsets) {
                List<Integer> newItem = new ArrayList(j);
                newItem.add(t);
                newItems.add(newItem);
            }

            if (!newItems.isEmpty()) {
                allSubsets.addAll(newItems);
            }

            List<Integer> newEntry = new ArrayList<>();
            newEntry.add(t);
            allSubsets.add(newEntry);
        }

        return allSubsets;
    }
}
