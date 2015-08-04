package com.sam;


import java.util.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;

import com.sam.algorithmImplementation.Bogosort;
import com.sam.algorithmImplementation.BubbleSort;
import com.sam.algorithmImplementation.Quicksort;
import com.sam.engine.SortEngine;

public class SortConsoleInterpret {
	private List<Integer> givenList;
	public SortConsoleInterpret(List<Integer> givenList){
		this.givenList = givenList;
	}
	
	public void start() {
		System.out.println("Welcome to array sorter!");
		StopWatch myWatch = new StopWatch();
		List<Integer> myList;
		if(givenList != null){
			myList = givenList;
		} else {
			myList =  new ArrayList<Integer>();
			initInvertedList(myList, 11);
		}
		
		SortEngine mySortingEngine;
		
		int item = 1;
		switch(item){
		case 1:
			System.out.println("Starting your quicksort sort of " + myList.size() + " elements");
			mySortingEngine = new Quicksort();
			break;
		case 2:
			System.out.println("Starting your bubble sort sort of " + myList.size() + " elements");
			mySortingEngine = new BubbleSort();
			break;
		default:
			System.out.println("Starting your bogosort sort of " + myList.size() + " elements");
			mySortingEngine = new Bogosort();
			break;
		}
		myWatch.start();
		mySortingEngine.sort(myList);
		myWatch.split();
		double myTime = myWatch.getSplitTime() == 0.0 ? 0 : myWatch.getSplitTime() / 1000;
		myWatch.stop();
		System.out.println("Hello :D, your " + myList.size() + " element list has been sorted and it took " + myTime + " seconds to sort.");
		System.out.println(myList.toString());
	}
	
	private static void initInvertedList(List<Integer> list, int length){
		for (int i = length; i > 0; i--) {
			list.add(i);
		}
	}
}
