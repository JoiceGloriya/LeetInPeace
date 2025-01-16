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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        ListNode tail = head;
        int length = 1;
        while(tail.next != null) {
            length++;
            tail = tail.next;
        }
        k = k % length;
        if(k == 0) return head;
        int ct = 0;
        tail.next = head;
        ListNode newTail = findNewTail(head, length - k); //newTail will be at length - k steps
        head = newTail.next;
        newTail.next = null;
        return head;        
    }

    ListNode findNewTail(ListNode head, int length) {
        int ct = 1;
        ListNode temp = head;
        while(temp != null) {
            if(ct == length) return temp;
            ct++;
            temp = temp.next;
        }
        return temp;
    }
}