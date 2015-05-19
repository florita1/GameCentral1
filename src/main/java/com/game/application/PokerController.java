package com.game.application;

import java.util.HashMap;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.game.services.poker.CalculateMoney;
import com.game.services.poker.MakeWallets;
import com.game.services.poker.PlayPokerGame;
import com.game.services.PokerInfo;
import com.game.services.UserInfo;


/**
 * Handles requests for the application home page.
 */
@Controller
public class PokerController {
	
	private static final Logger logger = LoggerFactory.getLogger(PokerController.class);
	private HashMap<String,Integer> wallets;
	
	@Autowired
	private UserInfo user;
	
	@Autowired
	private PokerInfo poker;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/setPoker", method = RequestMethod.GET)
	public String poker() {
		logger.info("User is setting up poker game");
		
		return "setPoker";
	}
	
	@RequestMapping(value = "/poker", method = RequestMethod.GET)
	public String setPoker( HttpServletRequest request, Model model) {
		logger.info("User is playing poker game");
		
		String playerName = this.user.getUserName();
		this.poker.setAnteAmount(Integer.parseInt(request.getParameter("anteAmount")));
		this.poker.setNumOfPlayers(Integer.parseInt(request.getParameter("players")));
		
		PlayPokerGame game = new PlayPokerGame(this.poker.getNumOfPlayers(), playerName);
		wallets = new MakeWallets
				(this.poker.getNumOfPlayers(), this.poker.getAnteAmount(), playerName).getStartWallets();
		
		String winner = game.getWinner();
		model.addAttribute("winner", winner+" wins!");
		wallets = new CalculateMoney(wallets, this.poker.getAnteAmount(), winner).recalculateMoney();
		
		String[] players = new String[] { playerName, "Player 2", "Player 3",
				"Player 4", "Player 5" };
		String[] attNames = new String[] { "p1","p2","p3","p4","p5"};
		for(int x = 0; x <= this.poker.getNumOfPlayers()-1; x++) {
			String player = players[x];
			String cards = game.getPlayerCards().get(player)[0] +
					" "+ game.getPlayerCards().get(player)[1] +
					" "+ game.getPlayerCards().get(player)[2] +
					" "+ game.getPlayerCards().get(player)[3] +
					" "+ game.getPlayerCards().get(player)[4];
			
			model.addAttribute(attNames[x], player +"'s cards: "+ cards );
			model.addAttribute(attNames[x]+"wallet", "Wallet: $"+wallets.get(player));
		}
		
		model.addAttribute("adjustPoker","true");
		return "poker";
	}
	
	@RequestMapping(value = "/poker", method = RequestMethod.POST)
	public String adjustPoker( HttpServletRequest request, Model model) {
		logger.info("User is playing poker game");
		
		String playerName = this.user.getUserName();
				
		PlayPokerGame game = new PlayPokerGame(this.poker.getNumOfPlayers(), playerName);
		String winner = game.getWinner();
		model.addAttribute("winner", winner+" wins!");
		wallets = new CalculateMoney(wallets, this.poker.getAnteAmount(), winner).recalculateMoney();
		
		String[] players = new String[] { playerName, "Player 2", "Player 3",
				"Player 4", "Player 5" };
		String[] attNames = new String[] { "p1","p2","p3","p4","p5"};
		for(int x = 0; x <= this.poker.getNumOfPlayers()-1; x++) {
			String player = players[x];
			String cards = game.getPlayerCards().get(player)[0] +
					" "+ game.getPlayerCards().get(player)[1] +
					" "+ game.getPlayerCards().get(player)[2] +
					" "+ game.getPlayerCards().get(player)[3] +
					" "+ game.getPlayerCards().get(player)[4];
			model.addAttribute(attNames[x], player +"'s cards: "+ cards );
			model.addAttribute(attNames[x]+"wallet", "Wallet: $"+wallets.get(player));
		}
		
		model.addAttribute("adjustPoker","true");
		return "poker";
	}
}
