public class SortedList<T extends Comparable<T>> {
	private class Node {
		private T item;
		private Node next;

		public Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	private Node head = null;

	public String toString() {
		String result = "[";
		for (Node current = head; current != null; current = current.next) {
			result += current.item;
			if (current.next != null) {
				result += ", ";
			}
		}
		return result + "]";
	}

	public void add(T item) {
		if (head == null) {
			head = new Node(item, head);
			return;
		}
		if (item.compareTo(head.item) < 0) {
			head = new Node(item, head);
			return;
		}
		Node current = head;
		while (current.next != null && current.next.item.compareTo(item) < 0) {
			current = current.next;
		}
		current.next = new Node(item, current.next);
	}

	public static void main(String[] args) {
		SortedList<Integer> l = new SortedList<>();
		l.add(3);
		l.add(2);
		l.add(1);
		l.add(4);
		l.add(5);
		System.out.println(l);
		SortedList<String> ls = new SortedList<>();
		ls.add("hello");
		ls.add("~");
		ls.add("world");
		ls.add("");
		ls.add("123");
		ls.add("!!123");
		ls.add("World");
		System.out.println(ls);
	}
}
