package EightQueens;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Chessboard {
    int cols;
    int rows;
    String[][] array;
    int[][] queens;
    int queenCounter = 0;
    boolean threat;
    public List<Queen> Queens = new ArrayList<>();


    public class Queen {
        public int cols, rows;
        public boolean inThreat;

        public Queen(int col, int row) {
            this.cols = col;
            this.rows = row;
            this.inThreat = false;
        }
    }


    public Point randomPos() {
        return new Point((int) (Math.random() * cols), (int) (Math.random() * rows));
    }

    public Chessboard(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.array = new String[cols][rows];
        this.queens = new int[cols][2];
        for (int i = 0; i < cols; i++) {
            // set to a negative flag
            queens[i][1] = -1;
        }
        make();
    }

    public Chessboard(Chessboard copyFrom) {
        this.cols = copyFrom.cols;
        this.rows = copyFrom.rows;
        this.array = deepCopy(copyFrom.array);
        this.Queens = new ArrayList<>(copyFrom.Queens);
        this.queens = deepCopy(copyFrom.queens);
        this.queenCounter = copyFrom.queenCounter;

    }

    public void make() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                array[i][j] = "[ ]";
            }
        }
    }

    public void printChess() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[j][i]);
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public void addQueen(int col, int row) {
        Queens.add(new Queen(col, row));
        array[col][row] = "[0]";
        queens[queenCounter][0] = col;
        queens[queenCounter][1] = row;
        queenCounter++;
    }

    public boolean isEmpty(int col, int row) {
        if (array[col][row].contentEquals("[0]")) return false;
        return true;
    }


    String[][] deepCopy(String[][] source) {
        String[][] dest = new String[cols][rows];
        for (int i = 0; i < cols; i++) {
            dest[i] = Arrays.copyOf(source[i], source[i].length);
        }
        return dest;
    }

    int[][] deepCopy(int[][] source) {
        int[][] dest = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            dest[i] = Arrays.copyOf(source[i], source[i].length);
        }
        return dest;
    }

// TODO: THIS ONLY WORKS FOR THE RIGHT SIDE DIAGONALLY. I ALREADY FIXED THE COLUMNS PLS FIX THE DIAGONAL
    public boolean threateningQueen(String[][] array, int col, int row) {
        int i, j;
        for (i = 0; i < cols; i++) {
            //check if they have the same row
            if (queens[i][1] == row) {
                return true;
            }
            if (queens[i][0] == col) {
                return true;
            }
        }

        //diagonal left side
        for (i = col, j = row; i >= 0 && j >= 0; i--, j--) {
            if (array[i][j] == "[0]") {
                return true;
            }
        }

        //diagonal left side down
        for (i = col, j = row; j < rows && i >= 0; j++, i--) {
            if (array[i][j] == "[0]") {
                return true;
            }
        }

        //otherwise, there is no threatening queen return false
        return false;
    }
}