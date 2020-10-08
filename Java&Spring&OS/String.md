# String

| METHOD                               | DESCRIPTION                                                  | RETURN TYPE |
| :----------------------------------- | :----------------------------------------------------------- | :---------- |
| charAt(int i)                        | returns the char at the specific index                       | char        |
| compareTo(String s, String t)        | compares two strings lexicographically                       | int         |
| contains(String t)                   | checks whether a string contains a sequence of chars         | boolean     |
| endsWith(char)                       | checks wheter a string ends with the specified chars         | boolean     |
| equals(String t)                     | returns true if two strings are equal                        | boolean     |
| equalsIngoreCase(String t)           | returns true if two strings are equal ignoring cas           | boolean     |
| indexOf(String)                      | returns the position of the first occurrence of the chars    | int         |
| lastIndexOf(String s)                | returns the position of the last occurrence of the chars     | int         |
| matches(Pattern p)                   | searches a string for a match aagainst a regular expression  | boolean     |
| replace(Char old, Char new)          | returns a new string by replacing all old char with new char | String      |
| replaceAll(String regex, String new) | returns a string replacing all matching sequence             | String      |
| substring(int i, int j)              | returns the substring from ith character to j-1 index        | String      |
| toLowerCase()                        | converts all chars to lowercase                              | String      |
| toUpperCase()                        | converts all chars to uppercase                              | String      |
| toCharArray()                        | converts the string to a new char array                      | char[]      |

# StringBuilder

#### Constructors

```java
StringBuilder sb = new StringBuilder();
StringBuilder sb = new StringBuilder(String s);

```

#### Methods

| METHODS                 | DESCRIPTION                                 | RETURN TYPE   |
| ----------------------- | ------------------------------------------- | ------------- |
| append(String s)        | appends the string to the sequence          | StringBuilder |
| length()                | returns the length                          | int           |
| charAt(int i)           | returns the char value in the sequence      | char          |
| delete(int s, int e)    | removes the char between s and e-1          | StringBuilder |
| indexOf(String s)       | returns the index with the first occurrence | int           |
| lastIndexOf(String s)   | returns the index with the last occurrence  | int           |
| insert(int i, String s) | inserts s from index i                      | StringBuilder |
| reverse()               | reverses the sequence                       | StringBuilder |

