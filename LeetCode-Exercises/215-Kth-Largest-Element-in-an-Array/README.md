# [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)

Find the **k**th largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

**Example 1:**

```
Input: [3,2,1,5,6,4] and k = 2
Output: 5
```

**Example 2:**

```
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
```

## Solution 1

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
```

## Solution 2

```java
class Solution {
	public int findKthLargest(int[] nums, int k) {
		return partition(nums, 0, nums.length - 1, k);
	}

	private int partition(int[] nums, int left, int right, int k) {

		getMid(nums, left, right);
		int pivotIndex = right;
		int pivot = nums[right];
		int r = right, l = left;

		while (left < right) {
			while (left < right && nums[left] <= pivot)
				left++;
			while (left < right && nums[right] >= pivot)
				right--;
			swap(nums, left, right);
		}

		swap(nums, right, pivotIndex);

		// compute the rank of the pivot
		int count = pivotIndex - right + 1;
		if (count == k)
			return nums[right];
		// kth is on the left partition
		if (count < k) {
			return partition(nums, l, right - 1, k - count);
		}
		// kth is on the right partition
		return partition(nums, right + 1, r, k);
	}

	private void swap(int nums[], int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private void getMid(int[] nums, int left, int right) {
		int mid = left + (right - left) / 2;
		if (getProductDiff(nums[left], nums[mid], nums[right]) < 0)
			swap(nums, mid, right);
		;
		if (getProductDiff(nums[mid], nums[left], nums[right]) < 0)
			swap(nums, right, left);
	}

	private int getProductDiff(int x, int y, int z) {
		return (x - y) * (z - y);
	}
}
```

