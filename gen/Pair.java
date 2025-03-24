public class Pair<E> {
	private E first;
	private E second;

	public Pair(E f, E s) {
		first = f;
		second = s;
	}

	public E getFirst() {
		return first;
	}

	public E getSecond() {
		return second;
	}

	public String toString() {
		return "(" + first + ", " + second + ")";
	}

	public void reverse() {
		E tmp = first;
		first = second;
		second = tmp;
	}

	public static void main(String[] args) {
		Integer a = 3;
		Integer b = 5;
		Pair<Integer> p = new Pair<>(a, b);
		Pair<String> p2 = new Pair<>("hello", "world");
		p.reverse();
		System.out.println(p);
		System.out.println(p2.getSecond().indexOf('v'));
	}
}
