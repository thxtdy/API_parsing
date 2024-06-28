package ch03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * {
	"userId": 1,
	"id": 1,
	"title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
	"body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
},
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	private int userId;
	private int id;
	private String title;
	private String body;
	@Override
	public String toString() {
		return "UserID : " + userId + " || ID : " + id + " || Title : " + title + " || Body " + body;
	}
	
	
}
