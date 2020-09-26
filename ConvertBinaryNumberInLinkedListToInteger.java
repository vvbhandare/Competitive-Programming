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
class ConvertBinaryNumberInLinkedListToInteger {
    int ans = 0;
    public int getDecimalValue(ListNode head) {
        rec(head);
        return ans;
    }
    
    private int rec(ListNode head) {
        if (head == null) return 0;
        int pow = rec(head.next);
        if (head.val == 1) 
            ans += 1 << pow;//Math.pow(2, pow);
        // System.out.println(pow + "=" + ans);
        return pow + 1;
    }
}

// 1 0 1
// 4 2 1