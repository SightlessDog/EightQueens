package EightQueens;


public class Main {

    public static void main(String[] args) {
        Chessboard board = new Chessboard(8,8);
        board.make();
        board.addQueen(4,0);
        if (board.threateningQueen(board.array,1,1)){
            board.addQueen(1,1);
        }
        if (board.threateningQueen(board.array,3,2)) {
            board.addQueen(3,2);
        }
        board.printChess();
    }
}
