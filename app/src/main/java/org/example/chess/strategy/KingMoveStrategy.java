package org.example.chess.strategy;

import org.example.chess.enums.MovePattern;
import org.example.chess.exception.CommonException;
import org.example.chess.model.Board;
import org.example.chess.model.Position;

import java.util.ArrayList;
import java.util.List;

public class KingMoveStrategy implements MoveStrategy {
    private static final List<MovePattern> movePatterns = List.of(MovePattern.values());

    @Override
    public List<Position> getMoves(Position from, Board board) {
        if(!board.isValid(from)) throw new CommonException("Invalid position for king move");

        List<Position> moves = new ArrayList<>();
        for (MovePattern move : movePatterns) {
            Position newPos = new Position(from.x + move.dx(), from.y + move.dy());
            if (board.isValid(newPos)) {
                moves.add(newPos);
            }
        }
        return moves;
    }
}

