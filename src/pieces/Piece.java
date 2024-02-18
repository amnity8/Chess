package pieces;

import main.Board;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Piece {
    Board board;
    public int col, row, x_cord, y_cord;
    public boolean isWhite;
    public String name;
    public BufferedImage pieces_pic;
    protected int image_size;
    public Image piece_pic;

    public Piece(Board board) {
        this.board = board;
        try {
            pieces_pic = ImageIO.read(ClassLoader.getSystemResourceAsStream("pieces.png"));
            image_size = pieces_pic.getWidth() / 6;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean sameTeam(Piece p2) {
        if (this == null || p2 == null)
            return false;
        if (this.isWhite == p2.isWhite)
            return true;
        return false;
    }
    private void removeFromStraightMoves(ArrayList<Integer> possibleMoves, int i, int j) {
        boolean top = i < this.row && j ==  this.col;
        boolean down = i > this.row &&  j == this.col;
        boolean left = i == this.row && j < this.col;
        boolean right = i == this.row && j > this.col;
        System.out.println("_top" + top);
        System.out.println("dow"+down);
        System.out.println("left"+left);
        System.out.println("rig"+right);
        if(top)
            possibleMoves.removeIf((n) -> ((int)n /10) < i  );

        if(down)
            possibleMoves.removeIf((n) -> ((int)n /10) > i  );

        if(right)
            possibleMoves.removeIf((n) -> n % 10 > j );

        if(left)
            possibleMoves.removeIf((n) -> n % 10 < j );

}

    public ArrayList<Integer> straightMoves(){
        ArrayList<Integer> possibleMoves = new ArrayList<>();
        ArrayList<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i< board.rows; i++){
            for (int j = 0; j< board.cols; j++){
                if( this.col == j || this.row == i ) {
                    if (board.pieceAt(j, i) != null) {
                        toRemove.add(i*10 + j);
                        if(board.pieceAt(j, i).isWhite != this.isWhite)
                            possibleMoves.add(i*10 + j);
                    }
                    else
                        possibleMoves.add(i*10 + j);
                }
            }
        }
        for (Integer remove: toRemove) {
            removeFromStraightMoves(possibleMoves, ((int)remove / 10), remove % 10);
        }

        return possibleMoves;
    }



    private void removeFromDiagonalMoves(ArrayList<Integer> possibleMoves, int i, int j) {
        boolean top_left = i < this.row && j < this.col;
        boolean top_right = i < this.row &&  j > this.col;
        boolean down_left = i > this.row && j < this.col;
        boolean down_right = i > this.row && j > this.col;
        if(top_left)
            possibleMoves.removeIf((n) -> (n % 10 < j && ((int)n /10) < i  ));
        if(top_right)
            possibleMoves.removeIf((n) -> (n % 10 > j && ((int)n /10) < i  ));
        if(down_left)
            possibleMoves.removeIf((n) -> (n % 10 < j && ((int)n /10) > i  ));
        if(down_right)
            possibleMoves.removeIf((n) -> (n > i*10 + j ));
    }

    public ArrayList<Integer> diagonalMoves(){
        ArrayList<Integer> possibleMoves = new ArrayList<>();
        ArrayList<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i< board.rows; i++){
            for (int j = 0; j< board.cols; j++){
                if( Math.abs(this.col - j) == Math.abs(this.row - i) ) {
                    if (board.pieceAt(j, i) != null) {
                        toRemove.add(i*10 + j);
                        if(board.pieceAt(j, i).isWhite != this.isWhite)
                            possibleMoves.add(i*10 + j);
                    }
                    else
                        possibleMoves.add(i*10 + j);
                }
            }
        }
        for (Integer remove: toRemove) {
            removeFromDiagonalMoves(possibleMoves, ((int)remove / 10), remove % 10);
        }
        return possibleMoves;
    }
    public ArrayList<Integer> checkForValidMoves(){
        return null;
    }
    public void place_piece(Graphics2D graph){
        graph.drawImage(piece_pic,x_cord,y_cord,null);
    }



}
