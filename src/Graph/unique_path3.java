package Graph;

public class unique_path3 {
    static int count=0;
    public static int uniquePathsIII(int[][] grid) {

        boolean visited[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    uniquePathsIII1(grid,i,j,visited);
                    break;
                }
            }
        }
        return count;

    }
    public static void uniquePathsIII1(int[][] grid,int i,int j,boolean visited[][]) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || grid[i][j]==-1){
            return;
        }
        if(grid[i][j]==2){
            count++;
            return;
        }
        visited[i][j]=true;
        uniquePathsIII1(grid,i,j+1,visited);
        uniquePathsIII1(grid,i-1,j,visited);
        uniquePathsIII1(grid,i,j-1,visited);
        uniquePathsIII1(grid,i+1,j,visited);

        visited[i][j]=false;

    }

    public static void main(String[] args) {
        int grid[][]={{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        System.out.println(uniquePathsIII(grid));
    }
}

