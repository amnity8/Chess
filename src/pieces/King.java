package pieces;
import main.Board;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class King extends Piece{
    public King(Board board,int col,int row,boolean isWhite){
        super(board);
        this.col = col;
        this.row = row;
        this.isWhite = isWhite;
        this.x_cord = col * board.Square_size;
        this.y_cord = row * board.Square_size;
        this.name = "King";
        this.piece_pic = pieces_pic.getSubimage(0 * image_size , isWhite ? 0 : image_size ,image_size,image_size).getScaledInstance(board.Square_size,board.Square_size, BufferedImage.SCALE_SMOOTH);
    }

    @Override
    public ArrayList<Integer> checkForValidMoves(){
        ArrayList<Integer> possibleMoves = new ArrayList<>();
        for (int i = 0; i< board.rows; i++){
            for (int j = 0; j< board.cols; j++){
                if(((Math.abs(j - this.col) * Math.abs(i - this.row) ) == 1) || ((Math.abs(j - this.col) + Math.abs(i - this.row) ) == 1) ){
                    possibleMoves.add(i*10 + j);
                }
            }
        }
        return possibleMoves;
    }
}
