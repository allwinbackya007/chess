package org.example.chess.strategy;

import org.example.chess.model.Board;
import org.example.chess.model.Position;

import java.util.List;

public interface MoveStrategy {
    List<Position> getMoves(Position from, Board board);
}

