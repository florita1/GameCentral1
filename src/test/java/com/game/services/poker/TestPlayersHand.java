package com.game.services.poker;
import static org.junit.Assert.*;

import java.util.LinkedHashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import com.game.services.poker.PlayersHand;



public class TestPlayersHand {
	
	static PlayersHand Phand;
	static String[] s1;

	@BeforeClass
	public static void createHands() {
		s1 = "6D 8S 6H QS TS".split(" ");
		
		Phand = new PlayersHand(s1);
	}

	@Test
	public void checkSuits() {
		LinkedHashMap<String, Integer> testMap = new LinkedHashMap<String, Integer>();
		testMap.put("S", 3);
		testMap.put("D", 1);
		testMap.put("C", 0);
		testMap.put("H", 1);
		LinkedHashMap<String, Integer> expected_output = Phand.checkSuits();
		assertEquals(expected_output, testMap);
	}

	@Test
	public void checkCards() {
		LinkedHashMap<String, Integer> testMap = new LinkedHashMap<String, Integer>();
		testMap.put("2", 0);
		testMap.put("3", 0);
		testMap.put("4", 0);
		testMap.put("5", 0);
		testMap.put("6", 2);
		testMap.put("7", 0);
		testMap.put("8", 1);
		testMap.put("9", 0);
		testMap.put("T", 1);
		testMap.put("J", 0);
		testMap.put("Q", 1);
		testMap.put("K", 0);
		testMap.put("A", 0);
		LinkedHashMap<String, Integer> expected_output = Phand.checkCards();
		assertEquals(expected_output, testMap);
	}

}
