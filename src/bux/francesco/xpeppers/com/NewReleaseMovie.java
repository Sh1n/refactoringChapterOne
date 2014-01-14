package bux.francesco.xpeppers.com;

public class NewReleaseMovie extends Movie{

	public NewReleaseMovie(String name, int priceCode) {
		super(name, priceCode);
	}

	@Override
	public double extractCharge(int daysRented) {
		return daysRented * 3;
	}
}
