package com.game.application;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.game.services.blackjack.CheckDealer;
import com.game.services.blackjack.ChooseWinner;
import com.game.services.blackjack.CountHands;
import com.game.services.blackjack.MakeHands;
import com.game.services.BlackjackInfo;
import com.game.services.UserInfo;


/**
 * Handles requests for the application home page.
 */
@Controller
public class BlackjackController {
	
	private static final Logger logger = LoggerFactory.getLogger(BlackjackController.class);
	private MakeHands cards;
	private ChooseWinner wins;
	
	@Autowired
	private UserInfo user;
	
	@Autowired
	private BlackjackInfo blackJack;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/blackjack", method = RequestMethod.GET)
	public String blackjack( Model model) {
		logger.info("User is playing war game");
		
		String playerName = this.user.getUserName();
		
		cards = new MakeHands(playerName);
		HashMap<String,List<String>> playerCards = cards.getPlayerMap();
		CountHands playerInfo = new CountHands(playerCards);
		
		String cardsStr = playerCards.get(playerName).get(0) +" "+ playerCards.get(playerName).get(1);
		
		model.addAttribute("playerCards" ,"Your cards: "+ cardsStr );
		model.addAttribute("playerCount", "Card count: "+ playerInfo.countHand(playerName));
		
		model.addAttribute("adjustBlackjack", "true");
		return "blackjack";
	}
	
	@RequestMapping(value = "/blackjack", method = RequestMethod.POST)
	public String adjustBlackjack( Model model) {
		logger.info("User hit in war game");
		
		String playerName = this.user.getUserName();
		
		cards.addCard();
		HashMap<String,List<String>> playerCards = cards.getPlayerMap();
		CountHands playerInfo = new CountHands(playerCards);
		
		String cardsStr = "";
		for(String card : playerCards.get(playerName)) {
			cardsStr += " "+ card;
		}
		
		model.addAttribute("playerCards", "Your cards: "+ cardsStr );
		model.addAttribute("playerCount", "Card count: "+ playerInfo.countHand(playerName));
		
		model.addAttribute("adjustBlackjack", "true");
		return "blackjack";
	}
	
	@RequestMapping(value = "/finishBlackjack", method = RequestMethod.GET)
	public String finishBlackjack( Model model) {
		logger.info("User is staying, winner is being determined");
		
		String playerName = this.user.getUserName();
		
		HashMap<String,List<String>> playerCards = cards.getPlayerMap();
		
		CountHands playerInfo = new CountHands(playerCards);
		CheckDealer dealerInfo = new CheckDealer(cards);
		int dealerCount = dealerInfo.getDealerCount();
		int playerCount = playerInfo.countHand(playerName);
		
		String pcards = ""; String dcards = "";
		for(String card : playerCards.get(playerName)) {
			pcards += " "+ card;
		}

		for(String card : playerCards.get("Dealer")) {
			dcards += " "+ card;
		}
		
		model.addAttribute("playerCards", "Your cards: "+ pcards );
		model.addAttribute("dealerCards", "Dealer cards: "+ dcards );
		
		model.addAttribute("playerCount", "Your card count: " + playerCount);
		model.addAttribute("dealerCount", "Dealer card count: " + dealerCount);
		
		ChooseWinner wins = blackJack.getWins();
		wins.adjustWins(playerInfo, dealerInfo, playerCount);
		model.addAttribute("pWins", "Your wins: " + wins.getPlayerWins());
		model.addAttribute("dWins", "Dealer wins: " + wins.getDealerWins());
		
		return "finishBlackjack";
	}
}
