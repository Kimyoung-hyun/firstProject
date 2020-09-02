package project;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Write_Music_file {
public static void main(String[] args)throws Exception {
	String path ="C:\\데이터\\음악데이터";
	File dir = new File(path);
	File[] list = dir.listFiles();
	
	String[] jang1 = new String[] {"락","밴드","발라드","클래식","댄스","POP","OST","컨트리",
			"R&B","트로트","EDM","재즈","캐롤","랩","힙합"};
	Random rnd = new Random();


	
	for(File sub : list) {
	BufferedWriter writer = new BufferedWriter(new FileWriter(sub));
	for(int i=0;i<=sub.length();i++) {
	writer.write(jang1[rnd.nextInt(jang1.length)]+","+jang1[rnd.nextInt(jang1.length)]);
	writer.write(","+rnd.nextInt(10));
	writer.write(","+rnd.nextInt(10));
	
	}
	writer.close();
	}
	
}
}