package com.game.services.blackjack;

public class ChooseWinner {
	
	private static int playerWins;
	private static int dealerWins;
	private boolean draw = false;
	
	/*static {
		playerWins = 0;
		dealerWins = 0;
	}*/
	
	public ChooseWinner() {
		playerWins = 0;
		dealerWins = 0;
	}
	
	public int getPlayerWins() {
		return playerWins;
	}

	public int getDealerWins() {
		return dealerWins;
	}
	
	
	public boolean isDraw() {
		return draw;
	}

	public void adjustWins( CountHands playerInfo, CheckDealer dealerInfo, int playCount) {
		if(playerInfo.isBust() && dealerInfo.isBust() || playCount == dealerInfo.getDealerCount()) {
			draw = true;
		} else if(dealerInfo.isBust() && !playerInfo.isBust()) {
			playerWins += 1;
		} else if(playerInfo.isBust() && !dealerInfo.isBust()) {
			dealerWins += 1;
		} else {
			int playdiff = 21 - playCount;
			int dealdiff = 21 - dealerInfo.getDealerCount();
			if( playdiff > dealdiff) {
				dealerWins += 1;
			} else {
				playerWins += 1;
			}
		}
	}

}
