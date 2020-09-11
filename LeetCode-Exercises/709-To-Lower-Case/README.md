# [To Lower Case](https://leetcode.com/problems/to-lower-case/)

## Description

Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

## Example

```java
Input: "Hello"
Output: "hello"
```

## Solution 1

#### Explanation

* Utilize java built-in method

```java
class Solution {
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }
}
```

## Solution 2

#### Explanation

1. According to ASCII table, the lowercase - uppercase = 32
2. Traverse the string
   * if the current character is between 65 and 90, inclusive
   * add 32 to change it to uppercase
   * append the character to the new string

```java
class Solution {
    public String toLowerCase(String str) {
        String s = "";
        int len = str.length();
        char ch;
        for(int i = 0; i < len; i++){
            ch = str.charAt(i);
            if(ch <=90 && ch >=65)
                ch +=32;
            s+=ch;
        }
        return s;
    }
}
```

