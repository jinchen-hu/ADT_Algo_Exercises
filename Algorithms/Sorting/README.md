# Sorting

## Terminology

#### What is in-place sorting?

An in-place sorting alogirthm uses constant extra space for producing the output. It sorts the list only by modifying the order of the elements within the list

#### What are internal and external sortings?

* **External sorting**: all data that needs to be sorted cannot be placed in-memory at a time. It is used for massive amount of data. Some external storage like hard-disk, CD, etc is used for external sorting
* **Internal sorting**: all data in placed in-memory

#### Stability

A sorting algorithm is said to be stable if the elements with equal keys appear in the same order in sorted output as they appear in the input array to be sorted

#### Complexity

| SORTING                           | TIME COMPLEXITY (Average) | TIME COMPLEXITY(Best) | TIME COMPLEXITY(Worst) | SPACE COMPLEXITY | IN-PLACE | STABILITY |
| --------------------------------- | :-----------------------: | :-------------------: | :--------------------: | :--------------: | :------: | :-------: |
| [Bubble sort](#Bubble-Sort)       |          O(n^2)           |         O(n)          |         O(n^2)         |       O(1)       |   YES    |    YES    |
| [Selection sort](#Selection-Sort) |          O(n^2)           |        O(n^2)         |         O(n^2)         |       O(1)       |   YES    |    NO     |
| [Insertion sort](#Insertion-Sort) |          O(n^2)           |         O(n)          |         O(n^2)         |       O(1)       |   YES    |    YES    |
| [Merge sort](#Merge-Sort)         |         O(nlgon)          |       O(nlogn)        |        O(nlogn)        |       O(n)       |    NO    |    YES    |
| [Quick sort](#Quick-Sort)         |         O(nlogn)          |       O(nlogn)        |         O(n^2)         |     O(logn)      |   YES    |    NO     |
| [Heap sort](#Heap-Sort)           |         O(nlogn)          |       O(nlogn)        |        O(nlogn)        |       O(1)       |   YES    |    NO     |
| [Counting sort](#Counting-Sort)   |          O(n+k)           |        O(n+k)         |         O(n+k)         |       O(K)       |    NO    |    YES    |
| [Bucket sort](#Bucket-Sort)       |          O(n+k)           |        O(n+k)         |         O(n^2)         |      O(n+k)      |    NO    |    YES    |
| [Radix sort](#Radix-Sort)         |          O(n*k)           |        O(n*k)         |         O(n*k)         |      O(n+k)      |    NO    |    YES    |



## Bubble Sort

**Bubble Sort** is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order. The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted.

#### Steps

1. Compara the two adjacent elements
2. If the first one is greater than the second one, then swaps them
3. Repeat untill reach the last two elements
4. Repeat 1~3 untill the sort terminates

#### Recursive Idea

1. Base Case: If array size is 1, return
2. Do one pass of normal Bubble Sort, which fixes the last element of the current subarray
3. Recur for all elements except last of current subarray

#### Animation

![bubble-sort](../../common/bubble-sort.gif)

#### Code Implementation

* [Java](BubbleSort.java)

  ```java
  import java.util.Arrays;
  
  public class BubbleSort{
      public void bubbleSort(int arr[]){
          if(arr == null || arr.length == 0)
              return;
  
          int len = arr.length;
          boolean swapped;
  
          for(int i = 0; i < len-1; ++i){
              swapped = false;
              for(int j = 0; j < len-i-1; ++j){
                  if(arr[j] > arr[j+1]){
                      swap(arr, j, j+1);
                      swapped = true;
                  }
              }
  
              // if no swaps, then break the loops
              if(!swapped)
                  break;
          }
      }
  
      public void swap(int arr[], int i, int j){
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
      }
  
      public static void main(String[] args) {
          int arr[] = {19, 45, 12, 22, 11, 90, 65};
          BubbleSort bs = new BubbleSort();
          System.out.println(Arrays.toString(arr));
          bs.bubbleSort(arr);
          System.out.println(Arrays.toString(arr));
      }
  }
  ```


* [Java-recursive](RecursiveBubbleSort)

  ```java
  import java.util.Arrays;
  
  public class RecursiveBubbleSort {
      public void recursiveBubbleSort(int arr[], int len){
          // Base Case
          if (len == 1)
              return;
          
          for(int i=0; i < len - 1; i++){
              if(arr[i] > arr[i+1])
                  swap(arr, i, i+1);
          }
  
          recursiveBubbleSort(arr, len-1);
      }
  
      public void swap(int arr[], int i, int j){
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
      }
  
      public static void main(String[] args) {
          int arr[] = {19, 45, 12, 22, 11, 90, 65};
          RecursiveBubbleSort rbs = new RecursiveBubbleSort();
          System.out.println(Arrays.toString(arr));
          rbs.recursiveBubbleSort(arr, arr.length);
          System.out.println(Arrays.toString(arr));
      }
  }
  
  ```

  

## Selection Sort

The **Selection Sort**  algorithm sorts an array by repeatedly finding the minimum element (considerting ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a give array.

#### Steps

1. Initial state: unsorted partition is R[1, ..., n], sorted partiton is null
2. When the ith (i = 1, 2, ..., n-1) starts, sorted partition is R[1, ..., i-1], unsorted part is R[i, ..., n].
   1. Cross through the unsorted partition, determine the minimal element R[k]
   2. Swap R[k] and R[i]
   3. Make R[1, ..., i] be the sorted partition, R[i+1, ..., n] be the unsorted partition
3. The array has been sorted when the (n-1)th sort terminates

#### Animation

![](../../common/selection-sort.gif) 

#### Code implemetation

* [Java](SelectionSort.java)

  ```java
  import java.util.Arrays;
  
  public class SelectionSort {
      public void selectionSort(int arr[]){
          if(arr==null || arr.length == 0)
              return;
          
          int minIndex = 0;
          int len = arr.length;
          // 
          for (int i = 0; i < len -1; ++i){
              // Current index of minimum element 
              minIndex = i;
              // Find the minimum element in unsorted subarray
              for (int j = i + 1; j < len; j++){
                  if(arr[j] < arr[minIndex])
                      minIndex = j;
              }
  
              if (minIndex != i)
                  swap(arr, i, minIndex);
          }
      }   
      
      public void swap (int arr[], int i, int j){
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
      }
  
      public static void main(String[] args) {
          int arr[] = {19, 45, 12, 22, 11, 90, 65};
          SelectionSort ss = new SelectionSort();
          System.out.println(Arrays.toString(arr));
          ss.selectionSort(arr);
          System.out.println(Arrays.toString(arr));
      }
  }
  ```

  

## Insertion Sort

**Insertion Sort** is a simple sorting algorithm that works similar to the way sorting playing cards in your hands. The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and placed at the correct postion in the sorted part

#### Steps

1. Iterate from arr[1] to arr[n]
2. Compare the target element which is the first one in the unsorted array to its previous element (predecessor)
3. If the element is smaller than its predecessor, compare it to the element before
4. Repeat step (3) until find an element that is smaller or equal to target element
5. Insert target element behind the current element
6. Repeat 2-5

#### Recursive Idea

1. Base Case: If the array size is 1 or small, return
2. Recursively sort first n-1 elements
3. Insert last element at its correct position in sorted array

#### Animation

![Insertion-Sort](../../common/insertion-sort.gif)

#### Code Implementation

* [Java](InsertionSort.java)

  ```java
  import java.util.Arrays;
  
  public class InsertionSort {
      public void insertionSort(int arr[]){
          if(arr == null || arr.length == 0)
              return;
          
          for(int i = 1; i < arr.length; ++i){
              int key = arr[i];
              int j = i - 1;
  
              while(j >= 0 && arr[j] > key){
                  arr[j+1] = arr[j];
                  j--;
              }
              arr[j+1] = key;
          }
      }
  
      public static void main(String[] args) {
          int arr[] = {19, 45, 12, 22, 11, 90, 65};
          InsertionSort is = new InsertionSort();
          System.out.println(Arrays.toString(arr));
          is.insertionSort(arr);
          System.out.println(Arrays.toString(arr));
      }
  }
  
  ```

  

* [Java-recursive](RecursiveInsertionSort.java)

  ```java
  import java.util.Arrays;
  
  public class RecursiveInsertionSort {
      public void recursiveInsertionSort(int arr[], int len){
          //Base Case
          if(len <= 1)
              return;
          // Sort first n-1 elements
          recursiveInsertionSort(arr, len-1);
          
          // Insert last element at its correct position in sorted array
          int last = arr[len-1];
          int j = len - 2;
  
          while(j >= 0 && arr[j] > last){
              arr[j+1] = arr[j];
              j--;
          }
          arr[j+1] = last;
      }
  
      public static void main(String[] args) {
          int arr[] = {19, 45, 12, 22, 11, 90, 65};
          RecursiveInsertionSort ris = new RecursiveInsertionSort();
          System.out.println(Arrays.toString(arr));
          ris.recursiveInsertionSort(arr, arr.length);
          System.out.println(Arrays.toString(arr));
      }
  }
  
  ```

  

## Merge Sort

**Merge Sort** is a Divide and Conquer algorithm. It divides input array in two halves, calls itself for the two harlves and then merge the two sorted halves.

#### Steps

1. Divide the array into two subarrays with equal size
2. Operate Merge Sort on these two subarrays
3. Merge subarrays to the final array

#### Animation

![merge-sort](../../common/merge-sort.gif)

#### Code  Implementation

* [Java](MergeSort.java)

  ```java
  import java.util.Arrays;
  
  public class MergeSort {
      public void mergeSort(int arr[]){
          mSort(arr, 0, arr.length -1);
      }
  
      private void mSort(int arr[], int l, int r){
          if(l < r){
              int m = (l+r) / 2;
  
              //Sort the left partition
              mSort(arr, l, m);
              //Sort the right partition
              mSort(arr, m+1, r);
              // merge sorted partitions
              merge(arr, l, m, r);
          }
      }
  
      private void merge(int arr[], int l, int m, int r){
          // Two partitions [l, m], [m+1, r]
          // Create a temp array
          int temp[] = new int[r-l+1];
  
          // index of the frist element in the left array
          int i = l;
          // index of the first element in the right array
          int j = m+1;
          // index of the frist element in the temp array
          int k = 0;
  
          // Merge two partitions to temp array by comparing each element 
          // one by one from left to right
          while(i <= m && j <= r){
              temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
          }
  
          // merge the remaining elements if any
          while(i <= m){
              temp[k++] = arr[i++];
          }
          while(j <= r){
              temp[k++] = arr[j++];
          }
  
          // Copy the values to original array
          for(int p = 0; p < temp.length; ++p){
              arr[l+p] = temp[p];
          }
      }
  
      public static void main(String[] args) {
          int arr[] = {19, 45, 12, 22, 11, 90, 65};
          MergeSort ms = new MergeSort();
          System.out.println(Arrays.toString(arr));
          ms.mergeSort(arr);
          System.out.println(Arrays.toString(arr));
      }
  }
  
  ```

  

## Quick Sort

**Quick Sort** is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array aroud the picked pivot

* Good Call: the sizes of two partitions are less than 3n/4
* Bad Call: the size of one of partitions are greater than 3n/4
* Generally, we pick the last element of the array as the pivot

#### Steps

1. Pick one pivot
2. Partitioning: reorder the array so that all elements less than the pivot come before the pivot, while all elements greater than the pivot come after it (equal values can go either way). After the partitioning, the pivot is in its final position.
3. Recursively aplly 1-2 to the subarrays

#### Animation

![quick-sort](../../common/quick-sort.gif)

#### Code Implementation

* [Java-v1](QuickSort.java)

  ```java
  import java.util.Arrays;
  
  public class QuickSort {
      private int partition(int arr[], int left, int right){
          int pivot = arr[right];
          int pivotIndex = right;
  
          while(left < right){
              while(left < right && arr[left] <= pivot)
                  left++;
              while(left < right && arr[right] >= pivot)
                  right--;
              swap(arr, left, right);
          }
          swap(arr, pivotIndex, right);
          return right;
      }
  
      private void swap(int arr[], int i, int j){
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
      }
  
      public void quickSort(int arr[]){
          if(arr == null || arr.length == 0)
              return;
          qSort(arr, 0, arr.length-1);
      }
  
      private void qSort(int arr[], int left, int right){
          if(left >= right)
              return;
          int pivot = partition(arr, left, right);
          qSort(arr, left, pivot-1);
          qSort(arr, pivot+1, right);
      }
  
      public static void main(String[] args) {
          int arr[] = {19, 45, 12, 22, 11, 90, 65};
          QuickSort qs = new QuickSort();
          System.out.println(Arrays.toString(arr));
          qs.quickSort(arr);
          System.out.println(Arrays.toString(arr));
      }
  }
  
  ```

* [Java-v2](QuickSortV2.java)

  ```java
  import java.util.Arrays;
  
  public class QuickSortV2 {
      private int partition(int arr[], int left, int right){
          int pivot = arr[right];
  
          for(int i = left; i < right; i++){
              if(arr[i] < pivot){
                  swap(arr, left, i);
                  left++;
              }
          }
  
          swap(arr, left, right);
          return left;
      }
  
      private void swap(int arr[], int i, int j){
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
      }
  
      private void qSort(int arr[], int left, int right){
          int partition = partition(arr, left, right);
  
          if(partition - 1 > left){
              qSort(arr, left, partition-1);
          }
          if(partition+1 < right){
              qSort(arr, partition+1, right);
          }
      }
  
      public void quickSort(int arr[]){
          if(arr == null || arr.length == 0)
              return;
          qSort(arr, 0, arr.length-1);
      }
  
      public static void main(String[] args) {
          int arr[] = {19, 45, 12, 22, 11, 90, 65};
          QuickSortV2 qs = new QuickSortV2();
          System.out.println(Arrays.toString(arr));
          qs.quickSort(arr);
          System.out.println(Arrays.toString(arr));
      }
  }
  
  ```

  

## Heap Sort

**Heap Sort** is a comparison based sorting technique based on Binary Heap data structure. It is similar to selection sort where we first find the maximum element and place the maximum element at the end

#### Steps



## Bucket Sort



## Radix Sort

