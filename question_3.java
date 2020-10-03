/**
 *
 * Problem statement:
 *
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.

 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
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

        int countL1=1,countL2 = 1;
        ListNode temp1,temp2;
        temp1 = l1;
        temp2 = l2;
        
        while(temp1.next != null){
            countL1++;
            temp1 = temp1.next;
        }
        while(temp2.next != null){
            countL2++;
            temp2 = temp2.next;
        }
        
        temp1 = l1;
        temp2 = l2;
        
        if(countL1 < countL2){
            while(temp1.next != null && temp2.next != null){
                temp1=temp1.next;
                temp2=temp2.next;
            }
            while(temp2.next != null){
                temp1.next = new ListNode(0);
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        
         if(countL2 < countL1){
            while(temp2.next != null && temp1.next != null){
                temp1=temp1.next;
                temp2=temp2.next;
            }
            while(temp1.next != null){
                temp2.next = new ListNode(0);
                temp2 = temp2.next;
                temp1 = temp1.next;
            }
        }
        
        ListNode result = new ListNode();
        ListNode head = result;
        int temp = 0,carry = 0;
        
        while((l1 != null) && (l2 != null)){
            
            temp = l1.val + l2.val + carry;
            carry = temp / 10;
            
            result.next = new ListNode(temp % 10);
            result = result.next;

            l1 = l1.next;
            l2 = l2.next;           
        }
        
        if(carry == 1){
            result.next = new ListNode(1);
            result = result.next;
        }
        result.next = null;
        
        return head.next;
    }
}