# Heap

A **Heap** is a complete binary tree sorting keys as its nodes and satisfying:

* Max-Heap:
  * the key present at the root node must be greatest among the keys present at all of its children.
  * key(v) <= key(parent(v))
* Min-Heap:
  * key(v) >= key(parent(v))

#### Height of a Heap:

A heap storing n keys has height O(logn)

#### Insertion into a heap

1. Find the new last node z

2. Store k at z

3. Restore the heap-order properly

   **Up-heap**: swap k along an upward path from the insertion node, terminates when k reaches the root or a node whose parent has a key smaller than or equal to k

#### Removal form a Heap

1. Replace the root key with the key of the last node w

2. Remove w

3. Restore the heap order

   **Down-heap**: swap k along a downward path from the root, terminates when k reaches a leaf or a node whose children have keys greater or equal to k

