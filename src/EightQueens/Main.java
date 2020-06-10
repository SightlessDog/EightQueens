package EightQueens;


public class Main {

    public static void main(String[] args) {
        Chessboard board = new Chessboard(8,8);
        board.make();
        board.printChess();
    }
}
