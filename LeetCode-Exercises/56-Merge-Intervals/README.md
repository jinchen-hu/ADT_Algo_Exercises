# [Merge Intervals](https://leetcode.com/problems/merge-intervals/)

## Description

Given a collection of intervals, merge all overlapping intervals.

## Example

```
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
```

```
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```

## Solution

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        LinkedList<int[]> res = new LinkedList<>();
        for(int[] interval : intervals){
            if(res.isEmpty() || interval[0] > res.getLast()[1])
                res.add(interval);
            else{
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
```

