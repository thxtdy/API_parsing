package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class UserClient {
	
	public static void main(String[] args) {
		// Setting
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/users");
			HttpURLConnection conn =  (HttpURLConnection)url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "json");
			// ResponseCode
			int responseCode = conn.getResponseCode();
			System.out.println("Response Code : " + responseCode);
			
			// Reader
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn .getInputStream()));
			StringBuffer readLine = new StringBuffer();
			String result;
			// 싸이트에서 긁어온 전체를 콘솔에서 확인하기
			while((result = reader.readLine()) != null) {
				readLine.append(result);
			}
//			System.out.println(readLine.toString());
			System.out.println("===============================");
			System.out.println("===============================");
			
			// Json 으로 변환.  클래스 연계
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			Type userType = new TypeToken<List<User>>() {}.getType();
			
			List<User> userList = gson.fromJson(readLine.toString(), userType);
			
			System.out.println(userList.size());
			for (User user : userList) {
				System.out.println(user.toString());
			}
			
//			System.out.println(userList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
