package com.sam.factory;

import com.sam.algorithmImplementation.Bogosort;
import com.sam.algorithmImplementation.BubbleSort;
import com.sam.algorithmImplementation.Quicksort;
import com.sam.engine.SortEngine;

public final class SortEngineFactory {
	private SortEngine getDefault(){
		return new Quicksort();
	} 
	
	public SortEngine getNewOrDefault(
			String name, 
			String detail){
		SortEngine result = null;
		if(name != null){
			if(name.toLowerCase().lastIndexOf("quick") >= 0 ||
					name.toLowerCase().lastIndexOf("1") >= 0){
				result = new Quicksort();
			}
			if(name.toLowerCase().lastIndexOf("bogo") >= 0 ||
					name.toLowerCase().lastIndexOf("2") >= 0){
				result = new Bogosort();
			}
			if(name.toLowerCase().lastIndexOf("bubble") >= 0 ||
					name.toLowerCase().lastIndexOf("3") >= 0){
				result = new BubbleSort();
			}
		} else {
			result = getDefault();
		}
		if(detail != null && 
				(detail == "" ||
				detail.toLowerCase().lastIndexOf("1") >= 0 ||
				detail.toLowerCase().lastIndexOf("y") >= 0 ||
				detail.toLowerCase().lastIndexOf("si") >= 0)){
			result.showDetail(true);
		}
		return result;
	}
}
