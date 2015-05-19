package com.game.services.poker;
import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.game.services.poker.HighestHand;



public class TestHighestHand {
	static HighestHand hHand;
	static List<String> winners;
	static LinkedHashMap<String, String[]> map;

	@BeforeClass
	public static void createHands() {
		winners.add("Julia");
		winners.add("Player 2");
		
		String[] p1 = "6D 8S 6H QS TS".split(" ");
		String[] p2 = "KH JC KS 6S 7S".split(" ");
		String[] p3 = "AH 2H 3S 6C 5H".split(" ");
		map = new LinkedHashMap<String, String[]>();
		map.put("Julia", p1);
		map.put("Player 2", p2);
		map.put("Player 3", p3);
		
		hHand = new HighestHand(winners, 1 , map);
	}

	@Test
	public void getHighCard() {
		String[] p1 = "6D 8S 6H QS TS".split(" ");
		int expected_output = hHand.getHighCard(p1);
		assertEquals(expected_output, 10);
		// fail("Not yet implemented");
	}

	@Test
	public void getHighHand() {
		String[] p1 = "6D 8S 6H QS TS".split(" ");
		int expected_output = hHand.getHighHand(p1);
		assertEquals(expected_output, 36);
		// fail("Not yet implemented");
	}
	
	@Test
	public void chooseWinner() {
		String expected_output = hHand.chooseWinner();
		assertEquals(expected_output, "Player 2");
	}

}
