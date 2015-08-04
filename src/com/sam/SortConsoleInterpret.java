package com.sam;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;

import com.sam.engine.SortEngine;
import com.sam.factory.SortEngineFactory;

public final class SortConsoleInterpret {

	public void start() {
		String response;
		sout("Welcome to array sorter!");
		response = queryConsoleUser("Which engine would you like to use? If we don't have the selected engine we'll use Quicksort."
				+ "\nQuicksort"
				+ "\nBogosort"
				+ "\nBubble sort");
		
		SortEngine mySortingEngine = factory.getNewOrDefault(response);
		sout("Starting sorting of " + myList.size() + " elements with" + mySortingEngine.getName() + ".");
		startMeasuringTime();
		mySortingEngine.sort(myList);
		double myTime = getMeasuredTime();
		stopMeasuringTime();
		System.out.println("Hello :D, your " + myList.size() + " element list has been sorted and it took " + myTime + " seconds to sort.");
		System.out.println(myList.toString());
	}
	
	public SortConsoleInterpret(List<Integer> givenList){
		if(givenList != null){
			myList = givenList;
		} else {
			myList =  new ArrayList<Integer>();
			initInvertedList(myList, 11);
		}
	}
	
/***
 * Inner workings
 */

	private List<Integer> myList;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private SortEngineFactory factory = new SortEngineFactory(); 
	private StopWatch myWatch = new StopWatch();
	
	
	private static void initInvertedList(List<Integer> list, int length){
		for (int i = length; i > 0; i--) {
			list.add(i);
		}
	}
	
	private String queryConsoleUser(String text){
		System.out.println(text);
		try {
			return br.readLine();
		} catch (IOException e) {
			return "";
		}
	}
	
	private void startMeasuringTime(){
		myWatch.start();
		myWatch.split();
	}
	
	private void stopMeasuringTime(){
		myWatch.stop();
	}
	
	private double getMeasuredTime(){
		return myWatch.getSplitTime() == 0.0 ? 0 : myWatch.getSplitTime() / 1000;
	}
	
	private void sout(String text){
		System.out.println(text);
	}
}
