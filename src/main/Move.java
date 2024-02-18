package main;

import pieces.*;

public class Move {
    int oldCol, oldRow, newCol, newRow;
    Piece moved_piece, captured_piece;
    public Move(Board board, Piece piece, int newCol, int newRow){
        this.moved_piece = piece;
        this.oldCol = moved_piece.col;
        this.oldRow = moved_piece.row;
        this.newCol = newCol;
        this.newRow = newRow;
        this.captured_piece = board.pieceAt(newCol,newRow);
    }
}
