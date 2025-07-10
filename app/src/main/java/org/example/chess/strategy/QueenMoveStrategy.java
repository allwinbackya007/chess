package org.example.chess.strategy;

import org.example.chess.enums.MovePattern;
import org.example.chess.exception.CommonException;
import org.example.chess.model.Board;
import org.example.chess.model.Position;

import java.util.ArrayList;
import java.util.List;

public class QueenMoveStrategy implements MoveStrategy {
    private static final List<MovePattern> movePatterns = List.of(MovePattern.values());

    public List<Position> getMoves(Position from, Board board) {
        if(!board.isValid(from)) throw new CommonException("Invalid position for queen move");

        List<Position> moves = new ArrayList<>();
        for (MovePattern move : movePatterns) {
            Position current = from;
            while (true) {
                current = new Position(current.x + move.dx(), current.y + move.dy());
                if (!board.isValid(current)) break;
                moves.add(current);
            }
        }
        return moves;
    }
}

