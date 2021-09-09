package com.gameoflife.gameoflife;

interface Cell {
    public abstract Cell computeNextStatus(int livingNeighbours);
}
