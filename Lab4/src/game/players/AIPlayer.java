package game.players;

import game.boards.Board;
import game.players.abstractions.Player;

public class AIPlayer  implements Player{
	
	@Override
	public int makeMove(char[] board) {
		int bestScore = Integer.MIN_VALUE;
	    int move = 0; 
	    for (int i = 0; i < board.length; i++) {
	        if (board[i] == ' ') {
	            board[i] = 'O';
	            int score = minimax(board, 0, false);
	            board[i] = ' ';
	            if (score > bestScore) {
	                bestScore = score;
	                move = i;
	            }
	        }
	    }
	    return move;
	}
	
	private int minimax(char[] board, int depth, boolean isMaximizing) {
        if (new Board().checkWin('O')) return 1;
        if (new Board().checkWin('X')) return -1;
        if (new Board().isFull()) return 0;

        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' ') {
                board[i] = isMaximizing ? 'O' : 'X';
                int score = minimax(board, depth + 1, !isMaximizing);
                board[i] = ' ';
                bestScore = isMaximizing ?
                        Math.max(score, bestScore) :
                        Math.min(score, bestScore);
            }
        }
        return bestScore;
    }
	
}
