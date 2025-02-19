public class BSTSet {
	private BSTNode root;
	private int size;

	public BSTSet() {
		root = null;
		size = 0;
	}

	public boolean contains(int i) {
		if (root == null) {
			return false;
		}
		return root.contains(i);
	}

	public int size() {
		return size;
	}

	public void add(int i) {
		if (root == null) {
			root = new BSTNode(i);
			size++;
			return;
		}
		size += root.add(i);
	}

	public String toString() {
		if (root == null) {
			return "empty";
		}
		return root.toString();
	}

	public void printValues() {
		if (root == null) {
			System.out.println("(empty)");
		}
		root.printValues();
	}

	public static void main(String[] args) {
		BSTSet set = new BSTSet();
		System.out.println(set);
		System.out.println(set.contains(5));

		set.add(5);
		System.out.println(set);
		System.out.println(set.contains(5));
		System.out.println(set.contains(3));
		System.out.println(set.contains(9));

		set.add(3);
		System.out.println(set);
		System.out.println(set.contains(3));
		System.out.println(set.contains(4));

		set.add(5);
		System.out.println(set);
		System.out.println(set.contains(5));

		set.add(-5);
		set.add(2);
		set.add(15);
		set.add(3);
		set.add(0);
		set.add(-1);
		set.add(7);
		set.add('A');

		set.printValues();
	}
}
