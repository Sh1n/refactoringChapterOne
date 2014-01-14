package bux.francesco.xpeppers.com;

public class Movie extends DomainObject {
    public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;


	private int _priceCode;

	public Movie(String name, int priceCode) {
		_name = name;
		_priceCode = priceCode;
	}

	public int priceCode() {
		return _priceCode;
	}

	public void persist() {
		Registrar.add ("Movies", this);
	}

	public static Movie get(String name) {
		return (Movie) Registrar.get ("Movies", name);
	}

	public double extractCharge(int daysRented) {
		// determine amounts for each line
		double amount = 0;
		switch (this.priceCode()) {
			case Movie.REGULAR:
				amount += 2;
				if (daysRented > 2)
					amount += (daysRented - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				amount += daysRented * 3;
				break;
			case Movie.CHILDRENS:
				amount += 1.5;
				if (daysRented > 3)
					amount += (daysRented - 3) * 1.5;
				break;

		}
		return amount;
	}
}
