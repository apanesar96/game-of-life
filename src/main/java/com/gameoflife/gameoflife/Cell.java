package com.gameoflife.gameoflife;

abstract class Cell {
    public int x;
    public int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract Cell computeNextStatus(int livingNeighbours);
}
