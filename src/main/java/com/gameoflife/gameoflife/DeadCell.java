package com.gameoflife.gameoflife;

public class DeadCell extends Cell {
    public boolean status = false;

    public DeadCell(int x, int y) {
        super(x, y);
    }

    @Override
    public Cell computeNextStatus(int livingNeighbours) {
        if(livingNeighbours == 3) return new AliveCell(this.x, this.y);

        return this;
    }
}
