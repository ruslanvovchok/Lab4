package game;

import game.boards.Board;
import game.players.abstractions.*;
import game.players.*;

public class Game {
	private Board board;
    private Player humanPlayer;
    private Player aiPlayer;
    private char currentPlayer = 'X';
    
    public Game() {
    	this.board = new Board();
    	this.humanPlayer = new HumanPlayer();
    	this.aiPlayer = new AIPlayer();
    }

    public void start() {
        while (true) {
            board.display();
            int move;
            if (currentPlayer == 'X') {
                move = humanPlayer.makeMove(board.cells);
            } else {
                move = aiPlayer.makeMove(board.cells);
            }
            board.cells[move] = currentPlayer;
            if (board.checkWin(currentPlayer)) {
                board.display();
                System.out.println("Player " + currentPlayer + " was win!");
                break;
            }
            if (board.isFull()) {
                board.display();
                System.out.println("Draw!");
                break;
            }
            switchPlayer();
        }
    }

    void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
