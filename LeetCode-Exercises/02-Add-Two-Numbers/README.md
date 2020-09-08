# [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

## Description

You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order** and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

## Example

```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```

## Solution

#### Explanation

1. A dummy head is needed so that each node has a previous node
2. The intenger carry indicates if the sum exceeds 10
3. A while loop terminates when two ListNode reach to the end
4. Comput sum = l1.val+l2.val+carry
5. After the loop ends, if the carry is equal to 1, append a new node with value 1 to the end
6. Time complexity: O(max(m, n))
7. Space complexity: O(max(m, n))

#### Animation

![](../../common/2 - add two numbers.gif)

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;
        int carry = 0;
        while(l1!=null || l2!=null || carry!= 0){
            if(l1 != null){
                carry += l1.val;
              	l1 = l1.next;
            }
            if(l2 != null){
                carry += l2.val;
              	l2 = l2.next;
            }
            current.next= new ListNode(carry % 10);
            current = current.next;
            carry /= 10;
        }
        return result.next;
    }
}
```

