package org.example.chess.strategy;

import org.example.chess.exception.CommonException;
import org.example.chess.model.Board;
import org.example.chess.model.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PawnMoveStrategyTest {

    private final Board board = new Board();
    private final PawnMoveStrategy strategy = new PawnMoveStrategy();

    @Test
    void shouldReturnForwardMoveWhenPawnIsInMiddleOfBoard() {
        Position from = Position.fromString("E2");
        List<Position> actualMoves = strategy.getMoves(from, board);

        List<Position> expectedMoves = List.of(Position.fromString("E3"));
        assertEquals(expectedMoves, actualMoves);
    }

    @Test
    void shouldReturnEmptyListWhenPawnIsAtTopEdge() {
        Position from = Position.fromString("E8"); // Position(4, 7)
        List<Position> actualMoves = strategy.getMoves(from, board);

        assertEquals(List.of(), actualMoves);
    }

    @Test
    void shouldThrowExceptionWhenPositionIsInvalid() {
        Position invalid = new Position(-1, -1);
        Exception ex = assertThrows(CommonException.class, () -> strategy.getMoves(invalid, board));
        assertEquals("Invalid position for pawn move", ex.getMessage());
    }
}
