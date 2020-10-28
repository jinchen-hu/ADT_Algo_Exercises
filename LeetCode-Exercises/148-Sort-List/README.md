# [Sort List](https://leetcode.com/problems/sort-list/)

## Description

Given the `head` of a linked list, return *the list after sorting it in **ascending order***.

**Follow up:** Can you sort the linked list in `O(n logn)` time and `O(1)` memory (i.e. constant space)?

## Example

**Example 1:**

![img](https://assets.leetcode.com/uploads/2020/09/14/sort_list_1.jpg)

```
Input: head = [4,2,1,3]
Output: [1,2,3,4]
```

**Example 2:**

![img](https://assets.leetcode.com/uploads/2020/09/14/sort_list_2.jpg)

```
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
```

**Example 3:**

```
Input: head = []
Output: []
```

## Solution 1

```java

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}

```

## Solution 2

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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
			
		// Finding the mid of the linked list and breaking the the list in two parts
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;
        mid=mid.next;
        slow.next=null;
		
		//recursive calls to sort the 2 seperated lists
        ListNode a=sortList(head);
        ListNode b=sortList(mid);
		
		//merging the 2 sorted lists
        return merge(a,b);
    }
    
    public ListNode merge(ListNode a,ListNode b){
        if(a==null) return b;
        if(b==null) return a;
        ListNode head;
        ListNode cur;
        if(a.val<b.val){
            head=a;
            cur=a;
            a=a.next;
        }else{
            head=b;
            cur=b;
            b=b.next;
        }
        while(a!=null && b!=null){
            if(a.val<b.val){
                cur.next=a;
                cur=cur.next;
                a=a.next;
            }else{
                cur.next=b;
                cur=cur.next;
                b=b.next;
            }
        }
        if(a!=null)
            cur.next=a;
        if(b!=null)
            cur.next=b;
        return head;
    }
}

```

