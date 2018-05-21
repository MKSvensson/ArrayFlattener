package com.marcus;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class ArrayFlattenerTest {

	@Test
	public void integersOnly() {
		Object[] items = {(Integer)1, (Integer)2, (Integer)3, (Integer)4, (Integer)5 };
		
		Integer[] expected = {1,2,3,4,5};
		assertTrue(Arrays.equals(expected, ArrayFlattener.flatten(items)));
	}
	
	@Test
	public void nestedAtStart() {
		Integer[] nested = {(Integer)1, (Integer)2};
		Object[] items = {nested, (Integer)3, (Integer)4, (Integer) 5 };
		
		Integer[] expected = {1,2,3,4,5};
		assertTrue(Arrays.equals(expected, ArrayFlattener.flatten(items)));
	}
	
	@Test
	public void nestedAtEnd() {
		Integer[] nested = {(Integer)4, (Integer)5};
		Object[] items = {(Integer)1, (Integer)2, (Integer) 3, nested };
		
		Integer[] expected = {1,2,3,4,5};
		assertTrue(Arrays.equals(expected, ArrayFlattener.flatten(items)));
	}
	
	@Test
	public void onlyNested() {
		Integer[] nested = {(Integer)1, (Integer)2};
		Integer[] nestedTwo = {(Integer)3, (Integer)4};
		Object[] items = {nested, nestedTwo};
		
		Integer[] expected = {1,2,3,4};
		assertTrue(Arrays.equals(expected, ArrayFlattener.flatten(items)));
	}
	
	@Test
	public void multipleNested() {
		Integer[] nested = {(Integer)1, (Integer)2};
		Object[] nestedTwo = {(Integer)3, (Integer)4, nested};
		Object[] items = {nestedTwo};
		
		Integer[] expected = {3,4,1,2};
		assertTrue(Arrays.equals(expected, ArrayFlattener.flatten(items)));
	}
	
	@Test
	public void ignoresBadValues() {
		Integer[] nested = {(Integer)4, (Integer)5};
		Object[] items = {(Double)1.0, (Integer)2, (Integer) 3, nested };
		
		Integer[] expected = {2,3,4,5};
		assertTrue(Arrays.equals(expected, ArrayFlattener.flatten(items)));
	}

}
