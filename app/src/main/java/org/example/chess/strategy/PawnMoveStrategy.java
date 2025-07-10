package org.example.chess.strategy;

import org.example.chess.enums.MovePattern;
import org.example.chess.exception.CommonException;
import org.example.chess.model.Board;
import org.example.chess.model.Position;

import java.util.ArrayList;
import java.util.List;

public class PawnMoveStrategy implements MoveStrategy {
    @Override
    public List<Position> getMoves(Position from, Board board) {
        if(!board.isValid(from)) throw new CommonException("Invalid position for pawn move");

        List<Position> moves = new ArrayList<>();
        MovePattern movePattern = MovePattern.UP;
        Position forward = new Position(from.x + movePattern.dx(), from.y + movePattern.dy()); // forward move
        if (board.isValid(forward)) moves.add(forward);
        return moves;
    }
}

