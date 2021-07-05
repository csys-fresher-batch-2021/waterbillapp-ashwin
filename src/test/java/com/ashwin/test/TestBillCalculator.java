package com.ashwin.test;

import static org.junit.Assert.*;


import org.junit.Test;

import in.ashwin.service.TotalBill;

public class TestBillCalculator {

	@Test
	public void domesticTest1() {
		int units = 3;
		String type = "Domestic";
		double totalPrice =TotalBill.getTotalBill(type, units);
		assertEquals(12.0f, totalPrice, 0);
	}

	@Test
	public void domesticTest2() {
		int units = 14;
		String type = "Domestic";
		double totalPrice = TotalBill.getTotalBill(type, units);
		assertEquals(224.0f, totalPrice, 0);
	}

	@Test
	public void domesticTest3() {
		int units = 40;
		String type = "DOmestic";
		double totalPrice = TotalBill.getTotalBill(type, units);
		assertEquals(1600.0f, totalPrice, 0);
	}

	@Test
	public void commercialTest1() {
		int units = 10;
		String type = "commercial";
		double totalPrice = TotalBill.getTotalBill(type, units);
		assertEquals(80.0f, totalPrice, 0);
	}

	@Test
	public void commercialTest2() {
		int units = 50;
		String type = "commercial";
		double totalPrice =  TotalBill.getTotalBill(type, units);
		assertEquals(2000.0f, totalPrice, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testcase() {
		int units = 1000;
		String type = "domestic";
		TotalBill.getTotalBill(type, units);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testcase1() {
		int units =0;
		String type = "school";
		TotalBill.getTotalBill(type, units);
	}

}