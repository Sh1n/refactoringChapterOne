package bux.francesco.xpeppers.com;

public class ChildrenMovie extends Movie{

	public ChildrenMovie(String name, int priceCode) {
		super(name, priceCode);
	}
	
	@Override
	public double extractCharge(int daysRented) {
		double amount = 1.5;
		if (daysRented > 3)
			amount += (daysRented - 3) * 1.5;
		return amount;
	}

}
