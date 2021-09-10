package com.gameoflife.gameoflife;

public class AliveCell implements Cell {
    @Override
    public Cell computeNextStatus(int livingNeighbours) {
        return (livingNeighbours < 2 || livingNeighbours > 3) ? new DeadCell() : this;
    }
}