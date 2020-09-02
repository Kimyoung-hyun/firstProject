package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class player {
public static void main(String[] args)throws Exception {
	MemberInfo m = new MemberInfo();
	memPlay();
}

public static void nMemPlay(String input) throws Exception {
	ArrayList<String> s1 = new ArrayList<String>();
	
	Scanner sc = new Scanner(System.in);
	int num=0,p=0,c=0;
	for(int i=0;i<50;i++) {
	s1.add(input);
	num=1;
	System.out.println("===============================");
	System.out.println("\t[재생 화면]\t");
	System.out.println("===============================");
	System.out.printf("재생중인 곡:%s\n",s1.get(i));
	System.out.println("비회원은 1분만 재생됩니다.");
	System.out.println("===============================");
	System.out.println("1.일시정지");
	System.out.println("2.이전 곡");
	System.out.println("3.다음 곡");
	System.out.println("b.이전 메뉴");
	System.out.println("===============================");
	System.out.print("입력(메뉴번호):");
	String a = sc.nextLine();
if(a.equals("1")) {
	num=1;
	p=1;
	System.out.println("===============================");
	System.out.println("\t[재생 화면]\t");
	System.out.println("===============================");
	System.out.printf("일시정지:%s\n",s1.get(i));
	System.out.println("비회원은 1분만 재생됩니다.");
	System.out.println("===============================");
	System.out.println("1.재생");
	System.out.println("2.이전 곡");
	System.out.println("3.다음 곡");
	System.out.println("4.검색");
	System.out.println("b.이전 메뉴");
	System.out.println("===============================");
	System.out.print("입력(메뉴번호):");
	a = sc.nextLine();
	
	if(p==1) { 		//일시정지 되있을때
		if(a.equals("1")) {
			continue;
		}
		else if(a.equals("2")) {		//전곡으로 이동
			
			if(c==0){ //첫번째 곡에서 뒤로하기시 마지막곡으로 
				i=49;
			}
			else {
				c--;
			}
		}
		else if(a.equals("3")) {		//다음 곡으로 이동
			if(c==s1.size()) {
				c=0;
			}else {
				c++;
			}
		}
		else if(a.equals("4")) {
			search.nonmember();
		}
		else if(a.equals("b")) {
			System.out.println("이전메뉴로 이동합니다.");
			MM.Menu();
		}
		
				
			}
}
else if(a.equals("2")) {		//전곡으로 이동
	
	if(c==0){ //첫번째 곡에서 뒤로하기시 마지막곡으로 
		c=s1.size();
		c--;
	}
	else {
		c--;
	}
	System.out.println();
}
else if(a.equals("3")) {		//다음 곡으로 이동
	if(c==s1.size()) {
		c=0;
	}
		c++;
}
else if(a.equals("4")) {
	search.nonmember();
}
else if(a.equals("b")) {
	System.out.println("이전메뉴로 이동합니다.");
	MM.Menu();
	break;
}
}
	
	
}

public static void memPlay() throws Exception{ //ID받아옴
	Scanner sc = new Scanner(System.in);
	MemberInfo m = new MemberInfo();
	String path = "D:\\데이터\\회원데이터\\"+m.getId()+"\\"+m.getId()+"playlist.txt";
	
	File dir = new File(path);
	String[] list = dir.list();  
	int num=0,p=0,c=0;
	
	
	//path = "F:\\더미\\회원1\\"+m.getId()+"\\"+m.getId()+".playlist.txt";
//	path = "F:\\더미\\회원1\\chanu71720\\chanu71720playlist.txt";
	ArrayList<String> s1 = new ArrayList<String>();
	BufferedReader reader = new BufferedReader(new FileReader(path));
	String b=null;
	while((b=reader.readLine())!=null) {
	s1.add(b);
	
	}
		c=s1.size()-1;
		for(int i=0;i<c;i++) {
		num=1;
		
		System.out.println("=============================================");
		System.out.println("	♩♪♬ 재생 화면♬♪♩");
		System.out.println("=============================================");
		System.out.printf("재생중인 곡:%d.%s\n",num,s1.get(c));
		System.out.println("=============================================");
		System.out.println("1.일시정지");
		System.out.println("2.이전 곡");
		System.out.println("3.다음 곡");
		System.out.println("4.검색");
		System.out.println("b.이전 메뉴");
		System.out.println("---------------------------------------------");
		System.out.print("입력(메뉴번호):");
		String a = sc.nextLine();
	if(a.equals("1")) {
		num=1;
		p=1;
		System.out.println("=============================================");
		System.out.println("	♩♪♬ 재생 화면 ♬♪♩");
		System.out.println("=============================================");
		System.out.printf("일시정지:%d.%s\n",num,s1.get(c));
		System.out.println("=============================================");
		System.out.println("1.재생");
		System.out.println("2.이전 곡");
		System.out.println("3.다음 곡");
		System.out.println("4.검색");
		System.out.println("b.이전 메뉴");
		System.out.println("---------------------------------------------");
		System.out.print("입력 ▶");
		a = sc.nextLine();
		
		if(p==1) { 		//일시정지 되있을때
			if(a.equals("1")) {
				memPlay();
			}
			else if(a.equals("2")) {		//전곡으로 이동
				c-=10;
				if(c==0){ //첫번째 곡에서 뒤로하기시 마지막곡으로 
					c=s1.size()-1;
				}
				System.out.println();
			}
			else if(a.equals("3")) {		//다음 곡으로 이동
				if(c==s1.size()-1) {
					c=0;
				}
				else {
					c++;
				}
			}
			else if(a.equals("4")) {
				search.msearch();
			}
			else if(a.equals("b")) {
				System.out.println("이전메뉴로 이동합니다.");
				MM.Menu1();
				break;
			}
			
					
				}
	}
	else if(a.equals("2")) {		//전곡으로 이동
		
		if(c==0){ //첫번째 곡에서 뒤로하기시 마지막곡으로 
			c=s1.size();
			c--;
		}
		else {
			c--;
		}
		System.out.println();
	}
	else if(a.equals("3")) {		//다음 곡으로 이동
		if(c==s1.size()-1) {
			c=0;
		}
		else {
			c++;
		}
	}
	else if(a.equals("4")) {
		search.msearch();
	}
	else if(a.equals("b")) {
		System.out.println("이전메뉴로 이동합니다.");
		MM.Menu1();
		break;
	}
	}
}

public static void plusMusic(String mname)throws Exception{
	MemberInfo m = new MemberInfo();
	String path ="D:\\데이터\\회원데이터\\"+m.getId()+"\\"+m.getId()+"playlist.txt";
	File file = new File(path);

//	FileOutputStream stream = new FileOutputStream(path, true);	
//	
//	
//	for(int i = 0; i<mname.length();i++) {
//		stream.write('\r');
//		stream.write('\n');
//		stream.write(mname.charAt(i));
//		}
//	stream.close();
	
	BufferedWriter writer = new BufferedWriter(new FileWriter(path,true));
	BufferedReader reader = new BufferedReader(new FileReader(path));
	ArrayList<String> dis = new ArrayList<String>(); 
	String tinct =null;
	while((tinct = reader.readLine())!=null) {
		dis.add(tinct);
	}

	
		writer.write(mname);
		writer.newLine();
		writer.close();
		
		}
	}
	




