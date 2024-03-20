package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/Testmain") // test home
	public String Testmain() {
		return "Testmain";
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}

	@PostMapping("/joinForm") // test join
	public String joinForm(@ModelAttribute User userDTO) {
		userService.InsertUser(userDTO);
		return "joinForm";
	}

	@GetMapping("/login") // login
	public String loginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String loginForm(@RequestParam("userID") String userID, @RequestParam("password") String password,
			Model model) {
		User user = userService.Login(userID, password);

		if (userID.isEmpty()) {
			System.out.println("아이디를 입력해 주세요");
			return "login";
		}

		if (password.isEmpty()) {
			System.out.println("비밀번호를 입력해 주세요");
			return "login";
		}

		if (user != null) {
			// 로그인 성공
			model.addAttribute("loggedInUser", user); // 세션에 사용자 정보 저장
			System.out.println("성공입니다");
			return "login";
		} else {
			// 로그인 실패
			System.out.println("실패입니다");
			return "login";
		}
	}

}