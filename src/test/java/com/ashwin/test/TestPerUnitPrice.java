package com.ashwin.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.ashwin.service.BillCalculator;
import in.ashwin.service.DisplayManager;

public class TestPerUnitPrice {

	@Test
	public void test1() {
		int units = 4;
		String type = "domestic";
		double perUnitPrice = DisplayManager.getPerUnitPrice(type,units);
		assertEquals(4.0f, perUnitPrice, 0);
	}
	@Test
	public void test2() {
		int units = 14;
		String type = "domestic";
		double perUnitPrice = DisplayManager.getPerUnitPrice(type,units);
		assertEquals(16.0f, perUnitPrice, 0);
	}
	@Test
	public void test3() {
		int units = 3;
		String type = "commercial";
		double perUnitPrice = DisplayManager.getPerUnitPrice(type,units);
		assertEquals(8.0f, perUnitPrice, 0);
	}
	@Test
	public void test4() {
		int units = 14;
		String type = "commercial";
		double perUnitPrice = DisplayManager.getPerUnitPrice(type,units);
		assertEquals(25.0f, perUnitPrice, 0);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testcase() {
		int units = 1000;
		String type = "domesti";
		DisplayManager.getPerUnitPrice(type, units);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testcase1() {
		int units =0;
		String type = "commercia";
		 DisplayManager.getPerUnitPrice(type,units);
	}

}
