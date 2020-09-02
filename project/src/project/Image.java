package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import com.github.lalyos.jfiglet.*;

public class Image {

	public static void main(String[] args) throws Exception{

		String path ="D:\\더미\\main.txt";
		
		BufferedReader freader = new BufferedReader(new FileReader(path));
		
		File file = new File(path);
		
		String line = freader.readLine();
		
		ArrayList<String> list = new ArrayList<String>();
		
		while ((line = freader.readLine()) != null) {
			list.add(line);
		}
		
		freader.close();	
		
		
		for (String type : list) {
			
			System.out.println(type);
			
		}	
		
		String asciiArt2 = FigletFont.convertOneLine(FigletFont.class.getResourceAsStream("/flf/banner3.flf"), "Music");
		System.out.println(asciiArt2);
		
				
	    //MyPage.startPage();
	}
					
}
	

