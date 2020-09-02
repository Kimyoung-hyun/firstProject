package com.project.bin.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class myType {
	
	static String id ;
	static Scanner scan;
	
	static {
		id = "baba88778";
		scan = new Scanner(System.in);
	}
	
	
	
	public static void main(String[] args) {
		
		//같은 나이대, 같은 성별의 멤버 이름 불러오기
		List<String> list = sameAgeGender(id);
		for(int i = 0; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}

		
		//모든 멤버의 선호도 불러오기
		allMemType();
		
		
		
		
		
	}//main



	private static List<String> sameAgeGender(String id) {
		String path = "F:\\더미\\회원\\" + id + "\\" + id + ".txt";
		String gender = "";
		String age = "";
		
		//내 나이대 & 성별 반환
		try {
			System.out.println(path);
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = reader.readLine();
			
			gender = line.split(",")[4];
			age = line.split(",")[3];
			
			reader.close();
		} catch (Exception e) {
			System.out.println("같은 나이대의 회원을 불러오는데 실패했습니다.");
			System.out.println(e);
		}
		
		
		//동일한 성별과 나이대의 회원 저장용 
		List<String> idList = new ArrayList<String>();
		
		path = "F:\\더미\\회원";
		
		File file = new File(path);
		File[] list = file.listFiles();
		
		
		//동일한 성별 & 동일한 나이대
		for(File mem : list) {
			String realId = mem.getName();
			String path2 = "F:\\더미\\회원\\" + realId + "\\" + realId + ".txt";
			
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader(path2));
				String line2 = reader.readLine();
				
				//성별 동일
				if(line2.split(",")[4].equals(gender) && Integer.parseInt(line2.split(",")[3])/10 == Integer.parseInt(age)/10) {
					idList.add(realId);
				}
				
				
				reader.close();
			} catch (Exception e) {
				System.out.println("파일 저장하기에 실패");
			}
			
			
		}
		
		return idList;
		
		
	}



	private static void allMemType() {
		//모든 멤버의 선호도 불러오기
		
		
		String path = "F:\\더미\\회원";
		File file = new File(path);
		File[] mems = file.listFiles();
		List<String> playlist = new ArrayList<String>();
		int index = 0;
		
		String[] genre = {"발라드", "댄스", "밴드", "클래식", "락", "R&B", "컨트리"
				, "OST", "트로트" ,"EDM", "재즈", "팝", "캐롤"};
		
		//각 장르가 몇개씩 듣고 있었는지 저장 될 hashMap
		
		
		
		
		for(File mem : mems) {
			//각 멤버 파일
			
			playlist = inputMusic.inputMusic(mem.getName());
			for(int i = 0; i < genre.length ; i++) {
				//장르 확인
				
				
			}
			
			index++;
		}
		
		
		
	}
	
	
	
	
	
}
