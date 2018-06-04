package com.testGame.fr;

public class TennisGame {
	private int Scoreplayer1 = 0;
	private int Scoreplayer2 = 0;
	private String player2;
	private String player1;
	
	public TennisGame(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public String getScore() {

		if (hasWinner()) {
			return playerWithHighestScore() + " wins";
		}
		
		if (hasAdvantage()) { 
			return "Advantage " + playerWithHighestScore(); 
		}
		
		if (isDeuce())
			return "Deuce";
		
		if(Scoreplayer1 == Scoreplayer2) {
			return translateScore(Scoreplayer1) + " all";
		}
		
		return translateScore(Scoreplayer1) + "," + translateScore(Scoreplayer2);
	}

	private boolean isDeuce() {
		return Scoreplayer1 >= 3 && Scoreplayer2 == Scoreplayer1;
	}
	
	private String playerWithHighestScore() {
		if (Scoreplayer1 > Scoreplayer2) {
			return player1;
		} else {
			return player2;
		}
	}
	
	private boolean hasWinner() {
		if(Scoreplayer2 >= 4 && Scoreplayer2 >= Scoreplayer1 + 2 )
			return true;
		if(Scoreplayer1 >= 4 && Scoreplayer1 >= Scoreplayer2 + 2)
			return true;
		return false;
	}
	
	private boolean hasAdvantage() {
		if (Scoreplayer2 >= 4 && Scoreplayer2 == Scoreplayer1 + 1)
			return true;
		if (Scoreplayer1 >= 4 && Scoreplayer1 == Scoreplayer2 + 1)
			return true;
		
		return false;

	}

	public void scoresPlayer1() {
		Scoreplayer1++;
	}

	public void scoresPlayer2() {
		Scoreplayer2++;
	}
	
	private String translateScore(int score) {
		switch (score) {
		case 3:
			return "40";
		case 2:
			return "30";
		case 1: 
			return "15";
		case 0:
			return "0";
		}
		throw new IllegalArgumentException("Illegal score: " + score);
	}
}
