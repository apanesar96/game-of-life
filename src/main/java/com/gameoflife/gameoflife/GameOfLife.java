package com.gameoflife.gameoflife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GameOfLife {
	private Cell [][] boardState;

	public GameOfLife(Cell[][] seedState) {
		boardState = seedState;
	}

	public Cell[][] nextGen() {
		Cell [][] nextGenGrid = boardState;

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

		if (isWithinGrid(x, y - 1) && boardState[y - 1][x] instanceof AliveCell) livingNeighbours++;
		if (isWithinGrid(x + 1, y - 1) && boardState[y - 1][x + 1] instanceof AliveCell) livingNeighbours++;
		if (isWithinGrid(x + 1, y) && boardState[y][x + 1] instanceof AliveCell) livingNeighbours++;
		if (isWithinGrid(x + 1, y + 1) && boardState[y + 1][x + 1] instanceof AliveCell) livingNeighbours++;
		if (isWithinGrid(x, y + 1) && boardState[y + 1][x] instanceof AliveCell) livingNeighbours++;
		if (isWithinGrid(x - 1, y + 1) && boardState[y + 1][x - 1] instanceof AliveCell) livingNeighbours++;
		if (isWithinGrid(x - 1, y) && boardState[y][x - 1] instanceof AliveCell) livingNeighbours++;
		if (isWithinGrid(x - 1, y - 1) && boardState[y - 1][x - 1] instanceof AliveCell) livingNeighbours++;

		return livingNeighbours;
	}

	private boolean isWithinGrid(int x, int y) {
		return (y >= 0 && y < boardState.length) && (x >= 0 && x < boardState[0].length);
	}
}
