package com.game.application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.NestedServletException;

import com.game.services.BlackjackInfo;
import com.game.services.LoginDB;
import com.game.services.ManageLogin;
import com.game.services.SpringException;
import com.game.services.UserInfo;
import com.game.services.blackjack.ChooseWinner;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserInfo user;
	
	@Autowired
	private BlackjackInfo blackJack;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		logger.info("User is registering.");
		
		return "register";
	}
	
	@RequestMapping(value = "/registered", method = RequestMethod.POST)
	public String registered(HttpServletRequest request, HttpServletResponse response, Model model) throws SQLException {
		logger.info("User info is submitted to database.");
		String name = request.getParameter("userName");
		String pass = request.getParameter("passWord");
		String email = request.getParameter("email");
		
		model.addAttribute("message", name );
		ManageLogin ML = new ManageLogin();
		ML.populateDB(name,pass,email);
		
		return "registered";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login( Model model) {
		logger.info("User is logging in");
		
		return "login";
	}
	
	@RequestMapping(value = "/thankyou", method = RequestMethod.POST)
	public String thankyou( HttpServletRequest request, Locale locale, Model model ) throws SQLException {
		logger.info("User is logging in.");
		
		String name = request.getParameter("userName");
		String pass = request.getParameter("passWord");
		
		user.setUserName(name);
		
		String passDB = ManageLogin.getPassword(name);
		String message = "";
		if(passDB.equals(pass)) {
			message = "Thank you for logging in "+name+".<br> "
					+ "Please choose a game to play <a href='/application'> here</a>.";
		} else {
			message = "Login failed. Please try logging in again <a href='/application/login'> here</a>.";
		}
		
		model.addAttribute("loginMessage", message );
		ChooseWinner wins = new ChooseWinner();
		blackJack.setWins(wins);
		return "thankyou";
	}
	
	@ExceptionHandler({SpringException.class})
	public String handleException(HttpServletRequest request, Exception e) {
		logger.info("Error page accessed.");
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		//String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		//String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		new SpringException(throwable, statusCode);
		return("exception");
	}
}
