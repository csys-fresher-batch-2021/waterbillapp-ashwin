package com.ashwin.test;

import static org.junit.Assert.*;

import java.util.*;
import in.ashwin.service.DisplayManager;


import org.junit.Test;

import in.ashwin.model.PerUnitPrice;

public class TestDisplayItems{
	@Test
	public void test1() {
		Map<String,List<PerUnitPrice>>size=DisplayManager.getList();
		System.out.println(size);
		assertEquals(2,size.size());
	}
	@Test
	public void test2() {
		Map<String,List<PerUnitPrice>>size=DisplayManager.getList();
		System.out.println(size);
		assertNotEquals(3,size.size());
	}
	
}