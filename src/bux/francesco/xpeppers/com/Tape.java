package bux.francesco.xpeppers.com;

class Tape extends DomainObject {
	
	public Movie getMovie() {
		return _movie;
	}

	public Tape(String serialNumber, Movie movie) {
		setSerialNumber(serialNumber);
		_movie = movie;
	}

	private String _serialNumber;
	
	private Movie _movie;
	
	public double extractAmount(int daysRented) {
		return this.getMovie().extractCharge(daysRented);
	}

	public String getSerialNumber() {
		return _serialNumber;
	}

	public void setSerialNumber(String _serialNumber) {
		this._serialNumber = _serialNumber;
	}
}
