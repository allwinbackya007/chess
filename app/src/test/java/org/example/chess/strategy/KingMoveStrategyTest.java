package org.example.chess.strategy;

import org.example.chess.exception.CommonException;
import org.example.chess.model.Board;
import org.example.chess.model.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KingMoveStrategyTest {

    private final Board board = new Board();
    private final KingMoveStrategy strategy = new KingMoveStrategy();

    @Test
    void shouldReturnEightMovesWhenKingIsInCenter() {
        Position from = Position.fromString("D4");

        List<Position> expectedMoves = List.of(
                Position.fromString("C4"),
                Position.fromString("E4"),
                Position.fromString("D5"),
                Position.fromString("D3"),
                Position.fromString("C5"),
                Position.fromString("E5"),
                Position.fromString("C3"),
                Position.fromString("E3")
        );

        List<Position> actualMoves = strategy.getMoves(from, board);

        assertEquals(expectedMoves, actualMoves);
    }

    @Test
    void shouldReturnThreeMovesWhenKingIsInCorner() {
        Position from = Position.fromString("A1");

        List<Position> expectedMoves = List.of(
                Position.fromString("B1"),
                Position.fromString("A2"),
                Position.fromString("B2")
        );

        List<Position> actualMoves = strategy.getMoves(from, board);

        assertEquals(expectedMoves, actualMoves);
    }

    @Test
    void shouldThrowExceptionWhenPositionIsInvalid() {
        Position invalid = new Position(-1, -1);
        Exception ex = assertThrows(CommonException.class, () -> strategy.getMoves(invalid, board));
        assertEquals("Invalid position for king move", ex.getMessage());
    }
}
