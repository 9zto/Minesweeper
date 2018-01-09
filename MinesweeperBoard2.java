
/**
 * Write a description of class Minesweeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MinesweeperBoard2{
    Cell[][] board;
    int rows;
    int columns;
    public MinesweeperBoard2(int row, int column, int bombs){
        //Put the constructor here.
        this.rows = row;
        this.columns = column;

        board = new Cell[rows][columns];

        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        addBombs(bombs);
        printBoard();
        addNums();
    }

    public MinesweeperBoard2(){
        this(10,10, 20);
    }

    public void addBombs(int bombs) {//throws Exception
        for(int i = 0; i < bombs; i++){
            int index = (int)((Math.random()) * (rows * columns) - 1);
            if(board[index].isBomb()){
                i--;
            }else{
                board[index].setBomb();
            }
        }
    }

    public void addNums(){
        int i = 0;
        for(i = 0; i < (columns * rows); i++){
            if(board[i].isBomb()){
                //Top
                if((i >= columns) && (i % columns != 0)){
                    board[i - columns - 1].addValue();
                }
                if(i >= columns){
                    board[i - columns].addValue();
                }
                if(i >= columns && (i % columns != columns - 1)){
                    board[i - columns + 1].addValue();
                }
                //Sides
                if(i % columns != 0){
                    board[i - 1].addValue();
                }
                if(i % columns != columns - 1){
                    board[i + 1].addValue();
                }
                //Bottom
                if(i < ((rows - 1)*columns) && i % columns != 0){
                    board[i + columns - 1].addValue();
                }
                if(i < ((rows - 1)*columns)){
                    board[i + columns].addValue();
                }
                if(i < (rows - 1)*columns && i % columns != (columns - 1)){
                    board[i + columns + 1].addValue();
                }
            }
        }
    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int val = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                if(board[val].isBomb()){
                    System.out.print("X" + " ");
                }else{ 
                    System.out.print(board[val].getValue() + " ");
                }
                val++;
            }
            System.out.println();
        }
    }

    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows*columns; i++){
            board[i]= new Cell();
            panel.add(board[i].getButton());
        }
        return panel;
    }

}

/**
 * 
 * STEP 1: Make 10 by 10 grid board
 * 0-0-0-0-0-0-0-0-0-0
 * 0-0-0-0-0-0-0-0-0-0
 * 0-0-0-0-0-0-0-0-0-0
 * 0-0-0-0-0-0-0-0-0-0
 * 0-0-0-0-0-0-0-0-0-0
 * 0-0-0-0-0-0-0-0-0-0
 * 0-0-0-0-0-0-0-0-0-0
 * 0-0-0-0-0-0-0-0-0-0
 * 0-0-0-0-0-0-0-0-0-0
 * 0-0-0-0-0-0-0-0-0-0
 * STEP 2: Make the "printBoard" method
 * STEP 3: Make the "addBombs" method, numerical value -1, print out x, make sure correct num of bombs
 * STEP 4: Create the "addNums" method
 * STEP 5: Make it look pretty
 * 
 * 
 *      //TOP LEFT
if((i % columns == 0) && (i % rows == 0)){
board[i].addValue();
}
//TOP CENTER
if(i % rows == 0 ){
}
//TOP RIGHT
if((i % columns == (columns - 1) && (i % rows == 0))){
}
//CENTER LEFT
if((i % columns == 0)){
}
//CENTER RIGHT
if((i % columns == (columns - 1))){
}
//BOTTOM LEFT
if((i % columns == 0) && (i % rows == (rows - 1))){
}
//BOTTOM CENTER
if((i % rows == (rows - 1)) ){
}
//BOTTOM RIGHT
if((i % columns == (columns - 1)) && (i % rows == (rows - 1))){
}
//BOTTOM CENTER
if((i % rows == (rows - 1)) ){
}

 */
