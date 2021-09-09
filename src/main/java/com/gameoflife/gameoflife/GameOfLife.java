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
		return boardState;
	}
}
