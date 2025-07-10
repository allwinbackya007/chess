package org.example.chess.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private final Board board = new Board();

    @Test
    void shouldReturnTrueForValidPositions() {
        assertTrue(board.isValid(new Position(0, 0)));
    }

    @Test
    void shouldReturnFalseForNegativeCoordinates() {
        assertFalse(board.isValid(new Position(-1, 0)));
    }

    @Test
    void shouldReturnFalseForCoordinatesOutsideBoard() {
        assertFalse(board.isValid(new Position(8, 0)));
    }
}
