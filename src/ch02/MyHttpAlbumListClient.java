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
/*
 * Json Array 형태를 파싕싕 파숭숭 파송송 해보자
 */
public class MyHttpAlbumListClient {

	public static void main(String[] args) {
		
		// 순수 자바 코드에서 HTTP 통신
		// 1. 서버 주소 경로
		// 2. URL 클래스
		// 3. url.openConnection() <= Stream I/O
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/albums");
			HttpURLConnection conn =  (HttpURLConnection)url.openConnection(); // 다운캐스팅팅 탱탱 탕탕티이이잉
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			// TCP 기반 == 신뢰성, 순서
			
			// 응답 코드 확인
			int responseCode = conn.getResponseCode();
			System.out.println("Response code : " + responseCode);
			
			// HTTP 응답 메시지에서 데이터를 추출
			conn.getInputStream();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while((inputLine = in.readLine()) != null) {
				buffer.append(inputLine);
			}
			in.close();
			
//			System.out.println(buffer.toString());
			// gson lib 활용
			System.out.println("============================");
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			// 하나의 Json Object 형태 파싱
			
//			Album album = gson.fromJson(buffer.toString(), Album.class);
			
//			System.out.println("userId : " + album.getUserId());
//			System.out.println("id : " + album.getId());
//			System.out.println("title : " + album.getTitle());
			
			// [{..},{..},{..}......{...}]  배열(Array) 형식 Json 을 변환
			// Gson 제공하는 type 이라는 데이터 타입을 활용할 수 있다.
			
			// Json 배열 형태를 쉽게 파싱하는 방법 => TypeToken 안에 List<T> 활용.
			
			Type albumType = new TypeToken<List<Album>>() {}.getType();
			
			List<Album> albumList = gson.fromJson(buffer.toString(), albumType);
			
			System.out.println(albumList.size());
			for (Album a : albumList) {
				System.out.println(a.toString());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end of main
	
}
