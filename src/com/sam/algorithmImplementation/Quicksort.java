package com.sam.algorithmImplementation;

import java.util.LinkedList;
import java.util.List;

import com.sam.engine.SortEngine;

public final class Quicksort extends SortEngine {

	@Override
	public void Sort(List<Integer> arr) {
		//TODO: fix autism here
		List<Integer> result = quickSort(arr); 
		arr.clear();
		arr.addAll(result);
	}
	
	private List<Integer> quickSort(List<Integer> arr) {
		//taken from http://rosettacode.org/wiki/Sorting_algorithms/Quicksort#Java
		if (!arr.isEmpty()) {
		    Integer pivot = arr.get(0); //This pivot can change to get faster results
		 
		 
		    List<Integer> less = new LinkedList<Integer>();
		    List<Integer> pivotList = new LinkedList<Integer>();
		    List<Integer> more = new LinkedList<Integer>();
		 
		    // Partition
		    for (Integer i: arr) {
		        if (i.compareTo(pivot) < 0)
		            less.add(i);
		        else if (i.compareTo(pivot) > 0)
		            more.add(i);
		        else
		            pivotList.add(i);
		    }
		 
		    // Recursively sort sublists
		    less = quickSort(less);
		    more = quickSort(more);
		 
		    // Concatenate results
		    less.addAll(pivotList);
		    less.addAll(more);
		    return less;
		 }
		return arr;
	}

}
