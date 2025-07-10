package org.example.chess.service;

import org.example.chess.exception.CommonException;
import org.example.chess.model.ChessPiece;
import org.example.chess.model.Position;
import org.example.chess.strategy.PawnMoveStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChessAppManagerTest {

    @Test
    void shouldReturnCorrectMovesWhenPositionIsValid() {
        ChessAppManager manager = new ChessAppManager();
        ChessPiece piece = new ChessPiece("Pawn", new PawnMoveStrategy());
        Position from = Position.fromString("E2");
        List<Position> expectedMoves = List.of(Position.fromString("E3"));

        List<Position> actualMoves = manager.getMoves(piece, from);

        assertEquals(expectedMoves, actualMoves);
    }

    @Test
    void shouldThrowExceptionWhenPositionIsInvalid() {
        ChessAppManager manager = new ChessAppManager();
        ChessPiece piece = new ChessPiece("Pawn", new PawnMoveStrategy());
        Position invalid = new Position(9, 9);

        Exception ex = assertThrows(CommonException.class, () -> manager.getMoves(piece, invalid));
        assertEquals("Invalid position for pawn move", ex.getMessage());
    }
}