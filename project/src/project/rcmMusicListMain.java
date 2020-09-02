package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class rcmMusicListMain {
	
	private String title; 		//노래 제목
	private String singer;	//가수 이름
	private String genre1;	//장르1
	private String genre2;	//장르2	
	private int playNum;	//재생횟수
	private int love;			//좋아요
	static MemberInfo m = new MemberInfo();
	private static String gv_id = m.getId();
	//private static String gv_age = "14";
	private static String gv_age = m.getAge();
	
	private static String gv_dirMemPath 	= "D:\\데이터\\회원데이터\\"; //회원파일
	private static String gv_dirMusicPath 	= "D:\\데이터\\음악데이터\\";  //뮤직파일
	
	//생성자
	public rcmMusicListMain(String title, String singer, String genre1, String genre2, int playNum, int love) {
		super();
		this.title = title;
		this.singer = singer;
		this.genre1 = genre1;
		this.genre2 = genre2;
		this.playNum = playNum;
		this.love = love;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getGenre1() {
		return genre1;
	}

	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}

	public String getGenre2() {
		return genre2;
	}

	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}

	public int getPlayNum() {
		return playNum;
	}

	public void setPlayNum(int playNum) {
		this.playNum = playNum;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		this.love = love;
	}
	
	public static String getAge() {
		return gv_age;
	}
	
	//toString
	@Override
	public String toString() {
		return String.format("(%s - %s,%s,%s,%d,%d)\n"
				, this.title, this.singer, this.genre1, this.genre2 ,this.playNum,this.love);
	}
	
	
	//myplayList List 가져오는 메소드
	public static List<rcmMusicListMain> getList() {

		List<rcmMusicListMain> list = new ArrayList<rcmMusicListMain>();
		List<String> myPlayList = new ArrayList<String>();
		List<String> myPlaySongInfo = new ArrayList<String>();
		
		String dirPath1 = gv_dirMemPath + gv_id; //회원 플레이리스트 Dir
		String fileName1 = gv_id + "playlist.txt"; //회원 플레이리스트 FileName
		
		String[] mp3Nm;
		String[] mp3Info;
		
		// ID에 해당하는 PlayList를 가지고 온다.
		myPlayList = getArrByFile(dirPath1,fileName1);

		String stSongNm = "";
		String stSongInfo = "`";
		for(int i=0; i < myPlayList.size(); i++) {
			if(i==myPlayList.size()-1) {
				stSongNm = myPlayList.get(i)+".mp3";
			}else {
			stSongNm = myPlayList.get(i); //노래제목-가수.mp3
			}
			myPlaySongInfo = new ArrayList<String>();
			myPlaySongInfo = getArrByFile(gv_dirMusicPath,stSongNm);
			stSongInfo = myPlaySongInfo.get(0);
			
			mp3Nm = stSongNm.split("-");
			mp3Info = stSongInfo.split(","); 
			
			list.add(new rcmMusicListMain(mp3Nm[0], mp3Nm[1].replace(".mp3", ""), mp3Info[0], mp3Info[1], Integer.parseInt(mp3Info[2]), Integer.parseInt(mp3Info[3])));

		}
		return list;
	}
	
	//같은나이대 사람들 리스트 불러오기 getAgeAllList
	public static List<rcmMusicListMain> getAgeAllList() {

		List<rcmMusicListMain> list = new ArrayList<rcmMusicListMain>();
		List<String> memFileMusicArr = new ArrayList<String>();
		int i = 0;
		
		String[] stMemInfo;
		
		String dirPath1;// = "E:\\더미\\회원\\" + id; //회원 Dir
		String fileName1;// = id + ".txt"; //회원 정보 FileName
		String fileName2; //회원 플레이리스트 FileName
		
		//1.회원정보 File 읽어오기
		File file = new File(gv_dirMemPath);
	    File[] mlist = file.listFiles();
	    
	    String stMem;
	    String stId;
	    
	    for(i=0; i < mlist.length; i++) {
	    	stId = mlist[i].getName();
	    	dirPath1 = gv_dirMemPath + stId;
			fileName1 = stId + ".txt";
			fileName2 = stId + "playlist.txt";
			
			stMem = getArrByFile(dirPath1, fileName1).get(0);
			stMemInfo = stMem.split(",");
			
			// 나이 앞자리수가 같은 회원 ID 추출
			if(gv_age.substring(0, 1).equals( stMemInfo[3].substring(0, 1))) {
				//memArr.add(stId);
				//나이대가 같은 회원의 플레이리스트 더하기 
				memFileMusicArr.addAll(getArrByFile(dirPath1,fileName2));
			}
	    }
	    
	    String[] wkMp3;
	    String[] wkMp3Info;
	    String stMpInfo;
		//4. 읽어온 파일을 LayOut에 맞게 생성자로 MusicList Class 초기화하며 생성
		for(i=0; i<memFileMusicArr.size(); i++) {
//			System.out.println(i+"."+memFileMusicArr.get(i));
			if(i==315) {
				memFileMusicArr.set(315, "EV01-럼블피쉬.mp3");
			}
			wkMp3 = memFileMusicArr.get(i).split("-");
			stMpInfo = getArrByFile(gv_dirMusicPath, memFileMusicArr.get(i)).get(0);
			wkMp3Info = stMpInfo.split(",");
    		list.add(new rcmMusicListMain(wkMp3[0], wkMp3[1].replace(".mp3", ""), wkMp3Info[0], wkMp3Info[1], Integer.parseInt(wkMp3Info[2]), Integer.parseInt(wkMp3Info[3])));
    	}
		return list;
	}
	
	//전체 리스트 불러오기 getAllList
	public static List<rcmMusicListMain> getAllList() {

		List<rcmMusicListMain> list = new ArrayList<rcmMusicListMain>();

//		//jin test start
//		List<String> testAllFileMusicArr = getArrByFile("전체파일명");
//		
//		String[] fileData;
//		for(int i=0; i<testAllFileMusicArr.size(); i++) {
//			fileData = testAllFileMusicArr.get(i).split(",");
//			list.add(new rcmMusicListMain(fileData[0], fileData[1], fileData[2], fileData[3], Integer.parseInt(fileData[4]), Integer.parseInt(fileData[5])));
//		}
//		//jin test end
//		//jin 나중에 지우고 채우시오
		
		return list;
				
	}
	//=================================================================================================================================
	
	//장르1
	public static List<String> getL1Genres() {
		
		List<String> list = new ArrayList<String>();
		List<rcmMusicListMain> musicLists = getList();
		
		for(rcmMusicListMain musicList : musicLists) {
			list.add(musicList.getGenre1());
		}
		return list;
	}
	
	public static List<String> getL2Genres() {
		
		List<String> list = new ArrayList<String>();
		List<rcmMusicListMain> musicLists = getList();
		
		for(rcmMusicListMain musicList : musicLists) {
			list.add(musicList.getGenre2());
		}
		return list;
	}
	
	/*
	public static List<String> getTitles(){
		
		List<String> list = new ArrayList<String>();
		List<rcmMusicListMain> musicLists = getList();
		
		for(rcmMusicListMain musicList : musicLists) {
			list.add(musicList.getTitle());
		}
		return list;
	}
	*/
	
	public static List<String> getSingers(String pMessage){
		
		List<String> list = new ArrayList<String>();
		
		List<rcmMusicListMain> musicLists = null;
		if("1".equals(pMessage) ) {
			musicLists = getList();
		}else {
			musicLists = getAgeAllList();
		}
		
		for(rcmMusicListMain musicList : musicLists) {
			list.add(musicList.getSinger());
		}
		return list;
	}
	
	/*
	public static List<Integer> getPlayNums(){
		
		List<Integer> list = new ArrayList<Integer>();
		List<rcmMusicListMain> musicLists = getList();
		
		for(rcmMusicListMain musicList : musicLists) {
			list.add(musicList.getPlayNum());
		}
		return list;
	}
	*/
	
	public static List<String> getGenreCtg(){
		
		List<String> genreList = new ArrayList();
		genreList.add("발라드");
		genreList.add("댄스");
		genreList.add("밴드");
		genreList.add("클래식");
		genreList.add("락");
		genreList.add("RNB");
		genreList.add("컨트리");
		genreList.add("OST");
		genreList.add("트로트");
		genreList.add("EDM");
		genreList.add("재즈");
		genreList.add("POP");
		genreList.add("캐롤");
		
		return genreList;
	}
	
	
	//jin 파일명으로 파일 읽어와서  Arr로 리턴
	//public static List<String> getArrByFile(File pFile){
	public static List<String> getArrByFile(String pPath, String pFileName){
		
		String fillInfo = pPath+"\\"+pFileName;
		File file = new File(fillInfo);
		
		List<String> arrList = new ArrayList<String>();

		String line = null;		
		try {
    		BufferedReader reader = new BufferedReader(new FileReader(file));
    		while ((line = reader.readLine()) != null) {
    			arrList.add(line);
    		}
    		reader.close();
    		
    	} catch (Exception e) {
    		System.out.println("파일 리드에 실패했습니다.");
    		System.out.println(e);
    	}
    
		//파일 읽어와서 List<String>로 리턴
		
//		//jin test 절취선 start
//		if ("내뮤직파일명".equals(pFileName)) {
//			// jin 잘해라
//			memMusicList.add("가,A,댄스,EDM,1,10");
//			memMusicList.add("나,A,댄스,발라드,11,10");
//			memMusicList.add("다,A,댄스,발라드,2,10");
//			memMusicList.add("라,A,댄스,발라드,9,10");
//			memMusicList.add("바,B,댄스,발라드,12,10");
//			memMusicList.add("사,B,댄스,밴드,14,10");
//			memMusicList.add("아,B,댄스,밴드,3,10");
//			memMusicList.add("자,B,댄스,밴드,13,10");
//			memMusicList.add("차,B,댄스,캐롤,15,10");
//			memMusicList.add("카,B,댄스,캐롤,4,10");
//			memMusicList.add("타,C,댄스,클래식,17,10");
//			memMusicList.add("파,C,댄스,재즈,19,10");
//			memMusicList.add("하,C,댄스,OST,24,10");
//			memMusicList.add("기,C,댄스,POP,5,10");
//			memMusicList.add("니,D,댄스,EDM,8,10");
//			memMusicList.add("디,D,댄스,EDM,26,10");
//			memMusicList.add("리,D,댄스,EDM,6,10");
//			memMusicList.add("미,E,OST,EDM,28,10");
//			memMusicList.add("비,E,OST,EDM,7,10");
//			memMusicList.add("시,F,트로트,EDM,30,10");
//			memMusicList.add("이,G,락,EDM,38,10");
//		}else if ("전체파일명".equals(pFileName)) {
//			memMusicList.add("전가,A,댄스,EDM,1,10");
//			memMusicList.add("전나,A,댄스,발라드,11,10");
//			memMusicList.add("전다,A,댄스,발라드,2,10");
//			memMusicList.add("전라,A,댄스,발라드,9,10");
//			memMusicList.add("전바,B,댄스,발라드,12,10");
//			memMusicList.add("전사,B,댄스,밴드,14,10");
//			memMusicList.add("전아,B,댄스,밴드,3,10");
//			memMusicList.add("전자,B,댄스,밴드,13,10");
//			memMusicList.add("전차,B,댄스,캐롤,15,10");
//			memMusicList.add("전카,B,댄스,캐롤,4,10");
//			memMusicList.add("전타,C,댄스,클래식,17,10");
//			memMusicList.add("전파,C,댄스,재즈,19,10");
//			memMusicList.add("전하,C,댄스,OST,24,10");
//			memMusicList.add("전기,C,댄스,POP,5,10");
//			memMusicList.add("전니,D,댄스,EDM,8,10");
//			memMusicList.add("전디,D,댄스,EDM,26,10");
//			memMusicList.add("전리,D,댄스,EDM,6,10");
//			memMusicList.add("전미,E,OST,EDM,28,10");
//			memMusicList.add("전비,E,OST,EDM,7,10");
//			memMusicList.add("전시,F,트로트,EDM,30,10");
//			memMusicList.add("전이,G,락,EDM,38,10");
//		}
//		//jin test 절취선 end
		
		return arrList;
	}
	
	public static List<rcmMusicListMain> getAllMusic()  {
	      
		List<rcmMusicListMain> list = new ArrayList<rcmMusicListMain>();
		
	    String path = gv_dirMusicPath; //음악파일
	      
	    File file = new File(path);
	    File[] mlist = file.listFiles();
	    List<String> arrfile = new ArrayList<String>();

	    String[] wkMp3;
	    String[] wkMp3Memo;

	    for(int i=0; i<mlist.length; i++) {
	    	wkMp3 = mlist[i].getName().split("-");

	    	arrfile = getArrByFile(mlist[i].getParentFile().getPath(), mlist[i].getName());
	    	
	    	for(int j=0; j < arrfile.size(); j++) {
	    		wkMp3Memo = arrfile.get(j).split(",");
    			list.add(new rcmMusicListMain(wkMp3[0], wkMp3[1].replace(".mp3", ""), wkMp3Memo[0], wkMp3Memo[1], Integer.parseInt(wkMp3Memo[2]), Integer.parseInt(wkMp3Memo[3])));
	    	}
	    }
	    return list;
	 }
	
}