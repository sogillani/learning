package com.in28minutes.mockito.mockitodemo;

public class SomeBusinessImpl {
	
	private DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findGreatestFromAllNumbers() {
		
		int[] data = dataService.retriveAllData();
		int greatest = Integer.MIN_VALUE;
		
		for (int value : data) {
			if (value > greatest)
				greatest = value;
		}
		
		return greatest;
	}

}

