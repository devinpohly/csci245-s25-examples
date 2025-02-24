public class ListNode {
	public final int datum;
	public ListNode next;

	public ListNode(int datum, ListNode next) {
		this.datum = datum;
		this.next = next;
	}

	public void addLast(int d) {
		if (this.next == null) {
			ListNode newNode = new ListNode(d, null);
			next = newNode;
			return;
		}
		next.addLast(d);
	}

	public int get(int index) {
		if (index == 0) {
			return datum;
		}
		return next.get(index - 1);
	}

	// returns (left, right)
	public ListNode[] split() {
		ListNode[] toReturn = new ListNode[2];

		if (next == null) {
			toReturn[0] = this;
			toReturn[1] = null;
			return toReturn;
		}

		ListNode[] didReturned = next.split();
		ListNode subA = didReturned[0];
		ListNode subB = didReturned[1];

		this.next = subB;

		toReturn[0] = this;
		toReturn[1] = subA;
		return toReturn;
	}

	// returns the head
	public ListNode mergeSort() {
		// Base case
		if (next == null) {
			return this;
		}

		// Initialize lists for "left" and "right" half
		System.out.println("--- About to mergesort: " + this);
		ListNode[] halves = this.split();
		ListNode halfA = halves[0];
		ListNode halfB = halves[1];

		// Recursively mergesort halves
		halfA = halfA.mergeSort();
		halfB = halfB.mergeSort();

		// Merge the sorted halves
		System.out.println("--- Merging:");
		System.out.println(halfA);
		System.out.println(halfB);
		ListNode merged = null;
		ListNode mergedTail = null;
		while (halfA != null || halfB != null) {
			// Add the next node in either halfA or halfB to merged, and
			// update mergedTail as well.
			if (halfA == null || (halfB != null && halfB.datum < halfA.datum)) {
				if (mergedTail == null) {
					merged = mergedTail = halfB;
					halfB = halfB.next;
					mergedTail.next = null;
				} else {
					mergedTail.next = halfB;
					mergedTail = mergedTail.next;
					halfB = halfB.next;
					mergedTail.next = null;
				}
			} else {
				if (mergedTail == null) {
					merged = mergedTail = halfB;
					halfA = halfA.next;
					mergedTail.next = null;
				} else {
					mergedTail.next = halfA;
					mergedTail = mergedTail.next;
					halfA = halfA.next;
					mergedTail.next = null;
				}
			}
		}
		System.out.println("merged: " + merged);
		return merged;
	}

	public String toString() {
		if (next == null) {
			return Integer.toString(this.datum);
		}
		return Integer.toString(this.datum) + ", " + next.toString();
	}

	public static void main(String[] args) {
		ListNode list = new ListNode(3, null);
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);
		list.addLast(7);
		System.out.println(list);

		ListNode[] splitted = list.split();
		System.out.println(splitted[0]);
		System.out.println(splitted[1]);
	}
}
