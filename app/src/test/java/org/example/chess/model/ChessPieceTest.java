package org.example.chess.model;

import org.example.chess.exception.CommonException;
import org.example.chess.strategy.KingMoveStrategy;
import org.example.chess.strategy.PawnMoveStrategy;
import org.example.chess.strategy.QueenMoveStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChessPieceTest {

    private final Board board = new Board();

    @Test
    void shouldReturnCorrectMovesForPawn() {
        ChessPiece pawn = new ChessPiece("Pawn", new PawnMoveStrategy());

        Position from = Position.fromString("E2");
        List<Position> expected = List.of(Position.fromString("E3"));

        List<Position> actual = pawn.getMoves(from, board);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectMovesForQueen() {
        ChessPiece queen = new ChessPiece("Queen", new QueenMoveStrategy());

        Position from = Position.fromString("D4");

        List<Position> expectedMoves = loadQueenExpectedPosition();

        List<Position> actualMoves = queen.getMoves(from, board);

        assertEquals(expectedMoves, actualMoves);
    }

    @Test
    void shouldReturnCorrectMovesForKing() {
        ChessPiece king = new ChessPiece("King", new KingMoveStrategy());

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

        List<Position> actualMoves = king.getMoves(from, board);

        assertEquals(expectedMoves, actualMoves);
    }

    @Test
    void shouldThrowExceptionWhenPositionIsInvalid() {
        ChessPiece pawn = new ChessPiece("Pawn", new PawnMoveStrategy());
        Position invalid = new Position(9, 9);

        Exception ex = assertThrows(CommonException.class, () -> pawn.getMoves(invalid, board));
        assertEquals("Invalid position for pawn move", ex.getMessage());
    }

    private static List<Position> loadQueenExpectedPosition() {
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
