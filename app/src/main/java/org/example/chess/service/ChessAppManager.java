package org.example.chess.service;

import org.example.chess.model.Board;
import org.example.chess.model.ChessPiece;
import org.example.chess.model.Position;

import java.util.List;

public class ChessAppManager {
    private final Board board;

    public ChessAppManager() {
        board = new Board();
    }

    public List<Position> getMoves(ChessPiece piece, Position position) {
        return piece.getMoves(position, board);
    }
}
