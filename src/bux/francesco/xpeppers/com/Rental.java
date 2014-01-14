package bux.francesco.xpeppers.com;

class Rental extends DomainObject {
	public int daysRented() {
		return _daysRented;
	}

	public Tape tape() {
		return _tape;
	}

	private Tape _tape;

	public Rental(Tape tape, int daysRented) {
		_tape = tape;
		_daysRented = daysRented;
	}

	private int _daysRented;
	
	public double extractMovieAmount() {
		// determine amounts for each line
		double amount = 0;
		switch (this.tape().movie().priceCode()) {
			case Movie.REGULAR:
				amount += 2;
				if (this.daysRented() > 2)
					amount += (this.daysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				amount += this.daysRented() * 3;
				break;
			case Movie.CHILDRENS:
				amount += 1.5;
				if (this.daysRented() > 3)
					amount += (this.daysRented() - 3) * 1.5;
				break;

		}
		return amount;
	}
}
