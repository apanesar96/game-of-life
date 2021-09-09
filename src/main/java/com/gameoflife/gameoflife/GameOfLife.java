package com.gameoflife.gameoflife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameOfLife {
	private boolean [][] boardState;

	public GameOfLife(boolean [][] seedState) {
		boardState = seedState;
	}

	private int countLivingNeighbours(boolean[] neighbours) {
		int livingNeighbours = 0;

	}

	private boolean[] getNeighbours(int 0, int 0) {

		boolean[] neighbouringCells = {
				{boardState[-1][-1]},
				{boardState[-1][0]},
				{boardState[-1][+1]},
				{boardState[0][-1]},
				{boardState[0][1]},
				{boardState[+1][-1]},
				{boardState[+1][0]},
				{boardState[+1][+1}};

//				for() {
//					if(isWithinGrid(cell) && cell == true) {
//						livingNeighbours++;
//					}
//				}
	}

	private boolean isWithinGrid(int x, int y) {
		return (y >= 0 && y <= boardState.length) && (x >= 0 && x <= boardState[0].length);
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
