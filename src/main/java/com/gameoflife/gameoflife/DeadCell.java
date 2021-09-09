package com.gameoflife.gameoflife;

public class DeadCell implements Cell {
    @Override
    public Cell computeNextStatus(int livingNeighbours) {
        if(livingNeighbours == 3) return new AliveCell();

        return this;
    }
}
