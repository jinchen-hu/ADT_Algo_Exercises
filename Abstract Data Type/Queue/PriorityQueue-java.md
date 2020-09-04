# PriorityQueue

* A **PriorityQueue** is used when the objects are supposed to be processed based on the priority

* It is based on the priority heap
* The elements of the priority queue are ordered according to the natural ordering, or by a Comparator provided at queue construction time, depending on which constructor is used

#### Constructors

* PriorityQueue\<E> pQueue = new PriorityQueue\<E>()

#### Basic methods

| METHOD      | DESCRIPTION                                                  |
| ----------- | ------------------------------------------------------------ |
| add(E)      | inserts the specified element into the priority queue        |
| remove(E)   | removes a single instance of the specified element if it is present |
| poll()      | retrieves and removes the head of the queue, or null if it is empty |
| peek()      | returns but not remove the head of the queue, or null if it is empty |
| contains(E) | returns true if the queue contains the specified element     |
| clear()     | removes all of the contents                                  |
| size()      | returns the number of elements in the queue                  |

