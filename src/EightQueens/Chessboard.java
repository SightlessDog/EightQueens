package EightQueens;

import java.lang.reflect.Array;

public class Chessboard {
    int cols;
    int rows;
    String[][] array;
    int[][] queens;
    int i = 0;
    boolean threat;

    public Chessboard(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.array = new String[cols][rows];
        this.queens = new int[cols][2];
    }


    public void make() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                array[i][j] = "[ ]";
            }
        }
    }

    public void printChess() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public void addQueen(int col, int row) {
        array[col][row] = "[0]";
        queens[i][0] = col;
        queens[i][1] = row;
        i++;
    }

    public boolean threateningQueen(String[][] array, int col, int row ) {
        int i, j ;
        for (i = 0; i < cols; i++) {
            // for (int j = 0 ; j < cols; j++) {
              /*  if (queens[i][1] == queens[j][1] && array[queens[j][0]][queens[j][1]]=="[0]") {
                    threat = true;
                    break;
                } else if (queens[i][0] == queens[j][0] && array[queens[j][0]][queens[j][1]]=="[0]") {
                    threat =true;
                    break ;
                } else if ((queens[i][1] == (queens[j][1] + 1)) && (queens[i][0] == (queens[j][0] + 1)) && (array[queens[j][0]][queens[j][1]]=="[0]" && array[queens[i][0]][queens[i][1]]=="[0]")) {
                    threat =true;
                    break ;
                } else if ((queens[i][1] == (queens[j][1] - 1)) && (queens[i][0] == (queens[j][0] - 1)) && (array[queens[j][0]][queens[j][1]]=="[0]" && array[queens[i][0]][queens[i][1]]=="[0]")) {
                    threat =true;
                    break ;
                } else if ((queens[i][1] == (queens[j][1] + 1)) && (queens[i][0] == (queens[j][0] - 1))&& (array[queens[j][0]][queens[j][1]]=="[0]" && array[queens[i][0]][queens[i][1]]=="[0]")) {
                    threat =true;
                    break ;
                } else if ((queens[i][1] == (queens[j][1] - 1)) && (queens[i][0] == (queens[j][0] + 1))&& (array[queens[j][0]][queens[j][1]]=="[0]" && array[queens[i][0]][queens[i][1]]=="[0]")) {
                    threat =true;
                    break ;
                } else {
                    threat =false;
                } */
            //check if they have the same row
            if (queens[i][1] == row) {
                return false;
            }
        }
            //diagonal left side
            for (i = col , j = row ; i>=0 && j>=0 ; i-- , j-- ) {
                if (array [i][j] == "[0]"){
                    return false ;
                }
            }

            //diagonal left side down
            for (i=col , j=row ; j<rows && i>=0 ; j++ ,i-- ) {
                if (array[i][j] == "[0]"){
                    return false ;
                }
            }

            //otherwise, there is no threatening queen return true
            return true ;
    }
}