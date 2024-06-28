package ch02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * "id": 1,
	"name": "Leanne Graham",
	"username": "Bret",
	"email": "Sincere@april.biz",
	"address": {
		"street": "Kulas Light",
		"suite": "Apt. 556",
		"city": "Gwenborough",
		"zipcode": "92998-3874",
	
	"geo": {
		"lat": "-37.3159",
		"lng": "81.1496"
	}
},
	"phone": "1-770-736-8031 x56442",
	"website": "hildegard.org",
	"company": {
		"name": "Romaguera-Crona",
		"catchPhrase": "Multi-layered client-server neural-net",
		"bs": "harness real-time e-markets"
	}
}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	private int id;
	private String username;
	private String email;
	private Address address;
	private Geo geo;
	private String phone;
	private String website;
	private Company company;
}
	class Address{
		private String street;
		private String suite;
		private String city;
		private String zipcode;
		@Override
		public String toString() {
			return "Address [Street : " + street + ", Suite : " + suite + ", City : " + city + ", Zipcode : " + zipcode + "]";
		}
		
	}
	class Geo{
		private String lat;
		private String lng;
		@Override
		public String toString() {
			return "Geo [Lat : " + lat + ", Lng : " + lng + "]";
		}
		
	}
	
	class Company{
		private String name;
		private String catchPhrase;
		private String bs;
		@Override
		public String toString() {
			return "Company [Name : " + name + ", catchPhrase : " + catchPhrase + ", Bs : " + bs + "]";
		}
	}
	
	

