package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class search {
	public static void main(String[] args) throws Exception {
		nonmember();
	}
	public static void msearch() throws IOException, FileNotFoundException, Exception {
		File file = new File("D:\\데이터\\음악데이터"); 
		MemberInfo m = new MemberInfo();
		List<String> songList = new ArrayList<>();
	
		String[] list = file.list();
		for(String a : list) {
			songList.add(a.substring(0,a.lastIndexOf(".")));
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("=============================================");
		System.out.println("	♩♪♬ 검색 ♬♪♩");
		System.out.println("---------------------------------------------");
		
		System.out.print("입력 ▶");
		String input =scan.nextLine(); //reader.readLine();
		List <String> matchList = new ArrayList<String>(); 
		for (String string : songList) {
            if(string.contains(input)){
                matchList.add(string+"\n");
            }
		}
		pagingfile.page(matchList);
//    			else {
//    				System.out.println("없는 노래입니다");
//    				System.out.println("---------------------------------------------");
//    				System.out.println("1.검색");
//    				System.out.println("b.돌아가기");
//    				Scanner csc = new Scanner(System.in);
//    				String cho = csc.nextLine();
//    				if(cho.equals("1")) {
//         		msearch();
//         	}
//         	else if(cho.equals("b")) {
//         		MM.Menu1();
//    			}
//          }
	
		
		//System.out.println(matchList);
		Scanner scan_1 = new Scanner(System.in);
	
		System.out.println("재생할 노래를 입력하세요.");
		
		String input_1 =scan_1.nextLine();
		
		List<String> playList = new ArrayList<>();
		
		if(songList.contains(input_1)) {
			playList.add(input_1);
			player.plusMusic(input_1);
			player.memPlay();
		} 	
	}
//		 else {
//         	System.out.println("없는 노래입니다");
//         	System.out.println("---------------------------------------------");
//         	System.out.println("1.검색");
//         	System.out.println("b.돌아가기");
//         	Scanner csc = new Scanner(System.in);
//         	String cho = csc.nextLine();
//         	if(cho.equals("1")) {
//         		msearch();
//         	}
//         	else if(cho.equals("b")) {
//         		MM.Menu1();
//         	}
//		 }
//		}


	
	
		//비회원 if else 을 넣어야하고 그 variable은 받아야함 
	//System.out.println(playList);


	public static void nonmember() throws Exception {
		
		File file = new File("D:\\데이터\\음악데이터"); 
		MemberInfo m = new MemberInfo();
		List<String> songList = new ArrayList<>();
	
		String[] list = file.list();
		for(String a : list) {
			songList.add(a.substring(0,a.lastIndexOf(".")));
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("=============================================");
		System.out.println("	♩♪♬ 검색 ♬♪♩");
		System.out.println("---------------------------------------------");
		System.out.print("입력 ▶");
		String input =scan.nextLine(); //reader.readLine();
		List <String> matchList = new ArrayList<String>(); 
		for (String string : songList) {
            if(string.contains(input)){
                matchList.add(string+"\n");
            }
            
		}
		
		//System.out.println(matchList);
		pagingfile.page(matchList);
	
		Scanner scan_3 = new Scanner(System.in);
		
		System.out.println("[비회원]1분 미리듣기할 노래 제목을 입력하세요");
		
		String input_3 =scan_3.nextLine();
		
		if(songList.contains(input_3)) {
			player.nMemPlay(input_3);
		} else { 
			System.out.println("없는 노래입니다");
		}
	}	
	
}
	