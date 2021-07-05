package in.ashwin.model;

public class UnitPrice {

	private double minUnit;
	private double maxUnit;
	private double price;

	public double getMinUnit() {
		return minUnit;
	}

	public double getMaxUnit() {
		return maxUnit;
	}

	public double getPrice() {
		return price;
	}

	// Used for initializing values
	public UnitPrice(double minUnit, double maxUnit, double price) {
		this.minUnit = minUnit;
		this.maxUnit = maxUnit;
		this.price = price;
	}
}