public class RectAdapterC extends RectangularPeg implements Round {

	public RectAdapterC(double w, double l) {
		super(w, l);
	}

	public double getRadius() {
		double w = getWidth();
		double l = getLength();
		return Math.sqrt(l*l + w*w) / 2;
	}
}
