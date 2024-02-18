package pieces;
import main.Board;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Pawn extends Piece{
    public boolean firstMove;
    public Pawn(Board board, int col, int row, boolean isWhite, boolean firstMove){
        super(board);
        this.col = col;
        this.row = row;
        this.isWhite = isWhite;
        this.x_cord = col * board.Square_size;
        this.y_cord = row * board.Square_size;
        this.name = "Pawn";
        this.firstMove = firstMove;
        this.piece_pic = pieces_pic.getSubimage(5 * image_size , isWhite ? 0 : image_size ,image_size,image_size).getScaledInstance(board.Square_size,board.Square_size, BufferedImage.SCALE_SMOOTH);
    }
    @Override
    public ArrayList<Integer> checkForValidMoves(){
        ArrayList<Integer> possibleMoves = new ArrayList<>();
        int whichMove = isWhite ? 1:-1;
        System.out.println(firstMove);
        if(firstMove){
            possibleMoves.add((row + whichMove * -2)*10 + col);
            possibleMoves.add((row + whichMove * -1)*10 + col);
            firstMove = false;
        }
        else{
            Piece right = board.pieceAt(col+1, row + whichMove * -1);
            Piece left = board.pieceAt(col-1, row + whichMove * -1);
            if((right != null || left != null)){
                if (right != null){
                    if(right.isWhite != isWhite)
                        possibleMoves.add((row + whichMove * -1)*10 + (col+1));
                    else
                        possibleMoves.add((row + whichMove * -1)*10 + col);


                }
                if(left != null)
                {
                    if(left.isWhite != isWhite)
                        possibleMoves.add((row + whichMove * -1)*10 + (col-1));
                    else
                        possibleMoves.add((row + whichMove * -1)*10 + col);


                }
            }
            else if(board.pieceAt(col, row + whichMove * -1) == null)
                possibleMoves.add((row + whichMove * -1)*10 + col);

        }
        return possibleMoves;
    }
}
