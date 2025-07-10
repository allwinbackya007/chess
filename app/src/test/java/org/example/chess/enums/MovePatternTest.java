package org.example.chess.enums;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovePatternTest {

    @Test
    void shouldReturnCorrectDxandDyForEachDirection() {
        assertEquals(-1, MovePattern.LEFT.dx());
        assertEquals(0, MovePattern.LEFT.dy());

        assertEquals(0, MovePattern.DOWN.dx());
        assertEquals(-1, MovePattern.DOWN.dy());

        assertEquals(-1, MovePattern.DIAGONAL_NW.dx());
        assertEquals(1, MovePattern.DIAGONAL_NW.dy());
    }

    @Test
    void shouldReturnAllMovePatterns() {
        List<MovePattern> patterns = List.of(MovePattern.values());
        assertEquals(8, patterns.size());
        assertTrue(patterns.contains(MovePattern.LEFT));
        assertTrue(patterns.contains(MovePattern.DIAGONAL_SE));
    }
}
