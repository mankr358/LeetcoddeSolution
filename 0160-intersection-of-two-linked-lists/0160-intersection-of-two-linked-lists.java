/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Initialize a pointer for traversal
        ListNode curr = headA;
        int a = 0, b = 0;

        // Count the length of list A
        while (curr != null) {
            a++;
            curr = curr.next;
        }

        // Count the length of list B
        curr = headB;
        while (curr != null) {
            b++;
            curr = curr.next;
        }

        // Calculate the difference in lengths
        int diff = Math.abs(a - b);

        // Align the starting point of the longer list to the shorter list's start
        if (a < b) {
            while (diff-- > 0) {
                headB = headB.next;
            }
        } else {
            while (diff-- > 0) {
                headA = headA.next;
            }
        }

        // Traverse both lists together to find the intersection point
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        // If no intersection, return null
        return null;
    }
}