/**
 * Created by rbhoompally on 1/15/18.
 */
public class MyLinkedList<T> {
    private LinkedListNode<T> head = null;
    private LinkedListNode<T> tail = null;

    public LinkedListNode<T> getHead() {
        return head;
    }

    public LinkedListNode<T> append(LinkedListNode<T> linkedListNode) {
        if (head == null) {
            head = tail = linkedListNode;
        } else {
            tail.next = linkedListNode;
            tail = linkedListNode;
        }
        return head;
    }

    public LinkedListNode getKthToLast(LinkedListNode head, int k) {
        LinkedListNode runner = head;
        LinkedListNode follower = head;

        for (int i = k; i > 0; --i) {
            if (runner == null) {
                return new LinkedListNode(-1);
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
