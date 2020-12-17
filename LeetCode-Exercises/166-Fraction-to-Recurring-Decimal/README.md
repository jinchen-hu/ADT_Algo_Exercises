# [Fraction to Recurring Decimal](https://leetcode.com/problems/fraction-to-recurring-decimal/)

Given two integers representing the `numerator` and `denominator` of a fraction, return *the fraction in string format*.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return **any of them**.

It is **guaranteed** that the length of the answer string is less than `104` for all the given inputs.

 

**Example 1:**

```
Input: numerator = 1, denominator = 2
Output: "0.5"
```

**Example 2:**

```
Input: numerator = 2, denominator = 1
Output: "2"
```

**Example 3:**

```
Input: numerator = 2, denominator = 3
Output: "0.(6)"
```

**Example 4:**

```
Input: numerator = 4, denominator = 333
Output: "0.(012)"
```

**Example 5:**

```
Input: numerator = 1, denominator = 5
Output: "0.2"
```

## Explanation

If the reminder start to repeat, the decimal part will start to repeat as well.

```
====> Integer part
4 / 333 = 0 ... 4

====> Decimal part
40 / 333 = 0 ... 40
400 / 333 = 1 ... 67
670 / 333 = 2 ... 4
			      <======repeart starts
40 / 333 = 0 ... 40
400 / 333 = 1 ... 67
670 / 333 = 2 ... 4

......
```

```java
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        // find sign
        String sign = ((numerator > 0) ^ (denominator > 0)) ? "-":"";
        // convert to long type to handle overflow
        long longN = Math.abs((long)numerator);
        long longD = Math.abs((long)denominator);
        sb.append(sign);
        sb.append(longN / longD);
        long rem = longN % longD;
        if(rem == 0)
            return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(rem != 0){
            if(map.containsKey(rem)){
                // start index
                int start = map.get(rem);
                String before = sb.substring(0, start);
                String repeat = "("+ sb.substring(start) +")";
                return before + repeat;
            }else
                // store the reminder and its index
                map.put(rem, sb.length());
            rem *= 10;
            sb.append(rem/longD);
            rem %= longD;
        }
        return sb.toString();
    }
}
```

