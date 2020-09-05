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

#### Animation

![bubble-sort](../common/bubble-sort.gif)

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

![](../common/selection-sort.gif) 

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

  

