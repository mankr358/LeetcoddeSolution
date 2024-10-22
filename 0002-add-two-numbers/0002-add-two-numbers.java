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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0; // Get the value from l1 if available, otherwise 0
            int y = (l2 != null) ? l2.val : 0; // Get the value from l2 if available, otherwise 0

            int sum = carry + x + y; // Add the two numbers and the carry
            carry = sum / 10;        // Update carry for next addition

            // Create a new node for the result list with the remainder of sum
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Move l1 and l2 pointers to the next nodes
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If there's any carry left, add a new node with that carry
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // Return the next node of dummy (the head of the result list)
        return dummy.next;
    
    }
}