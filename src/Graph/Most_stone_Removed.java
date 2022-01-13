package Graph;

public class Most_stone_Removed {
    public static int removeStones(int[][] stones) {
        if(stones.length==1){
            return 0;
        }
        int count=0;

        for(int i=stones.length-1;i>=0;i--){
            int m=stones[i][0],n=stones[i][1];
            for(int j=i-1;j>=0;j--)
            {
                if(m==stones[j][0] || n==stones[j][1] )
                {    count++;
                    break;
                }
            }
        }
        int count1=0;
        for(int i=0;i<stones.length;i++){
            int m=stones[i][0],n=stones[i][1];
            for(int j=i+1;j<=stones.length-1;j++)
            {
                if(m==stones[j][0] || n==stones[j][1] )
                {    count1++;
                    break;
                }
            }
        }
        return Math.max(count,count1);

    }
    public static void main(String[] args) {
        int a[][]={{0,1},{1,2},{1,3},{3,3},{2,3},{0,2}};
        System.out.println(removeStones(a));
    }
}

