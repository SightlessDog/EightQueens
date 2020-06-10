package EightQueens;

import java.lang.reflect.Array;

public class Chessboard {
    int cols ;
    int rows ;
    String [][] array ;

    public Chessboard (int cols , int rows) {
        this.cols = cols ;
        this.rows = rows ;
        this.array = new String[cols][rows];
    }



    public void make () {
        for (int i = 0 ; i < cols ; i++) {
            for (int j = 0 ; j< rows ; j++){
                array [i][j] = "[ ]";
            }
        }
    }

    public void printChess() {
        for (int i = 0 ; i < cols ; i++) {
            for (int j = 0 ; j< rows ; j++){
                System.out.print(array [i][j]);
            }
            System.out.println();
        }
    }

}
