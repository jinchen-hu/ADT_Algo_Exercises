# [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)

## Description

Given a singly linked list, determine if it is a palindrome.

**Example 1:**

```
Input: 1->2
Output: false
```

**Example 2:**

```
Input: 1->2->2->1
Output: true
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode fast = head.next;
        ListNode slow = head;
        boolean isEven = false;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = reverse(slow.next);
        
        while(mid!=null){
            if(head.val != mid.val)
                return false;
            head = head.next;
            mid = mid.next;
        }
        return true;
    }
    public ListNode reverse(ListNode temp){
        ListNode prev = null;
        ListNode curr = temp;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
```

