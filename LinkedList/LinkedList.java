package LinkedList;

public class LinkedList {
  public Node tail;
  public Node head;

  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.add(2);
    ll.add(1);
    ll.remove(1);
    ll.add(4);
    ll.print();
  }

  public LinkedList(Node node) {
    this.tail = node;
    this.head = node;
  }

  public LinkedList() {
    this.tail = null;
  }

  public boolean search(int val) {
    Node cur = head;
    while (cur != null) {
      if (cur.val == val)
        return true;
      cur = cur.next;
    }
    return false;
  }

  public void remove(int val) {
    if (this.head == null)
      return;
    Node cur = head;
    Node prev = null;

    while (cur.next != null && cur.val != val) {
      prev = cur;
      cur = cur.next;
    }

    if (prev != null) {
      prev.next = cur.next;
    } else {
      this.head = null;
    }

    if (cur == this.tail) {
      this.tail = prev;
    }
  }

  public void add(int val) {
    if (this.tail == null) {
      this.head = new Node(val);
      this.tail = this.head;
      return;
    }

    this.tail.next = new Node(val);
    this.tail = this.tail.next;
  }

  public void print() {
    Node cur = this.head;
    while (cur != null) {
      System.out.print(cur.val + " ");
      cur = cur.next;
    }
    System.out.println();
  }
}
