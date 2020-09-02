package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class pagingfile {
	
	public static void main(String[] args) {
		

		//페이징할 ArrayList만들기 프로젝트에 합치는거 x 개인 확인용
		String path = "D:\\데이터\\음악데이터";
		File file = new File(path);
		File[] list = file.listFiles();
		ArrayList<File> slist = new ArrayList<File>();
		ArrayList<String[]> flist = new ArrayList<String[]>();
		
		for(File song : list) {
			
			String[] stlist = new String[1];
			slist.add(song);
			stlist[0] = song.getName();
			flist.add(stlist);
		}
		
		
		
			
		
		
		
		
//		inputpaging(slist);
//		for(int i = 0; i < totalPage(slist) ; i++) {
//			for(int j = 0 ; j < 10 ; j++) {
//			System.out.println(inputpaging(slist).get(i)[j]);
//			}
//		System.out.println("===============================");
//			}
		
		
		
//		System.out.println(totalPage(slist));
		
		
		//다음페이지, 이전페이지
		//매개변수 어레이리스트 , 반환값 x
//		page(inputpaging(slist));
		
		
//		String path2 = "F:\\음악데이터";
		//매개변수 o 반환값 o
//		inputfile(path2);
		
		//매개변수 o 반환값 o
		//음악 제목 저장하기
//		page(musicTitle(slist));
		
		//매개변수 o 반환값o
		//회원 정보 저장하기 비밀번호 x
		page(memberTitle(supervisor.inputMember()));

//		ArrayList<String[]> mlist = new ArrayList<String[]>();
//		mlist = supervisor.inputMember();
		
		
		
		
	} //main










	static ArrayList<String> memberTitle(ArrayList<String[]> inputMember) {
		
		//회원정보 저장하기
		//비밀번호 x
		ArrayList<String> memberlist = new ArrayList<String>();
		
		
		for(int i = 0; i < inputMember.size() ; i++) {
			
			String name = new String();
			name = String.format("%3s\t%3s\t%3s\t%3s"
					, inputMember.get(i)[0]
					, inputMember.get(i)[2]
					, inputMember.get(i)[3]
					, inputMember.get(i)[4]);
			
			
			

			memberlist.add(name);
			
			
		}
		
		return memberlist;
		
		
	}










	static ArrayList<String> musicTitle(ArrayList<File> slist) {
		
		//음악 페이지용 노래 제목만 불러오기
		ArrayList<String> titlelist = new ArrayList<String>();
		
		for(File song : slist) {
			String musicName = new String();
			musicName = song.getName().substring(0, song.getName().lastIndexOf("."));
			titlelist.add(musicName);
		}
		
		
		
		return titlelist;
		
	}










	//총파일불러오기
	private static List<File> inputfile(String path) {
		File file = new File(path);
		List<File> filelist = new ArrayList<File>();
		
		File[] list3 = file.listFiles();
		for(File filename : list3) {
			filelist.add(filename);
		}
		
		return filelist;
	}
	
	
	
	
	
	
	
	
	
	
	static void page(List<String> arrayList) {
		
		
		 //10개씩 분할
		List<String[]> depart = new ArrayList<String[]>();
		int firstindex = 0;
		int lastindex = 10;
		int index = 0;
		int totalcount = arrayList.size();

		while (true) {
			// 10개의 String 이 들어갈 묶음
			String[] ranking = new String[10];

			for (int j = firstindex; j < lastindex; j++) {
				if (j >= arrayList.size()) {
					break;
				}
				ranking[j - (index) * 10] = arrayList.get(j);
				}
			depart.add(ranking);
			
			firstindex = firstindex + 10;
			lastindex = lastindex + 10;
			index++;

			if (firstindex >= totalcount) {
				break;
			}
		
		}
		
		
		
		//페이지 수 
		int count = 0;
		
		int num = 1;
		
		//페이지가 한개만 있는 경우
		if(depart.size() == 1) {
			//첫페이지 보여주기
			System.out.println("---------------------------------------------");
			for(int i = 0; i < depart.get(0).length; i++) {
				if( depart.get(0)[i] != null) {
				System.out.printf("%d. %s\n",i+1,depart.get(0)[i]);
				}
			}
			System.out.println("---------------------------------------------");
			System.out.println("넘어갈 페이지가 없습니다.");
			System.out.println("---------------------------------------------");
		}
		else {
		
		//페이지가 여러개인 경우
		while(true) {
			
			System.out.print("---------------------------------------------");
			for(int i = 0; i < 10; i++) {
				System.out.printf("\n%d. ", num);
				if( depart.get(count)[i] != null) {
				System.out.printf("%s\t" , depart.get(count)[i]);
				
				}
				num++;
			}
			//페이지 반복
			System.out.println();
			System.out.println("---------------------------------------------");
			System.out.printf("%d페이지 입니다.\n", count + 1);
			System.out.println("---------------------------------------------");
			System.out.println("1. 이전 페이지");
			System.out.println("2. 다음 페이지");
			System.out.println("3. 취소");
			System.out.println("---------------------------------------------");			
			//번호 고르기
			Scanner scan = new Scanner(System.in);
			System.out.print("입력▶ ");
			int answer = scan.nextInt();
			scan.skip("\r\n"); //엔터 무시
			System.out.println("---------------------------------------------");
			//이전페이지
			if(answer == 1) {
				//첫페이지 일 경우
				if(count == 0) {
					count = depart.size() - 1 ;
				}
				else {
					count = count-1;
				}
			} else if(answer == 2){
				//다음페이지
				
				//마지막 페이지일 경우
				if(count == depart.size() -1 ) {
					count = 0;
				} else {
					count = count+1;
					
				}
			} else {
				break;
			}
			
			
			
			
		} //while

		}
		
		
	}


	private static ArrayList<String[]> depart(ArrayList<String[]> arrayList) {
		
		//파일 나누기
				ArrayList<String[]> page = new ArrayList<String[]>();
				int firstindex = 0;
				int lastindex = 10;
				int index = 0;
				int totalPage = arrayList.size();

				
				
				while(true) {
		 		//10개의 String 이 들어갈 묶음
					String[] ranking = new String[10];
				
					
					for(int j = firstindex ; j < lastindex ; j++) {
						if(j >= arrayList.size() ) {
							break;
							}
						ranking[j - (index) *10] = arrayList.get(j)[0];
						
					
				}
					page.add(ranking);
					firstindex = firstindex + 10;
					lastindex = lastindex + 10;
					index++;
					
					if(firstindex >= totalPage) {
						break;
					}
				}
				
				
				return page;
		
		
	}


	private static int totalPage(ArrayList<File> slist) {
		
		return (slist.size() - (slist.size() / 10) * 10) > 0 ? slist.size()/10 + 1 : slist.size()/10;
		
	}


	//페이징 화
	private static ArrayList<String[]> inputpaging(ArrayList<File> slist) {
		//노래 파일 -> String 
		ArrayList<String[]> newlist = new ArrayList<String[]>();
		
		
		//총 파일개수
		int totalPage = slist.size();
		
		//인기순으로 정렬하기
		for(int i = 0; i < slist.size() ; i++) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(slist.get(i)));
				String[] songinfo = new String[5];
				String line  = reader.readLine();
				
				
				songinfo[0] = slist.get(i).getName().substring(0, slist.get(i).getName().lastIndexOf("."));
			
				songinfo[1] = line.split(",")[0];
				songinfo[2] = line.split(",")[1];
				songinfo[3] = line.split(",")[2];
				songinfo[4] = line.split(",")[3];
				
				
				
				newlist.add(songinfo);
				
				reader.close();
				
			} catch (Exception e) {
				System.out.println("파일 읽기 시도 실패");
//				System.out.println(e);
			}
				
		}//for
		
		
		//인기도순 정렬
		newlist.sort(new Comparator<String[]>(){

			@Override
			public int compare(String[] o1, String[] o2) {
				
				
				return Integer.parseInt(o2[4]) - Integer.parseInt(o1[4]);
			}
			
		});
		
		
		
		
		
//		//파일 나누기
//		ArrayList<String[]> page = new ArrayList<String[]>();
//		int firstindex = 0;
//		int lastindex = 10;
//		int index = 0;
//
//		while(true) {
// 		//10개의 String 이 들어갈 묶음
//			String[] ranking = new String[10];
//		
//			
//			for(int j = firstindex ; j < lastindex ; j++) {
//				if(j >= newlist.size() ) {
//					break;
//					}
//				ranking[j - (index) *10] = newlist.get(j)[0];
//				
//			
//		}
//			page.add(ranking);
//			firstindex = firstindex + 10;
//			lastindex = lastindex + 10;
//			index++;
//			
//			if(firstindex >= totalPage) {
//				break;
//			}
//		}
//		
		
		return newlist;
	}










	
	
	
	
	
	
	
	
}
