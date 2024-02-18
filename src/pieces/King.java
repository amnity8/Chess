package pieces;
import main.Board;

import java.awt.image.BufferedImage;


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
}
