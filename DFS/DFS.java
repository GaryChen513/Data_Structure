package DFS;

import java.util.*;

public class DFS {
  int[][] graph;

  public static void main(String[] args) {
    int[][] adj = {
        { 1, 2 },
        { 0, 2, 3 },
        { 0, 1, 3, 4 },
        { 1, 2, 4, 5 },
        { 2, 3 },
        { 3 },
    };

    DFS dfs = new DFS(adj);
    dfs.printPath(0);
  }

  public DFS(int[][] graph) {
    this.graph = graph;
  }

  public void printPath(int start) {
    Stack<Integer> stack = new Stack<>();
    HashSet<Integer> seen = new HashSet<>();
    stack.push(start);

    while (stack.size() != 0) {
      int cur = stack.pop();

      if (!seen.contains(cur)) {
        System.out.print(cur + " -> ");
        seen.add(cur);
      }

      int[] neighbors = this.graph[cur];
      for (int i = 0; i < neighbors.length; i++) {
        int next = neighbors[i];
        if (!seen.contains(next)) {
          stack.push(next);
        }
      }
    }

  }
}
