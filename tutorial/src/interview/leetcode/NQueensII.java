package interview.leetcode;

public class NQueensII {

	/**
	 * Follow up for N-Queens problem.
		Now, instead outputting board configurations, return the total number of distinct solutions.
	 */
	public static void main(String[] args) {
		NQueensII q=new NQueensII();
		
		System.out.println(q.totalNQueens(4));
	}
	
	
	public int totalNQueens(int n) {
        int[] maindiag=new int[2*n];
        int[] antidiag=new int[2*n];
        int[] col=new int[n];
        
        recusive(maindiag, antidiag, col , 0);
        return total;
    }
    
    int total=0;
    
    public void recusive(int[] maindiag, int[] antidiag, int[] columns, int r){
        int size=columns.length;
        if(r==size){
        	total++;
        	return;
        }
        for (int c = 0; c < size; ++c) {
        	boolean ok= (columns[c]==0 && maindiag[r+c]==0 && antidiag[r-c+size]==0);
        	if(!ok) continue;
        	columns[c]=maindiag[r+c]=antidiag[r-c+size]=1;
        	recusive(maindiag, antidiag, columns, r+1);
        	columns[c]=maindiag[r+c]=antidiag[r-c+size]=0;
        	
        }
    }

}
