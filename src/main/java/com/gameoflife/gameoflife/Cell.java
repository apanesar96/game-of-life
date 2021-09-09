package com.gameoflife.gameoflife;

abstract class Cell {
    public abstract Cell computeNextStatus(int livingNeighbours);
}
