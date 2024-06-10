import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame(){
        initializeGame();
    }

    private void initializeGame() {
        players = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Player1, choose your piece (X/O): ");
        String pieceChoice = sc.nextLine().trim().toUpperCase();

        while (!pieceChoice.equals("X") && !pieceChoice.equals("O")) {
            System.out.println("Invalid choice. Please choose either X or O: ");
            pieceChoice = sc.nextLine().trim().toUpperCase();
        }

        PlayingPiece player1Piece;
        PlayingPiece player2Piece;
        if (pieceChoice.equals("X")) {
            player1Piece = new PlayingPieceX();
            player2Piece = new PlayingPieceO();
        } else {
            player1Piece = new PlayingPieceO();
            player2Piece = new PlayingPieceX();
        }

        Player player1 = new Player("Player1", player1Piece);
        Player player2 = new Player("Player2", player2Piece);

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }
//    private void initializeGame() {
//        players = new LinkedList<>();
//        PlayingPieceX crossPiece = new PlayingPieceX();
//        Player player1 = new Player("Player1", crossPiece);
//
//        PlayingPieceO noughtsPiece = new PlayingPieceO();
//        Player player2 = new Player("Player2", noughtsPiece);
//
//        players.add(player1);
//        players.add(player2);
//
//        gameBoard = new Board(3);
//    }

    public String startGame(){
        boolean noWinner = true;

        while(noWinner){
            Player playerTurn = players.removeFirst();

            gameBoard.printBoard();
            List<Pair> freeSpaces = gameBoard.getFreeCells();

            if(freeSpaces.isEmpty()){
                noWinner = false;
                continue;
            }

            System.out.print(" Player : " + playerTurn.name + " Enter row,colums : ");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            String[] values = input.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputCol = Integer.parseInt(values[1]);

            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputCol,playerTurn.playingPiece);
            if(!pieceAddedSuccessfully){
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean winner = isThereWinner(inputRow,inputCol,playerTurn.playingPiece.pieceType);
            if(winner){
                return playerTurn.name + " wins!";
            }
        }
            return "It's Tie";
    }
    public boolean isThereWinner(int inputRow, int inputCol, PieceType pieceType) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagMatch = true;
        boolean antiDiagMatch = true;

        // Check row
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[inputRow][i] == null || gameBoard.board[inputRow][i].pieceType != pieceType) {
                rowMatch = false;
                break;
            }
        }

        // Check column
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][inputCol] == null || gameBoard.board[i][inputCol].pieceType != pieceType) {
                colMatch = false;
                break;
            }
        }

        // Check diagonal
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][i] == null || gameBoard.board[i][i].pieceType != pieceType) {
                diagMatch = false;
                break;
            }
        }

        // Check anti-diagonal
        for (int i = 0, j = gameBoard.size - 1; i < gameBoard.size; i++, j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagMatch = false;
                break;
            }
        }

        return rowMatch || colMatch || diagMatch || antiDiagMatch;
    }

}
