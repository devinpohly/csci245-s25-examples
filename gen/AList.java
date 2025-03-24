public class AList<E, O> {
	private static class Node<I, N> {
		private I item;
		private Node<N, I> next;

		public Node(I item, Node<N, I> next) {
			this.item = item;
			this.next = next;
		}

		public String toString() {
			if (next == null) {
				return this.item.toString();
			}
			return this.item + ", " + next.toString();
		}
	}

	private Node<E, O> head = null;

	public String toString() {
		if (head == null) {
			return "[]";
		} else {
			return "[" + head + "]";
		}
	}

	public void addFirst(E even, O odd) {
		this.head = new Node<E, O>(even, new Node<O, E>(odd, this.head));
	}

	public AList<O, E> addFirst(O odd) {
		AList<O, E> al = new AList<>();
		al.head = new Node<>(odd, this.head);
		return al;
	}

	public E getFirst() {
		return head.item;
	}

	public static void main(String[] args) {
		AList<Integer, String> l = new AList<>();
		AList<Integer, String> l2 = l.addFirst("foo").addFirst(3).addFirst("four").addFirst(5);
		System.out.println(l2);
		l2.addFirst(11, "eleven");
		System.out.println(l2);
	}
}
