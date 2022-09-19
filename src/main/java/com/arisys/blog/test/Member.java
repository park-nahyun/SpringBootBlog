package com.arisys.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor 
public class Member {

	private int id;
	private String username;
	private String password;
	private String email;
	
	@Builder // AllArgsConstructor 대신 직접 생성자 만들고 Builder붙인 것
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	/*
	 * Builder 패턴..
	 * 만약에 내가 id는 시퀀스를 주고 싶고 나머지만 직접 넣고 싶으면
	 * public Member(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
		}
		이런 식의 생성자가 필요하다. 근데 Builder 패턴을 쓰면 이런식으로 생성자를 일일이 만들 필요가 없음.
		HttpControllerTest로 가봐..
	 * */
}


/*
// @Getter
// @Setter
@Data
//@AllArgsConstructor // 생성자
@RequiredArgsConstructor // final 붙은 애들에 대한..
public class Member {

	private final int id;
	private final String username;
	private final String password;
	private final String email;
	
	// db에서 가지고 온 값을 변경하지 않으려고 final. 만약에 패스워드를 바꿔야하면 final을 붙이지 않는다.
	// 요새 많이 이렇게한다고 함.
	
}

*/
