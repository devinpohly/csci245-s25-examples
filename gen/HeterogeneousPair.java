public class HeterogeneousPair<F, S> {
	private F first;
	private S second;

	public HeterogeneousPair(F f, S s) {
		first = f;
		second = s;
	}

	public F getFirst() {
		return first;
	}

	public S getSecond() {
		return second;
	}

	public String toString() {
		return "(" + first + ", " + second + ")";
	}

	public HeterogeneousPair<S, F> reverse() {
		return new HeterogeneousPair<>(second, first);
	}

	public static void main(String[] args) {
		Integer a = 3;
		HeterogeneousPair<Integer, String> p = new HeterogeneousPair<>(a, "five");
		System.out.println(p);
		System.out.println(p.reverse());
	}
}
