public class RectAdapterO implements Round {
	private RectangularPeg internal;

	public RectAdapterO(RectangularPeg peg) {
		internal = peg;
	}

	public double getRadius() {
		double w = internal.getWidth();
		double l = internal.getLength();
		return Math.sqrt(l*l + w*w) / 2;
	}
}
