package com.arisys.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// 사용자가 요청 -> 응답(HTML)파일 @Controller
// 사용자가 요청 -> 응답(Data) @RestController

// 스프링부트의 MessageConverter라는 클래스가 url로 넘어온 데이터 값을 모델에 매핑하거나, JSON으로 넘어온 데이터를 모델에 매핑한다.

@RestController
public class HttpControllerTest {
	
	private final String TAG = "HttpControllerTest : ";
	
	//http:/localhost:8080/http/get(select) --> 브라우저 요청은 무조건 get만
	
	/*
	@GetMapping("/http/get")
	public String getTest(@RequestParam int id, @RequestParam String username) {
		
		return "get 요청 : " + id + ", 이름 : " + username;
		
	}
	*/
	
	
	@GetMapping("http/lombok")
	public String lombokTest() {
		
		// Member m = new Member(1, "ssar", "1234", "ssar@naver.com");
		
		// Builder를 써서 만든 객체 -- 내가 원하는 것만 만들어서 생성할 수 있다. -- 순서를 지키지 않아도 된다.
		Member m = Member.builder().username("vanilla").email("vanilla@naver.com").password("1234").build();
	
		System.out.println(TAG + "getter : " + m.getUsername());
		m.setUsername("berry");
		System.out.println(TAG + "setter : " + m.getUsername());
		return "lombok test 완료";
		
	}
	
	
	@GetMapping("/http/get")
	public String getTest(Member m) {
		
		return "get 요청 : " + m.getId() + ", 이름 : " + m.getUsername() + " / " + m.getEmail();
		
	}
	
	
	//http:/localhost:8080/http/post(insert)
	//post는 데이터를 주소가 아니라 body에 넣어 보낸다. 
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
			
		return "post 요청 : " + m.getId() + ", 이름 : " + m.getUsername() + " / " + m.getEmail();
			
	}
	
	//http:/localhost:8080/http/put(update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		
		return "put 요청 : " + m.getId() + ", 이름 : " + m.getUsername() + " / " + m.getEmail();
		
	}

	//http:/localhost:8080/http/delete(delete)
	@DeleteMapping("/http/delete")
	public String deleteTest(Member m) {
		
		return "delete 요청";
		
	}
	
}
