# [Course Schedule](https://leetcode.com/problems/course-schedule/)

## Description

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses-1`.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: `[0,1]`

Given the total number of courses and a list of prerequisite **pairs**, is it possible for you to finish all courses?

## Example

**Example 1:**

```
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
```

**Example 2:**

```
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
```

## Solution

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // compute the number of prerequisites for each course
        int[] numPre = new int[numCourses];
        int edges = prerequisites.length;
        for(int[] arr : prerequisites){
            numPre[arr[0]]++;
        }
        
        // find the courses without prerequisites
        Queue<Integer> availableCourses = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(numPre[i] == 0)
                availableCourses.add(i);
        }
        
        if(availableCourses.isEmpty())
            return false;
        
        int hasTaken = availableCourses.size();
        
        while(!availableCourses.isEmpty()){
            // pop the course means it has been taken 
            int finish = availableCourses.poll();
            // find the course whoso prerequisite is this course
            for(int[] arr : prerequisites){
                // if found, the number of pre decreases
                if(arr[1] == finish){
                    // numPre[arr[0]]--;
                    // once there is no pre, put it in available
                    if(--numPre[arr[0]] == 0){
                        hasTaken++;
                        availableCourses.add(arr[0]);
                    }
                }
            }
        }
        return hasTaken == numCourses;
    }
}
```

## Solution 2

```java
class Solution {
    private boolean[] marked;
    private boolean[] onStack;
    private boolean hasCycle;
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = initGraph(numCourses, prerequisites);
        for (int v = 0; v < numCourses; v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
        return !hasCycle();
    }
	
    private boolean hasCycle() {
        return hasCycle;
    }
	
    private void dfs(List<Integer>[] graph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : graph[v]) {
            if (hasCycle) {
                return;
            }
            if (!marked[w]) {
                dfs(graph, w);
            }
            else if (onStack[w]) {
                hasCycle = true;
            }
        }
        onStack[v] = false;
    }
	
    private List<Integer>[] initGraph(int N, int[][] edges){
        marked = new boolean[N];
        onStack = new boolean[N];
        List<Integer>[] graph = (List<Integer>[]) new LinkedList[N];
        for (int i = 0; i < N; i++) graph[i] = new LinkedList<>();
        for (int[] edge : edges) {
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }
}
```

