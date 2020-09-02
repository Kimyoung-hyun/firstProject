package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Top100 {
	
	
	public static ArrayList<String> top100 () {
		
		ArrayList<Data> data = new ArrayList<Data>();
		ArrayList<String> top100List = new ArrayList<String>();
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
			
			try {
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
				data.add(new Data(dir.list()[i].replace(".mp3", ""), Integer.parseInt(temp[3])));

			}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			data.sort(new Comparator<Data>() {
				
				@Override
				public int compare(Data o1, Data o2) {
					// TODO Auto-generated method stub
					return o2.count - o1.count;
				}
			});
			

			for(int i =0;i<data.size();i++) {
				top100List.add((data.get(i)+"").split(",")[0]);
			}
			
			
			//System.out.println(top100List);
			
			
			
			
		}//if
		
		
		return top100List;

		
	}
}

class Data {
	String name;
	int count;
	
	Data(String name, int count){
		this.name = name;
		this.count = count;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s, %d\n", this.name, this.count);
	}
}
