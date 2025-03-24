public class LList<T> {
	private class Node {
		private T item;
		private Node next;

		public Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}

		public void addLast(T item) {
			if (this.next == null) {
				this.next = new Node(item, this.next);
			} else {
				this.next.addLast(item);
			}
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

	public void addFirst(T item) {
		head = new Node(item, head);
	}

	public void addLast(T item) {
		if (head == null) {
			addFirst(item);
			return;
		}
		head.addLast(item);
	}

	public static void main(String[] args) {
		LList<Integer> l = new LList<>();
		l.addFirst(3);
		l.addFirst(2);
		l.addFirst(1);
		l.addLast(4);
		l.addLast(5);
		System.out.println(l);
	}
}
