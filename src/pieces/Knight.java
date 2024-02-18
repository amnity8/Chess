package pieces;
import main.Board;
import main.Move;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Knight extends Piece{
    public Knight(Board board,int col,int row,boolean isWhite){
        super(board);
        this.col = col;
        this.row = row;
        this.isWhite = isWhite;
        this.x_cord = col * board.Square_size;
        this.y_cord = row * board.Square_size;
        this.name = "Knight";
        this.piece_pic = pieces_pic.getSubimage(3 * image_size , isWhite ? 0 : image_size ,image_size,image_size).getScaledInstance(board.Square_size,board.Square_size, BufferedImage.SCALE_SMOOTH);
    }
    @Override
    public ArrayList<Integer> checkForValidMoves(){
        ArrayList<Integer> possibleMoves = new ArrayList<>();
        for (int i = 0; i< board.rows; i++){
            for (int j = 0; j< board.cols; j++){
                if((Math.abs(j - this.col) * Math.abs(i - this.row) ) == 2){
                    possibleMoves.add(i*10 + j);
                }
            }
        }
        return possibleMoves;
    }

}
