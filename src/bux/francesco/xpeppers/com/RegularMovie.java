package bux.francesco.xpeppers.com;

public class RegularMovie extends Movie{

	public RegularMovie(String name, int priceCode) {
		super(name, priceCode);
	}

	@Override
	public double extractCharge(int daysRented) {
		double amount = 2;
		if (daysRented > 2)
			amount += (daysRented - 2) * 1.5;
		return amount;
	}
}
