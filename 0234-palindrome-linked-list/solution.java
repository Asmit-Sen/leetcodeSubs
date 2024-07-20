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
    public boolean isPalindrome(ListNode head) {
        // if(head==null || head.next==null) return true;
        // if(head.next.next==null)
        // {
        //     return (head.val==head.next.val)?true:false;
        // }
        // Stack <Integer> stack =new Stack<>();
        // ListNode temp=head;
        // while(temp!=null)
        // {
        //     stack.push(temp.val);
        //     temp=temp.next;
        // }

        // temp=head;
        // while(temp!=null)
        // {
        //     if(stack.peek()==temp.val)
        //     {
        //         temp=temp.next;
        //         stack.pop();
        //     }
        //     else return false;
        // }
        // return true;




        if(head==null || head.next==null) return true;
        if(head.next.next==null)
        {
            return (head.val==head.next.val)?true:false;
        }

        ListNode slow=head,fast=head.next;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode newHead=reverse(slow.next); // head of l2 = reversed second half
        ListNode l1=head,l2=newHead;

        while(l2!=null)
        {
            if(l1.val!=l2.val) 
            {
                newHead=reverse(newHead); //reverse the second half to original
                return false;
            }
            l1=l1.next;
            l2=l2.next;
        }
        newHead=reverse(newHead); //reverse the second half to original
        return true;       

    }
    ListNode reverse(ListNode head)
    {
        ListNode temp=head,prev=null;
        while(temp!=null)
        {
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
}
