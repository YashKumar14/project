package com.example.demo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminRepository adminRepository;

	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("admin", new Admin());
		return "register";
	}

	@PostMapping("/register")
	public ModelAndView register(@RequestParam String username, @RequestParam String password,
			@RequestParam String confirmPassword, Model model) {
		Admin existingAdmin = adminRepository.findByUsername(username);
		if (existingAdmin != null) {
			model.addAttribute("error", "username_exist");
			return new ModelAndView("register");
		} else if (!password.equals(confirmPassword)) {
			model.addAttribute("error", "password_mismatch");
			return new ModelAndView("register");
		} else {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encryptedPassword = passwordEncoder.encode(password);

			Admin admin = new Admin();
			admin.setUsername(username);
			admin.setPassword(encryptedPassword);
			adminRepository.save(admin);
			return new ModelAndView("redirect:/admin/login");
		}

	}

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam String username, @RequestParam String password, Model model) {
		Admin admin = adminRepository.findById(username).orElse(null);
		if (admin != null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if (passwordEncoder.matches(password, admin.getPassword())) {
				return new ModelAndView("redirect:/admin/menu");
			} else {
				model.addAttribute("error", "Invalid password");
				return new ModelAndView("login");
			}
		} else {
			model.addAttribute("error", "Invalid username");
			return new ModelAndView("login");
		}
	}

	@GetMapping("/menu")
	public String getMenu() {
		return "menu";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/admin/register";
	}

}
