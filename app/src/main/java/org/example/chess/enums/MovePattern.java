package org.example.chess.enums;

import java.util.List;

public enum MovePattern {
    LEFT(-1, 0),
    RIGHT(1, 0),
    UP(0, 1),
    DOWN(0, -1),
    DIAGONAL_NW(-1, 1),
    DIAGONAL_NE(1, 1),
    DIAGONAL_SW(-1, -1),
    DIAGONAL_SE(1, -1);

    private final int dx;
    private final int dy;

    MovePattern(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

