package org.example.chess.model;

import org.example.chess.exception.CommonException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void shouldReturnPositionWhenInputIsValid() {
        Position pos = Position.fromString("A1");
        assertEquals(0, pos.x);
        assertEquals(0, pos.y);
        assertEquals("A1", pos.toChessNotation());
    }

    @Test
    void shouldReturnExceptionWhenInputIsInvalid() {
        Exception ex = assertThrows(CommonException.class, () -> Position.fromString("A"));
        assertEquals("Input must be exactly 2 characters like 'A1'", ex.getMessage());
    }

    @Test
    void shouldReturnChessNotation() {
        Position pos = new Position(3, 4);
        assertEquals("D5", pos.toChessNotation());
    }
}
