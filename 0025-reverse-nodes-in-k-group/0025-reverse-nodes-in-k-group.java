/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, prevNode = null;
        while (temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if (kthNode == null) {
                // if (prevNode != null) {
                    prevNode.next = temp;
                    return head;
                // }
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if (head == temp)
                head = kthNode;
            else
                prevNode.next = kthNode;
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    private ListNode findKthNode(ListNode temp, int k) {
        while (k > 1 && temp != null) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    private ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}