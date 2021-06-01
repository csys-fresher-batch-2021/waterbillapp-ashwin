package in.ashwin.service;

import java.util.*;


import in.ashwin.model.PerUnitPrice;

public class DisplayManager {
	private DisplayManager() {

	}

	private static final Map<String, List<PerUnitPrice>> map = new LinkedHashMap<>();

	static {
		PerUnitPrice domesticOneToTenkl = new PerUnitPrice(0, 10, 4);
		PerUnitPrice domesticElevenToFifteenkl = new PerUnitPrice(11, 15, 16);
		PerUnitPrice domesticSixteenToTwentyFivekl = new PerUnitPrice(16, 25, 24);
		PerUnitPrice domesticTwentySixToHundredkl = new PerUnitPrice(26, 100, 40);
		List<PerUnitPrice> domesticTariff = new ArrayList<>();
		domesticTariff.add(domesticOneToTenkl);
		domesticTariff.add(domesticElevenToFifteenkl);
		domesticTariff.add(domesticSixteenToTwentyFivekl);
		domesticTariff.add(domesticTwentySixToHundredkl);
		map.put("DOMESTIC", domesticTariff);

		PerUnitPrice commercialOneToTenkl = new PerUnitPrice(0, 10, 8);
		PerUnitPrice commercialElevenToFifteenkl = new PerUnitPrice(11, 15, 25);
		PerUnitPrice commercialSixteenToHundredKl = new PerUnitPrice(16, 100, 40);
		List<PerUnitPrice> commercialTariff = new ArrayList<>();
		commercialTariff.add(commercialOneToTenkl);
		commercialTariff.add(commercialElevenToFifteenkl);
		commercialTariff.add(commercialSixteenToHundredKl);
		map.put("COMMERCIAL", commercialTariff);
	}

	public static Map<String, List<PerUnitPrice>> getList() {

		return map;
	}
	public static double getPerUnitPrice(String type, int units) {
		if ((units < 0 || units > 1000)) {
			throw new IllegalArgumentException("Invalid Unit");
		}
		if (!(type != null && map.containsKey(type.toUpperCase()))) {
			throw new IllegalArgumentException("Invalid Type");
		}
		double perUnitPrice = 0;
		for (Map.Entry<String, List<PerUnitPrice>> entry : map.entrySet()) {
			String key = entry.getKey();
			List<PerUnitPrice> unitPrice = entry.getValue();
			for (PerUnitPrice up : unitPrice) {
				if (key.equalsIgnoreCase(type) && units >= up.getMinimumUnits() && units <= up.getMaximumUnits()) {
					perUnitPrice = up.getPrice();
					break;
				}
			}
		}
		return perUnitPrice;
	}

}












//	public static int getPerUnitPrice(String type, int units) {
//		if (units <= 0 || units > 101) {
//			throw new IllegalArgumentException("Invalid Unit");
//		}
//		if(!(type != null && map.containsKey(type.toUpperCase()))) {
//			throw new IllegalArgumentException("Invalid Type");
//		}
//
//		int costOfOneUnit = 0;
//		for (Map.Entry<String, List<PerUnitPrice>> entry : map.entrySet()) {
//			String Key = entry.getKey();
//			List<PerUnitPrice> perUnitPrice = entry.getValue();
//			for (PerUnitPrice size : perUnitPrice) {
//				if (Key.equalsIgnoreCase(type) && units >= size.getMinimumUnits() && units <= size.getMaximumUnits()) {
//					costOfOneUnit = size.getPrice();
//					break;
//				}
//			}
//		}
//
//		return costOfOneUnit;
//	}
//}
	
