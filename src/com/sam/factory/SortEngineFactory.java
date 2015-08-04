package com.sam.factory;

import com.sam.algorithmImplementation.Bogosort;
import com.sam.algorithmImplementation.BubbleSort;
import com.sam.algorithmImplementation.Quicksort;
import com.sam.engine.SortEngine;

public final class SortEngineFactory {
	public SortEngine getDefault(){
		return new Quicksort();
	} 
	
	public SortEngine getNewOrDefault(String name){
		if(name != null){
			if(name.toLowerCase().lastIndexOf("quick") >= 0 ||
					name.toLowerCase().lastIndexOf("1") >= 0){
				return new Quicksort();
			}
			if(name.toLowerCase().lastIndexOf("bogo") >= 0 ||
					name.toLowerCase().lastIndexOf("2") >= 0){
				return new Bogosort();
			}
			if(name.toLowerCase().lastIndexOf("bubble") >= 0 ||
					name.toLowerCase().lastIndexOf("3") >= 0){
				return new BubbleSort();
			}
		}
		return getDefault();
	}
}
