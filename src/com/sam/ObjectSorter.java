package com.sam;

import java.util.*;
import org.apache.commons.lang3.time.StopWatch;

import com.sam.algorithmImplementation.Bogosort;
import com.sam.algorithmImplementation.Quicksort;
import com.sam.engine.SortEngine;

public class ObjectSorter {

	public static void main(String[] args) {
		System.out.println("Welcome to array sorter!");
		SortEngine mySortingEngine;
		if(false){
			System.out.println("Starting your quicksort sort");
			mySortingEngine = new Quicksort();
		} else {
			System.out.println("Starting your bogosort sort");
			mySortingEngine = new Bogosort();
		}
		
		StopWatch myWatch = new StopWatch();
		List<Integer> myList =  new ArrayList<Integer>();
		initInvertedList(myList, 12);
		myWatch.start();
		mySortingEngine.Sort(myList);
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

