# Stack

#### Declaration

* Stack\<E> stack = new Stack\<E>(); 

#### Basic methods

| METHOD    | DESCRIPTION                                                  |
| --------- | ------------------------------------------------------------ |
| empty()   | returns true if nothing is on the top of the stack. Else, returns false |
| peek()    | returns the elements on the top of the stack, but does not remove it |
| pop()     | removes and returns the top element of the stack             |
| push(O)   | pushes an element on the top of the stack                    |
| search(O) | it determines whether an object exists in the stack. If the element is found, it returns the position of the element from the stack, -1 otherwise |

#### Method inherits from Vector

| METHOD                  | DESCRIPTION                                                  |
| ----------------------- | ------------------------------------------------------------ |
| add(i, Obj)             | inserts the specified eleement at the specified position     |
| addAll(i, Obj)          | appends all the elements in the specified collection at the specified position |
| clear()                 | removes all the elements                                     |
| clone()                 | returns a clone of this vector                               |
| contains(Obj)           | returns true if this vector contains the specified element   |
| containsAll(Col)        | returns true if the vector contains all the elements in the specified collection |
| firstElement()          | returns the first element (index 0)                          |
| get(i)                  | returns the element at the specified position                |
| indexOf(Obj)            | returns the index of the first occurrance of the specified element |
| insertElementAt(Obj, i) | inserts the element at the specified index                   |
| lastIndexOf(Obj)        | returns the index of the last occurrance of the element, or -1 |
| remove(i)               | removes the element at the specified position                |
| remove(Obj)             | removes the first occurrance of the specified element        |
| set(i, Obj)             | replaces the element at the specified position with the element |



#### Links

* [Stack-java](Stack-java.md)

