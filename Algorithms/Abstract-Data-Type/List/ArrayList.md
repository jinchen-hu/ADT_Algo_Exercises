# ArrayList

The **ArrayList** provides dynamic arrays

#### Constructor

* ArrayList\<E> list = new ArrayList\<E>();

#### Basic methods

| METHOD           | DESCRIPTION                                                  |
| ---------------- | ------------------------------------------------------------ |
| add(i, e)        | inserts a specified element at the specified position        |
| add(e)           | appends the element to the end of the list                   |
| contains(e)      | returns true if the list contains the specified element      |
| get(i)           | returns the element at specified position                    |
| indexOf(e)       | returns the index of the first occurrance of the element     |
| isEmpty()        | returns true if the list is empty                            |
| lastIndexOf()    | returns the index of the last occurrance of the element      |
| remove(i)        | removes the lements at the specified position                |
| remove(e)        | removes the first occurrance ofthe specified element         |
| removeRange(i,j) | removes the elements whose index is between i, inclusive, and j, exclusive |
| set(i, e)        | replaces the element at the specified position in the list   |
| size()           | returns the number of the elements in the list               |
| subList(i, j)    | returns a view of portion of the list between i, inclusive, and j, exclusive |
| trimToSize()     | trims the capacity of the instance of the list to the current size |

