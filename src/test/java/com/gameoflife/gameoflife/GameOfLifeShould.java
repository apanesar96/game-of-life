package com.gameoflife.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class GameOfLifeShould {

	private GameOfLife target;

	@Test
	void contain_single_dead_cell() {
		//given
		boolean [][] seedState = {{false}};
		target = new GameOfLife(seedState);
		//when
		boolean [][] currentState = target.nextGen();
		//then
		assertFalse(currentState[0][0]);
	}
}
