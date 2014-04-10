package interview.leetcode;

import java.util.ArrayList;

public class NQueens {

	
	/**
	 * The n-queens puzzle is the problem of placing n queens on an n×n
	 * chess board such that no two queens attack each other.
	 * 
	 * Given an integer n, return all distinct solutions to the n-queens puzzle.
	 * 
	 * Each solution contains a distinct board configuration of the n-queens'
	 * placement, where 'Q' and '.' both indicate a queen and an empty space
	 * respectively.
	 * 
	 * For example, There exist two distinct solutions to the 4-queens puzzle:
	 * 
	 * [
		 [".Q..",  // Solution 1
		  "...Q",
		  "Q...",
		  "..Q."],
		
		 ["..Q.",  // Solution 2
		  "Q...",
		  "...Q",
		  ".Q.."]
		]
	 */
	public static void main(String[] args) {
		NQueens n=new NQueens();
		n.solveNQueens(4);
		
	}
	
	// dfs
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		int[] tmpCol = new int[n]; // which column i and row num : which locate the
								// queens
		for (int i = 0; i < tmpCol.length; i++)
			tmpCol[i] = -1;
		dfs(tmpCol, result, 0);
		return result;
	}

	private void dfs(int[] tmpCol, ArrayList<String[]> result, int row) {
		int N = tmpCol.length;
		if (row == N) {
			String[] solution = new String[N];
			for (int i = 0; i < N; ++i) {
				char[] s = new char[N];
				for (int j = 0; j < N; ++j) {
					if (j == tmpCol[i])
						s[j] = 'Q';
					else
						s[j] = '.';
				}
				solution[i] = new String(s);
			}
			result.add(solution);
			return;
		}

		for (int c = 0; c < N; ++c) { // try columns
			if (isValid(tmpCol, row, c)){
				tmpCol[row] = c;
				dfs(tmpCol, result, row + 1);
			}
		}
		
		if(row>0) tmpCol[row-1] = -1;
	}

	private boolean isValid(int[] tmpCol, int currow, int currcol) {
		for (int i = 0; i < currow; i++) {
			if (tmpCol[i] == currcol // in the same column
					|| Math.abs(currcol - tmpCol[i]) == (currow - i)) //in the same diag
				return false;
		}
		return true;
	}
	
	
	//solution 2
    int[] columns; 
	int[] main_diag; 
	int[] anti_diag; 
	
	public ArrayList<String[]> solveNQueens2(int n) {
		this.columns = new int[n];
		this.main_diag = new int[2*n];
		this.anti_diag = new int[2*n];
		ArrayList<String[]> result=new ArrayList<String[]>();
		int[] C=new int[n]; 
		dfs2(C, result, 0);
		return result;
	}
			
	void dfs2(int[] C, ArrayList<String[]> result, int row) {
		int N = C.length;
		if (row == N) { 
			String[] solution= new String[N];
			for (int i = 0; i < N; ++i) {
				char[] s=new char[N];
				for (int j = 0; j < N; ++j) {
					if (j == C[i]) s[j] = 'Q';
					else s[j]='.';
				}
				solution[i]=new String(s);
			}
			result.add(solution);
			return;
		}
		
		for (int j = 0; j < N; ++j) { 
			boolean ok = columns[j] == 0 && main_diag[row + j] == 0 &&
			anti_diag[row - j + N] == 0;
			if (!ok) continue; 
			
			C[row] = j;
			columns[j] = main_diag[row + j] = anti_diag[row - j + N] = 1;
			dfs2(C, result, row + 1);
			// C[row] = 0;
			columns[j] = main_diag[row + j] = anti_diag[row - j + N] = 0;
		}
    }
}
