/**
 * Created by rbhoompally on 3/12/19.
 */
public class MergeKLists {
    public LinkedListNode mergeKLists(LinkedListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        LinkedListNode merged = lists[0];
        if (lists.length == 1) {
            return merged;
        }

        Merge2LinkedLists merge2LinkedLists = new Merge2LinkedLists();

        for (int i = 1; i < lists.length; i++) {
            merged = merge2LinkedLists.mergeTwoLists(merged, lists[i]);
        }

        return merged;
    }
}
