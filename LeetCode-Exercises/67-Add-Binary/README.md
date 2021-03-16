# Add Binary

Given two binary strings `a` and `b`, return *their sum as a binary string*.

 

**Example 1:**

```
Input: a = "11", b = "1"
Output: "100"
```

**Example 2:**

```
Input: a = "1010", b = "1011"
Output: "10101"
```

## Solution

```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >=0 || j >= 0){
            int sum = carry;
            if(i >= 0)
                sum += a.charAt(i--) - '0';
            if(j >= 0)
                sum += b.charAt(j--) - '0';
            // attach the last digit to the sb
            sb.append(sum % 2);
            // compute the carray, e.g., 1+1=10, 1+1+1=11
            carry = sum / 2;
        }
        
        if(carry == 1)
            sb.append(1);
        return sb.reverse().toString();
    }
}
```

