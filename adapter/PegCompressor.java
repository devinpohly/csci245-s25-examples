public class PegCompressor implements Round {
	private Round internal;
	private double ratio;

	public PegCompressor(Round internal, double ratio) {
		this.internal = internal;
		this.ratio = ratio;
	}

	public double getRadius() {
		return internal.getRadius() * ratio;
	}
}
