package com.project.bin.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Project_member {

	static Scanner scan ;
	static ArrayList<String>mlist ;
	static String foundname ;
	static {
		foundname = "";
		mlist = new ArrayList<String>();
		scan = new Scanner(System.in);
	}
	
	
	public static void main(String[] args) throws Exception{
		
		//회원 정보 불러오기 + 저장
		getMember();
		
		
		//메뉴
		int answer = menu();
		
		
		//회원 정보 열람
		if(answer == 1) {
			answer = mlistmenu();
			
			//회원이름 검색
			if(answer == 1) {
				System.out.print("찾고 싶은 회원의 이름을 입력하시오 : ");

				scan.skip("\r\n");
				foundname = scan.nextLine();
				if(search(foundname)) {
					//멤버 지울지 말지
					deletemem();
				} 	
				
			}
			
			//회원 전체 리스트 보기
			if(answer == 2) {
				 showtotalmem();
			}
			
			
			//분류별 보기
			if(answer == 3) {
				System.out.println("1. 성별 2. 나잇대");
				answer = scan.nextInt();
				if(answer == 1) {
					System.out.println("1. 남성 2. 여성");
					answer = scan.nextInt();
					//남성 여성
					if(answer == 1) {
					showmale();
				} else {
					showfemale();
				}
			} else if(answer == 2){
				//나이대
				showage();
			} else {
				System.out.println("번호를 다시 입력하세요.");
			}
		}
	}
		//음악 라이브러리 보기
		else if(answer == 2) {
			
		}
		
			
			
		}//main
		
		
	//나이대 보여주는 클래스
	private static void showage() {
		
		System.out.println("나이대를 선택하시오.");
		System.out.println("1. 10대");
		System.out.println("2. 20대");
		System.out.println("3. 30대");
		System.out.println("4. 40대");
		System.out.println("5. 50대 이상");
		
		Integer answer = scan.nextInt();
				
		if(answer == 1) {
			agelist(answer);
		} else if(answer == 2) {
			agelist(answer);
		} else if(answer == 3 ) {
			agelist(answer);
		} else if(answer == 4) {
			agelist(answer);
		} else if(answer == 5) {
			agelist(answer);
		} else {
			System.out.println("잘 못 입력하셨습니다.");
		}
		
		
	}


	private static void agelist(Integer answer) {
		
		for(int i = 0; i < mlist.size() ; i++) {
			
			int age = Integer.parseInt(mlist.get(i).split(",")[3]);
			
			if(age >= (answer) * 10 && age < (answer+1) * 10) {
				System.out.println(mlist.get(i));
			}
		}
		
		
		
		
	}


	private static void showfemale() {

		for(int i = 0; i < mlist.size() ; i++) {
			if(mlist.get(i).split(",")[4].equals("여")) {
				System.out.println(mlist.get(i));
			}
		}
		
		
	}





	//main
	
	

	
	
	private static void showmale() {
		
		for(int i = 0; i < mlist.size() ; i++) {
			if(mlist.get(i).split(",")[4].equals("남")) {
				System.out.println(mlist.get(i));
			}
		}
		
	}





	private static void showtotalmem() {
		
		for(int i = 0 ; i < mlist.size() ; i++) {
			
			System.out.printf("%d : %s", i+1 , mlist.get(i));
			
			
		}
		
	
	}//showtotalmem





	//멤버 지우기
	private static void deletemem() {
		
		ArrayList<String> dellist = new ArrayList<String>();
		
		for(int i = 0; i < mlist.size(); i++) {
			//전달받은 회원정보 리스트인 ArrayList를 ","로 나누고 3번째인 이름과 비교
			if(mlist.get(i).split(",")[2].equals(foundname)){
				dellist.add(mlist.get(i));
			}
		
		
			//멤버 지우기
			System.out.println("지우실 멤버의 번호를 눌러주세요.");
			int num = scan.nextInt();
			scan.skip("\r\n");
			
//			dellist.get(num-1);
			System.out.println("확인");
			//멤버 존재하면 삭제
			System.out.printf("");
			if(mlist.contains(dellist.get(num-1))) {
				System.out.println("확인");
				mlist.remove(dellist.get(num-1));
				System.out.println(mlist);
				//파일 이름을 어떻게 하는건지,,? 넘버링  
				
				
				
				
			}
		
		
		
		}
		
		
		
		
	}






	//공통기능 "검색"
	private static boolean search(String foundname) {
		
		//검색 정확도 순으로.?...
		//검색하고 싶은 이름 받기
		
		Boolean flag = false;
		//받은 정보와 비교
		for(int i = 0; i < mlist.size(); i++) {
			//전달받은 회원정보 리스트인 ArrayList를 ","로 나누고 3번째인 이름과 비교
			if(mlist.get(i).split(",")[2].equals(foundname)){
				System.out.printf("%d : %s\n", i+1, mlist.get(i));
				flag = true;
			}
			
			
		}
		
		return flag;
		
	}//search





	private static int mlistmenu() {
		
		System.out.println("회원 정보 열람입니다.");
		System.out.println("1. 회원 이름 검색");
		System.out.println("2. 회원 전체 리스트 보기");
		System.out.println("3. 분류별 보기");
		System.out.print("번호를 골라주세요 :");
		int answer = scan.nextInt();
		
		return answer;
		
	}





	private static int menu() {
		
		System.out.println("관리자 모드입니다.");
		
		System.out.println("1. 회원 정보 열람");
		System.out.println("2. 음악 라이브러리 보기");
		System.out.println("3. 위시리스트 보기");
		System.out.print("번호를 골라주세요. : ");
		
		int answer = scan.nextInt();
		
		return answer;
	}//menu





	//회원 정보 불러오기
	public static void getMember() throws Exception{
		
		String path = "F:\\첫번째프로젝트\\회원정보\\";
		File file = new File(path);
		
		File[] list = file.listFiles();
		
		
		for(File member : list) {
			
		
			
			String path2 = path + member.getName();
			File mem2 = new File(path2);
			BufferedReader reader = new BufferedReader(new FileReader(mem2));
			
			mlist.add(reader.readLine());
			
			reader.close();
			
		}//for문
		
		
		
		
	}
	
	
	
}//member

