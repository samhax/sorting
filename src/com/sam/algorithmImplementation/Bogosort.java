package com.sam.algorithmImplementation;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.sam.engine.SortEngine;

public final class Bogosort extends SortEngine {
	
	public void Sort(List<Integer> list) {
		while (!isSorted(list)) {
			Collections.shuffle(list);
		}
	}
	
	private boolean isSorted(List<Integer> list) {
		if(list.isEmpty()){
			return true;
		}
		Iterator<Integer> it = list.iterator();
		Integer last = it.next();
		while(it.hasNext()){
			Integer current = it.next();
			if(last.compareTo(current) > 0){
				return false;
			}
			last = current;
		}
		return true;
	}
}
