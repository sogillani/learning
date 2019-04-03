package com.in28minutes.mockito.mockitodemo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockAnnotationsTest {
	
	@Mock
	DataService dataService;
	
	@InjectMocks
	SomeBusinessImpl someBusiness;

	@Test
	public void testFindGreatestFromAllNumbers() {
		when(dataService.retriveAllData()).thenReturn(new int[] {24 ,6, 15});
		assertEquals(24, someBusiness.findGreatestFromAllNumbers());
	}

}