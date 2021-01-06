# [Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)

Given the `head` of a sorted linked list, *delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list*. Return *the linked list **sorted** as well*.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg)

```
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
```

**Example 2:**

![img](https://assets.leetcode.com/uploads/2021/01/04/linkedlist2.jpg)

```
Input: head = [1,1,1,2,3]
Output: [2,3]
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(0);
        ListNode fast = head;
        ListNode slow = dummyHead;
        slow.next = fast;
        while(fast != null){
            // go to last duplicate node
            while(fast.next != null && fast.val == fast.next.val)
                fast = fast.next;
            // if find the duplicates, remove them from slow
            if(slow.next != fast){
                slow.next = fast.next;
                fast = slow.next;
            // move to next and remain the distinct node
            }else{
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummyHead.next;
    }
}
```

