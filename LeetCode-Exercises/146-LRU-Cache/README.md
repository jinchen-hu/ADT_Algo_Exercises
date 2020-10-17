# [LRU Cache](https://leetcode.com/problems/lru-cache/)

## Description

Design a data structure that follows the constraints of a **[Least Recently Used (LRU) cache](https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU)**.

Implement the `LRUCache` class:

- `LRUCache(int capacity)` Initialize the LRU cache with **positive** size `capacity`.
- `int get(int key)` Return the value of the `key` if the key exists, otherwise return `-1`.
- `void put(int key, int value)` Update the value of the `key` if the `key` exists. Otherwise, add the `key-value` pair to the cache. If the number of keys exceeds the `capacity` from this operation, **evict** the least recently used key.

**Follow up:**
Could you do `get` and `put` in `O(1)` time complexity?

## Example

```
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
```

## Solution

```java
class LRUCache {
    DoublyList list;
    int capacity;
    Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        list = new DoublyList();
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.get(key) == null)
            return -1;
        Node node = map.get(key);
        list.moveToFirst(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            node.value = value;
            list.moveToFirst(node);
        }else{
            Node newNode = new Node(key, value);
            if(map.size() == capacity){
                Node last = list.removeLast();
                map.remove(last.key);
            }
            list.addToFirst(newNode);
            map.put(key, newNode);
        }      
    }
    
    class Node{
        Node pre;
        Node next;
        int key;
        int value;
        
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }       
    }
    
    class DoublyList{
        Node head;
        Node tail;
        DoublyList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }
        
        void addToFirst(Node node){
            Node temp = head.next;
            head.next = node;
            node.pre = head;
            node.next = temp;
            temp.pre = node;
        }
        
        void moveToFirst(Node node){
            // disconnect
            node.pre.next = node.next;
            node.next.pre = node.pre;
            addToFirst(node);
        }
        
        Node removeLast(){
            Node temp = tail.pre;
            temp.pre.next = tail;
            tail.pre = temp.pre;
            temp.next = null;
            temp.pre = null;
            return temp;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```

