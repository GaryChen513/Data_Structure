package BST;

import java.util.*;

public class BST {
  public Node root;

  public static void main(String[] args) {
    BST bst = new BST(new Node(6));
    bst.insert(4);
    bst.insert(12);
    bst.insert(2);
    bst.insert(10);
    bst.level_print();

    bst.delete(4);
    bst.level_print();
  }

  public BST(Node root) {
    this.root = root;
  }

  public BST() {
    this.root = null;
  }

  public void insert(int val) {
    if (this.root == null) {
      this.root = new Node(val);
      return;
    }

    insert_solver(this.root, val);
  }

  public boolean search(int val) {
    Node cur = this.root;

    while (cur != null) {
      if (cur.val < val) {
        cur = cur.left;
      } else if (cur.val > val) {
        cur = cur.right;
      } else {
        return true;
      }
    }

    return false;
  }

  public void delete(int val) {
    if (this.root == null) {
      System.out.println("Error No node in the tree");
      return;
    }

    delete_solver(this.root, val);

  }

  private Node insert_solver(Node cur, int val) {
    if (cur == null) {
      return new Node(val);
    }

    if (val < cur.val) {
      cur.left = insert_solver(cur.left, val);
    } else if (val > cur.val) {
      cur.right = insert_solver(cur.right, val);
    } else {
      return cur;
    }

    return cur;
  }

  private Node delete_solver(Node cur, int val) {
    if (cur == null) {
      return cur;
    }

    if (val < cur.val) {
      cur.left = delete_solver(cur.left, val);
    } else if (val > cur.val) {
      cur.right = delete_solver(cur.right, val);
    } else {
      if (cur.left == null) {
        return cur.right;
      }
      if (cur.right == null) {
        return cur.left;
      }
      Node tmp = cur.right;
      while (tmp.left != null) {
        tmp = tmp.left;
      }
      cur.val = tmp.val;
      cur.right = delete_solver(cur.right, tmp.val);
    }

    return cur;
  }

  public void level_print() {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(this.root);

    while (queue.size() > 0) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node cur = queue.poll();
        System.out.print(cur.val + " ");
        
        if (cur.left != null)
          queue.add(cur.left);
        if (cur.right != null)
          queue.add(cur.right);
      }

      System.out.println();
    }
  }
}
