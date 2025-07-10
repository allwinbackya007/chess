package org.example.factory;

import org.example.chess.exception.CommonException;
import org.example.chess.model.ChessPiece;
import org.example.chess.strategy.KingMoveStrategy;
import org.example.chess.strategy.PawnMoveStrategy;
import org.example.chess.strategy.QueenMoveStrategy;

public class ChessPieceFactory {
    public static ChessPiece create(String pieceName) {
        return switch (pieceName.toLowerCase()) {
            case "king" -> new ChessPiece("King", new KingMoveStrategy());
            case "queen" -> new ChessPiece("Queen", new QueenMoveStrategy());
            case "pawn" -> new ChessPiece("Pawn", new PawnMoveStrategy());
            default -> throw new CommonException("Illegal piece name: " + pieceName);
        };
    }
}

