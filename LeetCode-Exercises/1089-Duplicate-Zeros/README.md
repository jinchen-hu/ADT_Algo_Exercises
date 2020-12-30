# [Duplicate Zeros](https://leetcode.com/problems/duplicate-zeros/)

Given a fixed length array `arr` of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array **in place**, do not return anything from your function.

 

**Example 1:**

```
Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
```

**Example 2:**

```
Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]
```

## Solution 1

```java
class Solution {
    public void duplicateZeros(int[] arr) {
        int count = -1;
        int i = 0;
        boolean endOneZero = false;
        for(; i < arr.length-1; i++){
            if(arr[i]==0){
                count++;
                if(count == arr.length-1){
                    endOneZero = true;
                    break;
                }
                count++;
            }
            else
                count++;
            if(count == arr.length-1)
                break;
        }
        
        for(int j = arr.length-1; j >=0&&i>=0; j--, i--){
            arr[j] = arr[i];
            if(arr[i] == 0 && j>0 && !(j == arr.length - 1 && endOneZero)){
                    arr[--j] = 0;
            }
            //i--;
        }
        
    }
}
```

