package com.project.bin.test;

import java.io.File;

public class test {
	
	public static void main(String[] args) {
		
		String id = "1004hw";
		
		String path = "C:\\Users\\sist42\\Desktop\\회원데이터\\1004hw" ;

		File dir = new File(path);
		
		System.out.println(dir.isDirectory());
		
		File[] delmemlist = dir.listFiles();

		for(File file :  delmemlist) {
			System.out.println(file.delete());
		}
		
		
//		for(File file : delmemlist) {
//			file.delete(); //회원 정보 파일 + 플레이리스트 삭제
//		}
//		
		
		
		
		
		
		
		
	}//main
	
}//test
