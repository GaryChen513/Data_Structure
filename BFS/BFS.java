package BFS;

import java.util.*;

public class BFS {
  ArrayList<ArrayList<Integer>> adj;

  public static void main(String[] args) {
    int[][] connections = {
        { 1, 2 },
        { 0, 2, 3 },
        { 0, 1, 3, 4 },
        { 1, 2, 4, 5 },
        { 2, 3 },
        { 3 },
    };
    BFS bfs = new BFS(connections);
    int distance = bfs.search(0, 2);
    System.out.println(distance);
  }

  public BFS(int[][] arr) {
    this.adj = buildAdjList(arr);
  }

  private ArrayList<ArrayList<Integer>> buildAdjList(int[][] arr) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      ArrayList<Integer> sub_adj = new ArrayList<>();

      for (int j = 0; j < arr[i].length; j++) {
        sub_adj.add(arr[i][j]);
      }

      adj.add(sub_adj);
    }

    return adj;
  }

  public int search(int a, int b) {
    LinkedList<Integer> queue = new LinkedList<>();
    queue.offer(a);
    HashSet<Integer> seen = new HashSet<>();
    int distance = -1;

    while (!queue.isEmpty()) {
      distance++;
      int size = queue.size();

      // iterate current level
      for (int j = 0; j < size; j++) {
        int cur = queue.poll();
        seen.add(cur);

        // add neighbors to queue
        ArrayList<Integer> neighbors = this.adj.get(cur);
        for (int i = 0; i < neighbors.size(); i++) {
          int next = neighbors.get(i);
          if (seen.contains(next))
            continue;

          if (next == b) {
            return distance + 1;
          }
          queue.offer(next);
        }
      }
    }

    return -1;
  }
}
