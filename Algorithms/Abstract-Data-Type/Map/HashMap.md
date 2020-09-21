# HashMap

* Does not allow duplicate keys but values
* Allow one null key and mutiple null values
* Does not guarantee the order

#### Constructors

* HashMap\<E, T> hm = new HashMap\<E, T>();

#### Basic methods

| METHOD                   | DESCRIPTION                                                  |
| ------------------------ | ------------------------------------------------------------ |
| clear()                  | removes all the mappings                                     |
| containsKey(k)           | returns true if the the map contains the specified key       |
| containsValue(v)         | returns true if one or more key is mapped to the value       |
| isEmpty()                | returns true if the map is empty                             |
| get(k)                   | return the value mapped by the key                           |
| getOrDefault(k, default) | returns the value with the key mapped, or default value if no mapping |
| keySet()                 | returns a set of keys                                        |
| size()                   | returns the number of mappings                               |
| remove(k)                | removes the entry with the specified key                     |
| values()                 | returns a collection of the values                           |
| entrySet()               | creates a set out of the same elements container in the map  |
| put(k, v)                | adds a key/value pair to the map                             |
| replace(k, v)            | replaces the entry with the specified key                    |

