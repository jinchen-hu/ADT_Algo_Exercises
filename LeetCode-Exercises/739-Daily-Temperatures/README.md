# [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)

Given a list of daily temperatures `T`, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put `0` instead.

For example, given the list of temperatures `T = [73, 74, 75, 71, 69, 72, 76, 73]`, your output should be `[1, 1, 4, 2, 1, 1, 0, 0]`.

**Note:** The length of `temperatures` will be in the range `[1, 30000]`. Each temperature will be an integer in the range `[30, 100]`.

## Solution

```java
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        if(n == 0){
            return T;
        }
        
        int[] result = new int[n];
        result[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--){
            if(T[i] < T[i + 1]){
				// set to 1 if we just have a larger number on the right
                result[i] = 1;
            }else{
				// otherwise, we keep searching until we find one
				// the while loop here is pretty similar to the idea in #84 and #85
                int j = i + 1;
                while(j < n && T[j] <= T[i] && result[j] != 0){
                    j = j + result[j];
                }
                if(j < n && T[j] > T[i]){
                    result[i] = j - i;
                }else{
                    result[i] = 0;
                }
            }
        }
        return result;
    }
}
```

