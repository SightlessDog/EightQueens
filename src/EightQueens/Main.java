package EightQueens;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    static Stack<Chessboard> states = new Stack();
    static Chessboard board;
    static int numQueens = 8;
    static ArrayList<Chessboard> solutions = new ArrayList<>();

    public static void main(String[] args) {
        Chessboard board = new Chessboard(8, 8);
        board.addQueen(2, 1);
        if (!board.threateningQueen(board.array, 1, 0)) {
            board.addQueen(1, 0);
        }
        if (!board.threateningQueen(board.array, 1, 2)) {
            board.addQueen(1, 2);
        }
        if (!board.threateningQueen(board.array, 3, 0)) {
            board.addQueen(3, 0);
        }
        board.printChess();
        search();
        printSolutions();

    }


    static void search() {
        int i = 0;
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
        if (currentState.queenCounter >= numQueens) {
            currentState.printChess();
            if (uniqueSolution(currentState)) solutions.add(currentState);
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

                    if (!stateCopy.threateningQueen(stateCopy.array, x, y)) {
                        stateCopy.addQueen(x, y);
                        // if it doesn't then save state
                        states.push(stateCopy);
                        board = new Chessboard(stateCopy);
                        // continue search with this state
                        search();
                        
                    }

                }

            }

        }

    }

    static boolean uniqueSolution(Chessboard state) {
        for (Chessboard C : solutions) {
            if (java.util.Arrays.deepEquals(state.array, C.array)) return false;
        }
        return true;
    }

    static void printSolutions() {
        for (Chessboard C : solutions) {
            C.printChess();
        }
        System.out.println("Problem has " + solutions.size() + "unique solutions");
    }

}

