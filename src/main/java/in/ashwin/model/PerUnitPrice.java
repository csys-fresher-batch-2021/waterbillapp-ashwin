package in.ashwin.model;

public class PerUnitPrice {
	private int minimumUnits;
		
	private int maximumUnits;
		
	private int price;
	
	public int getMinimumUnits() {
		return minimumUnits;
	}
	public int getMaximumUnits() {
		return maximumUnits;
	}
	public int getPrice() {
		return price;
	}
	
	public PerUnitPrice(int minimumUnits,int maximumUnits,int price) {
		this.minimumUnits=minimumUnits;
		this.maximumUnits=maximumUnits;
		this.price=price;
	}
	public String toString() {
		return "perUnitPrice[minimumUnits = "+ minimumUnits +" ,maximumUnits= "+ maximumUnits +",price =" + price +"]";
	}
		
		
	}