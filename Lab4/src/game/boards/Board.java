package game.boards;

public class Board {
	public char[] cells = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

    public void display() {
        System.out.println(cells[0] + "|" + cells[1] + "|" + cells[2]);
        System.out.println("-+-+-");
        System.out.println(cells[3] + "|" + cells[4] + "|" + cells[5]);
        System.out.println("-+-+-");
        System.out.println(cells[6] + "|" + cells[7] + "|" + cells[8]);
        System.out.println();
    }

    public boolean isFull() {
        for (char c : cells) {
            if (c == ' ') {
                return false;
            }
        }
        return true;
    }

    public boolean checkWin(char player) {
        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };
        for (int[] condition : winConditions) {
            if (cells[condition[0]] == player &&
                cells[condition[0]] == cells[condition[1]] &&
                cells[condition[0]] == cells[condition[2]]) {
                return true;
            }
        }
        return false;
    }
}
