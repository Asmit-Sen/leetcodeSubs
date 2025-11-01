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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev= dummy, ptr = head;
        dummy.next=head;
        
        Set<Integer> set = new HashSet<>();
        for(int x: nums) set.add(x);

        while(ptr!=null){
            if(set.contains(ptr.val)){
                prev.next=ptr.next;
            }
            else{
                prev=ptr;
            }
            ptr=ptr.next;
        }

        return dummy.next;
    }
}
