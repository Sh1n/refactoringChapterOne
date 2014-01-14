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
	
	public double extractAmount() {
		return this.tape().extractAmount(this.daysRented());
	}

	public int extractFrequencyPoints() {
		if ((tape().movie().priceCode() == Movie.NEW_RELEASE) && daysRented() > 1)
			return 2;
		return 1;
	}
}
