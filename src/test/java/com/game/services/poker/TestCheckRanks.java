package com.game.services.poker;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import com.game.services.poker.CheckRanks;


public class TestCheckRanks {
	
	static CheckRanks cRanks;
	static HashMap<String,Integer> ranks;
	static LinkedHashMap<String, String[]> map;
	
	@BeforeClass
	public static void createCheck() {
		
		ranks  = new HashMap<String,Integer>();
		ranks.put("Julia", 1);
		ranks.put("Player 2", 1);
		ranks.put("Player 3", 0);
		
		String[] p1 = "6D 8S 6H QS TS".split(" ");
		String[] p2 = "KH JC KS 6S 7S".split(" ");
		String[] p3 = "AH 2H 3S 6C 5H".split(" ");
		map = new LinkedHashMap<String, String[]>();
		map.put("Julia", p1);
		map.put("Player 2", p2);
		map.put("Player 3", p3);
		
		cRanks = new CheckRanks(ranks,map);
	}
	
	@Test
	public void checkOneWinner() {
		String expected_output = cRanks.checkOneWinner();
		assertEquals(expected_output, "Julia");
	}
	
	public void checkMultiWinner() {
		String expected_output = cRanks.checkMultiWinner();
		assertEquals(expected_output, "Player 2");
	}

}
