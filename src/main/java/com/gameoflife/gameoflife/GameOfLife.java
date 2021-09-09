package com.gameoflife.gameoflife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameOfLife {
	private boolean [][] boardState;

	public GameOfLife(boolean [][] seedState) {
		boardState = seedState;
	}

	public boolean[][] nextGen() {
		int aliveCells = 0;

		for(boolean [] row : boardState) {
			for(boolean cell : row) {
				if(cell) aliveCells++;
			}
		}

		if(aliveCells == 3) return boardState;
		
		for (int i = 0; i < boardState.length; i++) {
			for (int j = 0; j < boardState[i].length; j++) {
				boardState[i][j] = false;
			}
		}

		return boardState;
	}
}
