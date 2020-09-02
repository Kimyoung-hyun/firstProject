package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class inputMusic {
	static MemberInfo m = new MemberInfo();
	static String id;
	

	static {
		
		id = m.getId(); 
	}
	
	
	public static void main(String[] args) {
		List<String> idPlaylist = new ArrayList<String>();
		
		
		
		
		
			idPlaylist = inputMusic(id);
			for(int i = 0; i < idPlaylist.size() ; i++) {
				System.out.println(idPlaylist.get(i));
			}
		
		
		
		
	}


	static List<String> inputMusic(String id2)  {
		
		String path = "D:\\데이터\\회원데이터" + id2 + "\\" + id2 + "playlist.txt"; //회원 플레이리스트
		String path2 = "D:\\데이터\\음악데이터"; //음악파일
		
		File file = new File(path2);
		File[] mlist = file.listFiles();
		List<String> songList = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = null;
			while ((line = reader.readLine()) != null) {

				for (File song : mlist) {

					if (song.getName().equals(line)) {
						String title = song.getName().substring(0, song.getName().lastIndexOf("-"));
						String singer = song.getName().substring(song.getName().lastIndexOf("-") + 1,
								song.getName().lastIndexOf("."));

						BufferedReader sreader = new BufferedReader(new FileReader(song));

						songList.add(title + "," + singer + "," + sreader.readLine());

						sreader.close();
					}

				}

				
			}
			reader.close();
		} catch (Exception e) {

			System.out.println("플레이리스트 저장에 실패했습니다.");
			System.out.println(e);
		}

		
		return songList;
	}

}
