package in.ashwin.model;

public class PerUnitPrice {
	private int minimumUnits;
		
	private int maximumUnits;
		
	private double price;
	
	
	public int getMinimumUnits() {
		return minimumUnits;
	}
	public int getMaximumUnits() {
		return maximumUnits;
	}
	public double getPrice() {
		return price;
	}
	public PerUnitPrice(int minimumUnits,int maximumUnits,double price) {
		this.minimumUnits=minimumUnits;
		this.maximumUnits=maximumUnits;
		this.price=price;
	}
	public String toString() {
		return "perUnitPrice[minimumUnits = "+ minimumUnits +" ,maximumUnits= "+ maximumUnits +",price =" + price +"]";
	}
		
		
	}