package com.in28minutes.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyMathTest {
	
	@Before
	public void before() {
		System.out.println("before");
	}

	@Test
	public void sumWith3Numbers() {
		System.out.println("Test1");
		MyMath myMath = new MyMath();
		int result = myMath.sum(new int [] {1,2,3});
		assertEquals(6, result);
	}
	
	@Test
	public void sumWith1Numbers() {
		System.out.println("Test2");
		MyMath myMath = new MyMath();
		int result = myMath.sum(new int [] {1});
		assertEquals(1, result);
	}
	
	@After
	public void after() {
		System.out.println("After");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After class");
	}


}
