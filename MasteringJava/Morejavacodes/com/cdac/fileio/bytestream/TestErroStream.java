package com.cdac.fileio.bytestream;

import java.io.IOException;

public class TestErroStream {
	public static void main(String[] args) throws IOException {

		int b = System.in.read();

		for(int i=0;i<5;i++){
			System.out.println("Hello");
			System.out.flush();
			System.err.println("Error");
		}
	}
}