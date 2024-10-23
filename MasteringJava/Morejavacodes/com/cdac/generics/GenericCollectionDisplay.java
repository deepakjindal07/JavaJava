package com.cdac.generics;

import java.util.Collection;

public class GenericCollectionDisplay {
	public static void display(Collection<?> list){
		for (Object obj : list) {
			System.out.println(obj);
		}
	}
}