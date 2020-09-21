# [Remove Nth Node From End Of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

## Description

Given a linked list, remove the *n*-th node from the end of list and return its head.

## Example

```
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```

## Solution

```java
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        if(n == 0){
            return head;
        }
        
        int length = countNode(head);
        
        // remove the first node
        if(n == length)
            return head.next;
        
        if(n > length){
            return null;
        }
        ListNode temp = head;
        
        // remove the last node
        if(n == length){
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
            return head;
        }
        
        int preI = length - n - 1;
        
        for(int i = 0; i < length; i++){
            if(i == preI){
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        return null;
    }
    
    private int countNode(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}
```

