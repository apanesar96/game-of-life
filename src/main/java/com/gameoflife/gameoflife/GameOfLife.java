package com.gameoflife.gameoflife;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameOfLife {
	private Cell[][] boardState;

	public GameOfLife(Cell[][] seedState) {
		boardState = seedState;
	}

	public Cell[][] nextGen() {
		Cell[][] nextGenGrid = boardState;

		for (int i = 0; i < boardState.length; i++) {
			for (int j = 0; j < boardState[i].length; j++) {

				Cell cell = boardState[i][j];
				nextGenGrid[i][j] = cell.computeNextStatus(countLivingNeighbours(i, j));
			}
		}
		boardState = nextGenGrid;

		return nextGenGrid;
	}

	private int countLivingNeighbours(int x, int y) {
		int livingNeighbours = 0;

		for (int i = -1; i <= 1 ; i++) {
			for (int j = -1; j <= 1 ; j++) {
				if(i == 0 && j == 0) continue;
				if (isAliveNeighbour(x + i, y + j)) livingNeighbours++;
			}
		}

		return livingNeighbours;
	}

	private boolean isAliveNeighbour(int x, int y) {
		return isWithinGrid(x, y) && boardState[y][x] instanceof AliveCell;
	}

	private boolean isWithinGrid(int x, int y) {
		return (y >= 0 && y < boardState.length) && (x >= 0 && x < boardState[0].length);
	}
}
