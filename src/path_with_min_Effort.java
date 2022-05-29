import java.util.*;

public class path_with_min_Effort {
}

class Solutiondf {
    int effort=Integer.MAX_VALUE;
    static
    class psf{
        String p;
        int wt;
    }
    static List<psf> l=new ArrayList<>();
    public static int minimumEffortPath(int[][] heights) {

        minimumEffortPath1(heights,0,0,new boolean[heights.length][heights[0].length],0,0,"");
        Collections.sort(l,(a,b)->(a.wt-b.wt));
        for (int i = 0; i < l.size(); i++) {

            System.out.println(l.get(i).p+" "+l.get(i).wt);
        }
        return l.get(0).wt;
    }

    public static void minimumEffortPath1(int[][] heights,int i,int j,boolean visited[][],int prev,int mdiff,String s)
    {
        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length || visited[i][j])
        {
            return;
        }
        s+=heights[i][j];
        mdiff=Math.max(mdiff,Math.abs(prev-heights[i][j]));
        if(i==heights.length-1 && j==heights[0].length-1){
            psf m=new psf();
            m.wt=mdiff;
            m.p=s;
            l.add(m);
            return;

        }
        visited[i][j]=true;

        // effort=Math.min(effort,mdiff);
        minimumEffortPath1(heights,i-1,j,visited,heights[i][j],mdiff,s);
        minimumEffortPath1(heights,i+1,j,visited,heights[i][j],mdiff,s);
        minimumEffortPath1(heights,i,j-1,visited,heights[i][j],mdiff,s);
        minimumEffortPath1(heights,i,j+1,visited,heights[i][j],mdiff,s);
        visited[i][j]=false;

    }

    public static void main(String[] args) {
        minimumEffortPath(new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}});
       int a[]=new int[5];
       String s="sdffv";
        char cc[]=s.toCharArray();

    }
}
class ghg {
    static char c[]={'a','e','i','o','u'};
    // int count=0;
    static Set<String> hs=new HashSet<>();
    public static int countVowelStrings(int n) {
        if(n==0){
            return 0;
        }
        co(n,0,"");
        // System.out.println(hs);
        return hs.size();
    }
    public static void co(int n,int i,String s) {
        if(i>=c.length) return;
        if(n==0){
            char cc[]=s.toCharArray();
            Arrays.sort(cc);
            String str=new String(cc);
            if(!hs.contains(str)){
                hs.add(str);
            }
            return;
        }
        co(n-1,i,s+c[i]);
        co(n,i+1,s);
    }

    public static void main(String[] args) {
        countVowelStrings(1);
    }
}