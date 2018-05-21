package com.marcus;
public class Main {
	
	public static void main(String[] args) {
		Integer[] nested = {(Integer)5, (Integer)6};
		Object[] items = {(Integer)1,(Integer)2,(Integer)3,(Integer)4 , nested, (Integer)7 };
		Integer[] results =  ArrayFlattener.flatten(items);
		for(Integer i : results) {
			System.out.println(i);
		}
	}
	

}
