package main;

import pieces.*;

import java.awt.*;

public class Move {
    int oldCol, oldRow, newCol, newRow;
    Piece moved_piece, captured_piece;
    Board board;
    public Move(Board board, Piece piece, int newCol, int newRow){
        this.moved_piece = piece;
        this.oldCol = moved_piece.col;
        this.oldRow = moved_piece.row;
        this.newCol = newCol;
        this.newRow = newRow;
        this.board = board;
        this.captured_piece = board.pieceAt(newCol,newRow);
    }
    public void drawMoves(Graphics2D graph){
        if(board.pieceAt(this.newCol,this.newRow) == null)
            graph.setColor(new Color(88, 204, 50,190));
        else
            graph.setColor(new Color(239, 62, 75,190));
        graph.fillRect(this.newCol* board.Square_size, this.newRow* board.Square_size,board.Square_size,board.Square_size);
    }

    }
