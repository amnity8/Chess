package main;

import pieces.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseMov extends MouseAdapter {
    Board board;
    public MouseMov(Board board){
        this.board = board;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int col = e.getX() / board.Square_size;
        int row = e.getY() / board.Square_size;
        Piece piece = board.pieceAt(col, row);
        if (board.pieceInPlay == null && piece != null) {
            board.pieceInPlay = piece;
            //show movements
        }
        else if(board.pieceInPlay != null) {
            if(piece == board.pieceInPlay){
                board.pieceInPlay = null;
            }
            else {
                Move move = new Move(board, board.pieceInPlay, col, row);
                if (board.isValidMove(move)) {
                    board.makeMove(move);
                    board.pieceInPlay = null;

                }
            }
        }
        board.repaint();

    }



    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

}
