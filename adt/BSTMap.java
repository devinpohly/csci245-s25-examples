public class BSTMap {
	private BSTMNode root;

	public BSTMap() {
		root = null;
	}

	public boolean containsKey(int i) {
		if (root == null) {
			return false;
		}
		return root.containsKey(i);
	}

	public void put(int i, String v) {
		if (root == null) {
			root = new BSTMNode(i, v);
			return;
		}
		root.put(i, v);
	}

	public String get(int i) {
		if (root == null) {
			return null;
		}
		return root.get(i);
	}

	public static void main(String[] args) {
		BSTMap map = new BSTMap();
		System.out.println(map.get(5));

		map.put(5, "five");
		System.out.println(map.get(5));

		map.put(3, "tree");
		System.out.println(map.get(3));

		map.put(5, "fife");
		System.out.println(map.get(5));

		map.put(-5, "unfife");
		map.put(2, "toooo");
		map.put(15, "fifty");
		System.out.println(map.get(2));
		System.out.println(map.get(-5));
		System.out.println(map.get(14));
		System.out.println(map.get(15));
	}
}
