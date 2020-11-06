# [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)

Reverse a singly linked list.

**Example:**

```
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
```

**Follow up:**

A linked list can be reversed either iteratively or recursively. Could you implement both?

## Solution

```java
// 1. iterative
   public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
   }

// 2. recursive, with helper method
    public ListNode reverseList(ListNode head) {
        return reverseRecursive(head, null);
    }
    
    private ListNode reverseRecursive(ListNode curr, ListNode prev) {
        if (curr == null) {return prev;}
        ListNode next = curr.next;
        curr.next = prev;
        return reverseRecursive(next, curr);
    }
    
// 3. recursive, without helper method
// requires an instance variable to point to head
    private ListNode listhead;
    public ListNode reverseList(ListNode node) {
        if (node == null) return null;
        
		if (node.next == null) {
			// this is the last node, set listhead to point to this node
			listhead = node;
			return listhead;
		}
		
		reverseList(node.next);
		// now reverse the link by setting the next node's next to point to this node
		node.next.next = node;
		// set node.next to null to ensure the last node terminates properly when recursion ends
		node.next = null;
        return listhead;
    }    
```

