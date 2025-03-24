public class ReverseArray {
	public static <E> void reverseArray(E[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			E t = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = t;
		}
	}

	public static void main(String[] args) {
		Double[] arr = new Double[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = (double) (i + 1) * (i + 1);
		}

		Integer[] iarr = new Integer[10];
		for (int i = 0; i < 10; i++) {
			iarr[i] = (i - 10);
		}

		String[] sarr = new String[]{
			"hello",
			"world",
			"and",
			"other",
			"planets",
		};

		reverseArray(arr);
		reverseArray(iarr);
		reverseArray(sarr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < iarr.length; i++) {
			System.out.print(iarr[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < sarr.length; i++) {
			System.out.print(sarr[i] + " ");
		}
		System.out.println();
	}
}
