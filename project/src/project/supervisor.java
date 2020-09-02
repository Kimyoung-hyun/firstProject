package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class supervisor {
	
	static Scanner scan ;
	
	static {
		scan = new Scanner(System.in);
	}
	
	
	public static void main(String[] args) {
		 visormenu();
		
		
	}//main

	private static void wishListList() {
		//위시리스트 신청 목록 보기
		System.out.println("=============================================");
		System.out.println("\t♩♪♬ 위시리스트 보기입니다.♩♪♬ ");
		System.out.println("=============================================");
		List<String> mlist = new ArrayList<String>();
		
		
		File file = new File("C:\\더미\\회원1");
		File[] list = file.listFiles();
	
		
		for(File mem : list) {
			
			File[] list2 = mem.listFiles();
			for(File song : list2) {
				if(song.getName().toLowerCase().contains("wishlist")) {
					
					try {
						BufferedReader reader = new BufferedReader(new FileReader(song));
						String line = null;
						while((line = reader.readLine()) != null) {
							mlist.add(line);
						}
						
						reader.close();
					} catch (Exception e) {
						System.out.println("\t위시리스트 불러오기에 실패했습니다.");
					}
					
				}
			
			}
				
		}
        System.out.println("---------------------------------------------");
		System.out.println("[번호]\t[제목]\t[가수]");
		pagingfile.page(mlist);
		
		
		
		
		
		
		
	
	}

	//음악 정보 열람
	private static void musicInfo() {
		while(true) {
			System.out.println("=============================================");
			System.out.println("\t♩♪♬ 음악 라이브러리 열람입니다.♩♪♬ ");
			System.out.println("=============================================");
			System.out.println("1. 검색");
			System.out.println("2. 전체 보기");
			System.out.println("3. 장르별 보기");
			System.out.println("4. 음악 추가");
			System.out.println("b. 뒤로가기");
	         System.out.println("---------------------------------------------");
	         System.out.print("입력 ▶ ");
			String answer = scan.nextLine();
	         System.out.println("---------------------------------------------");

			if(answer.equals("1")) {
				//검색
				searchMusicInfo();
			} else if(answer.equals("2")) {
				//전체보기 -> 굳이 메소드로 뽑을 필요 없을 거 같음
				ArrayList<String> titlelist = pagingfile.musicTitle(inputMusic());
				System.out.println("[번호]\t[제목]\t[가수]");
				pagingfile.page(titlelist);
			} else if(answer.equals("3")) {
				//분류별보기
				musicGenreInfo();
			} else if(answer.equals("4")){
				//음악 추가
				addMusic();
			}else {
				//뒤로가기
				break;
			}
			
		}
		
		
		
		
	}//음악 정보 열람
	
	//음악 추가
	private static void addMusic() {
		while(true) {
			System.out.println("=============================================");
			System.out.println("\t♩♪♬ 음악 추가 입니다.♩♪♬ ");
			System.out.println("=============================================");
			System.out.println("1. 음악 추가");
			System.out.println("b. 뒤로 가기");
	         System.out.println("---------------------------------------------");
	         System.out.print("입력 ▶ ");
			String answer = scan.nextLine();
	         System.out.println("---------------------------------------------");

			if (answer.equals("1")) {
				System.out.println("=============================================");
				System.out.println("\t추가 하고 싶은 노래의 제목을 입력해주세요.");
				System.out.println("=============================================");

				System.out.print("제목 ▶ ");
				String title = scan.nextLine();
		         System.out.println("---------------------------------------------");

				System.out.println("=============================================");
				System.out.println("\t추가 하고 싶은 노래의 가수를 입력해주세요.");
				System.out.println("=============================================");

				System.out.print("가수 ▶ ");
				String singer = scan.nextLine();
		         System.out.println("---------------------------------------------");

				System.out.println("=============================================");
				System.out.println("\t추가 하고 싶은 노래의 장르를 입력해주세요.");
				System.out.println("=============================================");

				System.out.print("장르1 ▶ ");
				String genre1 = scan.nextLine();
		         System.out.println("---------------------------------------------");
		         
				System.out.print("장르2 ▶ ");
				String genre2 = scan.nextLine();
		         System.out.println("---------------------------------------------");
				
				
				// 중복되는 노래 확인
				ArrayList<File> songs = inputMusic();

				int result = 0;
				for (File song : songs) {
					// 중복 확인
					if (song.getName().substring(0, song.getName().lastIndexOf(".")).trim().toLowerCase()
							.equals(title + "-" + singer)) {
						result = 1;
						break;

					}
				} // for

				if (result == 1) {
					// 중복 되는 경우
					System.out.println("=============================================");
					System.out.println("\t중복되는 노래 입니다. 덮어쓰시겠습니까?");
					System.out.println("=============================================");
					System.out.println("1. 네");
					System.out.println("2. 아니요");
			         System.out.println("---------------------------------------------");
			         } else {
					// 중복 되지 않는 경우
					System.out.println("=============================================");
					System.out.println("\t정말 추가 하시겠습니까?");
					System.out.println("=============================================");
					System.out.println("1. 네");
					System.out.println("2. 아니요");
			        System.out.println("---------------------------------------------");
			         }

				System.out.print("입력▶ ");
				int answer2 = scan.nextInt();
				scan.skip("\r\n");

				if (answer2 == 1) {
					File newSong = new File("C:\\더미\\data\\음악데이터\\" + title + "-" + singer + ".mp3");
					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter(newSong));
						writer.write(genre1 + "," + genre2 + "," + 0 + "," + 0);

						writer.close();
				         System.out.println("=============================================");
				         System.out.printf("\t%s, %s 장르의 %s-%s 노래를 추가하였습니다.\n", genre1, genre2, title, singer);

						break;
					} catch (IOException e) {
						System.out.println("추가에 실패했습니다.");
					}

				} else {
					System.out.println("=============================================");
					System.out.println("\t음악 추가를 취소하셨습니다.");
					System.out.println("=============================================");
					// 뒤로가기
					break;
				}
			}

		} // while

	}//음악 추가
		
	

	//음악 장르별로 보기
	private static void musicGenreInfo() {
		String[] genre = {"발라드", "댄스", "밴드", "클래식", "락", "R&B", "컨트리"
				, "OST", "트로트" ,"EDM", "재즈", "팝", "캐롤"};
		while(true) {
	         System.out.println("=============================================");
	         System.out.println("\t♩♪♬장르별 분류 메뉴입니다.♩♪♬");
	         System.out.println("=============================================");
	         
			System.out.println("1. 발라드");
			System.out.println("2. 댄스");
			System.out.println("3. 밴드");
			System.out.println("4. 클래식");
			System.out.println("5. 락");
			System.out.println("6. R&B");
			System.out.println("7. 컨트리");
			System.out.println("8. OST");
			System.out.println("9. 트로트");
			System.out.println("10. EDM");
			System.out.println("11. 재즈");
			System.out.println("12. 팝");
			System.out.println("13. 캐롤");
			System.out.println("b. 뒤로 가기");
	         System.out.println("---------------------------------------------");
	         
			System.out.print("입력▶ ");
			ArrayList<File> titlelist = inputMusic();
			ArrayList<File> titlelist2 = new ArrayList<File>();

			String answer = scan.nextLine();
	         System.out.println("---------------------------------------------");
			
			if(!answer.toLowerCase().equals("b")) {
			for(File song :  titlelist) {
				try {
					BufferedReader reader = new BufferedReader(new FileReader(song));
					String line = reader.readLine();
					
					//장르 확인
					if(line.split(",")[0].toUpperCase().equals(genre[Integer.parseInt(answer)-1].toUpperCase()) 
							|| line.split(",")[1].toUpperCase().equals(genre[Integer.parseInt(answer)-1].toUpperCase())) {
						titlelist2.add(song);
					}
					
					
					reader.close();
				
				} catch (Exception e) {
					System.out.println("장르 불러오기에 실패했습니다.");
				}
				
				
			}
	         System.out.println("=============================================");
	         
			System.out.printf("\t♩♪♬%s 장르입니다.♩♪♬ \n", genre[Integer.parseInt(answer)-1]);
			System.out.println("=============================================");
			
			System.out.println("[번호]\t[제목]\t[가수]");

			pagingfile.page(pagingfile.musicTitle(titlelist2));
			
			} else {
				break;
			}
			
		}//while
	}//분류별 보기
	

	//검색하기
	private static void searchMusicInfo() {
		while(true) {
			ArrayList<String> titlelist = pagingfile.musicTitle(inputMusic());
			ArrayList<String> resultList = new ArrayList<String>();
			System.out.println("=============================================");
			System.out.println("\t♩♪♬ 음악 검색입니다.♩♪♬ ");
			System.out.println("찾고 싶은 가수나 노래 제목을 입력해주세요.");

	         System.out.println("=============================================");
	         System.out.println("b. 뒤로 가기"); //1이 포함된 노래 찾을 때 방지용
	         System.out.println("---------------------------------------------");
	         System.out.print("입력 : ");
			String answer = scan.nextLine();
	         System.out.println("---------------------------------------------");
	         
			//이름 검색
			if(!answer.toLowerCase().equals("b")) {
				for(String song : titlelist) {
					
					if(song.toUpperCase().contains(answer.toUpperCase())) {
						resultList.add(song);
					}
					
					
				}
				if (resultList.size() != 0) {
					System.out.println("[번호]\t[제목]\t[가수]");
					pagingfile.page(resultList);
					 System.out.println("---------------------------------------------");
					 deleteMusic(resultList);
				} else {
					System.out.println("입력하신 정보가 없습니다.");
				}
			} else {
				//1을 입력한 경우
				break;
			}
		}
		
		
	}//음악 검색

	//음악 삭제하기
	private static void deleteMusic(ArrayList<String> resultList) {
		while(true) {
			System.out.println("=============================================");
			System.out.println("\t삭제를 원하시는 노래의 번호를 눌러주세요.");
			System.out.println("=============================================");
			System.out.println("b. 뒤로 가기");
	         System.out.println("---------------------------------------------");
	         System.out.print("입력 : ");
			String answer = scan.nextLine();
	         System.out.println("---------------------------------------------");
			if(!answer.toLowerCase().equals("b")) {
				int count = Integer.parseInt(answer);
				String name = resultList.get(count-1);
				File file = new File("C:\\더미\\data\\음악데이터\\" + name + ".mp3");
				
				file.delete();
				resultList.remove(count-1);
				System.out.println("[번호]\t[제목]\t[가수]");

				pagingfile.page(resultList);
				System.out.println("삭제 완료되었습니다.");

			} else {
				break;
			}
			
			
			
			
		}
		
		
		
	}

	//음악 파일 불러오기
	static ArrayList<File> inputMusic() {
		File file = new File("D:\\데이터\\음악데이터");
		File[] list = file.listFiles();
		ArrayList<File> mlist = new ArrayList<File>();
		
		for(File song : list) {
			mlist.add(song);
		}
		
		return mlist;
		
	}
	


	//회원 정보 열람
	private static void memberinfo() {
		while(true) {
			System.out.println("=============================================");
			System.out.println("\t♩♪♬ 회원 정보 열람입니다.♩♪♬ ");
			System.out.println("=============================================");
			System.out.println("1. 검색");
			System.out.println("2. 전체 보기");
			System.out.println("3. 분류별 보기");
			System.out.println("b. 뒤로가기");
	         System.out.println("---------------------------------------------");
	         
		System.out.print("입력▶ ");
		String answer = scan.nextLine();
		
		if(answer.equals("1")) {
			//검색하기
			searchMemberInfo();
		} else if(answer.equals("2")) {
			//모든 멤버 전체 보기
			allMemberInfoList();
		} else if(answer.equals("3")) {
			//분류별 보기
			askMemberInfo();
		} else {
			break;
		}
		
		
		}
		
	}//회원정보 열람


	private static void askMemberInfo() {
		//분류별로 멤버 보기
		while(true) {
			System.out.println("=============================================");
			System.out.println("\t♩♪♬분류별 보기 메뉴입니다.♩♪♬");
			System.out.println("=============================================");
			System.out.println("1. 성별");
			System.out.println("2. 나이대별");
			System.out.println("b. 뒤로 가기");
	         System.out.println("---------------------------------------------");			
			System.out.print("입력▶ ");
			String answer = scan.nextLine();
			 System.out.println("---------------------------------------------");
			if(answer.equals("1")) {
				//성별
				memberGenderInfo();
			} else if(answer.equals("2")) {
				//나이별
				memberAgeInfo();
			} else {
				//뒤로가기
				break;
			}
			
		}
	}//askMemberInfo()


	private static void memberAgeInfo() {
		//나이별로 나누기
		while(true) {
			System.out.println("=============================================");
			System.out.println("\t♩♪♬나이별 분류 메뉴입니다.♩♪♬");
			System.out.println("=============================================");
			System.out.println("1. 10대");
			System.out.println("2. 20대");
			System.out.println("3. 30대");
			System.out.println("4. 40대");
			System.out.println("5. 50대 이상");
			System.out.println("b. 뒤로 가기");
			 System.out.println("---------------------------------------------");
			 
			System.out.print("입력▶ ");
			ArrayList<String[]> meminfo = inputMember();	
			ArrayList<String[]> meminfo2 = new ArrayList<String[]>();

			String answer = scan.nextLine();
			//10대
			if(answer.equals("1")) {
				for(String[] mem : meminfo) {
					if(Integer.parseInt(mem[3]) < 20) {
						meminfo2.add(mem);
					}
				}
				System.out.println("[아이디]\t[이름]\t[나이]\t[성별]");
				pagingfile.page(pagingfile.memberTitle(meminfo2));
			} //20대
			else if(answer.equals("2")) {
				for(String[] mem : meminfo) {
					if(Integer.parseInt(mem[3]) < 30 && Integer.parseInt(mem[3]) >= 20) {
						meminfo2.add(mem);
					}
				}		
				System.out.println("[아이디]\t[이름]\t[나이]\t[성별]");
				pagingfile.page(pagingfile.memberTitle(meminfo2));
			}//30대
			else if(answer.equals("3")) {
				for(String[] mem : meminfo) {
					if(Integer.parseInt(mem[3]) < 40 && Integer.parseInt(mem[3]) >= 30) {
						meminfo2.add(mem);
					}
				}
				System.out.println("[아이디]\t[이름]\t[나이]\t[성별]");
				pagingfile.page(pagingfile.memberTitle(meminfo2));
			}//40대
			else if(answer.equals("4")) {
				for(String[] mem : meminfo) {
					if(Integer.parseInt(mem[3]) < 50 && Integer.parseInt(mem[3]) >= 40) {
						meminfo2.add(mem);
					}
				}		
				System.out.println("[아이디]\t[이름]\t[나이]\t[성별]");
				pagingfile.page(pagingfile.memberTitle(meminfo2));
			}//50대 이상
			else if(answer.equals("5")) {
				for(String[] mem : meminfo) {
					if(Integer.parseInt(mem[3]) >= 50) {
						meminfo2.add(mem);
					}
				}
				System.out.println("[아이디]\t[이름]\t[나이]\t[성별]");

				pagingfile.page(pagingfile.memberTitle(meminfo2));
			} else {
				//뒤로 가기
				break;
			}
			
		}
		
	}


	private static void memberGenderInfo() {
		//성별로 나누기
		while(true) {
			System.out.println("=============================================");
			System.out.println("\t♩♪♬ 성별 분류 메뉴입니다.♩♪♬ ");
			System.out.println("=============================================");
			System.out.println("1. 여성");
			System.out.println("2. 남성");
			System.out.println("b. 뒤로 가기");
			 System.out.println("---------------------------------------------");			
			System.out.print("입력▶ ");
			String answer = scan.nextLine();
			 System.out.println("---------------------------------------------");			

			ArrayList<String[]> meminfo = inputMember();	
			ArrayList<String[]> meminfo2 = new ArrayList<String[]>();

			//여성
			if(answer.equals("1")) {
				for(String[] mem : meminfo) {
					if(mem[4].equals("여")) {
						meminfo2.add(mem);
					}
				}
				System.out.println("[아이디]\t[이름]\t[나이]\t[성별]");

				pagingfile.page(pagingfile.memberTitle(meminfo2));
			}//남성  
			else if(answer.equals("2")) {
				for(String[] mem : meminfo) {
					if(mem[4].equals("남")) {
						meminfo2.add(mem);
					}
				}
				System.out.println("[아이디]\t[이름]\t[나이]\t[성별]");

				pagingfile.page(pagingfile.memberTitle(meminfo2));
			} else {
				//뒤로 가기
				break;
			}
			
		}
	} //성별


	private static void searchMemberInfo() {
		
		//멤버 이름 검색하기
		System.out.println("=============================================");
		System.out.println("\t♩♪♬회원 검색입니다.♩♪♬");

		while(true) {

			System.out.println("=============================================");
			System.out.println("\t회원의 아이디나 이름을 검색하시오.");
			System.out.println("b. 뒤로 가기");
			 System.out.println("---------------------------------------------");
			System.out.print("입력 ▶  ");
			String name = scan.nextLine();
			 System.out.println("---------------------------------------------");
		if(!name.equals("b")) {
			
			ArrayList<String[]> meminfo = inputMember();	
			//멤버 정보 불러오기
			ArrayList<String[]> meminfo2 = new ArrayList<String[]>();	
			
			for(String[] findName : meminfo) {
				
				//이름이나 아이디 검색
				if( findName[2].contains(name) || findName[0].contains(name)) {
					
					meminfo2.add(findName);	

					
				} 
				
				
				
			} //일치하는 멤버 불러오기

			if(!meminfo2.isEmpty()) {
				System.out.println("=============================================");
				System.out.println("일치하는 회원입니다.");
				System.out.println("=============================================");
				System.out.println("[아이디]\t[이름]\t[나이]\t[성별]");
				
			pagingfile.page(pagingfile.memberTitle(meminfo2));
			System.out.println("=============================================");
			System.out.println("\n삭제하실 데이터가 있습니까?");
			System.out.println("=============================================");
			System.out.println("1. 네");
			System.out.println("2. 아니오. 되돌아가기.");
			 System.out.println("---------------------------------------------");
			System.out.print("입력▶  ");
			String answer = scan.nextLine();
			 System.out.println("---------------------------------------------");
			
			if(answer.equals("1")) {
				//삭제하기
				deleteFactor(meminfo2);

				} else {
					break;
				}
				
				
				} else {
					System.out.println("일치하는 회원이 없습니다.");
					System.out.println("=============================================");								
				}
			} else {
				//1. 뒤로가기
				break;
			}
			
			
			
			
		}//while 
			
			
		}//검색 메소드
	
	


	//삭제하기
	private static void deleteFactor(ArrayList<String[]> meminfo2) {

		
		
		while(true) {
			
			System.out.println("=============================================");
			System.out.println("\t원하시는 삭제 번호를 눌러주세요.");
			System.out.println("b.뒤로가기");
			System.out.println("=============================================");
			
			System.out.println("---------------------------------------------");
			System.out.print("입력▶ ");
			String count = scan.nextLine();
			System.out.println("---------------------------------------------");
			if (!count.toLowerCase().equals("b")) {
				int num = Integer.parseInt(count);
				String id = meminfo2.get(num - 1)[0];
				
				
				String path = "D:\\데이터\\음악데이터\\" + id;
				File dir = new File(path);
			
				File[] delmemlist = dir.listFiles(); //파일리스트 뽑기
				
				for(File file : delmemlist) {
					System.out.println(file.getName());
					System.out.println(file.exists());
					System.out.println(file.getAbsolutePath());
					System.out.println(file.delete()); //회원 정보 파일 + 플레이리스트 삭제
				}
				
				dir.delete(); //폴더도 삭제

				meminfo2.remove(num - 1);
				System.out.println("[아이디]\t[이름]\t[나이]\t[성별]");

				pagingfile.page(pagingfile.memberTitle(meminfo2));
				System.out.println("=============================================");
				System.out.println("\t삭제 되었습니다.");
				System.out.println("=============================================");
				} else {
				break;
			}
		}

	}//삭제하기 메소드


	


	


	private static void allMemberInfoList() {

		//전체 멤버 보기
		
		ArrayList<String[]> meminfo = inputMember();
		System.out.println("=============================================");
		System.out.println("\t♩♪♬전체 멤버 보기입니다.♩♪♬");
		System.out.println("[아이디]\t[이름]\t[나이]\t[성별]");
		pagingfile.page(pagingfile.memberTitle(meminfo));
		System.out.println("===============================");
		
	}


	static ArrayList<String[]> inputMember() {
		//멤버 불러오기, 반환값 어레이리스트
		String path = "D:\\데이터\\회원데이터";
		File file = new File(path);
		File[] list = file.listFiles();
		
		ArrayList<File> memlist = new ArrayList<File>();
		ArrayList<String[]> meminfo = new ArrayList<String[]>();
		
		
		for(File mem : list) {
			File[] list2 = mem.listFiles();
			for(File mem2 : list2) {
				//플레이리스트 저장 x
				if(!mem2.getName().contains("playlist")) {
				try {
					BufferedReader reader = new BufferedReader(new FileReader(mem2));
					try {
						meminfo.add(reader.readLine().split(","));
						reader.close();
					} catch (Exception e) {
						System.out.println("문장저장에 실패");
					}
				} catch (FileNotFoundException e) {
					System.out.println("파일 저장하기에 실패했습니다.");
					System.out.println(e);
				}
				}
			}
		}
		return meminfo;
	}


	static  void visormenu() {
		//대답 반환
		while(true) {
			System.out.println("=============================================");
			System.out.println("\t♩♪♬ 관리자 모드입니다.♩♪♬ ");
			System.out.println("=============================================");
			System.out.println("1. 회원 정보 열람");
			System.out.println("2. 음악 라이브러리 열람");
			System.out.println("3. 위시리스트 신청 목록 보기");
			System.out.println("b. 뒤로가기");
			 System.out.println("---------------------------------------------");	
			 System.out.print("입력 : ");
			String answer = scan.nextLine();
			 System.out.println("---------------------------------------------");
			//회원 정보 열람
			if(answer.equals("1")) {
				memberinfo();
			} else if(answer.equals("2")) {
				//음악 라이브러리 열람
				musicInfo();
			} else if(answer.equals("3")) {
				//위시리스트 신청 목록 보기
				wishListList();
			} else {
				//뒤로 가기
				break;
			}
		} //while	
		}
	
	
	
	
}
