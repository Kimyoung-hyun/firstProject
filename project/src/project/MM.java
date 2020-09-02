package project;

import java.util.Scanner;

public class MM {
public static void main(String[] args)throws Exception {
	
	Menu();
	
	
}

public static void recMenu() throws Exception{
	Scanner scan = new Scanner(System.in);
	for(;;) {
	System.out.println("=============================================");
	System.out.println("\t♩♪♬[추천] ♬♪♩");
	System.out.println("=============================================");
	System.out.println("1.유저");
	System.out.println("2.장르");
	System.out.println("3.시간");
	System.out.println("4.계절");
	System.out.println("5.가수별");
	System.out.println("b.뒤로가기");
	System.out.println("=============================================");
	System.out.print("번호:");
	String cho = scan.nextLine();
	if(cho.equals("1")) {
		User_reco.recoM();
	}
	else if(cho.equals("2")) {
		RecommendGenre.main(null);;
	}
	else if(cho.equals("3")) {
		PickTimeNum.timeList();
		
	}
	else if(cho.equals("4")) {
		PickSeasonNum.seasonList();
	}
	else if(cho.equals("5")) {
		RecommendSinger.main(null);	
	}
	else if(cho.equals("b")) {
		MM.Menu1();
	}
	}
	
}


static void Menu1() throws Exception{
	Scanner scan = new Scanner(System.in);
	MemberInfo m = new MemberInfo();

	for(;;) {
	System.out.println("=============================================");
	System.out.printf("	♩♪♬ %s님 안녕하세요! ♬♪♩\n",m.getId());
	System.out.println("=============================================");
	System.out.println("1.회원정보");
	System.out.println("2.재생");
	System.out.println("3.검색");
	System.out.println("4.추천");
	System.out.println("5.Top100");
	System.out.println("6.로그아웃");
	System.out.println("---------------------------------------------");
	System.out.print("입력 ▶");
	int cho = scan.nextInt();

	if(cho==1) {
		MyPage.myPage();
	}
	else if (cho==2) {
		player.memPlay();
	}
	else if (cho==3) {
		search.msearch();
	}
	else if (cho==4) {
		recMenu();
	}
	else if (cho==5) {
		System.out.println("=============================================");
		System.out.println("\t♩♪♬ Top100 ♬♪♩");
		System.out.println("=============================================");
		pagingfile.page(project.Top100.top100());
	}
	else if (cho==6) {
		Menu();
	}
	
	else if (cho==7) {
		playlist.playlist();
	}
	
	}
}


public static void Menu() throws Exception {
	//비회원 상태창
	Scanner scan = new Scanner(System.in);
	for(;;) {
		System.out.println("=============================================");
		System.out.println("\t♩♪♬ 시작 화면 ♬♪♩");
		System.out.println("=============================================");
		System.out.println("\t1. Top10 더보기");
		System.out.println("\t2. 검색");
		System.out.println("\t3. 로그인");
		System.out.println("\t4. 회원가입");
		System.out.println("---------------------------------------------");
        System.out.print("입력 ▶  ");
	int cho = scan.nextInt();

	if(cho==1) {
		System.out.println("=============================================");
		System.out.println("\t♩♪♬ Top100 ♬♪♩");
		System.out.println("=============================================");
		pagingfile.page(project.Top100.top100());
	}
	else if (cho==2) {
		search.nonmember();
	}
	else if (cho==3) {
		
		MyPage.login();
	}
	else if (cho==4) {
		MyPage.signUp();
		Menu();
	}
	else if (cho==6) {
		supervisor.visormenu();
	}
	
	}
}
}
