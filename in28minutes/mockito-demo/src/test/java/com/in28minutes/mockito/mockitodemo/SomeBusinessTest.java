package com.in28minutes.mockito.mockitodemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomeBusinessTest {

	@Test
	public void testFindGreatestFromAllNumbers() {
		SomeBusinessImpl someBusiness = new SomeBusinessImpl(new DataServiceStub());
		int result = someBusiness.findGreatestFromAllNumbers();
		assertEquals(24, result);
	}

}

class DataServiceStub implements DataService {

	@Override
	public int[] retriveAllData() {
		return new int[] {24, 6, 15};
	}
	
}
