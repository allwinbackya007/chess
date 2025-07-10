package org.example.chess.model;

import org.example.chess.strategy.MoveStrategy;

import java.util.List;

public class ChessPiece {
    private final String name;
    private final MoveStrategy moveStrategy;

    public ChessPiece(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public List<Position> getMoves(Position from, Board board) {
        return moveStrategy.getMoves(from, board);
    }

    public String getName() {
        return name;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }
}

