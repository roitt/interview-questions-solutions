/**
 * Created by rbhoompally on 3/11/19.
 */
public class Merge2LinkedLists {
    public LinkedListNode<Integer> mergeTwoLists(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> move = null;

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                if (move == null) {
                    move = new LinkedListNode<>(l1.value);
                    head = move;
                } else {
                    move.next = new LinkedListNode<>(l1.value);
                    move = move.next;
                }
                l1 = l1.next;
            } else {
                if (move == null) {
                    move = new LinkedListNode<>(l2.value);
                    head = move;
                } else {
                    move.next = new LinkedListNode<>(l2.value);
                    move = move.next;
                }
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            move.next = l1;
        }

        if (l2 != null) {
            move.next = l2;
        }

        return head;
    }
}
