package EightQueens;


public class Main {

    public static void main(String[] args) {
        Chessboard board = new Chessboard(8,8);
        board.make();
        board.addQueen(3,5);
        board.addQueen(0,5);
        board.threateningQueen();
        board.printChess();
    }
}
