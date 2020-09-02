package com.project.bin.test;

import java.io.File;

public class dsadasdas {

	
	public static void main(String[] args) {
		
		String id = "1004hw";
		System.out.println(id);
//		System.out.println(meminfo2.get(num-1)[0]);
		String path = "E:\\회원데이터\\" + id;
	
		System.out.println(path);
		File dir = new File(path);
		File[] list = dir.listFiles();
		
		for(File factor : list) {
			System.out.println(factor.delete());
		}
		dir.delete(); 
	}//main
}
