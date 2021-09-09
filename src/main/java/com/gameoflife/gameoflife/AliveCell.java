package com.gameoflife.gameoflife;

public class AliveCell extends Cell {
    @Override
    public Cell computeNextStatus(int livingNeighbours) {
        if(livingNeighbours < 2 || livingNeighbours > 3) return new DeadCell();

        return this;
    }
}