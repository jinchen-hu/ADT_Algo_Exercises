# [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)

Given a non-empty array of integers, return the ***k\*** most frequent elements.

**Example 1:**

```
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
```

**Example 2:**

```
Input: nums = [1], k = 1
Output: [1]
```

## Solution 1

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length) return nums;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(int num : map.keySet()){
            minHeap.add(num);
            if(minHeap.size() > k)
                minHeap.poll();
        }
        
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--)
            result[i] = minHeap.poll();
        
        return result;
        
    }
}
```

## Solution 2

```java
class Solution {
  public int[] topKFrequent(int[] nums, int k) {
      int res[]=new int [k];
      Map<Integer,Integer> map = new HashMap<>();
      List<Integer>[] counts = new List[nums.length+1];
      // count the occurrence of each num
      for (int num : nums)
          map.put(num, map.getOrDefault(num, 0)+1);
		
      // index indicates the occuarrency
      // each list stores the num with same count
      for(int key : map.keySet()){
          if(counts[map.get(key)] == null)
              counts[map.get(key)] = new ArrayList();
          counts[map.get(key)].add(key);
      }
      int j = 0;
      for (int i=nums.length; k>0; i--) {
          if(counts[i] != null){
              for (int p=0; p<counts[i].size() && k>0; p++){
                  res[j++]=counts[i].get(p);
                  k--;
              }
          }
      }
      return res;
    }
}
```

