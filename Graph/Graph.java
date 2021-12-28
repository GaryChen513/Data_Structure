package Graph;

import java.util.*;

public class Graph {
  int size;
  ArrayList<ArrayList<Integer>> adj;

  public static void main(String args[]) {
    Graph graph = new Graph(6);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 3);
    graph.addEdge(2, 4);
    graph.addEdge(3, 4);
    graph.addEdge(3, 5);
    graph.print();
  }

  public Graph(int size) {
    this.size = size;
    this.adj = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      this.adj.add(new ArrayList<Integer>());
    }
  }

  public void addEdge(int a, int b) {
    if (a < 0 || a >= this.size || b < 0 || b >= this.size) {
      System.out.println("Cant add an edge between " + a + " and " + b);
      return;
    }
    this.adj.get(a).add(b);
    this.adj.get(b).add(a);
  }

  public void print() {
    for (int i = 0; i < this.adj.size(); i++) {
      System.out.print(i + " : ");
      System.out.println(this.adj.get(i).toString());
    }
  }
}
