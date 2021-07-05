package in.ashwin.service;

import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import in.ashwin.model.UnitPrice;

public class BillManager {
	private BillManager() {

	}

	private static final Map<String, List<UnitPrice>> map = new LinkedHashMap<>();

	static {
		UnitPrice domesticOneToTenkl = new UnitPrice(0, 10, 4);
		UnitPrice domesticElevenToFifteenkl = new UnitPrice(11, 15, 16);
		UnitPrice domesticSixteenToTwentyFivekl = new UnitPrice(16, 25, 24);
		UnitPrice domesticTwentySixToHundredkl = new UnitPrice(26, 100, 40);
		List<UnitPrice> domesticTariff = new ArrayList<>();
		domesticTariff.add(domesticOneToTenkl);
		domesticTariff.add(domesticElevenToFifteenkl);
		domesticTariff.add(domesticSixteenToTwentyFivekl);
		domesticTariff.add(domesticTwentySixToHundredkl);
		map.put("DOMESTIC", domesticTariff);

		UnitPrice commercialOneToTenkl = new UnitPrice(0, 10, 8);
		UnitPrice commercialElevenToFifteenkl = new UnitPrice(11, 15, 25);
		UnitPrice commercialSixteenToHundredKl = new UnitPrice(16, 100, 40);
		List<UnitPrice> commercialTariff = new ArrayList<>();
		commercialTariff.add(commercialOneToTenkl);
		commercialTariff.add(commercialElevenToFifteenkl);
		commercialTariff.add(commercialSixteenToHundredKl);
		map.put("COMMERCIAL", commercialTariff);
	}

	public static Map<String, List<UnitPrice>> getList() {

		return map;
	}
	public static double getPerUnitPrice(String type, double units) {
		if ((units < 0 || units > 100)) {
			throw new IllegalArgumentException("Invalid Unit");
		}
		if (!(type != null && map.containsKey(type.toUpperCase()))) {
			throw new IllegalArgumentException("Invalid Type");
		}
		double perUnitPrice = 0;
		for (Map.Entry<String, List<UnitPrice>> entry : map.entrySet()) {
			String key = entry.getKey();
			List<UnitPrice> unitPrice = entry.getValue();
			for (UnitPrice up : unitPrice) {
				if (key.equalsIgnoreCase(type) && units >= up.getMinUnit() && units <= up.getMaxUnit()) {
					perUnitPrice = up.getPrice();
					break;
				}
			}
		}
		return perUnitPrice;
	}
}