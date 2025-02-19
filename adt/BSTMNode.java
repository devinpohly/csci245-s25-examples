public class BSTMNode {
	public int key;
	public String value;
	public BSTMNode left, right;

	public BSTMNode(int key, String value) {
		this.key = key;
		this.value = value;
		left = right = null;
	}

	public void printValues() {
		if (left != null) left.printValues();
		System.out.println(key);
		if (right != null) right.printValues();
	}

	public String put(int k, String v) {
		if (key == k) {
			String old = value;
			value = v;
			return old;
		}
		if (k < key) {
			// belongs on left
			if (left == null) {
				left = new BSTMNode(k, v);
				return null;
			} else {
				return left.put(k, v);
			}
		}
		else {
			if (right == null) {
				right = new BSTMNode(k, v);
				return null;
			} else {
				return right.put(k, v);
			}
		}
	}

	public String remove(int k) {
		// CSCI 345
		return null;
	}

	public String get(int i) {
		if (key == i) {
			return value;
		}
		if (i < key) {
			if (left == null) {
				return null;
			}
			return left.get(i);
		}
		else {  // i > key
			if (right == null) {
				return null;
			}
			return right.get(i);
		}
	}

	public boolean containsKey(int i) {
		if (key == i) {
			return true;
		}
		if (i < key) {
			if (left == null) {
				return false;
			}
			return left.containsKey(i);
		}
		else {  // i > key
			if (right == null) {
				return false;
			}
			return right.containsKey(i);
		}
	}

	public String toString() {
		return this.key + "[" + this.left + "][" + this.right + "]";
	}
}
