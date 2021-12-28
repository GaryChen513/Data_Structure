package ArrayList;

public class ArrayList<T> {
  private int size;
  private T[] arr;

  public static void main(String[] args) {
    ArrayList<String> al = new ArrayList<>();
    al.add("Hello");
    al.add("My");
    al.add("Friend");
    al.add("my");
    al.add("name");
    al.add("is");
    al.add("Gary");

    System.out.println(al.get(6));
  }

  public ArrayList() {
    arr = (T[]) new Object[5];
  }

  public void add(T element) {
    size++;
    this.arr[size - 1] = element;

    if (size == this.arr.length) {
      T[] new_arr = (T[]) new Object[size * 2];
      for (int i = 0; i < size; i++) {
        new_arr[i] = arr[i];
      }

      this.arr = new_arr;
    }
  }

  public T remove(int x) {
    if (x >= size) {
      System.out.println("Index excceded the size of array");
      return null;
    }

    if (x < 0) {
      System.out.println("Index should not be less than 0");
      return null;
    }

    T ans = arr[x];

    for (int i = x; i <= size; i++) {
      arr[i] = arr[i + 1];
    }
    size--;

    return ans;
  }

  public T pop() {
    T ans = arr[size - 1];
    size--;

    return ans;
  }

  public T get(int i) {
    if (i >= size) {
      System.out.println("Index excceded the size of array");
      return null;
    }

    if (i < 0) {
      System.out.println("Index should not be less than 0");
      return null;
    }
    return arr[i];
  }

  public T set(int i, T item) {
    if (i >= size) {
      System.out.println("Index excceded the size of array");
      return null;
    }

    if (i < 0) {
      System.out.println("Index should not be less than 0");
      return null;
    }

    arr[i] = item;
    return null;
  }
}
