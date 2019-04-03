package com.in28minutes.spring.basics.springin5steps.cdi;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeCdiBusinessTest {

	@InjectMocks
	SomeCdiBusiness cdiBusiness;
	
	@Mock
	SomeCdiDao cdiDao;
	
	@Test
	public void testSomeScenario() {
		when(cdiDao.getData()).thenReturn(new int[] {4,2});
		int actualResult = cdiBusiness.findGreates();
		assertEquals(4, actualResult);
	}

}
