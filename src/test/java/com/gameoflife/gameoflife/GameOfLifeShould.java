package com.gameoflife.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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

	@Test
	void contain_single_dead_cell_if_a_single_alive_cell_is_passed() {
		//given
		boolean [][] seedState = {{true}};
		target = new GameOfLife(seedState);
		//when
		boolean [][] currentState = target.nextGen();
		//then
		assertFalse(currentState[0][0]);
	}

	@Test
	void contain_four_dead_cells_if_2_x_2_grid_with_one_alive() {
		//given
		boolean [][] seedState = {{false, false}, {false, true}};
		target = new GameOfLife(seedState);

		//when
		boolean [][] currentState = target.nextGen();

		//then
		assertFalse(currentState[0][0]);
		assertFalse(currentState[0][1]);
		assertFalse(currentState[1][0]);
		assertFalse(currentState[1][1]);
	}

	@Test
	void contain_three_alive_cells_if_2_x_2_grid_with_three_alive() {
		//given
		boolean [][] seedState = {{false, true}, {true, true}};
		target = new GameOfLife(seedState);

		//when
		boolean [][] currentState = target.nextGen();

		//then
		assertFalse(currentState[0][0]);
		assertTrue(currentState[0][1]);
		assertTrue(currentState[1][0]);
		assertTrue(currentState[1][1]);
	}
}
