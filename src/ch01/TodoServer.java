package ch01;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import lombok.Data;
@Data
public class TodoServer {
	
	public static void main(String[] args) {
		
		try {
	
			HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);

			server.createContext("/todos", new MyTodoHandler());
			server.start();
			System.out.println("ServerStart");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} // end of main
	
	static class MyTodoHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange exchange) throws IOException {
			String method = exchange.getRequestMethod();
			System.out.println("Method" + method);
			System.out.println("eeeee");
			
			if("GET".equalsIgnoreCase(method)) {
				getHandlerRequest(exchange);
			} else if("POST".equalsIgnoreCase(method)) {
				System.out.println("ㄷㄷㄷ");
			}
			
			
		} 
		private void getHandlerRequest(HttpExchange exchange) throws IOException{
			
			Gson gson = new Gson();
			
			String response = """
					eeeee
					""";
			System.out.println(response);
			
			
			exchange.sendResponseHeaders(200, response.length());
			OutputStreamWriter os = new OutputStreamWriter(exchange.getResponseBody());
			os.write(response);
			os.close();
			
		} // end of getHandlerRequest
		
	} // end of MyTodohandler

	class JaeSung {
		String name;
		int age;
		
		public JaeSung(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}
}
