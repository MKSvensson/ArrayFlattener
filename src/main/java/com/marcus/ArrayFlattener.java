package com.marcus;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayFlattener {
	/*
	 * Uses Object to allow arbitrarily nesting of arrays
	 */
	public static Integer[] flatten(Object[] input) {
		ArrayList<Integer> results = new ArrayList<>();
		for(Object item : input) {
			if(item instanceof Object[]) {
				results.addAll(Arrays.asList((Integer[])flatten((Object[])item)));
			} else if(item instanceof Integer){
				results.add((Integer)item);
			}
			else {
				//Invalid input, log this, will just use system.out for now and ignore the bad input)
				System.out.println("Bad input cant cast to Integer");
			}
		}
		return results.toArray(new Integer[results.size()]);
	}
}
