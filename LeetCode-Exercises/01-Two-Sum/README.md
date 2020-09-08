# [01. Two Sum](https://leetcode.com/problems/two-sum/)

## Description

Given an array of integers `nums` and an integer `target`, return *indices of the two numbers such that they add up to `target`*.

You may assume that each input would have **exactly one solution**, and you may not use the *same* element twice.

You can return the answer in any order.

## Example

```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
```

## Solution 1

#### Explanation

1. Uses two for-loops
2. The frist for-loop records the first number and its index
3. The second records the seconde number, its index, and sum of two numbers
4. Terminates until getting the given target number

* Time Complexity: O(n*2)

* Space Complexity: O(1)

```java
public int[] twoSum(int[] nums, int target) {
		int i, j;
    int result[] = new int[2];
    for(i = 0; i < nums.length - 1; i++){
        for(j = i+1; j < nums.length; j++){
            if(nums[i] + nums[j] == target){
            		result[0] = i;
                result[1] = j;
                return result;
            };
        }
    }
    return null;
}    
```

## Solution 2

#### Explanation

1. Create a HashMap
2. Traverse the given array, compute the difference between the current element and target number
3. If the difference is present in the HashMap, return the result
4. Otherwise, store the value/index as a k/v pair in the map

* Time Complexity: O(n)

* Space Complexity: O(n)

#### Animation

![1.two-sum](../../common/1-two-sum.gif)

```java
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                result[0] = map.get(diff);
                result[1] = i;
                return result;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return null;
    }    
```

