package interview.leetcode;

public class WordSearch {

	
	
	/**
	 * Given a 2D board and a word, find if the word exists in the grid.

		The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
		
		For example,
		Given board =
		
		[
		  ["ABCE"],
		  ["SFCS"],
		  ["ADEE"]
		]
		word = "ABCCED", -> returns true,
		word = "SEE", -> returns true,
		word = "ABCB", -> returns false.
	 */
	public static void main(String[] args) {

	}
	
	//time O(n^2 * m^2) space O(n^2)
	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n]; // all false

		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				if (dfs(board, word, 0, i, j, visited))
					return true;
		return false;
	}

	public boolean dfs(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
		
		if (index == word.length())
			return true;
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length)
			return false;
		if (visited[x][y])
			return false;
		if (board[x][y] != word.charAt(index))
			return false;
		visited[x][y] = true;
		boolean ret = dfs(board, word, index + 1, x - 1, y, visited) || // up
				dfs(board, word, index + 1, x + 1, y, visited) || // down
				dfs(board, word, index + 1, x, y - 1, visited) || // left
				dfs(board, word, index + 1, x, y + 1, visited); // right
		visited[x][y] = false;
		return ret;
	}

}
