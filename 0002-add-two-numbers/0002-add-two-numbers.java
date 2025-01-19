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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode temp = dummyHead;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        while (temp1 != null || temp2 != null || carry == 1) {
            int sum = 0;
            if (temp1 != null) {
                sum += temp1.val;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                sum += temp2.val;
                temp2 = temp2.next;
            }
            sum += carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            temp.next = newNode;
            temp = temp.next;
        }
        return dummyHead.next;
    }
}