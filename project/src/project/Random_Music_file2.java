package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


	public class Random_Music_file2 {
		public static void main(String[] args) throws Exception{
			dummy();
			//cId();
			//login();
			
		}



		public static void login()throws Exception {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("\t[로그인 화면]\t");
			System.out.print("아이디 입력:");
			String Id = sc.nextLine();
			System.out.print("PSW 입력:");
			String psw = sc.nextLine();

			String cId = "C:\\Users\\김찬우\\Desktop\\회원\\"+Id; //아이디파일
			File file = new File(cId);
			
			if(file.exists()) {
			String path = cId+"\\회원정보.txt";
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String chkPsw = reader.readLine();//아이디,비밀번호 읽기
			

			
			 if(Id.equals(chkPsw.substring(0,chkPsw.indexOf(",",8)))
				&& psw.equals(chkPsw.substring(chkPsw.indexOf(",",6)+1,chkPsw.indexOf(",",15))))
				{
				System.out.println("로그인이 완료되었습니다.");
				}
			else if(Id.equals(chkPsw.substring(0,chkPsw.indexOf(",",8)))
					&&!psw.equals(chkPsw.substring(chkPsw.indexOf(",",6)+1,chkPsw.indexOf(",",15))))
					{
				System.out.println("틀린 비밀번호입니다.");
						}
				}
			else {
				System.out.println("없는 아이디입니다.");
			}
			
		}



		private static void dummy() throws Exception {
			String Uname;
			ArrayList<String> nlist = new ArrayList<String>();
			
			String[] name1 = new String[] {"김","이","최","박","오","하","조","공","한","염"
					,"고","지","송","유","정","강","손","천"};
			String[] name2 = new String[] {"찬","예","보","윤","정","진","동","화","선","영","혜",
					"신","민","도","나","라","인","미","지","림","형","현","준","연","선"};
			String[] Id = new String[] {"kids","dohyun","chanu","kmw","hoit","fly","ziloner","hochi","tongtong"
					,"baba","lala","kong","rabe","zazaza","looptop","illillli","hong","boong","bibiD","babiD","boo"
					,"sell","pikolo","preder","sooji"};

			String[] PSW = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
			String[] PSW1 = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
			String[] PSW2 = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
			

			Random rnd = new Random(10);
			for(int i=0;i<500;i++) {
			String id =Id[rnd.nextInt(Id.length)]+rnd.nextInt(99999);
			String s ="D:\\데이터\\회원데이터\\"+id; //아이디 파일 만들기
			File dir = new File(s);
			//System.out.println(s);
			
			boolean result =dir.mkdir();

			String s1 = "D:\\데이터\\회원데이터\\"+id+"\\"+id+".txt";
			System.out.println(s1);
			File file = new File(s1); //회원정보.txt  파일 만들기
			FileOutputStream stream = new FileOutputStream(s1);
			stream.close();
			
			BufferedWriter writer = new BufferedWriter (new FileWriter(file));
			writer.write(dir.getName()+","); //아이디
			writer.write(PSW[rnd.nextInt(PSW.length)]+PSW1[rnd.nextInt(PSW2.length)]+PSW2[rnd.nextInt(PSW2.length)]+rnd.nextInt(99999)+",");//랜덤 비밀번호
			writer.write(name1[rnd.nextInt(name1.length)]+name2[rnd.nextInt(name2.length)]+name2[rnd.nextInt(name2.length)]+","); //무작위 이름
			writer.write(rnd.nextInt(100)+","); //무작위 나이
			writer.write(rnd.nextInt(2)==1 ?"남":"여");	//무작위 성별
			writer.close();
			
			File music = new File("D:\\데이터\\음악데이터");
			ArrayList<String> ml= new ArrayList<String>();
			String[] mlist = music.list();
			for(String m : mlist) {
				
				ml.add(m);
			}
			
			String[] mArr = new String[50];// arrlist -> arr
			for(int k=0;k<50;k++) {
			mArr[k] = ml.get(rnd.nextInt(ml.size()));
			}
			
			String s2 = "D:\\데이터\\회원데이터\\"+id+"\\"+id+"playlist.txt";
			System.out.println(s2);
			File file1 = new File(s2); //플레이리스트.txt  파일 만들기
			FileOutputStream stream1 = new FileOutputStream(s2);
			stream1.close();
			
				BufferedWriter writer1 = new BufferedWriter (new FileWriter(file1));
				for(int j=0;j<rnd.nextInt(50)+1;j++) {
			writer1.write(mArr[j]);
			writer1.write("\r\n");
				}

			writer1.close();
			
			}
		}	
}

