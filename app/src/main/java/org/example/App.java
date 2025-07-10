package org.example;

import org.example.chess.model.ChessPiece;
import org.example.chess.model.Position;
import org.example.chess.service.ChessAppManager;
import org.example.factory.ChessPieceFactory;

import java.util.List;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {

        try {
            ChessAppManager manager = new ChessAppManager();

            String pieceName = "Queen";
            ChessPiece piece = ChessPieceFactory.create(pieceName);

            String positionStr = "D4";
            Position position = Position.fromString(positionStr);

            List<Position> positionList = manager.getMoves(piece, position);

            positionList.stream().map(Position::toChessNotation).forEach(s -> System.out.print(s + " "));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

}
}
