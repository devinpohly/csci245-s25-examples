import java.util.*;

public class Test implements Iterable<Integer> {

	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			int i = 1;

			public boolean hasNext() {
				return true;
			}

			public Integer next() {
				int toReturn = i;
				i++;
				return toReturn;
			}
		};
	}

	public static void main(String[] args) {
		Test test = new Test();
		for (int i : test) {
			System.out.println(i);
		}
	}
}
