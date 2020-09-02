package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//플레이리스트

class playlist {
	public static void main(String[] args)throws Exception {
		playlist();
		
	}
public static void playlist() throws Exception {
	Scanner sc = new Scanner(System.in);
	//login에서 아이디 연동필요
	MemberInfo m = new MemberInfo();
	
	String path ="D:\\데이터\\회원데이터"+m.getId()+"\\"+m.getId()+"playlist.txt";
	File dir = new File(path);
	int pagecnt =1,cnt=10,num=0,x=0;
	int n=1;
	List<String> s1 = new ArrayList<>();
	
	Scanner scan = new Scanner(dir);
	boolean flag = scan.hasNext();
	
	
	while (scan.hasNextLine())
		s1.add(scan.nextLine());
		
	
	
	for(int i=0; ;i++) {
	
	System.out.println("=============================================");
	System.out.println("	♩♪♬ 재생 화면 ♬♪♩");
	System.out.println("=============================================");
	
	if(s1.size()<10) {
	for(int j=0;j<s1.size();j++) {
		
		System.out.printf("%d.%s\n",n,s1.get(s1.size()));
		n++;
	}
	}
	else if(s1.size()>pagecnt*10){
		 for(int j=0;j<10;j++) {

		 System.out.printf(s1.get(j));
			
		}
	}
		
	System.out.println("=============================================");
	System.out.println("1.재생");
	System.out.println("2.이전 페이지");
	System.out.println("3.다음 페이지");
	System.out.println("5.삭제");
	System.out.println("4.이전 메뉴");
	System.out.println("현재 페이지:"+pagecnt);
	System.out.println("---------------------------------------------");
	System.out.print("입력 ▶ ");
	int a = sc.nextInt();
	if(a==1) {
		System.out.print("(노래번호)▶ ");
		a=sc.nextInt();
		String input = s1.get(a).substring(0,s1.get(a).indexOf("."));
		System.out.println(input);
		player.plusMusic(input);
	}
	else if(a==2) {
	
		if(pagecnt-1<1) {
			System.out.println("이전페이지가 없습니다.");
			pause();
		}
		else {
			pagecnt--;
			x-=10;
			for(int j=x;j<x-10;j--) {
			System.out.println(s1.get(i));
			}
		
		}
		
	}
	else if(a==3) {
		if(s1.size()<10) {
			System.out.println("다음페이지가없습니다.");
			pause();
		}
		else if(s1.size()>x*10){
			pagecnt++;
			
		}
		
		if(pagecnt>=5) {
		pagecnt=1;
		num=1;
		x=0;
	
		for(int j=x;j<x+10;j++) {
		System.out.printf("%d.%s\n",num,s1.get(j));
		num++;
		}
	
		a = sc.nextInt();}
	}
	else if(a==4) {
		System.out.println("이전 메뉴");
		MM.Menu1();
		break;
	}
		
	else if(a==5) {
		System.out.println("삭제할 번호입력");
		Scanner scn = new Scanner(System.in);
		String nom = scn.nextLine();
		List g1 = new ArrayList<String>();
		g1.add(s1.get((Integer.parseInt(nom))));
		s1.remove((Integer.parseInt(nom)));
		break;
	}

	
	else {
		System.out.println("없는메뉴입니다.");
		pause();
	}
			}
}


private static void pause() throws Exception {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("계속 하려면 Enter");
	reader.readLine();
	
	
}

}
