public class PegTest {
	public static void main(String[] args) {
		RoundPeg rp = new RoundPeg(1);
		assert rp.getRadius() == 1;
		assert Math.abs(rp.area() - Math.PI) < 0.0001;

		RoundHole h1 = new RoundHole(1);
		assert h1.tryPlug(rp);

		assert !h1.tryPlug(new RoundPeg(2));
		assert h1.tryPlug(new RoundPeg(0.8));

		RectAdapterC recp = new RectAdapterC(2.5, 2);
		RoundHole oneFive = new RoundHole(1.5);
		assert oneFive.tryPlug(new RectAdapterC(2.5, 1.5));
		assert !oneFive.tryPlug(new RectAdapterC(2.5, 2.0));

		RectangularPeg wrapped = new RectangularPeg(2.5, 1.5);
		RectangularPeg wrappedBig = new RectangularPeg(2.5, 2);
		assert oneFive.tryPlug(new RectAdapterO(wrapped));
		assert !oneFive.tryPlug(new RectAdapterO(wrappedBig));

		RoundPeg r2 = new RoundPeg(2);
		assert !oneFive.tryPlug(r2);
		assert oneFive.tryPlug(new PegCompressor(r2, 0.5));

		RoundPeg veryround = new RoundPeg(20);
		Round compressed = new PegCompressor(veryround, 0.5);
		assert !oneFive.tryPlug(compressed);
		Round compressedAgain = new PegCompressor(compressed, 0.5);
		assert !oneFive.tryPlug(compressed);
		Round thirdTimeLucky = new PegCompressor(compressedAgain, 0.25);
		assert oneFive.tryPlug(thirdTimeLucky);

		System.out.println("\u001b[42;30m\u001b[KSuccess!\u001b[0m");
	}
}
