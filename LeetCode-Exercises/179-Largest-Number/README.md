# [Largest Number](https://leetcode.com/problems/largest-number/)

Given a list of non-negative integers `nums`, arrange them such that they form the largest number.

**Note:** The result may be very large, so you need to return a string instead of an integer.

 

**Example 1:**

```
Input: nums = [10,2]
Output: "210"
```

**Example 2:**

```
Input: nums = [3,30,34,5,9]
Output: "9534330"
```

**Example 3:**

```
Input: nums = [1]
Output: "1"
```

**Example 4:**

```
Input: nums = [10]
Output: "10"
```

 

**Constraints:**

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 109`

## Explanation

Sort the array as following:

* if a~b > b~a ====> a>b
  * 30~3=303, 3~30=330, 
  * 330>303 ====> 3>30
* 34~3 > 3~30 > 30~3 ===> 3430 > 3034

Therefore, the comparator preserves transitivity

## Solution

```java
class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";
        if(nums.length == 1)
            return String.valueOf(nums[0]);
        String s[] = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            s[i] = String.valueOf(nums[i]);
        }
        
        //Arrays.sort(s,(a,b)->(b+a).compareTo(a+b));
        Arrays.sort(s, new Comparator<String>(){
            public int compare(String a, String b){
                return (b+a).compareTo(a+b); 
            }
        });
        
        if(s[0].equals("0"))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String str: s){
            sb.append(str);
        }
        return sb.toString();   
    }
}
```

