package com.tests;

import org.testng.annotations.Test;

import com.utility.Log;
public class TestClass1 {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}
	@Test
	public static void testCase1() {
		Log.startTestCase("testCase1");
		Log.info("This is testCase 1");
		Log.endTestCase("testCase1");
	}
	
	@Test
	public static void testCase2() {
		Log.startTestCase("testCase2");
		Log.info("This is testCase 2");
		Log.endTestCase("testCase2");
	}
	

}
