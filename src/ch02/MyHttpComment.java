package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyHttpComment {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/comments/7");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "json");
			
			int response = conn.getResponseCode();
			System.out.println("Response Code : " + response);
			
			BufferedReader reader;
			if(response >= 200 && response <= 300) {
				reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
			}else {
				reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			StringBuilder readline = new StringBuilder();
			String result;
			
			while((result = reader.readLine()) != null) {
				readline.append(result);
			}
			System.out.println(readline.toString());
			
			// Trans Json
			System.err.println("======================");
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			Comment comment = gson.fromJson(readline.toString(), Comment.class);
			
			System.out.println(comment.getPostId());
			System.out.println(comment.getId());
			System.out.println(comment.getEmail());
			System.out.println(comment.getName());
			System.out.println(comment.getBody());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
