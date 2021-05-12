package in.ashwin.service;

import java.util.*;
import in.ashwin.model.PerUnitPrice;

public class DisplayManager {
	private DisplayManager()
	{
		
	}

	private static final Map<String,List<PerUnitPrice>>map=new LinkedHashMap<>();

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
		map.put("Domestic Users", domesticTariff);

		PerUnitPrice commercialOneToTenkl = new PerUnitPrice(0, 10, 8);
		PerUnitPrice commercialElevenToFifteenkl = new PerUnitPrice(11, 15, 25);
		PerUnitPrice commercialSixteenToHundredKl = new PerUnitPrice(16, 100, 40);
		List<PerUnitPrice> commercialTariff = new ArrayList<>();
		commercialTariff.add(commercialOneToTenkl);
		commercialTariff.add(commercialElevenToFifteenkl);
		commercialTariff.add(commercialSixteenToHundredKl);
		map.put("Commercial Users", commercialTariff);
	}

	public static Map<String, List<PerUnitPrice>> getList() {
		return map;
	}
}