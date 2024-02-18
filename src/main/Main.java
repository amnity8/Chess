package main;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        JFrame board_frame = new JFrame();
        board_frame.setMinimumSize(new Dimension(1000,1000));
        board_frame.setLayout(new GridBagLayout());
        board_frame.setLocationRelativeTo(null);
        Board board = new Board();
        board_frame.add(board);
        board_frame.setVisible(true);


    }
}
