# [Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/)

Given an array `A` of non-negative integers, return an array consisting of all the even elements of `A`, followed by all the odd elements of `A`.

You may return any answer array that satisfies this condition.

 

**Example 1:**

```
Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
```

## solution

```java
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length-1;
        while(left < right){
            //left is odd, right is even
            if(A[left] % 2 == 1 && A[right] % 2 == 0)
                swap(A, left++, right--);
            //both odd
            else if(A[left] % 2 == 1 && A[right] % 2 == 1)
                right--;
            //both even
            else if(A[left] % 2 == 0 && A[right] % 2 == 0)
                left++;
            //left is even, right is odd
            else{
                right--;
                left++;
            }
        }
        return A;
    }
    
    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
```

```java
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }
}
```

