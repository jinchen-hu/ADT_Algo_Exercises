# [Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)

Given a linked list, swap every two adjacent nodes and return its head.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg)

```
Input: head = [1,2,3,4]
Output: [2,1,4,3]
```

**Example 2:**

```
Input: head = []
Output: []
```

**Example 3:**

```
Input: head = [1]
Output: [1]
```

## Solution

![24](..\..\common\24.gif)

```
dummy : 0 - A - B - C - null
head  : A - B - C - null
pre   : 0 - A - B - C - null
second: B - C - null

head.next = second.next
head: A - C - null

second.next = head : 
second: B - A - C - null

pre.next = second
pre: 0 - B - A - C - null

pre = head
pre: A - C - null

head = head.next
C - null
```

```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        
        while(head != null && head.next != null){
            ListNode second = head.next;
            head.next = second.next;
            second.next = head;
            pre.next = second;
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }
}
```

