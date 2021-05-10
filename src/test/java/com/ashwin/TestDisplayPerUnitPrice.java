package com.ashwin;

import static org.junit.Assert.*;

import org.junit.Test;

import in.ashwin.DisplayPerUnitPrice;

public class TestDisplayPerUnitPrice {
	@Test
	public void test() {
		int size=DisplayPerUnitPrice.displayAllDetails().size();
		assertEquals(7,size);
	}
	@Test
	public void test1() {
		int size=DisplayPerUnitPrice.displayAllDetails().size();
		assertNotEquals(6,size);
	}
	
}
	/*@Test
	public void testCase1() {
		int units=10;
		String userType="Domestic";
		double costOfOneUnit=DisplayPerUnitPrice.getPerUnitPrice(userType , units);
		assertEquals(4,costOfOneUnit,0);	
	}
	
	@Test
	public void testCase2() {
		int units=13;
		String type="Domestic";
		double costOfOneUnit=DisplayPerUnitPrice.getPerUnitPrice(type , units);
		assertEquals(16,costOfOneUnit,0);
	}
	@Test
	public void testCase3() {
		int units=20;
		String type="Domestic";
		double costOfOneUnit=DisplayPerUnitPrice.getPerUnitPrice(type , units);
		assertEquals(24,costOfOneUnit,0);
	}
	@Test
	public void testCase4() {
		int units=50;
		String type="Domestic";
		double costOfOneUnit=DisplayPerUnitPrice.getPerUnitPrice(type , units);
		assertEquals(40,costOfOneUnit,0);
	}
	@Test
	public void testCase5() {
		int units=10;
		String type="Commercial";
		double costOfOneUnit=DisplayPerUnitPrice.getPerUnitPrice(type , units);
		assertEquals(8,costOfOneUnit,0);
	}
	@Test
	public void testCase6() {
		int units=14;
		String type="Commercial";
		double costOfOneUnit=DisplayPerUnitPrice.getPerUnitPrice(type , units);
		assertEquals(25,costOfOneUnit,0);
	}
	@Test
	public void testCase7() {
		int units=30;
		String type="Commercial";
		double costOfOneUnit=DisplayPerUnitPrice.getPerUnitPrice(type , units);
		assertEquals(40,costOfOneUnit,0);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase8() {
		int units=100000;
		String type="Commercial";
		DisplayPerUnitPrice.getPerUnitPrice(type ,units);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase9() {
		int units=0;
		String type="domestic";
		DisplayPerUnitPrice.getPerUnitPrice(type ,units);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase10() {
		int units=-123;
		String type="domestic";
		DisplayPerUnitPrice.getPerUnitPrice(type ,units);
	}

}
*/
