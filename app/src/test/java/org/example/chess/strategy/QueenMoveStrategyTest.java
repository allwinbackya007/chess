package org.example.chess.strategy;

import org.example.chess.exception.CommonException;
import org.example.chess.model.Board;
import org.example.chess.model.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QueenMoveStrategyTest {

    private final Board board = new Board();
    private final QueenMoveStrategy strategy = new QueenMoveStrategy();

    @Test
    void shouldReturnCorrectPositionsWhenQueenIsInCenter() {
        Position from = Position.fromString("D4");
        List<Position> actualMoves = strategy.getMoves(from, board);

        List<Position> expectedMoves = loadExpectedPosition();

        assertEquals(expectedMoves, actualMoves);
    }

    @Test
    void shouldReturnCorrectPositionsWhenQueenIsInCorner() {
        Position from = Position.fromString("A1");
        List<Position> actualMoves = strategy.getMoves(from, board);

        List<Position> expectedMoves = List.of(
                Position.fromString("B1"),Position.fromString("C1"),Position.fromString("D1"),Position.fromString("E1"),Position.fromString("F1"),Position.fromString("G1"),Position.fromString("H1"),
                Position.fromString("A2"),Position.fromString("A3"),Position.fromString("A4"),Position.fromString("A5"),Position.fromString("A6"),Position.fromString("A7"),Position.fromString("A8"),
                Position.fromString("B2"),Position.fromString("C3"),Position.fromString("D4"),Position.fromString("E5"),Position.fromString("F6"),Position.fromString("G7"),Position.fromString("H8")
        );

        assertEquals(expectedMoves, actualMoves);
    }

    @Test
    void shouldThrowExceptionWhenPositionIsInvalid() {
        Position invalid = new Position(-1, -1);
        Exception ex = assertThrows(CommonException.class, () -> strategy.getMoves(invalid, board));
        assertEquals("Invalid position for queen move", ex.getMessage());
    }

    private static List<Position> loadExpectedPosition() {
        return List.of(
                Position.fromString("C4"), Position.fromString("B4"), Position.fromString("A4"),
                Position.fromString("E4"), Position.fromString("F4"), Position.fromString("G4"), Position.fromString("H4"),
                Position.fromString("D5"), Position.fromString("D6"), Position.fromString("D7"), Position.fromString("D8"),
                Position.fromString("D3"), Position.fromString("D2"), Position.fromString("D1"),
                Position.fromString("C5"), Position.fromString("B6"), Position.fromString("A7"),
                Position.fromString("E5"), Position.fromString("F6"), Position.fromString("G7"), Position.fromString("H8"),
                Position.fromString("C3"), Position.fromString("B2"), Position.fromString("A1"),
                Position.fromString("E3"), Position.fromString("F2"), Position.fromString("G1")

        );
    }


}
