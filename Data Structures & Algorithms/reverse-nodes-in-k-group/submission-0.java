/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    private ListNode getKthNode(ListNode curr, int k) {
        while(curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode grpPrev = dummy;
        while(true) {
            ListNode kth = getKthNode(grpPrev, k);
            if(kth == null ) break;

            ListNode grpNext = kth.next;
            ListNode prev = grpNext;
            ListNode curr = grpPrev.next;

            for(int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode temp = grpPrev.next;
            grpPrev.next = kth;
            grpPrev = temp;
        }
        return dummy.next;
    }
}