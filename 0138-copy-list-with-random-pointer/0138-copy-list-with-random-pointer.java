/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        // TC -> O(3N) SC -> O(N) => [this is reqd in the question]
        createCopyNodes(head);
        connectRandomPointers(head);
        return connectNextPointers(head);
    }

    private void createCopyNodes(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
    }

    private void connectRandomPointers(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copyNode = temp.next;
            if (temp.random == null)
                copyNode.random = null;
            else
                copyNode.random = temp.random.next;
            temp = temp.next.next;
        }
    }

    private Node connectNextPointers(Node head) {
        Node dummyHead = new Node(-1);
        Node temp = head;
        Node dTemp = dummyHead;
        while (temp != null) {
            Node copyNode = temp.next;
            dTemp.next = copyNode;
            dTemp = dTemp.next;
            temp.next = copyNode.next;
            if (copyNode.next != null)
                copyNode.next = copyNode.next.next;
            temp = temp.next;
            
        }
        return dummyHead.next;
    }

}