package project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class wishList {
	
	static String id;
	static Scanner scan ;
	static MemberInfo m = new MemberInfo();
	//아이디 입력되었다고 가정.
	static {
		id = m.getId();
		scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		
		wishList();
		
	}

	static void wishList() {
		
		System.out.println("===============================");		
		System.out.println("위시리스트 메뉴입니다.");
		System.out.println("===============================");
		
		
		while(true) {
		
		System.out.println("===============================");
		System.out.println("추가 하고 싶은 노래의 제목을 입력하세요.");			
		System.out.println("===============================");

		System.out.println("b. 뒤로 가기");
		System.out.print("입력 : ");
		
		String title = scan.nextLine();
		if(!title.equals("b")) {
			//입력
			
			System.out.println("추가 하고 싶은 노래의 가수를 입력하세요.");
			System.out.print("입력 : ");

			String singer = scan.nextLine();
			
			//위시리스트 메뉴에 추가 
			String path = "D:\\데이터\\회원데이터\\" + id + "\\" + id + "wishlist.txt";
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(path , true)); //이어쓰기
				
				writer.write(title + "-" + singer + ".mp3" + "\r\n");
				
				
				
				writer.close();
				
			} catch (IOException e) {
				System.out.println("위시리스트 저장에 실패했습니다.");
			}
			
			System.out.println("===============================");

			System.out.println("위시리스트에 저장되었습니다.");
			
		} else {
			//뒤로 가기
			break;
		}
		
		}//while
	}
	
	
	
	
}

