package ch01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonExample {
	
	public static void main(String[] args) {
		Student student1 = new Student("고길동", 40, "애완학과");
		Student student2 = new Student("둘리", 99999999, "공룡");
		Student[] studentArr = {student1, student2};
		// => 특정 형식(구조화) 있는 문자열로 변환하고 싶다 =JSON
		
		// 객체를 json 형식의 문자열로 변환 시켜라. == 메소드
		
		Gson gson1 = new GsonBuilder().setPrettyPrinting().create(); // 쌈뽕하게 출력하라 option 
		String student1Str = gson1.toJson(studentArr);
		System.out.println(student1Str);
		
		Gson gson2 = new Gson();
		String student2Str = gson2.toJson(student2);
		System.out.println(student2Str);
		
		// 객체에서 ==> 문자열 형태로 가능.. 반대로 해보자
		// 문자열에서 => 클래스 형태
		
		Student studentObject= gson1.fromJson(student1Str, Student.class);
		
		System.out.println(studentObject.getAge());
		
		
		
	}
	
}
