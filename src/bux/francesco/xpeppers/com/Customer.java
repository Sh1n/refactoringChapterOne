package bux.francesco.xpeppers.com;

import java.util.Enumeration;
import java.util.Vector;

class Customer extends DomainObject {
	public Customer(String name) {
		_name = name;
	}

	public String statement() {
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + name() + "\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += "\t" + each.getTape().getMovie().name() + "\t"
					+ String.valueOf(each.extractCharge()) + "\n";

		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequecePoints())
				+ " frequent renter points";
		return result;

	}
	
	private double getTotalAmount() {
		double totalAmount = 0;
		Enumeration rentals = _rentals.elements();
		while(rentals.hasMoreElements()){
			Rental aRental = (Rental) rentals.nextElement();
			totalAmount += aRental.extractCharge();
		}
		return totalAmount;
	}
	
	private int getTotalFrequecePoints(){
		int pointAmount = 0;
		Enumeration rentals = _rentals.elements();
		while(rentals.hasMoreElements()){
			Rental aRental = (Rental) rentals.nextElement();
			pointAmount += aRental.extractFrequencyPoints();
		}
		return pointAmount;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public static Customer get(String name) {
		return (Customer) Registrar.get("Customers", name);
	}

	public void persist() {
		Registrar.add("Customers", this);
	}

	private Vector _rentals = new Vector();
}
