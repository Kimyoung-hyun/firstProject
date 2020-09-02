package project;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class Random_Music_file {
public static void main(String[] args) throws Exception {

	String path ="C:\\데이터\\음악데이터";
	File dir = new File(path);
	File[] list = dir.listFiles();
	
	String[] title = new String[] {"첫사랑","소나기","비밀","에잇","cheer up","나아게로 떠나는 여행","1st","파도","파란 봄","heaven","좋은날",
			"200%","크레센도","하루","보고싶다","예감 좋은 날","휘파람","마지막처럼","RUN","광대","EV01","Happy day","달라","RATATA","인연","난춘","형","지독하게",
			"ENDLESS","FUNNY ROCK","하루하루","rain drop","바람","Dynamite","DNA","빨간 맛","Psyco","거짓말","노래방에서","oh my god","낭만 고양이","파도"};

	
	String[] sSinger = new String[] {"IU","FLOWER","방탄소년단","TWICE","레드벨벳","버즈","빅뱅","FTILAND","새소년","노라조","장범준"
			,"악동뮤지션","김범수","에일리","럼블피쉬","블랙핑크","리쌍","체리필터","이선희","자우림","ITZY(잇지)","(여자)아이들"};
	
	Random rnd = new Random();
	for(int i=0;i<300;i++) {
		
	
	String s ="D:\\데이터\\음악데이터\\"+title[rnd.nextInt(title.length)]+"-"+sSinger[rnd.nextInt(sSinger.length)]+".mp3";
	System.out.println(i+s);
	
	File file = new File(s);
	FileOutputStream stream1 = new FileOutputStream(s);
	stream1.close();

//	if(dir.isDirectory()) {
//		for(File sub : list) {
//			  sub.renameTo(file);
//			  System.out.println(1);
//		}
//	}
//	else {
//		System.out.println("파일없음");
//	}
	

	}
	
	
	
}
}