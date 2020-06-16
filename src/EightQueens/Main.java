package EightQueens;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    static Stack<Chessboard> states = new Stack();
    static Chessboard board;
    static int numQueens = 6;

    public static void main(String[] args) {
        Chessboard board = new Chessboard(8, 8);
        // TODO THIS SHOWS THAT THE CHECK IS NOT WORKING. I CAN PLACE A QUEEN DIAGONALLY TO THE LEFT BUT NOT THE RIGHT
        board.addQueen(4, 0);
        if (!board.threateningQueen(board.array, 5, 1)) {
            board.addQueen(5, 1);
        }
        if (!board.threateningQueen(board.array, 3, 1)) {
            board.addQueen(3, 1);
        }
        board.printChess();
        search();
    }



    static void search() {
        Chessboard currentState;
        // if there are no states
        if (states.isEmpty()) {
            currentState = new Chessboard(8, 8);
            board = new Chessboard(currentState);
            states.push(currentState);
        }
        // get last one from stack
        currentState = states.pop();
        // termination condition
        if (board.queenCounter >= numQueens) {
            board.printChess();
            return;
        }
        for (int y = 0; y < currentState.rows; y++) {
            for (int x = 0; x < currentState.cols; x++) {

                // check if empty
                if (currentState.isEmpty(x, y)) {
                    // create copy
                    Chessboard stateCopy = new Chessboard(currentState);
                    // if it is empty add a queen
                    // now check if the state has any threats
                    if (!stateCopy.threateningQueen(stateCopy.array,x,y)){
                        stateCopy.addQueen(x, y);
                        // if it doesn't then save state
                        states.push(stateCopy);
                        board = new Chessboard(stateCopy);
                        // continue search with this state
                        search();
                        return;
                    }

                }
            }

        }

        // if I have searched all fields and there is nothing
        if (!states.isEmpty()) {
            search();
        }

        System.out.println("No possible option for "+numQueens+" Queens ");
    }
}
