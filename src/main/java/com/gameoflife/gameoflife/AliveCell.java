package com.gameoflife.gameoflife;

public class AliveCell extends Cell {
    public boolean status = true;

    public AliveCell(int x, int y) {
        super(x, y);
    }

    @Override
    public Cell computeNextStatus(int livingNeighbours) {
        if(livingNeighbours < 2 || livingNeighbours > 3) return new DeadCell(this.x, this.y);

        return this;
    }
}
