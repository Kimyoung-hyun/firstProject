package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PickSeasonNum {

	public static void seasonList() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		File dir = new File("D:\\데이터\\음악데이터");

		if (dir.exists()) {

			int count = 0; // 누적 변수
			File[] list = dir.listFiles(); // 이클립스의 자식

			// 음악 파일 개수
			for (File sub : list) {

				if (sub.isFile()) {

					count++;
				}
			}

			// 음악정보가 들어갈 리스트
			ArrayList<String> data = new ArrayList<String>();

			// 장르로 리스트 정리
			for (int i = 0; i < count - 1; i++) {
				// 디렉토리에 있는 음악파일 하나씩 읽기
				String path = String.format("D:\\데이터\\음악데이터\\%s", dir.list()[i]);

				File file = new File(path);
				BufferedReader reader1 = new BufferedReader(new FileReader(file));

				// ArrayList<String> list1 = new ArrayList<String>();
				// 음악파일의 데이터를 line에 저장
				String line = reader1.readLine();

				String[] temp = line.split(",");

				// 파일명 + 장르를 저장
				data.add(String.format("%s=%s%s\n", dir.list()[i].replace(".mp3", ""), temp[0], temp[1]));

			}
//			System.out.println(data);

			// 시간에 해당되는 노래를 저장할 list
			ArrayList<String> list1 = new ArrayList<String>();
			ArrayList<String> list2 = new ArrayList<String>();
			ArrayList<String> list3 = new ArrayList<String>();
			ArrayList<String> list4 = new ArrayList<String>();

			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).contains("발라드") || data.get(i).contains("재즈") || data.get(i).contains("클래식")) {
					list1.add(data.get(i).split("=")[0]);
				}
			}
			for (int i = 0; i < data.size(); i++) {

				if (data.get(i).contains("댄스") || data.get(i).contains("힙합") || data.get(i).contains("EDM")) {
					list2.add(data.get(i).split("=")[0]);
				}
			}
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).contains("팝") || data.get(i).contains("발라드") || data.get(i).contains("알앤비")) {
					list3.add(data.get(i).split("=")[0]);
				}
			}
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).contains("팝") || data.get(i).contains("발라드") || data.get(i).contains("캐롤")) {
					list4.add(data.get(i).split("=")[0]);
				}
			}

			// 메뉴 프린트

			boolean flag1 = true;
			while (flag1) {
				System.out.println("=============================================");
				System.out.println("\t♩♪♬ 지금 계절의 추천 곡 ♬♪♩");
				System.out.println("=============================================");

				System.out.println("1. 봄");
				System.out.println("2. 여름");
				System.out.println("3. 가을");
				System.out.println("4. 겨울");
				System.out.println("---------------------------------------------");
				System.out.print("입력 ▶  ");

				String input = reader.readLine();
				System.out.println("---------------------------------------------");

				ArrayList<String> menu = new ArrayList<String>();
				if (input.equals("1")) {
					// 장르 > 재즈, 발라드, 클래식
					System.out.println("\t추천 노래 목록");
					for (int i = 0; i < list1.size(); i++) {
						menu.add(String.format("%d=%s", i + 1, list1.get(i)));
						// System.out.printf("%d. %s\n", i + 1, list1.get(i));
					}
				} else if (input.equals("2")) {
					System.out.println("\t추천 노래 목록");
					for (int i = 0; i < list2.size(); i++) {

						menu.add(String.format("%d=%s", i + 1, list2.get(i)));
						// System.out.printf("%d. %s\n", i + 1, list2.get(i));
					}

				} else if (input.equals("3")) {

					System.out.println("\t추천 노래 목록");
					for (int i = 0; i < list3.size(); i++) {

						menu.add(String.format("%d=%s", i + 1, list3.get(i)));
						// System.out.printf("%d. %s\n", i + 1, list3.get(i));
					}
				} else if (input.equals("4")) {

					System.out.println("\t추천 노래 목록");
					for (int i = 0; i < list4.size(); i++) {

						menu.add(String.format("%d=%s", i + 1, list4.get(i)));
						// System.out.printf("%d. %s\n" + "", i + 1, list4.get(i));
					}

				} else if (input.equals("b")) {
					flag1 = false;
					break;
				}

				ArrayList<String> menuList = new ArrayList<String>();
				for (int i = 0; i < menu.size(); i++) {
					menuList.add(menu.get(i).split("=")[1]);
				}

				pagingfile.page(menuList);
				
				
				

				System.out.println();
				// 재생
				// 페이징??

				boolean flag = true;
				while (flag) {
					System.out.println("=============================================");
					System.out.println("\t어떤 곡을 재생하시겠습니까?");
					System.out.println("\t(숫자로 입력하세요)");
					System.out.println("=============================================");
					System.out.print("입력 ▶ ");
					String input2 = reader.readLine();
					System.out.println("---------------------------------------------");

				
					if (input2.equals("b")) {
						flag = false;
					}

					for (int i = 0; i < menu.size(); i++) {

						if (input2.equals(menu.get(i).split("=")[0])) {
							System.out.printf("[%s]를 재생합니다.\n", menu.get(i).split("=")[1]);
						}

					}
				} // while

			}//while
		}
	}

}
