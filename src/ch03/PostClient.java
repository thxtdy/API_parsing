package ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class PostClient {
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			
			int response = connection.getResponseCode();
			System.out.println(response);
			
			BufferedReader reader;
			String readLine = new String();
			StringBuffer sb = new StringBuffer();
			if((response >= 200 && response <= 300)) {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			}
			while((readLine = reader.readLine()) != null) {
				sb.append(readLine);
			}
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			Type postType = new TypeToken<List<Post>>() {}.getType();
			
			List<Post> postlist = gson.fromJson(sb.toString(), postType);
			System.out.println(postlist.size());
			for (Post post : postlist) {
				System.out.println(post.toString());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
