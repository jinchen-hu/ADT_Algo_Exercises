# [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)

## Description

Given a linked list, return the node where the cycle begins. If there is no cycle, return `null`.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. **Note that `pos` is not passed as a parameter**.

**Notice** that you **should not modify** the linked list.

**Follow up:**

Can you solve it using `O(1)` (i.e. constant) memory?

## Example

**Example 1:**

![img](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png)

```
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
```

**Example 2:**

![img](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png)

```
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
```

**Example 3:**

![img](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png)

```
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
```

## Solution 1

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return head;
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head))
                return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
```

## Solution 2

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // suppose the length from head to starting point of cycle is M
        // the length of cycle is L
        // the lenght of starting point to meet point P is i
        // the length from meet point P to the starting point of cycle is j
        // L = i+j
        // fast = M+i+j+i = M+2i+j
        // slow = M+i
        // fast = 2slow, M+2i+j = 2M+2i ==> M=j
        // therefore, the length from head to the starting point of cycle is
        // equal to the length from meet point to the starting point of cycle
        
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                while(head != slow){
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }
}
```

