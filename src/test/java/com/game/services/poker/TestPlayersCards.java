package com.game.services.poker;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import com.game.services.poker.PlayerCards;


public class TestPlayersCards {

	static PlayerCards pCards;
	
	@BeforeClass
	public static void createCards() {
		String cardsStr = "6D 8S 6H QS TS KH JC KS 6S 7S AH 2H 5S 4C 5H";
		String[] cards = cardsStr.split(" ");
		String name = "Julia";
		try {
			pCards = new PlayerCards(cards, 3, name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getData() {
		String[] p1 = "6D 8S 6H QS TS".split(" ");
		String[] p2 = "KH JC KS 6S 7S".split(" ");
		String[] p3 = "AH 2H 5S 4C 5H".split(" ");
		LinkedHashMap<String, String[]> map = new LinkedHashMap<String, String[]>();
		map.put("Julia", p1);
		map.put("Player 2", p2);
		map.put("Player 3", p3);
		LinkedHashMap<String, String[]> expected_output = pCards.getData();
		for(String[] val : expected_output.values()) {
			System.out.println(val[0]);
		}
		assertEquals(expected_output, map);
	}

}
