package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class User_reco {
	
	public static void main(String[] args)throws Exception {
	
		recoM();
		
	}
		public static void Uboard() throws Exception {
			Scanner scan = new Scanner(System.in);
			Random rnd = new Random();
			String[] name = new String[10];
			String path= "D:\\데이터\\유저추천게시판";
			ArrayList<String> b = new ArrayList<String>(); 
			File board = new File(path);
			String[] user = board.list();
			

			
			for(String s : user) {
				b.add(s);
			}
			
			
			for(int i=0;i<10;i++) {
				name[i] = ""+rnd.nextInt(10);
				
			}
			
			System.out.println("=============================================");
			System.out.print("\t♩♪♬ 유저 추천 게시판♬♪♩\n");
			System.out.println("=============================================");
			for(int i=0;i<b.size();i++) {
				System.out.printf("%d.%s의 	노래추천\n",i+1,b.get(i));
			}
			System.out.println("---------------------------------------------");
			System.out.println("게시판 번호 입력 b.뒤로가기");
			System.out.print("입력:");
			String s = scan.nextLine();
			if(s.equals("b")) {
				MM.recMenu();
			}
			else {
			String bpath = "D:\\데이터\\유저추천게시판\\"+b.get(Integer.parseInt(s)-1);
			BufferedReader reader = new BufferedReader(new FileReader(bpath));
			String chk=null;
			while((chk=reader.readLine())!=null){
				System.out.println(chk);
			}
			}
			System.out.println("=============================================");
			System.out.println("1.검색 b.뒤로가기");
			Scanner csc = new Scanner(System.in);
			String cho = csc.nextLine();
			
			if(cho.equals("1")) {
				search.msearch();
			}
			else if(cho.equals("b")) {
				Uboard();
			}
		}
		
		public static void Uplaylist() throws Exception {
			MemberInfo m = new MemberInfo();
			Scanner scan = new Scanner(System.in);
			Random rnd = new Random();
			String[] name = new String[10]; 
			ArrayList<String> user = new ArrayList<String>();
			ArrayList<String> list = new ArrayList<String>();
			user = test.m2(favoriteList(m.getId()));
			
			

		
			System.out.println("=============================================");
			System.out.println("\t♩♪♬ 시작 화면 ♬♪♩");
			System.out.println("=============================================");
			for(int i=0;i<5;i++) {
				System.out.printf("%d.%s의 플레이리스트\n",i+1,user.get(i));
			}
			System.out.println("=============================================");
			System.out.print("입력:");
			int s = scan.nextInt();
			
			
			switch (s){
				case 1:
					String mpath = "D:\\데이터\\회원데이터\\"+user.get(1)+"\\"+user.get(1)+"playlist.txt";
					BufferedReader reader = new BufferedReader(new FileReader(mpath));
					String chk = null;
					while ((chk=reader.readLine())!=null) {
						list.add(chk);
					}
					
					System.out.printf("\t[%s의 플레이리스트]\t",user.get(0));
					pagingfile.page(list);
				break;
				case 2:
					System.out.printf("\t[%s의 플레이리스트]\t",user.get(1));
					pagingfile.page(list);
				break;
				case 3:
					System.out.printf("\t[%s의 플레이리스트]\t",user.get(2));
					pagingfile.page(list);
				break;
				case 4:
					System.out.printf("\t[%s의 플레이리스트]\t",user.get(3));
					pagingfile.page(list);
				break;
				case 5:
					System.out.printf("\t[%s의 플레이리스트]\t",user.get(4));
					pagingfile.page(list);
				break;
			}
		System.out.println("---------------------------------------------");
		System.out.println("1.재생 2.이전으로 3. 메인으로 4.검색");
		s = scan.nextInt();
		switch (s) {
			case 1:
				System.out.println("재생화면출력");
			break;
			case 2:
				recoM();
			break;
			case 3:
				System.out.println("메인화면 출력");
			break;
			case 4:
				System.out.println("검색화면 출력");
			break;
			
		
					
		}
		}
		public static String favoriteList(String id) {
			String path = "C:\\데이터\\회원데이터\\" + id + "\\" + id + "playlist.txt";
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
				if(songs.get(i).equals(allSong.get(j).getName())) {
					
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
					
//			System.out.println(myMusic);
			
			
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

		public static void recoM() throws Exception {
			Scanner scan = new Scanner(System.in);
			System.out.println("=============================================");
			System.out.println("\t♩♪♬ 유저 추천 ♬♪♩");
			System.out.println("=============================================");
			System.out.println("1.다른유저의 플레이 리스트");
			System.out.println("2.유저 추천 게시판");
			System.out.println("b.뒤로 가기");
			System.out.println("---------------------------------------------");
			System.out.print("입력:");
			String s = scan.nextLine();
			if(s.equals("1")) {
				Uplaylist();
			}
			else if(s.equals("2")){
				Uboard();
			}
			else if(s.equals("b")) {
				MM.Menu1();
			}
		}
		}
