public class RectangularPeg {
	private double width, length;

	public RectangularPeg(double w, double l) {
		width = w;
		length = l;
	}

	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}

	public double area() {
		return width * length;
	}
}
