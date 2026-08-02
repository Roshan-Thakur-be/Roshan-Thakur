
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfHead = reverseList(slow);
        ListNode firstHalfHead = head;

        ListNode temp = secondHalfHead; 
        boolean isPalindrome = true;
        while (temp != null) {
            if (firstHalfHead.val != temp.val) {
                isPalindrome = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            temp = temp.next;
        }

        reverseList(secondHalfHead);

        return isPalindrome;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }
}