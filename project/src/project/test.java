package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class test {
	
	static Scanner scan;
	static ArrayList<Member> favoriteMemList = new ArrayList<Member>();
	static String id ;
	static Random rnd;
	static MemberInfo m = new MemberInfo();
	static {
		scan = new Scanner(System.in);
		id = m.getId();
		rnd = new Random();
	}
	
	
	public static void main(String[] args) {
		
//		String id ="F:\\더미\\회원1\\";
//		File list = new File(id);
//		ArrayList<String> arr = new ArrayList<String>();
//		String[] ilist = list.list();
//		
		//회원 아이디 저장
//		for(String name : ilist) {
//			arr.add(name);
//		}
		

		
		//로그인한 아이디의 최애 장르
		System.out.println(favoriteList(m.getId()));
		//로그인한 아이디의 최애 장르와 최애 장르가 같은 사람들 ArrayList<String> id담겨있음
		System.out.println(m2(favoriteList(m.getId())));
		
		
		
		
	}//main



//로그인한 아이디의 최애 장르와 최애 장르가 같은 사람들
	 static ArrayList<String> m2(String string) {
		
		//string == 최애 장르
		String path  ="D:\\데이터\\회원데이터";
		File file  = new File(path);
		
		File[] names = file.listFiles();
		List<String> idList = new ArrayList<String>();
		
		//아이디 뽑아내기
		for(File name : names) {
			
			idList.add(name.getName());
			
		}
		//뽑은 아이디별로 장르뽑아서 리스트에 넣기
		for(int i = 0; i < idList.size() ; i ++) {
			//최애 장르가 같은 사람

			if(string.equals(favoriteList(idList.get(i)))){
				favoriteMemList.add(new Member(idList.get(i), favoriteList((idList.get(i)))));
			}
		}
		//뽑은 리스트에서 랜덤 돌리기
		ArrayList<String> finalList = new ArrayList<String>();
		
//		String name = temp1[rnd.nextInt(temp1.length)] + temp2[rnd.nextInt(temp2.length)] + temp2[rnd.nextInt(temp2.length)];

		
		
		while(true) {	
			if(!finalList.contains(favoriteMemList.get(rnd.nextInt(favoriteMemList.size())).id)) {
			finalList.add(favoriteMemList.get(rnd.nextInt(favoriteMemList.size())).id);
			}
			
			if(finalList.size() == 5) {
			break;
			}
		}
	
		return finalList;
		
	}

	
	
	

	public static String favoriteList(String id) {
		String path = "D:\\데이터\\회원데이터\\" + id + "\\" + id + "playlist.txt";
		File file= new File(path);
		//내 노래 저장
		List<String> songs = new ArrayList<String>();
		
		if(file.exists()) {
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null ) {
				songs.add(line);
			}
			
			reader.close();
		} catch (Exception e) {
			System.out.println("플레이리스트를 불러오지 못했습니다.");
		} 
		
		//전체 노래 불러오기
		List<File> allSong = supervisor.inputMusic();

		
		
		//장르저장
		HashMap<String, Integer> myMusic = new HashMap<String, Integer>();
		
		
		//내노래
		for(int i = 0; i < songs.size() ; i++) {
			
			//전체 노레
			for(int j = 0; j < allSong.size() ; j++) {
				//제목이 같은 경우
			if(songs.get(i).contains(allSong.get(j).getName())) {
				
				try {
					BufferedReader sreader = new BufferedReader (new FileReader(allSong.get(j)));
					String line = sreader.readLine(); 
					String genre1 = line.split(",")[0];
					String genre2 = line.split(",")[1];
					
					//첫번째 장르
					if(!myMusic.containsKey(genre1)) {
						myMusic.put(genre1,  1);
					} else {
						myMusic.put(genre1, myMusic.get(genre1) + 1);
					}
					
					//두번째 장르
					if(!myMusic.containsKey(genre2)) {
						myMusic.put(genre2,  1);
					} else {
						myMusic.put(genre2, myMusic.get(genre2) + 1);
					}                        
					
					
					
					sreader.close();
				} catch (Exception e) {
					System.out.println("장르 저장에 실패했습니다.");
					e.printStackTrace();
				}
				
				
				
			}
			
			
			}
			
		}
				
//		System.out.println(myMusic);
		
		
		 //value 가장 큰 key 찾기
	      Map.Entry<String, Integer> maxEntry = null; //??
	      
	      
	      
	      if(!myMusic.isEmpty()) {
	      for (Map.Entry<String, Integer> entry : myMusic.entrySet())
	      {
	          if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
	          {
	        	 
	              maxEntry = entry;
	          }
	      }
	      String favoritGan = maxEntry.getKey();
	      
	      
	      return favoritGan;} 
	      
		} else {
			return null;
		}
		return null;
	}
	
	
	
	
	
	
	
}//test




class Member{
	
	String id = null;
	String favoriteGan = null;
	public Member(String string, String favoriteList) {
		this.id = string;
		this.favoriteGan= favoriteList;
	}
	
}
