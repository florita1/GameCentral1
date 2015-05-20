package com.game.application;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.game.services.war.GetWinner;
import com.game.services.war.HandleDeck;
import com.game.services.war.MakePlayersHands;
import com.game.services.UserInfo;
import com.game.services.WarInfo;


/**
 * Handles requests for the application home page.
 */
@Controller
public class WarController {
	
	private static final Logger logger = LoggerFactory.getLogger(WarController.class);
	private HashMap<String,List<String>> playerCards;
	
	@Autowired
	private UserInfo user;
	
	@Autowired
	private WarInfo war;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/war", method = RequestMethod.GET)
	public String war(Model model, HttpServletRequest request) {
		logger.info("User is playing war.");
		HttpSession userSession = request.getSession();
		if(userSession.getAttribute("Authen")==null || userSession.isNew()) {
			String msg = "You must be logged in to view your profile.";
			model.addAttribute("loginMessage", msg);
			model.addAttribute("Authenticated", "no");
		} else {
			model.addAttribute("Authenticated", "yes");
			String playerName = this.user.getUserName();
			playerCards = new MakePlayersHands(playerName).getPlayerMap();

			String winner = new GetWinner(playerCards, playerName).getWinner();

			war.setPlayerCard(playerCards.get(playerName).get(0));
			war.setpDeckSize(playerCards.get(playerName).size());
			war.setDealerCard(playerCards.get("Player 2").get(0));
			war.setdDeckSize(playerCards.get("Player 2").size());
			war.setWinner(winner);

			model.addAttribute("playerCard", this.war.getPlayerCard());
			model.addAttribute("dealerCard", this.war.getDealerCard());
			model.addAttribute("playerDeck", this.war.getpDeckSize());
			model.addAttribute("dealerDeck", this.war.getdDeckSize());
			model.addAttribute("winner", this.war.getWinner());

			model.addAttribute("adjustWar", "true");
		}
		return "war";
	}
	
	@RequestMapping(value = "/war", method = RequestMethod.POST)
	public String adjustWar(Model model) {
		logger.info("User is playing war again.");
		String playerName = this.user.getUserName();
		
		String winner = new GetWinner(playerCards, playerName).getWinner();
		boolean warScene =  new GetWinner(playerCards, playerName).getWar();
		new HandleDeck(winner, playerCards, warScene, playerName);
		winner = new GetWinner(playerCards, playerName).getWinner();
		
		war.setPlayerCard(playerCards.get(playerName).get(0));
		war.setpDeckSize(playerCards.get(playerName).size());
		war.setDealerCard(playerCards.get("Player 2").get(0));
		war.setdDeckSize(playerCards.get("Player 2").size());
		war.setWinner(winner);
		
		if(warScene) model.addAttribute("war","War!");
		model.addAttribute("playerCard", this.war.getPlayerCard());
		model.addAttribute("dealerCard", this.war.getDealerCard());
		model.addAttribute("playerDeck", this.war.getpDeckSize());
		model.addAttribute("dealerDeck", this.war.getdDeckSize());
		model.addAttribute("winner", this.war.getWinner());
		
		model.addAttribute("adjustWar", "true");
		return "war";
	}
}
