package main;
import pieces.*;
import pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Board extends JPanel {
    public int Square_size = 70;
    public int rows = 8;
    public int cols = 8;
    ArrayList<Piece> board_pieces = new ArrayList<>();
    Piece pieceInPlay;
    MouseMov mouse = new MouseMov(this);
    public Board(){
        pieceInPlay = null;
        setPreferredSize(new Dimension(cols* Square_size,rows * Square_size));
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
        addPieces();
    }

    public Piece pieceAt(int col, int row){
        for (Piece piece: board_pieces) {
            if(piece.col == col && piece.row == row)
                return piece;
        }
        return null;
    }
    public void addPieces() {
        for (int j = 0; j < 2;j++) {
            board_pieces.add(new King(this, 4, j== 0? 0 : 7, j== 0?false : true));
            board_pieces.add(new Bishop(this, 2, j== 0? 0 : 7, j== 0?false : true));
            board_pieces.add(new Bishop(this, 5, j== 0? 0 : 7, j== 0?false : true));
            board_pieces.add(new Rook(this, 0, j== 0? 0 : 7, j== 0?false : true));
            for (int i = 0; i < 8; i++)
                board_pieces.add(new Pawn(this, i, j== 0? 1 : 6, j== 0?false : true, true));
            board_pieces.add(new Rook(this, 7, j== 0? 0 : 7, j== 0?false : true));
            board_pieces.add(new Knight(this, 1, j== 0? 0 : 7, j== 0?false : true));
            board_pieces.add(new Knight(this, 6, j== 0? 0 : 7, j== 0?false : true));
            board_pieces.add(new Queen(this, 3, j== 0? 0 : 7, j== 0?false : true));
        }
    }
    public void makeMove(Move move){
        move.moved_piece.col = move.newCol;
        move.moved_piece.row = move.newRow;
        move.moved_piece.x_cord = move.newCol * Square_size;
        move.moved_piece.y_cord = move.newRow * Square_size;
        capture(move);
        repaint();
    }

    public void capture(Move move){
        board_pieces.remove(move.captured_piece);
    }

    public boolean isValidMove(Move move){
        if(move.moved_piece ==move.captured_piece || move.moved_piece.sameTeam(move.captured_piece))
            return false;
        if(pieceInPlay.checkForValidMoves().contains(move.newRow*10 + move.newCol))
            return true;
        return false;
    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graph = (Graphics2D) g;
        for (int i =0 ; i< rows;i++){
            for (int j = 0; j< cols; j++){
                if((i+j) % 2 == 0)
                    graph.setColor(new Color(155, 91, 22));
                else
                    graph.setColor(new Color(194, 140, 86));
                graph.fillRect(j * Square_size , i * Square_size , Square_size, Square_size);


            }
        }
        for (int i =0 ; i< rows;i++){
            for (int j = 0; j< cols; j++){
                if(pieceInPlay != null &&   isValidMove(new Move(this, pieceInPlay, j, i))){
                    graph.setColor(new Color(88, 204, 50,190));
                    graph.fillRect(j*Square_size, i* Square_size,Square_size,Square_size);
                }


                }
            }
        for (Piece piece: board_pieces) {
            piece.place_piece(graph);

        }
    }
}
