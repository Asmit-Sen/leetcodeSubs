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
    int f(ListNode head, int c, HashMap<Integer, Integer> map, int ans[]){
        if (head==null) return c;

        map.put(c, head.val);
        int len = f(head.next, c+1, map, ans);

        int twin = len-1-c;
        ans[0] = Math.max(ans[0], head.val + map.get(twin));

        return len;
    }
    public int pairSum(ListNode head) {
        int ans[] = {0};
        f(head, 0, new HashMap<>(), ans);

        return ans[0];
    }
}
