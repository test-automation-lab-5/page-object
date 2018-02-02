package com.epam.objectpattern;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {
	
	public AppTest(String testName) {
		super(testName);
	}
	
	

	public static TestSuite suite() {
		return new TestSuite(AppTest.class);
	}

	
	
}