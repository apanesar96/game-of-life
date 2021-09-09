package com.gameoflife.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameOfLifeShould {

	private GameOfLife target;

	@Test
	void contain_single_dead_cell() {
		//given
		Cell[][] seedState = {{new DeadCell()}};
		target = new GameOfLife(seedState);
		//when
		Cell[][] currentState = target.nextGen();
		//then
		assertTrue(currentState[0][0] instanceof DeadCell);
	}

	@Test
	void contain_single_dead_cell_if_a_single_alive_cell_is_passed() {
		//given
		Cell [][] seedState = {{new AliveCell()}};
		target = new GameOfLife(seedState);
		//when
		Cell[][] currentState = target.nextGen();
		//then
		assertTrue(currentState[0][0] instanceof DeadCell);
	}

	@Test
	void contain_four_dead_cells_if_2_x_2_grid_with_one_alive() {
		//given
		Cell [][] seedState = {{new DeadCell(), new DeadCell()},{new DeadCell(), new AliveCell()}};
		target = new GameOfLife(seedState);

		//when
		Cell [][] currentState = target.nextGen();

		//then
		assertTrue(currentState[0][0] instanceof DeadCell);
		assertTrue(currentState[1][0] instanceof DeadCell);;
		assertTrue(currentState[0][1] instanceof DeadCell);
		assertTrue(currentState[1][1] instanceof DeadCell);
	}

	@Test
	void contain_three_alive_cells_if_2_x_2_grid_with_three_alive() {
		//given
		Cell [][] seedState = {{new DeadCell(), new AliveCell()}, {new AliveCell(), new AliveCell()}};
		target = new GameOfLife(seedState);

		//when
		Cell [][] currentState = target.nextGen();

		//then
		assertTrue(currentState[1][0] instanceof AliveCell);
		assertTrue(currentState[0][1] instanceof AliveCell);
		assertTrue(currentState[1][1] instanceof AliveCell);
	}

	@Test
	void cell_dies_if_more_than_3_neighbours_alive() {
		//given
		Cell [][] seedState = {{new AliveCell(), new AliveCell(), new AliveCell()},
				{new AliveCell(), new AliveCell(), new AliveCell()}, {new AliveCell(), new AliveCell(), new AliveCell()}};
		target = new GameOfLife(seedState);

		//when
		Cell [][] currentState = target.nextGen();

		//then
		assertTrue(currentState[1][1] instanceof DeadCell);
	}

	@Test
	void cell_should_come_back_to_life_if_have_3_alive_neighbours() {
		//given
		Cell [][] seedState = {{new DeadCell(), new AliveCell()}, {new AliveCell(), new AliveCell()}};
		target = new GameOfLife(seedState);

		//when
		Cell [][] currentState = target.nextGen();

		//then
		assertTrue(currentState[0][0] instanceof AliveCell);
	}
}