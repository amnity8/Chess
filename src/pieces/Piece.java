package pieces;

import main.Board;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Piece {
    Board board;
    public int col,row,x_cord,y_cord;
    public boolean isWhite;
    public String name;
    public BufferedImage pieces_pic;
    protected int image_size;
    public Image piece_pic;

    public Piece(Board board) {
        this.board = board;
        try {
            pieces_pic = ImageIO.read(ClassLoader.getSystemResourceAsStream("pieces.png"));
            image_size = pieces_pic.getWidth() / 6 ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isValidMove(int col, int row){
        return true;
    }
    public void place_piece(Graphics2D graph){
        graph.drawImage(piece_pic,x_cord,y_cord,null);
    }



}
