package com.gameoflife.gameoflife;

public class DeadCell implements Cell {
    @Override
    public Cell computeNextStatus(int livingNeighbours) {
        return livingNeighbours == 3 ? new AliveCell() : this;
    }
}
