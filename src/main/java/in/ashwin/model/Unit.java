package in.ashwin.model;

public class Unit {

	private String type;
	private double minimumUnit;
	private double maximumUnit;
	private double price;

	
	public String getType() {
		return type;
	}

	public double getMinimumUnit() {
		return minimumUnit;
	}

	public double getMaximumUnit() {
		return maximumUnit;
	}

	public double getPrice() {
		return price;
	}

	public Unit(double minimumUnit, double maximumUnit, double price) {
		super();
		this.minimumUnit = minimumUnit;
		this.maximumUnit = maximumUnit;
		this.price = price;
	}

	public Unit(String type, double minimumUnit, double maximumUnit, double price) {
		super();
		this.type = type;
		this.minimumUnit = minimumUnit;
		this.maximumUnit = maximumUnit;
		this.price = price;
	}
	
}

	