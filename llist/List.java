public class List {
	private ListNode head;

	public List() {
		head = null;
	}

	public void addFirst(int d) {
		ListNode newNode = new ListNode(d, head);
		this.head = newNode;
	}

	public int removeFirst() {
		int d = head.datum;
		head = head.next;
		return d;
	}

	public void addLast(int d) {
		ListNode newNode = new ListNode(d, null);
		if (this.head == null) {
			head = newNode;
			return;
		}

		ListNode current = this.head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}

	public void addLastR(int d) {
		if (this.head == null) {
			ListNode newNode = new ListNode(d, null);
			head = newNode;
			return;
		}
		this.head.addLast(d);
	}

	public int get(int index) {
		int n = 0;
		ListNode current = this.head;
		while (n < index) {
			current = current.next;
			n++;
		}
		return current.datum;
	}

	public int getR(int index) {
		return head.get(index);
	}

	public String toString() {
		String s = "[";
		for (ListNode current = this.head;
			current != null;
			current = current.next) {
			if (current == this.head) {
				s += current.datum;
			} else {
				s += "," + current.datum;
			}
		}
		s += "]";
		return s;
	}

	public void selectionSort() {
		if (head == null || head.next == null) {
			return;
		}

		ListNode sorted = null;
		ListNode rest = head;

		while (rest != null) {
			int biggest = rest.datum;
			ListNode preBiggest = null;
			for (ListNode current = rest; current.next != null; current = current.next) {
				if (current.next.datum > biggest) {
					biggest = current.next.datum;
					preBiggest = current;
				}
			}
			ListNode temp;
			if (preBiggest == null) {
				temp = rest;
				rest = rest.next;
			} else {
				temp = preBiggest.next;
				preBiggest.next = preBiggest.next.next;
			}
			temp.next = sorted;
			sorted = temp;
		}

		head = sorted;
	}

	public void mergeSort() {
		if (this.head == null) {
			return;
		}
		head = head.mergeSort();
	}

	public static void main(String[] args) {
		List l = new List();
		System.out.println(l);
		l.selectionSort();
		System.out.println(l);

		l.addLast(3);
		System.out.println(l);
		l.selectionSort();
		System.out.println(l);
		l.addLast(5);
		System.out.println(l);
		l.addLastR(4);
		System.out.println(l);
		l.addFirst(6);
		System.out.println(l);

		System.out.println(l.get(1));
		System.out.println(l.getR(3));
		System.out.println("MERGESORTING!!! GO");
		l.mergeSort();
		System.out.println(l);
	}
}
