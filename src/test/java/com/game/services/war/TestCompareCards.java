package com.game.services.war;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.game.services.war.CompareCards;

public class TestCompareCards {
	
	static CompareCards cCards;
	static String p1;
	static String p2;
	static String player;
	static HashMap<String,List<String>> pc;
	
	
	@BeforeClass
	public static void createComparison() {
		p1 = "AH";
		p2 = "4D";
		player = "Florita";
		cCards = new CompareCards(pc,player);
	}

	@Test
	public void highestCard() {
		int expected_output = cCards.highestCard(p1);
		assertEquals(expected_output, 13);
	}
	
	@Test
	public void getWinner() {
		String expected_output = cCards.getWinner();
		assertEquals(expected_output, "Player 1 wins");
	}

}
