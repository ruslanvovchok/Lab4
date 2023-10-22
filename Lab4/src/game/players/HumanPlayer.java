package game.players;

import java.util.Scanner;

import game.players.abstractions.Player;

public class HumanPlayer implements Player{
	
	private final Scanner scanner;
	
	public HumanPlayer() {
		this.scanner = new Scanner(System.in);
	}
	
	@Override
	public int makeMove(char[] board) {
		System.out.println("Your turn (1-9):");
        int move = scanner.nextInt() - 1;
        if (board[move] != ' ') {
            System.out.println("This cell was busy!");
            return makeMove(board);
        }
        return move;
	}

}