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

	private int countLivingNeighbours(int x, int y) {
		int livingNeighbours = 0;
//		List <boolean> neighbouringCells = {
//				{boardState[x-1][-1]},
//				{boardState[-1][0]},
//				{boardState[-1][+1]},
//				{boardState[0][-1]},
//				{boardState[0][1]},
//				{boardState[+1][-1]},
//				{boardState[+1][0]},
//				{boardState[+1][+1}};

//				for() {
//					if(isWithinGrid(cell) && cell == true) {
//						livingNeighbours++;
//					}
//				}
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

	public Cell[][] nextGen() {
		Cell [][] nextGenGrid = boardState;

		for (int i = 0; i < boardState.length; i++) {
			for (int j = 0; j < boardState[i].length; j++) {

				Cell cell = boardState[i][j];
				nextGenGrid[i][j] = cell.computeNextStatus(countLivingNeighbours(i, j));
//
//				if(cell && countLivingNeighbours(i, j) < 2) {
//					nextGenGrid[i][j] = false;
//				} else if(cell && countLivingNeighbours(i, j) > 3)  {
//					nextGenGrid[i][j] = false;
//				} else if(!cell && countLivingNeighbours(i, j) == 3) {
//					nextGenGrid[i][j] = true;
//				}
			}
		}
		boardState = nextGenGrid;

		return nextGenGrid;
	}

}
