# [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

## Description

Merge two sorted linked lists and return it as a new **sorted** list. The new list should be made by splicing together the nodes of the first two lists.

## Example

```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```

## Solution 1

#### Explanation

1. Create a dunmmy head
2. While both two lists are not null
   1. compare the head values of current two lists, and find the smallest one
   2. link the smallest node
3. If one list is not null after the loop, link it to the list
4. return the list with deleting the dummy head

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        // dunmmy head
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                p.next = l2;
                l2 = l2.next;
            }else{
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }
        return head.next;
    }
}
```

## Solution 2

#### Explanation

1. Compare the values to choose the smallest one as the head node
2. Move the pointer two the next and choose the next node
3. Recursively execute setp (1) and (2)

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
```

