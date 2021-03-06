package com.sam;

import java.util.*;

public final class ObjectSorter {

	public static void main(String[] args) {
		List<Integer> myReceivedList = null;
		String mySortAlgorightm = null;
		//Assuming only two args
		if(args.length > 0){
			List<String> myArgs  = new ArrayList<String>();
			myReceivedList = new ArrayList<Integer>();
			Collections.addAll(myArgs, args);
			for (String string : myArgs) {
				if(string.matches("\\[(\\s*\\d*\\s*,)*\\d*\\]")){
					String txtArray = string
							.replaceAll("\\[", "")
							.replaceAll("\\]", "")
							.replaceAll("\\s", "");
					String[] array = txtArray.split(",");
					for (String value : array) {
						myReceivedList.add(Integer.parseInt(value));
					}
				} else {
					mySortAlgorightm = string;
				}
				
			}
		}
		SortConsoleInterpret main = new SortConsoleInterpret(myReceivedList, mySortAlgorightm);
		
		main.start();
	}
}

