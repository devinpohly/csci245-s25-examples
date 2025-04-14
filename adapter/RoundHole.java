public class RoundHole {
	private double radius;

	public RoundHole(double r) {
		radius = r;
	}

	public boolean tryPlug(Round item) {
		return this.radius >= item.getRadius();
	}
}
