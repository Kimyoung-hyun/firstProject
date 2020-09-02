package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class RecommendSinger {
	
	public static void main(String[] args)  {
		
		try {
			recommedSinger();
		} catch (Exception e) {
			System.out.println("가수 추천 항목을 불러오지 못했습니다.");
			e.printStackTrace();
		}


		
	}

	private static void recommedSinger() throws Exception {
		Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성
		String message;
		String out = "";
		
	    boolean loop = true;
		
		for (;loop;) {
		
			System.out.println("=============================================");
//			System.out.println("가수 추천");
			System.out.println("\t♩♪♬ 가수 추천 ♬♪♩");
			System.out.println("=============================================");
			System.out.println("1. 자주 들은 가수 추천\n2. 같은 나이대 추천 \nb. 뒤로가기");
	         System.out.println("---------------------------------------------");
			
		    System.out.print("입력 ▶ ");
		      
		    message = scan.nextLine(); 
		    System.out.println();
		    
		    if(message.equals("1")) {
	//		    favoritGanRecom();
		    	out = favoritSingerRecom(message);
	//		    break;
		    } else if(message.equals("2")){
	//	    	recomGan1();
		    	out = favoritSingerRecom(message);
		    	//System.out.println("s");
	//			break;
			}else if(message.equals("b")) {
				out = "b";
				MM.recMenu();
				break;
		    }else {
		    	System.out.println("정상적인 접근이 아닙니다 다시 입력하세요.");
//		    	RecommendGenre.pause();
		    }
		    if("j".equals(out)) {
//		    	goPlay();
//		    	player.memPlay();
		    	break;
		    }
		    
//		    if("h".equals(out)) {
//		    	RecommendGenre.goHome();
//		    	break;
//		    }
		
		}
	}
	
	
	private static String favoritSingerRecom(String pMessage) throws Exception {
		Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성
		String message;
		String out="";
		String result="";
		
	    boolean loop = true;
	    
	    String wkFstAge = rcmMusicListMain.getAge().substring(0, 1);
		
		for (;loop;) {
			if("1".equals(pMessage) ) {
				System.out.println("=============================================");
//				System.out.println("자주 들은 가수");
				System.out.println("\t♩♪♬ 자주 들은 가수 ♬♪♩");
				System.out.println("=============================================");
				System.out.printf("당신이 ");
			}else {
				System.out.println("=============================================");
//				System.out.println("같은 나이대 추천");
				System.out.println("\t♩♪♬ 같은 나이대 추천 ♬♪♩");
				System.out.println("=============================================");
				System.out.printf("["+wkFstAge+"0대]가 ");
			}
			
			List<rcmMusicListMain> musicLists = rcmMusicListMain.getAllMusic();
			
			List<String> wkFavorCtg = getFavoritSing(pMessage);
			if(wkFavorCtg.size()<1){
				System.out.printf("추천에 필요한 데이터가 부족합니다 많은 이용 바랍니다.\n");
				break;
			}
			
			System.out.printf("좋아하는 가수는\n[%s, %s, %s\n, %s, %s] 입니다.\n"
									,wkFavorCtg.get(0)
									,wkFavorCtg.get(1)
									,wkFavorCtg.get(2)
									,wkFavorCtg.get(3)
									,wkFavorCtg.get(4));
	         System.out.println("---------------------------------------------");
			System.out.printf("1. [%s] 추천!\n2. [%s] 추천!\n3. [%s] 추천!\n4. [%s] 추천!"
					+ "\n5. [%s] 추천!\nb. 뒤로가기\n"
									,wkFavorCtg.get(0)
									,wkFavorCtg.get(1)
									,wkFavorCtg.get(2)
									,wkFavorCtg.get(3)
									,wkFavorCtg.get(4));
			
			
	         System.out.println("---------------------------------------------");
			System.out.println("원하는 가수의 번호를 입력해 주세요.(숫자)");
		        
		    System.out.print("입력 ▶ ");
		      
		    message = scan.nextLine(); 
		    System.out.println();
		    
		    String choice = "";
		    if(message.equals("1")) {
		    	choice = wkFavorCtg.get(0);
		    }else if(message.equals("2")){
		    	choice = wkFavorCtg.get(1);
			}else if(message.equals("3")){
		    	choice = wkFavorCtg.get(2);
			}else if(message.equals("4")){
		    	choice = wkFavorCtg.get(3);
			}else if(message.equals("5")){
		    	choice = wkFavorCtg.get(4);
			}else if(message.equals("b")) {
		    	//System.out.println("가수 추천 화면으로 이동합니다.");
		    	//recommSinger();
		    	break;
//		    } else if(message.equals("h")) {
//		    	//System.out.println("홈 화면으로 이동합니다.");
//		    	out = "h";
//		    	break;	
		    }else {
		    	System.out.println("정상적인 접근이 아닙니다 다시 입력하세요.");
//		    	RecommendGenre.pause();
		    }
		    
	         System.out.println("=============================================");
			 System.out.println("\t♩♪♬추천 리스트♬♪♩");
	         System.out.println("=============================================");
	    	List<HashMap<String, String>> rList = serchSinger(choice);
	    	System.out.println("b. 뒤로가기");
	         System.out.println("---------------------------------------------");
			
			result = RecommendGenre.singNumchoice(scan, rList);
//			if("h".equals(result)) {
//				out="h";
//		    	break;
//			}
//	    	break;
		}
		return out;
	}

	public static List<String> getFavoritSing(String pMessage) {		//List 불러오기
		List<String> singers = rcmMusicListMain.getSingers(pMessage);
		
		//맵 만들기
		Map<String, Integer> singerMap = new HashMap<String, Integer>();
		
		for(int i = 0 ; i < singers.size(); i++) {
			
			//존재하면 count에 하나씩 더하기 -> value에 넣기
			if(singerMap.containsKey(singers.get(i))) {			
				singerMap.put(singers.get(i), singerMap.get(singers.get(i))+1);
			//존재하지 않으면 key 추가, value = 1	
			}else {
				singerMap.put(singers.get(i), 1);
			}
			
		}

		//value 오름차순 정리
		List<String> singerList = new ArrayList<>(singerMap.keySet());
		Collections.sort(singerList, (o1, o2) -> (singerMap.get(o2).compareTo(singerMap.get(o1))));

		/*
		String singersList = "";
		for(int i = 0;i<5;i++) {
			singersList = new String(singerList.get(i));
		}
		*/
		
		return singerList;
	}
	
	private static List<HashMap<String, String>> serchSinger(String choice) {

		//List<rcmMusicListMain> musicLists = rcmMusicListMain.getList();
		//List<rcmMusicListMain> musicLists = rcmMusicListMain.getAllList();
		List<rcmMusicListMain> musicLists = rcmMusicListMain.getAllMusic();
		

		List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> aMap = new HashMap<String, String>();
		HashMap<String, String> bMap = new HashMap<String, String>();
		
		musicLists.stream()
			//.sorted((item1, item2) -> item1.getName().compareTo(item2.getName()))
			
			.filter(musicList -> musicList.getSinger().equals(choice)) 
			.sorted((musicList1, musicList2) -> musicList2.getPlayNum() - musicList1.getPlayNum())
			.limit(10).forEach(musicList -> {
				aMap.put("TITLE", musicList.getTitle());
				aMap.put("ITEM", musicList.getSinger());
				aList.add((HashMap<String, String>)aMap.clone());
				//System.out.println(musicList);
				});
		
		for(int i=0; i<aList.size(); i++) {
			bMap = aList.get(i); 
			bMap.put("SEQ", i+1+"");
			System.out.println(bMap.get("SEQ")+". "+bMap.get("TITLE")+" : "+bMap.get("ITEM"));
		}
		
		return aList;
		
	}
	
	
}


