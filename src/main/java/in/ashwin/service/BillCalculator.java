package in.ashwin.service;

public class BillCalculator {
	private BillCalculator() {

	}

	/**
	 * Used to calculate the total bill
	 */
	public static double getBillCalculator(String type, int units) {
		double perUnitPrice = DisplayManager.getPerUnitPrice(type, units);
		return perUnitPrice * units;
	}

}
