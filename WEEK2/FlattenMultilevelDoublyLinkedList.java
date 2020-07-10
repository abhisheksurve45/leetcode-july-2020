public class FlattenMultilevelDoublyLinkedList {


    /**
     * Reference : https://www.youtube.com/watch?v=pjWqjqGDOlw
     */
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    */

    class Solution {
        public Node flatten(Node head) {
            if (head == null) return head;

            Node curr = head;
            Stack<Node> stk = new Stack<>();

            while (curr != null) {

                // IF CHILD PRESENT
                if (curr.child != null) {

                    if (curr.next != null) stk.push(curr.next);

                    curr.next = curr.child;
                    curr.next.prev = curr;
                    curr.child = null;

                } else if (curr.next == null && !stk.isEmpty()) {
                    curr.next = stk.pop();
                    curr.next.prev = curr;
                }

                curr = curr.next;
            }

            return head;
        }
    }
}
