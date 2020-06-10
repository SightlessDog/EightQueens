package EightQueens;


public class Main {

    public static void main(String[] args) {
        Chessboard board = new Chessboard(8,8);
        board.make();
        board.addQueen(3,4);
        board.addQueen(0,4);
        System.out.println(board.threateningQueen());
        board.printChess();
    }
}
