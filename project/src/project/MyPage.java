package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MyPage {

	static MemberInfo m = new MemberInfo();
	
	public static void main(String[] args) {
		
		try {
			//startPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void startPage() throws Exception{ //시작
		
		//while(true) {
		
		System.out.println("=============================================");
		System.out.println("\t♩♪♬ 시작 화면 ♬♪♩");
		System.out.println("=============================================");
		System.out.println("\t1. Top10 더보기");
		System.out.println("\t2. 검색");
		System.out.println("\t3. 로그인");
		System.out.println("\t4. 회원가입");
		System.out.println("---------------------------------------------");
        System.out.print("입력 ▶  ");
		//System.out.println("5. 관리자");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		int key = 0;
		try {
			key = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        while (key != 0) {
            switch (key) {
            	case 1:
            		System.out.println("=============================================");
            		System.out.println("\t♩♪♬ Top100 ♬♪♩");
            		System.out.println("=============================================");
            		pagingfile.page(project.Top100.top100());
            		break;
            	case 2:
            		memberWithdraw();
            		break;
                case 3:
                    login();
                    break;
                case 4:
                    signUp();
                    break;
                //case 5: 관리자
            }
        }
        	
	
	
	}
	
	public static void memberInfo() throws Exception{ //회원정보
		
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String path = "D:\\더미\\data\\음악데이터" + m.getId() + "\\" + m.getId() + ".txt"; //이 경로
		
		System.out.println();
		System.out.println("=============================================");
		System.out.println("\t♩♪♬ 회원 정보 ♬♪♩");
		System.out.println("=============================================");
		System.out.println("\t아이디 ▶ " + m.getId());
		System.out.println("\t비밀번호 ▶ " + m.getPwd());
		System.out.println("\t이름 ▶ " + m.getName());
		System.out.println("\t나이 ▶ " + m.getAge());
		System.out.println("\t성별 ▶ " + m.getGender());
		System.out.println("=============================================");
		System.out.println("\t1. 회원 정보 수정");
		System.out.println("\tb. 뒤로가기");
		System.out.println("---------------------------------------------");
        System.out.print("입력 ▶  ");
		
		if(reader.readLine().equals("1")) memberInfoModify();
		else MM.Menu1();
		
		reader.close();
			
		
	}

	public static void memberInfoModify() throws Exception{ //수정
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] members = new String[5];
		
		String path = "D:\\데이터\\회원데이터\\" + m.getId() + "\\" + m.getId() + ".txt"; //이거
		
		File file = new File(path);
		
		FileWriter writer = new FileWriter(path);
			
		System.out.println("=============================================");
		System.out.println("\t♩♪♬ 회원 정보 수정♬♪♩");
		System.out.println("=============================================");
		
		System.out.print("아이디 ▶ "); //id
		members[0] = reader.readLine();
		m.setId(members[0]);
		
		System.out.print("비밀번호 ▶ "); //pwd
		members[1] = reader.readLine();
		m.setPwd(members[1]);
		
		System.out.print("이름 ▶ "); //name
		members[2] = reader.readLine();
		m.setName(members[2]);
		
		System.out.print("나이 ▶ "); //age
		members[3] = reader.readLine();
		m.setAge(members[3]);
		
		System.out.print("성별 ▶ "); //gender
		members[4] = reader.readLine();
		m.setGender(members[4]);
		
		
		for(int i=0; i<members.length; i++) {
			if(i == 4) writer.write(members[i]);
			else writer.write(members[i] + ",");
		}
		
		writer.close();

		System.out.println("회원정보수정이 완료되었습니다.");
		
		memberInfo();
		
	}

	

	public static void myPage() throws Exception{ //마이페이지
		
		while(true) {
		
		System.out.println("=============================================");
		System.out.println("\t♩♪♬ 마이 페이지 ♬♪♩");
		System.out.println("=============================================");
		System.out.println("\t1. 회원정보");
		System.out.println("\t2. 회원탈퇴");
		System.out.println("\t3. 위시리스트");
		System.out.println("\t4. 나의선호도");
		System.out.println("\t5. 뒤로가기");
		System.out.println("---------------------------------------------");
        System.out.print("입력 ▶  ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int key = 0;
		try {
			key = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        while (key != 0) {
            switch (key) {
            	case 1:
            		memberInfo();
            		break;
            	case 2:
            		memberWithdraw();
            		break;
                case 3:
                	wishList();
                    break;
                case 4:
                	myType();
                    break;
                case 5:
                	MM.Menu1();
                	break;
                   
            }
       
            
        }
		}
		
	}

	public static void myType() throws Exception{ //나의선호도
		
		
		List<String> a = sameAgeGender(m.getId()); //같은 나이대, 성별의 아이디들
		

		int rock=0, balad=0, hiphop=0, rnb=0, pop=0, carol=0, edm=0, band=0,
				ost=0, trot=0, dance=0, country=0, jazz=0, classic = 0;
		
		int mrock=0, mbalad=0, mhiphop=0, mrnb=0, mpop=0, mcarol=0, medm=0, mband=0,
				most=0, mtrot=0, mdance=0, mcountry=0, mjazz=0, mclassic = 0; //내 장르 카운트
		
		int index=0;
		int mindex=0;
		String g="락";
		String mg="락";
		int totalNum = 0;
		
		ArrayList<Integer> glist = new ArrayList<Integer>(); //장르
		ArrayList<Integer> mglist = new ArrayList<Integer>(); //내 장르
		
		
		for(int j=0; j<a.size(); j++) {
		
			String path = "D:\\데이터\\회원데이터\\" + a.get(j) + "\\" + a.get(j) + "playlist.txt";
			
		
			File file = new File(path);
		
		
			if(file.exists()) {
			
				ArrayList<String> list = new ArrayList<String>();
			
				BufferedReader freader = new BufferedReader(new FileReader(path));
			
			
				String line = null;
			
				while ((line = freader.readLine()) != null) {
					list.add(line);
				}
			
			
				freader.close();	
			
				//rock, balad, hiphop, rnb, pop, carol, edm, band, ost, trot, classic, dance, country, jazz
			
				for(int i=0; i<list.size(); i++) {
			
				String mpath = "D:\\데이터\\음악데이터\\"+list.get(i);
				
				BufferedReader reader = new BufferedReader(new FileReader(mpath));
		         
		        String mline = reader.readLine();
		        
		        String genre1 = mline.split(",")[0];
		        String genre2 = mline.split(",")[1];
		        
		       
			    if(a.get(j).equals(m.getId())) {
			    	
			    	switch(genre1) {
			        case "락":
			        	mrock++;
			        	break;
			        case "발라드":
			        	mbalad++;
			        	break;
			        case "힙합":
			        	mhiphop++;
			        	break;
			        case "R&B":
			        	mrnb++;
			        	break;
			        case "POP":
			        	mpop++;
			        	break;
			        case "캐롤":
			        	mcarol++;
			        	break;
			        case "EDM":
			        	medm++;
			        	break;
			        case "밴드":
			        	mband++;
			        	break;
			        case "OST":
			        	most++;
			        	break;
			        case "트로트":
			        	mtrot++;
			        	break;
			        case "클래식":
			        	mclassic++;
			        	break;
			        case "댄스":
			        	mdance++;
			        	break;
			        case "컨트리":
			        	mcountry++;
			        	break;
			        case "재즈":
			        	mjazz++;
			        	break;
			        }
			        
			        switch(genre2) {
			        case "락":
			        	mrock++;
			        	break;
			        case "발라드":
			        	mbalad++;
			        	break;
			        case "힙합":
			        	mhiphop++;
			        	break;
			        case "R&B":
			        	mrnb++;
			        	break;
			        case "POP":
			        	mpop++;
			        	break;
			        case "캐롤":
			        	mcarol++;
			        	break;
			        case "EDM":
			        	medm++;
			        	break;
			        case "밴드":
			        	mband++;
			        	break;
			        case "OST":
			        	most++;
			        	break;
			        case "트로트":
			        	mtrot++;
			        	break;
			        case "클래식":
			        	mclassic++;
			        	break;
			        case "댄스":
			        	mdance++;
			        	break;
			        case "컨트리":
			        	mcountry++;
			        	break;
			        case "재즈":
			        	mjazz++;
			        	break;
			        }
		        
			    } else {
		    	
			    switch(genre1) {
		        case "락":
		        	rock++;
		        	break;
		        case "발라드":
		        	balad++;
		        	break;
		        case "힙합":
		        	hiphop++;
		        	break;
		        case "R&B":
		        	rnb++;
		        	break;
		        case "POP":
		        	pop++;
		        	break;
		        case "캐롤":
		        	carol++;
		        	break;
		        case "EDM":
		        	edm++;
		        	break;
		        case "밴드":
		        	band++;
		        	break;
		        case "OST":
		        	ost++;
		        	break;
		        case "트로트":
		        	trot++;
		        	break;
		        case "클래식":
		        	classic++;
		        	break;
		        case "댄스":
		        	dance++;
		        	break;
		        case "컨트리":
		        	country++;
		        	break;
		        case "재즈":
		        	jazz++;
		        	break;
		        }
		        
		        switch(genre2) {
		        case "락":
		        	rock++;
		        	break;
		        case "발라드":
		        	balad++;
		        	break;
		        case "힙합":
		        	hiphop++;
		        	break;
		        case "R&B":
		        	rnb++;
		        	break;
		        case "POP":
		        	pop++;
		        	break;
		        case "캐롤":
		        	carol++;
		        	break;
		        case "EDM":
		        	edm++;
		        	break;
		        case "밴드":
		        	band++;
		        	break;
		        case "OST":
		        	ost++;
		        	break;
		        case "트로트":
		        	trot++;
		        	break;
		        case "클래식":
		        	classic++;
		        	break;
		        case "댄스":
		        	dance++;
		        	break;
		        case "컨트리":
		        	country++;
		        	break;
		        case "재즈":
		        	jazz++;
		        	break;
		        }
	        
			}
		
			}
			
			} else {
				System.out.println("파일 없음");
			}
		
		}
		
		//System.out.println(rock);
		
		glist.add(rock);
		glist.add(balad);
		glist.add(hiphop);
		glist.add(rnb);
		glist.add(pop);
		glist.add(carol);
		glist.add(edm);
		glist.add(band);
		glist.add(ost);
		glist.add(trot);
		glist.add(classic);
		glist.add(dance);
		glist.add(country);
		glist.add(jazz);
		
		ArrayList<Integer> slist = new ArrayList<Integer>();
		
		for(int k=0; k<glist.size(); k++) { //slist는 정렬용 복사본
			slist.add(k, glist.get(k));
		}
		
		
		
//			for(int m = 0; m < glist.size() ; m++) {
//				totalNum += glist.get(m);
//			}
//			
//			System.out.println(totalNum);
		
		slist.sort(null); //오름차순정렬
		
		
		if(balad == glist.get(glist.size()-1)) {
			index = 1;
			g = "발라드";
		}
		else if(hiphop == glist.get(glist.size()-1)) {
			index = 2;
			g = "힙합";
		}
		else if(rnb == glist.get(glist.size()-1)) {
			index = 3;
			g = "R&B";
		}
		else if(pop == glist.get(glist.size()-1)) {
			index = 4;
			g = "POP";
		}
		else if(carol == glist.get(glist.size()-1)) {
			index = 5;
			g = "캐롤";
		}
		else if(edm == glist.get(glist.size()-1)) {
			index = 6;
			g = "EDM";
		}
		else if(band == glist.get(glist.size()-1)) {
			index = 7;
			g = "밴드";
		}
		else if(ost == glist.get(glist.size()-1)) {
			index = 8;
			g = "OST";
		}
		else if(trot == glist.get(glist.size()-1)) {
			index = 9;
			g = "트로트";
		}
		else if(dance == glist.get(glist.size()-1)) {
			index = 10;
			g = "댄스";
		}
		else if(country == glist.get(glist.size()-1)) {
			index = 11;
			g = "컨트리";
		}
		else if(jazz == glist.get(glist.size()-1)) {
			index = 12;
			g = "재즈";
		}
		else if(classic == glist.get(glist.size()-1)) {
			index = 13;
			g = "클래식";
		}
		
		ArrayList<Integer> smlist = new ArrayList<Integer>();
		
		mglist.add(mrock);
		mglist.add(mbalad);
		mglist.add(mhiphop);
		mglist.add(mrnb);
		mglist.add(mpop);
		mglist.add(mcarol);
		mglist.add(medm);
		mglist.add(mband);
		mglist.add(most);
		mglist.add(mtrot);
		mglist.add(mclassic);
		mglist.add(mdance);
		mglist.add(mcountry);
		mglist.add(mjazz);
		
		for(int k=0; k<mglist.size(); k++) { //slist는 정렬용 복사본
			smlist.add(k, mglist.get(k));
		}
		
		//System.out.println(slist);
		
		smlist.sort(null); //내 리스트 오름차순정렬
		
		if(balad == mglist.get(mglist.size()-1)) {
			mindex = 1;
			mg = "발라드";
		}
		else if(hiphop == mglist.get(mglist.size()-1)) {
			mindex = 2;
			mg = "힙합";
		}
		else if(rnb == mglist.get(mglist.size()-1)) {
			mindex = 3;
			mg = "R&B";
		}
		else if(pop == mglist.get(mglist.size()-1)) {
			mindex = 4;
			mg = "POP";
		}
		else if(carol == mglist.get(mglist.size()-1)) {
			mindex = 5;
			mg = "캐롤";
		}
		else if(edm == mglist.get(mglist.size()-1)) {
			mindex = 6;
			mg = "EDM";
		}
		else if(band == mglist.get(mglist.size()-1)) {
			mindex = 7;
			mg = "밴드";
		}
		else if(ost == mglist.get(mglist.size()-1)) {
			mindex = 8;
			mg = "OST";
		}
		else if(trot == mglist.get(mglist.size()-1)) {
			mindex = 9;
			mg = "트로트";
		}
		else if(dance == mglist.get(mglist.size()-1)) {
			mindex = 10;
			mg = "댄스";
		}
		else if(country == mglist.get(mglist.size()-1)) {
			mindex = 11;
			mg = "컨트리";
		}
		else if(jazz == mglist.get(mglist.size()-1)) {
			mindex = 12;
			mg = "재즈";
		}
		else if(classic == mglist.get(mglist.size()-1)) {
			mindex = 13;
			mg = "클래식";
		}
		
		
		for(int m = 0; m < glist.size() ; m++) {
			totalNum += glist.get(m);
		}
		

		double mytotalNum = 0;
		
		for(int i = 0; i < mglist.size() ; i++) {
			mytotalNum += mglist.get(i);
		}
		
//		System.out.println(mglist); //내 리스트
//		System.out.println(mg); //내 선호 장르명
//		System.out.println(mindex); //선호 장르의 위치값
//		System.out.println(mglist.get(mindex)); //선호 장르 들은 횟수
//		System.out.println(mytotalNum); //내 리스트에서 전체 장르 횟수 다 더한 것
//		
//		System.out.println(glist); //동년배 리스트
//		System.out.println(g); //동년배 선호 장르명
//		System.out.println(index); //동년배 선호 장르의 위치값
//		System.out.println(glist.get(index)); //동년배들 선호 장르 들은 횟수
//		System.out.println(totalNum); //동년배들 전체 장르 다 더한 것
		
		//(내가 나의 선호 장르를 들은 횟수 / 나의 전체 음악 횟수) * 100
		System.out.printf("당신은 동년배중에서 총 %.1f%%의 취향을 가지고 있습니다.\n", ((double)(glist.get(mindex))/totalNum) * 100);
		
	
		
		myPage();
	}

	
	
	private static List<String> sameAgeGender(String id) {
		
		  String path = "D:\\더미\\data\\회원데이터\\" + id + "\\" + id + ".txt";
	      String gender = "";
	      String age = "";
	      
	      //내 나이대 & 성별 반환
	      try {
	         
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
	      
	      path = "D:\\더미\\data\\회원데이터";
	      
	      File file = new File(path);
	      File[] list = file.listFiles();
	      
	      
	      //동일한 성별 & 동일한 나이대
	      for(File mem : list) {
	         String realId = mem.getName();
	         
	         String path2 = "D:\\더미\\data\\회원데이터\\" + realId + "\\" + realId + ".txt";
	         
	         
	         try {
	            BufferedReader reader = new BufferedReader(new FileReader(path2));
	            String line2 = reader.readLine();
	            
	            //성별 동일
	            if(line2.split(",")[4].equals(gender) && (Integer.parseInt(line2.split(",")[3])/10 == Integer.parseInt(age)/10)) {
	               idList.add(mem.getName());
	            }
	            
	            
	            reader.close();
	         } catch (Exception e) {
	            System.out.println("파일 저장하기에 실패");
	         }
	         
	         
	      }
	      
	      return idList;
	      
	      
	   }
	
	
	
	
	
	public static void wishList() throws Exception{ //위시리스트
		
		System.out.println("=============================================");
        System.out.println("\t♩♪♬ 위시 리스트 ♬♪♩");
        System.out.println("=============================================");
		
		String path = "D:\\더미\\data\\회원데이터\\" + m.getId() + "\\" + m.getId() + "wishlist.txt"; 
		
		File file = new File(path);
		
		if(file.exists()) {
			
			ArrayList<String> list = new ArrayList<String>();
			
			BufferedReader freader = new BufferedReader(new FileReader(path));
			
			String line = null;
			
			while ((line = freader.readLine()) != null) {
				list.add(line);
			}
			
			freader.close();	
			
			
			for (String wish : list) {
				System.out.println(wish);
			}
			
			
		} else {
			System.out.println("파일 없음");
		}

		myPage();
		
		
		}
		
		
	
	

	public static void memberWithdraw() throws Exception{ //회원탈퇴
		
		
		String dpath = "D:\\데이터\\회원데이터\\" + m.getId();
		
		File file = new File(dpath);
		
		if(file.exists()) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("=============================================");
        System.out.println("\t♩♪♬ 회원 탈퇴 ♬♪♩");
        System.out.println("=============================================");
		System.out.println("회원 탈퇴를 하시려면 회원 탈퇴를 입력하세요");
		System.out.println("---------------------------------------------");
        System.out.print("입력 ▶  ");
		
		String withdraw = reader.readLine();
		if(withdraw.equals("회원 탈퇴")) {
			file.delete();
			System.out.println("회원 탈퇴가 완료되었습니다.");

			startPage();
		} else startPage();
		
		reader.close();
		
		}
			
	}

	
	
	
	public static void signUp() throws Exception{ //회원가입
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("=============================================");
        System.out.println("\t♩♪♬ 회원 가입 ♬♪♩");
        System.out.println("=============================================");
		
		
		String[] members = new String[5];
		
		for(;;) {
		
			System.out.print("아이디(8~20자) ▶ "); //id
			
			members[0] = reader.readLine();
		
			if(members[0].length() >= 8 && members[0].length() <= 20) {
				break;
			
			} else if(members[0].length() == 0) {
			
				System.out.println("문자를 입력해주세요.");
			
			
			} else if(members[0].length() > 20) {
			
				System.out.println("20자 이내로 입력해주세요.");
			
			} else if(members[0].length() < 8) {
			
				System.out.println("아이디는 8글자 이상 입력해주세요.");
			
			}
		}
		
	
		for(;;) {
		
			System.out.print("비밀번호(8~16자) ▶ "); //pwd
			
			members[1] = reader.readLine();
		
			if(members[1].length() >= 8 && members[1].length() <= 16) {
			
				break;
			
			} else if(members[1].length() == 0) {
			
				System.out.println("문자를 입력해주세요.");
			
			} else if(members[1].length() > 16) {
			
				System.out.println("16자 이내로 입력해주세요.");
			
			
			} else if(members[1].length() < 8) {
			
				System.out.println("비밀번호는 8글자 이상 입력해주세요.");
			
			}
		}
		
		for(;;) {
		
			System.out.print("이름 ▶ "); //name
			members[2] = reader.readLine();
		
			if(members[2].length() >= 2 && members[2].length() <= 5) {
			
				break;
			
			} else if(members[2].length() == 0) {
			
				System.out.println("문자를 입력해주세요.");
			
			
			} else if(members[2].length() > 5) {
			
				System.out.println("5자 이내로 입력해주세요.");
			
			
			} else if(members[2].length() < 2) {
			
				System.out.println("이름은 2글자 이상 입력해주세요.");
			
			
			}
		}
		
			
		for(;;) {
			
			System.out.print("나이(1~99세) ▶ "); //age
			members[3] = reader.readLine();
		
			if(Integer.parseInt(members[3]) > 0 && Integer.parseInt(members[3]) < 100) {
			
				break;
			
			} else if(members[3].length() == 0) {
			
				System.out.println("나이를 입력해주세요.");
			
			} else  {
			
				System.out.println("올바른 나이를 입력해주세요(1~99세)");
			
			}
		
		}
		
		for(;;) {
		
			System.out.print("성별(남, 여) ▶ "); //gender
			members[4] = reader.readLine();
		
			if(members[4].equals("남") || members[4].equals("여")) {
			
				break;
				
			} else {
			
				System.out.println("성별은 '남' 또는 '여'로 입력해주세요.");
			
			}
		
		
		}
				
		String dpath = "D:\\데이터\\회원데이터\\" + members[0]; 
			
		File dir = new File(dpath);

		if(dir.exists()) {
			
			System.out.println();
			System.out.println("이미 있는 아이디입니다.");
			System.out.println();
			signUp();
		} else {
		
			dir.mkdir();
			String path = dpath + "\\" + members[0] + ".txt";
			File file = new File(path);
			
			FileWriter writer = new FileWriter(path);
		
		for(int i=0; i<members.length; i++) {
			if(i == 4) writer.write(members[i]);
			else writer.write(members[i] + ",");
		}
		
		writer.close();
		System.out.println("회원가입이 완료되었습니다.");
		
		startPage();
		}
		
		
		
	}

	public static void login() throws Exception{ //로그인
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("=============================================");
        System.out.println("\t♩♪♬ 로그인 ♬♪♩");
        System.out.println("=============================================");
		
		String id, pwd;
		System.out.print("아이디 ▶ ");
		id = reader.readLine();
		
		System.out.print("비밀번호 ▶ ");
		pwd = reader.readLine();
		
		String path = "D:\\데이터\\회원데이터\\" + id + "\\" + id + ".txt"; //이거
		
		
		File dir = new File(path);
		
		BufferedReader freader = new BufferedReader(new FileReader(path));
		
		String idpwd = freader.readLine();
		
		String[] a = idpwd.split(",");
		
		if(id.equals(a[0]) && pwd.equals(a[1])) {
			
			System.out.println();
			System.out.println("로그인이 완료되었습니다.");
			System.out.println();

			m.setId(a[0]);
			m.setPwd(a[1]);
			m.setName(a[2]);
			m.setAge(a[3]);
			m.setGender(a[4]);
			
		} else{
			
			System.out.println();
			System.out.println("아이디나 비밀번호를 다시 확인하세요.");
			System.out.println();
			login();
		
		}
		
		MM.Menu1();
	}
	
		
		
}

