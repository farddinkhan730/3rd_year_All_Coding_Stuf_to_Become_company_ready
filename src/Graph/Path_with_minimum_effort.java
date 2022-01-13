package Graph;

public class Path_with_minimum_effort {

    static int effort=0,mieffort=0,anseff=0;
    public static int minimumEffortPath(int[][] heights) {
        effort=Math.abs(heights[heights.length-1][heights[0].length-1]-heights[heights.length-2][heights[0].length-1]);
        effort=Math.max(effort,
                Math.abs(heights[heights.length-1][heights[0].length-1]-heights[heights.length-1][heights[0].length-2]));
        mieffort=Math.min(effort,
                Math.abs(heights[heights.length-1][heights[0].length-1]-heights[heights.length-1][heights[0].length-2]));

        System.out.println(effort+" "+ mieffort);
        minimumEffortPath1(heights,0,0,new boolean[heights.length][heights[0].length],0);
        return effort;
    }

    public static void minimumEffortPath1(int[][] heights,int i,int j,boolean visited[][],int eff) {
        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length || visited[i][j]){
            return;
        }
        visited[i][j]=true;
        if(i==heights.length && j==heights[0].length && eff<=mieffort ){
            anseff=eff;

        }

        minimumEffortPath1(heights, i - 1, j, visited,Math.abs(heights[i][j]-heights[i-1][j]));
        minimumEffortPath1(heights,i+1,j,visited,Math.abs(heights[i][j]-heights[i+1][j]));
        minimumEffortPath1(heights,i,j-1,visited,Math.abs(heights[i][j]-heights[i][j-1]));
        minimumEffortPath1(heights,i,j+1,visited,Math.abs(heights[i][j]-heights[i][j+1]));
    }

    public static void main(String[] args) {
        int height[][]={{1,2,2},
                        {3,8,2},
                        {5,3,5}};
        System.out.println(minimumEffortPath(height));

    }
}
