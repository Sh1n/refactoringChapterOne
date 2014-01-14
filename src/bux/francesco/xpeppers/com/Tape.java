package bux.francesco.xpeppers.com;

class Tape extends DomainObject {
	public Movie movie() {
		return _movie;
	}

	public Tape(String serialNumber, Movie movie) {
		_serialNumber = serialNumber;
		_movie = movie;
	}

	private String _serialNumber;
	private Movie _movie;
	
	public double extractAmount(int daysRented) {
		// determine amounts for each line
		double amount = 0;
		switch (this.movie().priceCode()) {
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
