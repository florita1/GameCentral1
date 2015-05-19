package com.game.services.blackjack;

import java.util.HashMap;
import java.util.List;

public class CheckDealer {
	
	private int dealerCount;
	private boolean bust = false;

	public int getDealerCount() {
		return dealerCount;
	}

	public CheckDealer(MakeHands cards) {
		HashMap<String,List<String>> playerMap = cards.getPlayerMap();
		CountHands ch = new CountHands(playerMap);
		dealerCount = ch.countHand("Dealer");
		//System.out.println("DealerCount: " + dealerCount);
		
		List<String> cardDeck = cards.getCards();
		List<String> dealerCards = playerMap.get("Dealer");
		while(dealerCount <= 17) {
			String card = cardDeck.get(0);
			dealerCards.add(card);
			cardDeck.remove(card);
			playerMap.put("Dealer", dealerCards);
			dealerCount = ch.countHand("Dealer");
			bust = ch.isBust();
			//System.out.println("new DealerCount: " + dealerCount);
		}
		dealerCount = ch.countHand("Dealer");
		bust = ch.isBust();
	}

	public boolean isBust() {
		return bust;
	}

}
