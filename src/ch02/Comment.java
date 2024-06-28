package ch02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * {
	"postId": 2,
	"id": 7,
	"name": "repellat consequatur praesentium vel minus molestias voluptatum",
	"email": "Dallas@ole.me",
	"body": "maiores sed dolores similique labore et inventore et\nquasi temporibus esse sunt id et\neos voluptatem aliquam\naliquid ratione corporis molestiae mollitia quia et magnam dolor"
}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	
	private int postId;
	private int id;
	private String name;
	private String email;
	private String body;
	
}
