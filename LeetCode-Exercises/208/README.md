# [Implement Trie](https://leetcode.com/problems/implement-trie-prefix-tree/)

## Description

Implement a trie with `insert`, `search`, and `startsWith` methods.

**Example:**

```
Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
```

## Solution

```java
class Trie {

    private TrieNode root;
    
    private class TrieNode {
        TrieNode[] characters = new TrieNode[26];
        boolean end;
    }
    
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tmp = root;
        for(int i=0;i<word.length();i++){
            int idx= word.charAt(i) - 'a';
            if(tmp.characters[idx]==null){
                tmp.characters[idx] = new TrieNode();
            }
            tmp = tmp.characters[idx];
        }
        tmp.end=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node==null?false:node.end;
    } 
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchNode(prefix)!=null;
    }
    
    private TrieNode searchNode(String word) {
        TrieNode tmp = root;
        for(int i=0;i<word.length();i++) {
            int idx = word.charAt(i)-'a';
            if(tmp.characters[idx]==null) {
                return null;
            }
            tmp=tmp.characters[idx];
        }
        return tmp;
    }   
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```

