package interview.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	
	
	/**
	 * 
	   Determine if a Sudoku is valid, according to: 
	 
	        Sudoku Puzzles - The Rules.
			1. Each column must have the numbers 1-9 occuring just once.
			2. Each row must have the numbers 1-9 occuring just once.
			3. And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.
		
		The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

		Note:
		A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
	 */
	public static void main(String[] args) {
		ValidSudoku v= new ValidSudoku();
		
		char[] c1 =new char[]{'.', '8', '7', '6', '5', '4', '3', '2', '1'};
		char[] c2 =new char[]{'2', '.', '.', '.', '.', '.', '.', '.', '.'};
		char[] c3 =new char[]{'3', '.', '.', '.', '.', '.', '.', '.', '.'};
		char[] c4 =new char[]{'4', '.', '.', '.', '.', '.', '.', '.', '.'};
		char[] c5 =new char[]{'5', '.', '.', '.', '.', '.', '.', '.', '.'};
		char[] c6 =new char[]{'6', '.', '.', '.', '.', '.', '.', '.', '.'};
		char[] c7 =new char[]{'7', '.', '.', '.', '.', '.', '.', '.', '.'};
		char[] c8 =new char[]{'8', '.', '.', '.', '.', '.', '.', '.', '.'};
		char[] c9 =new char[]{'9', '.', '.', '.', '.', '.', '.', '.', '.'};
		
		char[][] board=new char[9][9];
		board[0]=c1;
		board[1]=c2;
		board[2]=c3;
		board[3]=c4;
		board[4]=c5;
		board[5]=c6;
		board[6]=c7;
		board[7]=c8;
		board[8]=c9;
		
		System.out.println(v.isValid(c1));
		System.out.println(v.isValidSudoku(board));
	}
	
	
	public boolean isValidSudoku(char[][] board) {
        
        int len=board.length;
        
        //check row
        for(int i=0;i<len;i++){
            if(!isValid(board[i])) return false;
        }
        
        //check column
        for(int j=0;j<len;j++){
            char[] col =new char[len];
            for(int i=0;i<len;i++){
                col[i]=board[i][j];
            }
            if(!isValid(col)) return false;
        }
        
        //check each box
        int rl=0; //row limit
        int cl=0; //col limit
        for(int i=0;i<len/3;i++){
            for(int j=0;j<len/3;j++){
                char[] box =new char[len];
                int ind=0;
                for(int r=rl;r<len/3+rl;r++){ //wrong here : forget to add row limit for len/3+rl
                    for(int c=cl;c<len/3+cl;c++){
                        box[ind++]=board[r][c];
                    }
                }
                if(!isValid(box)) return false;
                cl+=3;
                if(cl==len) cl=0;
            }
            rl+=3;
        }
        
        return true;
    }
    
    public boolean isValid(char[] arr){
        Set<String> set=new HashSet<String>(); //not able to use Set<char>
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!='.'){
                set.add(Character.toString(arr[i])); //how to convert char to string
                count++;
            }
        }
        return count==set.size();
    }

}
