public class LList<T> {
	private static class Node<I> {
		private I item;
		private Node<I> next;

		public Node(I item, Node<I> next) {
			this.item = item;
			this.next = next;
		}

		public void addLast(I item) {
			if (this.next == null) {
				this.next = new Node<I>(item, this.next);
			} else {
				this.next.addLast(item);
			}
		}
	}

	private Node<T> head = null;

	public String toString() {
		String result = "[";
		for (Node<T> current = head; current != null; current = current.next) {
			result += current.item;
			if (current.next != null) {
				result += ", ";
			}
		}
		return result + "]";
	}

	public void addFirst(T item) {
		head = new Node<T>(item, head);
	}

	public void addLast(T item) {
		if (head == null) {
			addFirst(item);
			return;
		}
		head.addLast(item);
	}

	public void addAll(LList<? extends T> other) {
		if (head == null) {
			// add starting at head
			return;
		}
		Node<T> current = head;
		while (current.next != null) {
			current = current.next;
		}
		Node<? extends T> otherCurrent = other.head;
		while (otherCurrent != null) {
			current.next = new Node<T>(otherCurrent.item, null);
			current = current.next;
			otherCurrent = otherCurrent.next;
		}
		other.addFirst(this.head.item);
	}

	public void addAllTo(LList<? super T> other) {
		if (other.head == null) {
			// add starting at head
			return;
		}
		Node<T> otherCurrent = other.head;
		while (otherCurrent.next != null) {
			otherCurrent = otherCurrent.next;
		}
		Node<T> thisCurrent = head;
		while (thisCurrent != null) {
			otherCurrent.next = new Node<T>(thisCurrent.item, null);
			otherCurrent = otherCurrent.next;
			thisCurrent = thisCurrent.next;
		}
	}

	public static void main(String[] args) {
		// LList<Integer> l = new LList<>();
		// l.addFirst(3);
		// l.addFirst(2);
		// l.addFirst(1);
		// l.addLast(4);
		// l.addLast(5);
		// System.out.println(l);
		// LList<Integer> l2 = new LList<>();
		// l2.addFirst(13);
		// l2.addFirst(12);
		// l2.addFirst(11);
		// l2.addLast(14);
		// l2.addLast(15);
		// System.out.println(l2);
		// LList<String> l3 = new LList<>();
		// l3.addFirst("broken");

		LList<Pigeon> l = new LList<>();
		l.addFirst(new Pigeon());
		l.addFirst(new Pigeon());
		l.addFirst(new Pigeon());
		l.addFirst(new Pigeon());

		LList<Bird> l2 = new LList<>();
		l2.addFirst(new Penguin());
		l2.addFirst(new Pigeon());
		l2.addFirst(new Toucan());
		l2.addFirst(new Toucan());
		l2.addFirst(new UrbanPigeon());

		// l.addAll(l2);
		System.out.println(l);
		System.out.println(l2);

		// l2.addAll(l);
		l.addAllTo(l2);
		System.out.println(l2);
	}
}
