public class BSTNode {
	public int datum;
	public BSTNode left, right;

	public BSTNode(int i) {
		datum = i;
		left = right = null;
	}

	public void printValues() {
		if (left != null) left.printValues();
		System.out.println(datum);
		if (right != null) right.printValues();
	}

	public int add(int i) {
		if (datum == i) {
			return 0;
		}
		if (i < datum) {
			// belongs on left
			if (left == null) {
				left = new BSTNode(i);
				return 1;
			} else {
				return left.add(i);
			}
		}
		else {
			if (right == null) {
				right = new BSTNode(i);
				return 1;
			} else {
				return right.add(i);
			}
		}
	}

	public void remove(int i) {
		// CSCI 345
	}

	public boolean contains(int i) {
		if (datum == i) {
			return true;
		}
		if (i < datum) {
			if (left == null) {
				return false;
			}
			return left.contains(i);
		}
		else {  // i > datum
			if (right == null) {
				return false;
			}
			return right.contains(i);
		}
	}

	public String toString() {
		return this.datum + "[" + this.left + "][" + this.right + "]";
	}
}
