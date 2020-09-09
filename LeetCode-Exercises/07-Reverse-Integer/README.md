# [Reverse Integer](https://leetcode.com/problems/reverse-integer/)

## Description

Given a 32-bit signed integer, reverse digits of an integer.

## Example

```
Input: 123
Output: 321
```

## Solution

```java
class Solution {
    public int reverse(int x) {
         //declare a long type storing the reverse integer
        long rev = 0;
        while(x!=0){
            //get the last digit and assign it the the rev
            rev = rev*10 + x % 10;
            //remove the last digit
            x /= 10;
        }
        //check if the rev overflows the range of int type
        if(rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE)
            return 0;
        
        Long ll = new Long(rev);
        return ll.intValue();
    }
}
```

