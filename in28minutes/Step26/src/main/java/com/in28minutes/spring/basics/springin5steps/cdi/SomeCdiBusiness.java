package com.in28minutes.spring.basics.springin5steps.cdi;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SomeCdiBusiness {
	
	@Inject
	SomeCdiDao someCdiDao;

	public SomeCdiDao getSomeCDIDAO() {
		return someCdiDao;
	}

	public void setSomeCDIDAO(SomeCdiDao someCdiDao) {
		this.someCdiDao = someCdiDao;
	}
	
	public int findGreates() {
		
		int[] data = someCdiDao.getData();
		int greatest = Integer.MIN_VALUE;
		for (int i : data) {
			if (i > greatest)
				greatest = i;
		}
		
		return greatest;
	}
}
