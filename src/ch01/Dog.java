package ch01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Data;

 

@Data
public class Dog {
	String name;
	int age;
	String currentsc;
	
	public Dog(String name, int age, String currentsc) {
		this.name = name;
		this.age = age;
		this.currentsc = currentsc;
	}
	public static void main(String[] args) {
		
		Dog dog1 = new Dog("유재성", 21, "군대가야함");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String trans = gson.toJson(dog1);
		System.out.println(trans);
		
		Dog dogObject = gson.fromJson(trans, Dog.class);
		
		System.out.print(dogObject.getName() + " : ");
		System.out.println(dogObject.getAge());
		System.out.println(dogObject.getCurrentsc());
	}
	
	
}
