package project;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//import com.test.lambda.Item;

public class RecommendGenre {


	public static void main(String[] args) {
		
		try {
			recommGan();
		} catch (Exception e) {
			System.out.println("장르 추천 항목을 불러오지 못했습니다.");
			e.printStackTrace();
		}
		
	}//main




	public static void goHome() {
		System.out.println("홈화면 이동");
	}
	
	public static void goPlay() {

		
	}


	private static void recommGan() throws Exception {
		Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성
		String message;
		
	    boolean loop = true;
	    String out = "";
		
		for (;loop;) {
		
			System.out.println("=============================================");
			System.out.println("\t♩♪♬장르 추천♬♪♩");
			System.out.println("=============================================");
//			System.out.println("1. 나의 장르 추천\n2. 장르별 추천 \n\nb. 뒤로가기 \nh. 홈");
			System.out.println("1. 나의 장르 추천\n2. 장르별 추천 \nb. 뒤로가기");
	         System.out.println("---------------------------------------------");
		    System.out.print("입력 ▶ ");
		    //scan.skip("[\\r\\n]+");
		    message = scan.nextLine();
		    System.out.println("\n");
		    
		    if(message.equals("1")) {
		    	out = favoritGanRecom();
		    } else if(message.equals("2")){
		    	out = recomGan1();
			}else if(message.equals("b")) {
		    	System.out.println("추천 화면으로 이동합니다.");
		    	MM.recMenu();
		    	break;
//		    }else if(message.equals("h")) {
//		    	//goHome();//joo 홈메소드 추가하시오
//		    	out = "h";
//		    	break;
		    }else {
		    	System.out.println("정상적인 접근이 아닙니다 다시 입력하세요.");
//		    	pause();
		    }

//		    if("h".equals(out)) {
//		    	goHome();
//		    	break;
		    if("j".equals(out)) {
//		    	goPlay();
//		    	player.memPlay();
		    	break;
		    }
		}
		scan.close();
	}
	
	private static String recomGan1() throws Exception {
		
		Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성
		String message;	
		String choice = "";
		String out = "";
	    boolean loop = true;
	    List<String> genreList = rcmMusicListMain.getGenreCtg(); // 장르목록
	    
		for (;loop;) {

			System.out.println("=============================================");
//			System.out.println("장르별 추천");
			System.out.println("\t♩♪♬장르별 추천♬♪♩");
			System.out.println("=============================================");
	         
	        for( int i=0; i < genreList.size(); i++ ){
	        	System.out.println((i+1)+". "+genreList.get(i));
	        }
	        	
//	        System.out.println("b. 뒤로가기");
				
	         System.out.println("---------------------------------------------");
			
			System.out.println("원하는 장르의 번호를 입력해 주세요.(숫자)");
		    System.out.print("입력 ▶ ");
		      
		    message = scan.nextLine(); 

		    
		    String stMsg = "";
		    int iMessage = 0;
		    try {
		    	iMessage = Integer.parseInt(message);
		    	stMsg = "NUMBER";
		    }catch(Exception e){
		    	stMsg = "STRING";
		    }
		    
		    if("NUMBER".equals(stMsg)) {
		    	if( iMessage > genreList.size() ) {
			    	System.out.println("정상적인 접근이 아닙니다 다시 입력하세요.");
//			    	pause();
		    	}
		    	
		    	choice = genreList.get(iMessage-1);
		    }else {
		    	if(message.equals("b")) {
		    		System.out.println("장르 추천 화면으로 이동합니다.");
		    		break;
//		    	} else if(message.equals("h")) {
//		    		out="h";
//			    	break;	
		    	}else {
			    	System.out.println("정상적인 접근이 아닙니다 다시 입력하세요.");
//		    		pause();
		    	}
		    }
		    
	    	System.out.println("=============================================");
			System.out.println("\t♩♪♬추천 리스트♬♪♩");
	    	System.out.println("=============================================");
		    List<HashMap<String, String>> rList = getChoiceGan(choice);
//	        System.out.println("b. 뒤로가기");
	         System.out.println("---------------------------------------------");
		    out = singNumchoice(scan, rList);
			if(!"b".equals(out)) {
				break;
			}
		    /*
		    result = singNumchoice(scan, rList);
			if("h".equals(result)) {
				out="h";
		    	break;
			}*/
		}
		
		return out;
	}
	
	@SuppressWarnings("unchecked")
	public static List<HashMap<String, String>> getChoiceGan(String choice) {
		//List<rcmMusicListMain> musicLists = rcmMusicListMain.getAllList();
		List<rcmMusicListMain> musicLists = rcmMusicListMain.getAllMusic();
		
		List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> aMap = new HashMap<String, String>();
		HashMap<String, String> bMap = new HashMap<String, String>();
		
		musicLists.stream()
			.filter(musicList -> musicList.getGenre1().equals(choice) 
					|| musicList.getGenre2().equals(choice))
			.sorted((musicList1, musicList2) -> musicList2.getPlayNum() - musicList1.getPlayNum())
			.limit(10).forEach(musicList -> {
					//System.out.println(musicList.getSeq()+". "+musicList.getTitle()+" : "+musicList.getSinger());
					aMap.put("TITLE", musicList.getTitle());
					aMap.put("ITEM", musicList.getSinger());
					aList.add((HashMap<String, String>)aMap.clone());
				});
		
		
		for(int i=0; i<aList.size(); i++) {
			bMap = aList.get(i); 
			bMap.put("SEQ", i+1+"");
			System.out.println(bMap.get("SEQ")+". "+bMap.get("TITLE")+" : "+bMap.get("ITEM"));
			//System.out.println(aList.get(i).get("SEQ")+". "+aList.get(i).get("TITLE")+" : "+aList.get(i).get("ITEM"));
		}
		
		return aList; 
	}

	private static String favoritGanRecom() throws Exception {
		Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성
		String message;
		String out = "";
		
	    boolean loop = true;
		for (;loop;) {
			
			System.out.println("=============================================");
//			System.out.println("나의 장르");
			System.out.println("\t♩♪♬나의 장르♬♪♩");
			System.out.println("=============================================");
			System.out.printf("당신이 제일 좋아하는 장르는 [%s] 입니다.\n",getFavoritGan());
	         System.out.println("---------------------------------------------");
			System.out.printf("1. [%s] 추천! \nb. 뒤로가기 \n",getFavoritGan());
	         System.out.println("---------------------------------------------");
			
		    System.out.print("입력▶  ");
		      
		    message = scan.nextLine(); 
		    System.out.println();
		    
		    if(message.equals("1")) {
		    	
		    	System.out.println("=============================================");
				System.out.println("\t♩♪♬추천 리스트♬♪♩");
		    	System.out.println("=============================================");
				List<HashMap<String, String>> rList = serchGenre();
		        System.out.println("b. 뒤로가기");
		         System.out.println("---------------------------------------------");
//				System.out.println("=============================");
				
				/*
				result = singNumchoice(scan, rList);
				if("h".equals(result)) {
					//goHome();//joo 홈메소드 추가하시오
					out = "h";
			    	break;
				}*/
				out = singNumchoice(scan, rList);
				if(!"b".equals(out)) {
					break;
				}
		    }else if(message.equals("b")) {
		    	System.out.println("장르 추천 화면으로 이동합니다.");
		    	//recMenu();
		    	break;
//		    } else if(message.equals("h")) {
//		    	//System.out.println("홈 화면으로 이동합니다.");
//		    	out = "h";
//		    	//goHome();
//		    	break;	
		    }else {
		    	System.out.println("정상적인 접근이 아닙니다 다시 입력하세요.");
//		    	pause();
		    }
		}
		return out;
	}



/*
	static void singNumchoice(Scanner scan, List<HashMap<String, String>> pList) {
		String message;
		System.out.print("▶노래 번호 선택:");
		message = scan.nextLine();

		//jin 잘못된 키인시 정리
		
		for(int i=0; i<pList.size(); i++) {
			if(pList.get(i).get("SEQ").equals(message)) {
				System.out.println();
				System.out.println("----------------------------------");
				System.out.printf("%S번 노래를 재생합니다.%s(%s)\n",message,pList.get(i).get("TITLE"),pList.get(i).get("ITEM"));
				System.out.println("----------------------------------");
			}
		}
		
	}
	*/
	

	static String singNumchoice(Scanner scan, List<HashMap<String, String>> pList) throws Exception {
		
		String message;

//        System.out.println("---------------------------------------------");
//		System.out.println("b.백");
//        System.out.println("---------------------------------------------");
//		System.out.println("어떤 곡을 재생하시겠습니까?");
		System.out.print("입력 ▶ ");
		message = scan.nextLine();

		/*
		if("h".equals(message) || "b".equals(message)) {
			return message;
		}*/
		
		int iMessage = 0;
		String title = "";
		String singer = "";
		
		try {
	    	iMessage = Integer.parseInt(message);
	    }catch(Exception e){
	    	iMessage = 0;
	    }
		
		if(iMessage >= 1 && iMessage <= 10) {
			for(int i=0; i<pList.size(); i++) {
				if(pList.get(i).get("SEQ").equals(message)) {
					System.out.println();
			         System.out.println("---------------------------------------------");
					System.out.printf("%s - %s를 재생합니다.\n",pList.get(i).get("TITLE"),pList.get(i).get("ITEM"));
			         System.out.println("---------------------------------------------");
					message = "j";
					title = pList.get(i).get("TITLE");
					singer = pList.get(i).get("ITEM");
					player.plusMusic(title + "-" + singer);
					player.memPlay();
				
				}
			}
//		}else if(!"h".equals(message) && !"b".equals(message)){
		}else if(!"b".equals(message)){
	    	System.out.println("정상적인 접근이 아닙니다 다시 입력하세요.");
			singNumchoice(scan, pList);
		}

//		return title + "-" + singer ;
		return message;
	}
	
	

	//가장 좋아하는 장르 찾기
	public static String getFavoritGan() {		//List 불러오기
		List<String> genres1 = rcmMusicListMain.getL1Genres();
		List<String> genres2 = rcmMusicListMain.getL2Genres();
		
		//장르 List 합치기
		List <String> genres = new ArrayList<String>(genres1);
		genres.addAll(genres2);
		
		//잘 합쳐졌는지 확인
		
		//맵 만들기
		Map<String, Integer> ganMap = new HashMap<String, Integer>();
		
		for(int i = 0 ; i < genres.size(); i++) {
			
			//존재하면 count에 하나씩 더하기 -> value에 넣기
			if(ganMap.containsKey(genres.get(i))) {			
				ganMap.put(genres.get(i), ganMap.get(genres.get(i))+1);
			//존재하지 안으면 key 추가, value = 1	
			}else {
				ganMap.put(genres.get(i), 1);
			}
			
		}

		//value 가장 큰 key 찾기
		Map.Entry<String, Integer> maxEntry = null;

		for (Map.Entry<String, Integer> entry : ganMap.entrySet())
		{
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
		    {
		        maxEntry = entry;
		    }
		}
		String favoritGan = maxEntry.getKey();
		
		return favoritGan;
		
	}
	
//	static void pause() throws Exception{
//		System.out.println();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("네(엔터 입력)");
//		reader.readLine();		
//	}
	
	
	//가장 좋아하는 장르 기반 추천 노래
	private static List<HashMap<String, String>> serchGenre() {

		//List<rcmMusicListMain> musicLists = rcmMusicListMain.getAllList();
		List<rcmMusicListMain> musicLists = rcmMusicListMain.getAllMusic();
		
		List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> aMap = new HashMap<String, String>();
		HashMap<String, String> bMap = new HashMap<String, String>();
		
		musicLists.stream()
			//.sorted((item1, item2) -> item1.getName().compareTo(item2.getName()))
			
			.filter(musicList -> musicList.getGenre1().equals(getFavoritGan()) 
					|| musicList.getGenre2().equals(getFavoritGan()))
			.sorted((musicList1, musicList2) -> musicList2.getPlayNum() - musicList1.getPlayNum())
			.limit(10).forEach(musicList -> {
				aMap.put("TITLE", musicList.getTitle());
				aMap.put("ITEM", musicList.getSinger());
				aList.add((HashMap<String, String>)aMap.clone());
				});
		
		for(int i=0; i<aList.size(); i++) {
			bMap = aList.get(i); 
			bMap.put("SEQ", i+1+"");
			System.out.println(bMap.get("SEQ")+". "+bMap.get("TITLE")+" - "+bMap.get("ITEM"));
		}

		return aList;
		
	}

	

}//Recomm














