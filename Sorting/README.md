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

| SORTING                | TIME COMPLEXITY (Average) | TIME COMPLEXITY(Best) | TIME COMPLEXITY(Worst) | SPACE COMPLEXITY | IN-PLACE | STABILITY |
| ---------------------- | :-----------------------: | :-------------------: | :--------------------: | :--------------: | :------: | :-------: |
| [Bubble sort](#Bubble) |          O(n^2)           |         O(n)          |         O(n^2)         |       O(1)       |   YES    |    YES    |
| Selection sort         |          O(n^2)           |        O(n^2)         |         O(n^2)         |       O(1)       |   YES    |    NO     |
| Insertion sort         |          O(n^2)           |         O(n)          |         O(n^2)         |       O(1)       |   YES    |    YES    |
| Merge sort             |         O(nlgon)          |       O(nlogn)        |        O(nlogn)        |       O(n)       |    NO    |    YES    |
| Quick sort             |         O(nlogn)          |       O(nlogn)        |         O(n^2)         |     O(logn)      |   YES    |    NO     |
| Heap sort              |         O(nlogn)          |       O(nlogn)        |        O(nlogn)        |       O(1)       |   YES    |    NO     |
| Bucket sort            |          O(n+k)           |        O(n+k)         |         O(n^2)         |      O(n+k)      |    NO    |    YES    |
| Radix sort             |          O(n*k)           |        O(n*k)         |         O(n*k)         |      O(n+k)      |    NO    |    YES    |

## Bubble Sort



