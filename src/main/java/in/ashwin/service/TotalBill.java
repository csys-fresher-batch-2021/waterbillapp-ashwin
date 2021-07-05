package in.ashwin.service;

public class TotalBill {
	private TotalBill() {

	}

	public static double getTotalBill(String type, double units) {
		double perUnitPrice = BillManager.getPerUnitPrice(type,units);
		return perUnitPrice * units;

	}

	public static void main(String args[]) {
		String type="DOMESTIC";
		double unit=50;
		System.out.println(getTotalBill(type,unit));
	}
}