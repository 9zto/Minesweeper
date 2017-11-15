
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
    Cell[] board;
    int rows;
    int columns;
    public MinesweeperBoard2(int row, int column, int bombs){
        //Put the constructor here.
        this.rows = row;
        this.columns = column;

        board = new Cell[rows * columns];

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
        this(10,10, 25);
    }

    public void addBombs(int bombs) {//throws Exception{
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
        int index = 0;
        for(int i = 0; i < columns; i++){
            for(int k = 0; k < rows; k++){
                if(board[index].getValue() != -1){
                    //TOP LEFT
                    if(index == 0){
                        if(board[index + 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + rows].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + rows + 1].isBomb()){
                            board[index].addValue();
                        }
                    }
                    //TOP RIGHT
                    else if(index == (rows - 1)){
                        if(board[index - 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + rows].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + rows - 1].isBomb()){
                            board[index].addValue();
                        }
                    }
                    //BOTTOM LEFT
                    else if(index == ((columns - 1) * rows)){
                        if(board[index + 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index - rows].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index - rows + 1].isBomb()){
                            board[index].addValue();
                        }
                    }
                    //BOTTOM RIGHT
                    else if(index == (columns * (rows - 1))){
                        if(board[index - 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index - rows].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index - rows - 1].isBomb()){
                            board[index].addValue();
                        }
                    }
                    //TOP ROW
                    else if(index < rows){
                        if(board[index - 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + rows].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + rows - 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + rows + 1].isBomb()){
                            board[index].addValue();
                        }
                    }
                    //BOTTOM ROW
                    else if(i == (columns - 1)){
                        if(board[index - 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index - rows].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index - rows - 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index - rows + 1].isBomb()){
                            board[index].addValue();
                        }
                    }
                    //LEFT COLUMN
                    else if(index < columns){
                        if(board[index + 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index - rows].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + rows].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + rows + 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index - rows + 1].isBomb()){
                            board[index].addValue();
                        }
                    }
                    //RIGHT COLUMN
                    else if(index == ((i + 1)* rows) - 1){
                        if(board[index - 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index - rows].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + rows].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + rows - 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index - rows - 1].isBomb()){
                            board[index].addValue();
                        }
                    }else{
                        if(board[index + 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index - 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index - rows].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + rows].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + rows + 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index - rows + 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index + rows - 1].isBomb()){
                            board[index].addValue();
                        }
                        if(board[index - rows - 1].isBomb()){
                            board[index].addValue();
                        }
                    }
                }
                index++;
            }
        }
    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int val = 0;
        for(int c = 0; c < columns; c++){
            for(int r = 0; r < rows; r++){
                System.out.print(board[val].value + " ");
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
 */
