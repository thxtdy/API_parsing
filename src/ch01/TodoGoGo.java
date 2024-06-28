package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Data;
@Data

public class TodoGoGo {
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder urlBuilder = new StringBuilder("https://jsonplaceholder.typicode.com/todos/1");
		
		URL url = new URL(urlBuilder.toString());
		
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Content-type", "json");
		
		System.out.println(connection.getResponseCode());
		
		BufferedReader reader;
		if(connection.getResponseCode() >= 200 && connection.getResponseCode() <= 300) {
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		} else {
			reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
		}
		
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null) {
			sb.append(line);
		}
		
//		reader.close();
//		connection.disconnect();
		Gson gson = new Gson();
		
		System.out.println(sb.toString());         
		
		System.out.println("------rnqns---");
//		
//		String trans = gson.toJson(sb.toString()); // json 으로 바꾸기
//		System.out.println(trans);
		
		System.out.println("--------------=================");
		
//		Todo todoObject = gson.fromJson(line, Todo.class);
		
	
//   1. 문자열 ---> 인스턴스화 toJson();
//   2. 클래스 ---> 문자열 fromJson(); 		
		
		
		User user = new User(1, 3, "333", true);
//		
		Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
//		
//		String todoStr = gson2.toJson(user);
//		
		
		User userObject = gson2.fromJson(sb.toString(), User.class);
		
		System.out.println(userObject.userId);
		System.out.println(userObject.id);
		System.out.println(userObject.title);
		System.out.println(userObject.completed);
	}
	static class User {
		public int userId;
		public int id;
		public String title;	
		public boolean completed;
		
		public User(int userId, int id, String title, boolean completed) {
			this.userId = userId;
			this.id = id;
			this.title = title;
			this.completed = completed;
			
		}
	
	
	
	}
}