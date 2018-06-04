package com.testGame.fr;

import junit.framework.TestCase;

public class TennisGameTest extends TestCase{
TennisGame game = new TennisGame("SONIA" , "CELIA");
	
	public void testNewGameShouldReturn0All()
	{
		String score = game.getScore();
		
		assertEquals("0 all", score);
	}
	
	public void testPlayer1WinsFirstBall()
	{
		game.scoresPlayer1();

		String score = game.getScore();
		assertEquals("15,0", score);		
	}
	
	public void testFifteenAll(){
		game.scoresPlayer1();
		game.scoresPlayer2();
		
		String score = game.getScore();
		assertEquals("15 all", score);
	}
	
	public void testPlayer2WinsFirstTwoBalls() {
		createScore(0, 2);
		
		String score = game.getScore();
		assertEquals("0,30", score);
	}
	
	
	public void testPlayer1WinsFirstThreeBalls(){
		createScore(3, 0);
		String score = game.getScore();
		assertEquals("40,0", score);
	}
	
	public void testPlayersAreDeuce() {
		createScore(3, 3);
		
		String score = game.getScore();
		assertEquals("Deuce", score);		
	}
	
	public void testPlayer1WinsGame()
	{
		createScore(4, 0);
		
		String score = game.getScore();
		assertEquals("SONIA  wins", score);
	}
	
	public void testPlayer2WinsGame(){
		createScore(1,4);
		
		String score = game.getScore();
		assertEquals("CELIA wins", score);
	}
	
	public void testPlayersAreDeuce4() {
		createScore(4, 4);
		String score = game.getScore();
		assertEquals("Deuce", score);		
	}

	public void testPlayer2Advantage(){
		createScore(4, 5);
		
		String score = game.getScore();
		assertEquals("Advantage CELIA ", score);
	}

	public void testPlayer1Advantage(){
		createScore(5, 4);
		
		String score = game.getScore();
		assertEquals("Advantage SONIA", score);
	}
	
	public void testPlayer2Wins(){
		createScore(2, 4);
		String score = game.getScore();
		assertEquals("CELIA  wins", score);
	}
	
	
	public void testPlayer2WinsAfterAdvantage() {
		createScore(6, 8);
		String score = game.getScore();
		assertEquals("CELIA  wins", score);
	}
	
	
	
	public void testPlayer1WinsAfterAdvantage() {
		createScore(8, 6);
		String score = game.getScore();
		assertEquals("SONIAr wins", score);
	}
	
	private void createScore(int playerOneBalls, int playerTwoBalls ) {
		for (int i = 0; i < playerOneBalls; i++) {
			game.scoresPlayer1();
		}
		for (int i = 0; i < playerTwoBalls; i++) {
			game.scoresPlayer2();
		}
	}
	
}
