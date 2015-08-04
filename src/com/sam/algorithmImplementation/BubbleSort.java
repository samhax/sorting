package com.sam.algorithmImplementation;

import java.util.List;

import com.sam.engine.SortEngine;

public final class BubbleSort extends SortEngine {

	private final String NAME = "Bubble sort";
	@Override
	public String getName(){
		return NAME;
	}

	@Override
	public void sort(List<Integer> list) {
		int size = list.size();
		boolean ordered;
		for (int o = 0; o < size; o++) {
			ordered = true;
			for (int i = 0; i < size - 1; i++) {
				if(list.get(i) > list.get(i + 1)){
					int temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);
					ordered = false;
				}
			}
			if(ordered){
				break;
			}
		}
	}
}
