package org.example.factory;

import org.example.chess.exception.CommonException;
import org.example.chess.model.ChessPiece;
import org.example.chess.strategy.KingMoveStrategy;
import org.example.chess.strategy.PawnMoveStrategy;
import org.example.chess.strategy.QueenMoveStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessPieceFactoryTest {

    @Test
    void testCreateKing() {
        ChessPiece king = ChessPieceFactory.create("king");
        assertNotNull(king);
        assertEquals("King", king.getName());
        assertInstanceOf(KingMoveStrategy.class, king.getMoveStrategy());
    }

    @Test
    void testCreateQueen() {
        ChessPiece queen = ChessPieceFactory.create("queen");
        assertNotNull(queen);
        assertEquals("Queen", queen.getName());
        assertInstanceOf(QueenMoveStrategy.class, queen.getMoveStrategy());
    }

    @Test
    void testCreatePawn() {
        ChessPiece pawn = ChessPieceFactory.create("pawn");
        assertNotNull(pawn);
        assertEquals("Pawn", pawn.getName());
        assertInstanceOf(PawnMoveStrategy.class, pawn.getMoveStrategy());
    }

    @Test
    void testCreateInvalidPieceThrowsException() {
        CommonException exception = assertThrows(CommonException.class, () -> {
            ChessPieceFactory.create("dragon");
        });
        assertEquals("Illegal piece name: dragon", exception.getMessage());
    }
}
