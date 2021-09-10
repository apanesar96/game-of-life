package com.gameoflife.gameoflife;

interface Cell {
    Cell computeNextStatus(int livingNeighbours);
}
