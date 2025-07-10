package org.example.chess.model;

public class Board {
    public static final int SIZE = 8;

    public boolean isValid(Position p) {
        return p.x >= 0 && p.x < SIZE && p.y >= 0 && p.y < SIZE;
    }
}

