package org.example.chess.model;

import org.example.chess.exception.CommonException;

import java.util.Objects;

public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position fromString(String input) {
        if (input == null || input.length() != 2) {
            throw new CommonException("Input must be exactly 2 characters like 'A1'");
        }

        int xValue = input.toUpperCase().charAt(0) - 'A';
        int yValue = Character.getNumericValue(input.charAt(1)) - 1;

        return new Position(xValue, yValue);
    }


    public String toChessNotation() {
        return "" + (char) ('A' + x) + (y + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

