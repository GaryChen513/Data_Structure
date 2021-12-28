package Heap;

import java.util.*;

class Heap<T extends Number & Comparable> implements Comparator<T> {
	private ArrayList<T> heap;
	private int size = 0;

	public static void main(String[] args) {
		System.out.println("Hello world");
		Heap<Integer> h = new Heap<>();
		h.insert(3);
		h.insert(2);
		h.insert(1);
		h.insert(5);
		h.insert(6);

		System.out.println(h.pop());
		h.insert(7);
		h.print();
	}

	public Heap() {
		heap = new ArrayList<T>();
	}

	public void heapify() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			int left = 2 * i + 1;
			int right = 2 * i + 2;

			if (left < size && heap.get(i).compareTo(heap.get(left)) > 0) {
				T tmp = heap.get(i);
				heap.set(i, heap.get(left));
				heap.set(left, tmp);
			}

			if (right < size && heap.get(i).compareTo(heap.get(right)) > 0) {
				T tmp = heap.get(i);
				heap.set(i, heap.get(right));
				heap.set(right, tmp);
			}
		}
	}

	public T pop() {
		T ans = heap.get(0);
		heap.set(0, heap.get(size - 1));
		size--;

		return ans;
	}

	public int size() {
		return size;
	}

	public T insert(T item) {
		if (size < heap.size()) {
			heap.set(size, item);
		} else {
			heap.add(item);
		}
		size++;
		heapify();

		return null;
	}

	public void print() {
		System.out.println(heap.toString());
	}

	@Override
	public int compare(T a, T b) {

		return a.compareTo(b);
	}
}