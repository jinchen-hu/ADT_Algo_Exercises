# ZigZag Conversion

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

```
P   A   H   N
A P L S I I G
Y   I   R
```

And then read line by line: `"PAHNAPLSIIGYIR"`

Write the code that will take a string and make this conversion given a number of rows:

```
string convert(string s, int numRows);
```

 

**Example 1:**

```
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
```

**Example 2:**

```
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
```

**Example 3:**

```
Input: s = "A", numRows = 1
Output: "A"
```

## Solution

```java
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        // initialize the stringbuilder array
        for(int i = 0; i < numRows; i++){
            sbs[i] = new StringBuilder();
        }
        
        char[] cs = s.toCharArray();
        int len = cs.length;
        int p = 0;
        while(p < len){
            // Top to bottom
            for(int i = 0; i < numRows && p < len; i++){
                sbs[i].append(cs[p++]);
            }
            
            // diagonal
            for(int i = numRows - 2; i > 0 && p < len; i--){
                sbs[i].append(cs[p++]);
            }
        }
        
        for(int i = 1; i < numRows; i++){
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }
}
```

