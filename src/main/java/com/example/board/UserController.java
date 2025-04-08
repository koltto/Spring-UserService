package com.example.board;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {
/*
 * URL 정의(localhost:8080/users)
 * 
 * url은 동사로 시작하지 않고 명사로 정의한다.
 * 명사는 복수의 형태로 정의한다. user(x), users
 * HTTP Method: GET, POST, PUT, DELETE, PATCH, OPTION, ....
 * 
 * 회원정보 관리
 * 1) 회원정보 등록(POST)
 * 2) 회원정보 조회(GET)
 * 3) 회원정보 수정(PUT, PATCH)
 * 4) 회원정보 삭제(DELETE)
 * 
 * */
	
   private final UserRepository userRepository;
   
   // 회원정보 추가
   @PostMapping("users")
   public User registUser(@RequestBody User user) {
	   log.info("user: {}", user);
	   userRepository.save(user);
	   
	   return user; 
   }
   
   // 회원정보 조회
   @GetMapping("users/{id}")
   public User getUser(@PathVariable(name="id") Long id) {
	   log.info("id: {}", id);
	   return userRepository.getUser(id);
   }
}
