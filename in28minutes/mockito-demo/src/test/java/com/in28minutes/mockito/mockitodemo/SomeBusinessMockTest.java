package com.in28minutes.mockito.mockitodemo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class SomeBusinessMockTest {

	@Test
	public void testFindGreatestFromAllNumbers() {
		
		DataService dataService = mock(DataService.class);
		when(dataService.retriveAllData()).thenReturn(new int[] {24 ,6, 15});
		
		SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataService);
		
		int result = someBusiness.findGreatestFromAllNumbers();
		
		assertEquals(24, result);
	}

}