/**
 * Created by rbhoompally on 3/12/19.
 */
public class MyLinkedListSimple {
    private SimpleListNode head = null;
    private SimpleListNode tail = null;

    public SimpleListNode getHead() {
        return head;
    }

    public SimpleListNode append(SimpleListNode linkedListNode) {
        if (head == null) {
            head = tail = linkedListNode;
        } else {
            tail.next = linkedListNode;
            tail = linkedListNode;
        }
        return head;
    }

    public SimpleListNode getKthToLast(SimpleListNode head, int k) {
        SimpleListNode runner = head;
        SimpleListNode follower = head;

        for (int i = k; i > 0; --i) {
            if (runner == null) {
                return new SimpleListNode(-1);
            } else {
                runner = runner.next;
            }
        }

        while (runner != null) {
            runner = runner.next;
            follower = follower.next;
        }

        return follower;
    }
}
