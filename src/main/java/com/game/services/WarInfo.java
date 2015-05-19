package com.game.services;

public class WarInfo {
	
	private String playerCard;
	private String dealerCard;
	private int pDeckSize;
	private int dDeckSize;
	private String winner;
	
	public String getPlayerCard() {
		return playerCard;
	}
	public void setPlayerCard(String playerCard) {
		this.playerCard = playerCard;
	}
	public String getDealerCard() {
		return dealerCard;
	}
	public void setDealerCard(String dealerCard) {
		this.dealerCard = dealerCard;
	}
	public int getpDeckSize() {
		return pDeckSize;
	}
	public void setpDeckSize(int pDeckSize) {
		this.pDeckSize = pDeckSize;
	}
	public int getdDeckSize() {
		return dDeckSize;
	}
	public void setdDeckSize(int dDeckSize) {
		this.dDeckSize = dDeckSize;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}

}
