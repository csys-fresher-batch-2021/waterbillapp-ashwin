package in.ashwin.model;

public class PerUnitPrice {
	public int minimumUnits;
		
	public int maximumUnits;
		
	public int price;
	
	public PerUnitPrice(int minimumUnits,int maximumUnits,int price) {
		this.minimumUnits=minimumUnits;
		this.maximumUnits=maximumUnits;
		this.price=price;
	}
	public String toString() {
		return "perUnitPrice[minimumUnits = "+ minimumUnits +" ,maximumUnits= "+ maximumUnits +",price =" + price +"]";
	}
		
		
	}