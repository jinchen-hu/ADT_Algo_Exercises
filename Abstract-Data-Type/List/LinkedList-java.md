# LinkedList

* Elements are not stored in contiguous locations and every element in a separate object with a data part and address part
* The elements are linked using pointers and addresses, known as nodes

#### Constructors

* LinkedList\<E> list = new LinkedList\<E>();

#### Basic methods

| METHOD               | DESCRIPTION                                                  |
| -------------------- | ------------------------------------------------------------ |
| add(i, e)            | inserts the specified element at the specified position in the list |
| add(e)               | appends the specified element to the end of the list         |
| addFirst(e)          | insert the specified element to the end of the list          |
| clear()              | remvoes all the elements from the list                       |
| clone()              | returns a shallow copy                                       |
| contains(Obj)        | returns true if the list contains the specified element      |
| element()/getFirst() | returns but not remove the first element                     |
| get(i)               | returns the element at the specified position                |
| getLast()            | returns the last element in the list                         |
| indexOf(Obj)         | returns the index of the first occurrance of the element, or -1 if not exits |
| lastIndexOf(Obj)     | returns the index of the last occurrance of the element, or -1 if not exits |
| remove()             | returns and remove the first element                         |
| removeLast()         | returns and remove the last element                          |
| remove(i)            | remove the element at the specified position                 |
| remove(Obj)          | removes the first occurrance of the specified element        |
| set(i, e)            | replaces the element at the specified position with the element |
| size()               | returns the number of elements in the list                   |

