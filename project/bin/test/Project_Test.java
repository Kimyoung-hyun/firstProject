package com.project.bin.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Project_Test {

	
	public static void main(String[] args) throws Exception{
		
		
		//음악 목록 불러와서 HashMap에 저장하기
		File file = new File("F:\\첫번째프로젝트\\ㅊ~ㅎ음악");
		File[] list = file.listFiles();
		
//		ArrayList<String[]> mlist = new ArrayList<String[]>();
		HashMap<String, String> mlist = new HashMap<String, String>();
		
		
		for (File name : list) {
			String path = "F:\\첫번째프로젝트\\ㅊ~ㅎ음악" + "\\" + name.getName();
			File file2 = new File(path);
			BufferedReader reader = new BufferedReader(new FileReader(file2));
			
			String line  = null;
			
			while((line = reader.readLine()) != null) {
				
//				String[] line2 = line.split(",");
//				System.out.println(line2);
//				System.out.println(line2[0]);
				mlist.put(name.getName(), line);
				
//				System.out.print(name.getName());
//				for(int i = 0 ; i < mlist.get(name.getName()).length ; i ++) {
//					System.out.print(mlist.get(name.getName())[i] + "\t");
//				}
//				
			}
			
//			System.out.println(name.getName());
				
			
				reader.close();
				
			}//for
			
	
	
		//검색하기
		//완전히 일치하지 않아도 나올 수 있게 할건지?
		Scanner scan = search(mlist);
		
		
		
		
		
		
		//검색했을 때 결과 없으면 -> 추가
		//새로 입력하기
		addMusic(scan);
		
		
		
		
		
		
		
		
		
		
		}//main




	private static Scanner search(HashMap<String, String> mlist) {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색 : ");
		String name =  scan.nextLine();
		
		//이름 일치
		if(mlist.containsKey(name)) {
			
			System.out.println(mlist.get(name));
			mlist.remove(name);
			
			
		} else {
			System.out.println("일치하는 항목이 없습니다. ");
		}
		return scan;
	}
	
	
	

	private static void addMusic(Scanner scan) throws IOException {
		
		
		System.out.print("노래 제목 : ");
		String title = scan.nextLine();

		System.out.println("가수 : ");
		String singer = scan.nextLine();
		 
		String path2 ="" + "\\" + title + "-" + singer + ".mp3";
		File nfile = new File(path2);
		
		System.out.print("장르 : ");
		String g1 =scan.nextLine();
		String g2 =scan.nextLine();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(nfile));
		
		//저장 + 닫기
		writer.write(g1 + "," + g2 + "," + "0" + "," + "0" );
		writer.close();
	}
		
		
		
		
		
		
		
		
	}

