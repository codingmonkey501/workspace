package interview.leetcode;


public class SudokuSolver {
	/**
	 * Write a program to solve a Sudoku puzzle by filling the empty cells.
		Empty cells are indicated by the character '.'.
		You may assume that there will be only one unique solution.
		A sudoku puzzle...
	 */
	
	public boolean solveSudoku(char[][] board) {
		for (int i = 0; i < 9; ++i)
			for (int j = 0; j < 9; ++j) {
				if (board[i][j] == '.') {
					for (int k = 0; k < 9; ++k) {
						board[i][j] = (char) ('1' + k);
						if (isValid(board, i, j) && solveSudoku(board))
							return true;
						board[i][j] = '.';
					}
					return false;
				}
			}
		return true;
	}

	private boolean isValid(char[][] board, int x, int y) {
		char num = board[x][y];
		// check column
		for (int i = 0; i < 9; i++)
			if (i != x && board[i][y] == num)
				return false;
		// check row
		for (int j = 0; j < 9; j++)
			if (j != y && board[x][j] == num)
				return false;

		// check block
		for (int i = 3 * (x / 3); i < 3 * (x / 3 + 1); i++)
			for (int j = 3 * (y / 3); j < 3 * (y / 3 + 1); j++)
				if ((i != x || j != y) && board[i][j] == num)
					return false;
		return true;
	}
	
}
