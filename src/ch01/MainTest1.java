package ch01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainTest1 {
	
	// gof design pattern
	public static void main(String[] args) {
		
		// Gson <= 현재 사용 불가
		// lib 폴더에 Gson 라이브러리 추가
		// 우리 소스 코드에 사용하기 위해 설정이 필요하다
		
		
		// properties => java build path => class path + add jars 등록
		Gson gson = new Gson();
//		gson.fieldNamingStrategy();
		
		Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
		
		Student student1 = new Student("가", 3, "컴컴");
		
		String trans = gson1.toJson(student1);
		
		System.out.println(trans);
		
		
		
	} // end of main 

	
} // end of class
