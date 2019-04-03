package com.in28minutes.mockito.mockitodemo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class ListTest extends TestCase {
	
	@Test
	public void testListSize() {
		List<?> list = mock(List.class);
		when(list.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, list.size());
		assertEquals(20, list.size());
	}

}
