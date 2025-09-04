package kr.or.kosa;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data @AllArgsConstructor @Builder
public class UserInfo implements Serializable{ 
	// implements Serializable : 직렬화가 가능하다.(레고)
	private String userId;
	private String userPwd;
	private int age;
	
	
}
