public class RoundPeg implements Round {
	private double radius;

	public RoundPeg(double r) {
		radius = r;
	}

	public double getRadius() {
		return radius;
	}

	public double area() {
		return Math.PI * radius * radius;
	}
}
