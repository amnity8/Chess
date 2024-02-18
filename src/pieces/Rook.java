package pieces;
import main.Board;

import java.awt.image.BufferedImage;


public class Rook extends Piece{
    public Rook(Board board,int col,int row,boolean isWhite){
        super(board);
        this.col = col;
        this.row = row;
        this.isWhite = isWhite;
        this.x_cord = col * board.Square_size;
        this.y_cord = row * board.Square_size;
        this.name = "Rook";
        this.piece_pic = pieces_pic.getSubimage(4 * image_size , isWhite ? 0 : image_size ,image_size,image_size).getScaledInstance(board.Square_size,board.Square_size, BufferedImage.SCALE_SMOOTH);
    }
}
