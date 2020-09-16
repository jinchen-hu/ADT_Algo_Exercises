# Tree

A **tree** is an abstract model of a hierachical structure, consisiting of a node with parent-child relation

#### Attribute

* Root: node without parent
* internal node: node with at least one child
* external node: node without children
* Ancestor of node: parent, grandparent, ...
* depth of a node: number of ancestors
* height of a node: maximum depth of any node (longest path to the leaf), the number of edges in the path
* descendant of a node: child, grandchild, ...

#### Traversal

* Preorder
  * root -> left subtree -> right subtree
* postorder
  * left subtree -> right subtree -> root
* inorder
  * left subtree -> root ->right subtree

#### Links

* [Binary Tree](Bianry-Tree.md)
* [Binary Search Tree](Binary-Search-Tree.md)
* [Heap](Heap.md)
* [AVL Tree](AVL-Tree.md)
* [Red-Black Tree](Red-Black-Tree.md)