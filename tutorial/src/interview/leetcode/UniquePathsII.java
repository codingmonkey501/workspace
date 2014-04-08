package interview.leetcode;

public class UniquePathsII {

	
	
	/**
	 * Follow up for "Unique Paths":

		Now consider if some obstacles are added to the grids. How many unique paths would there be?
		
		An obstacle and empty space is marked as 1 and 0 respectively in the grid.
		
		For example,
		There is one obstacle in the middle of a 3x3 grid as illustrated below.
		
		[
		  [0,0,0],
		  [0,1,0],
		  [0,0,0]
		]
		The total number of unique paths is 2.
		
		Note: m and n will be at most 100.
	 */
	public static void main(String[] args) {
		UniquePathsII u=new UniquePathsII();
		int[][] rows=new int[3][3];
		int[] col1=new int[]{0,0,0};
		int[] col2=new int[]{0,1,0};
		int[] col3=new int[]{0,0,0};
		rows[0]=col1;
		rows[1]=col2;
		rows[2]=col3;
		System.out.println(u.uniquePathsWithObstacles(rows));
	}
	
	
	//和Unique Path一样的转移方程： Step[i][j] = Step[i-1][j] + Step[i][j-1] 
	//if Array[i][j] ==0 or = 0 if Array[i][j] =1
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if (obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0) {
            return 0;
        }
        
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        cache=new int[m+1][n+1];
        return dfs(obstacleGrid, m, n);
    }
    
    int[][] cache;
    
    public int dfs(int[][] obstacleGrid, int x, int y){
    	if(x<1 || y<1) return 0;	//illegal
    	if(obstacleGrid[x-1][y-1]==1) return 0; //obstacle
    	if(x==1 && y==1) return 1; //terminal condition
        return getOrUpdate(obstacleGrid, x-1, y) + getOrUpdate(obstacleGrid, x, y-1);
    }
    
    int getOrUpdate(int[][] obstacleGrid, int x, int y) {
		if (cache[x][y] > 0) return cache[x][y];
		else return cache[x][y] = dfs(obstacleGrid, x, y);
	}

}
