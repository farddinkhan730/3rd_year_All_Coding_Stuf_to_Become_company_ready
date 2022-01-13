package Graph;

import java.util.*;

public class Evaluate_Division {
    static class Edge{
        String src;
        String nbr;
        double wt;

        public Edge(String src, String nbr, double wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    static class Pair{
        String v;
        double d;

        public Pair(String v, double d) {
            this.v = v;
            this.d = d;
        }
    }
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,ArrayList<Edge>> hs=new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            hs.put(equations.get(i).get(0),new ArrayList<>());
            hs.put(equations.get(i).get(1),new ArrayList<>());
        }
        for (int i = 0; i < equations.size(); i++) {

            hs.get(equations.get(i).get(0)).add(new Edge(equations.get(i).get(0),equations.get(i).get(1),values[i]));
            hs.get(equations.get(i).get(1)).add(new Edge(equations.get(i).get(1),equations.get(i).get(0),1.0/values[i]));
        }
        int m=0;
        double al[]=new double[queries.size()];
        Queue<Pair> q=new LinkedList<>();

        for (int i = 0; i <queries.size() ; i++) {
            q.add(new Pair(queries.get(i).get(0),1));
            String dst=queries.get(i).get(1);
            ArrayList<String> vi=new ArrayList<>();
            while (q.size() > 0) {
                Pair s = q.poll();
                if (hs.containsKey(s.v) && s.v.equals(dst)){
                    al[m++]=s.d;
                    vi.add(s.v);
                    while (q.size()>0) q.poll();
                    break;
                }
                if (!hs.containsKey(dst) || !hs.containsKey(s.v)) {
                    al[m++]=-1.0;
                    vi.add(dst);
                    continue;
                }
                if (vi.contains(s.v)) continue;
                vi.add(s.v);

                for (Edge e : hs.get(s.v)) {
                    if (!vi.contains(e.nbr))
                        q.add(new Pair(e.nbr, e.wt*s.d));
                }
            }
            if (!vi.contains(dst)){
                al[m++]=-1.0;
            }
        }
        for (int i = 0; i < al.length; i++) {
            System.out.println(al[i]);
        }

        return al;

    }
    public static void main(String[] args) {
        List<List<String>> ls=new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ls.add(new ArrayList<>());
//            ls.add(new ArrayList<>());
        }
        ls.get(0).add("a");
        ls.get(0).add("b");
        ls.get(1).add("b");
        ls.get(1).add("c");
        List<List<String>> q=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            q.add(new ArrayList<>());
//            ls.add(new ArrayList<>());
        }
        q.get(0).add("a");
        q.get(0).add("c");
        q.get(1).add("b");
        q.get(1).add("a");
        q.get(2).add("a");
        q.get(2).add("e");

        q.get(3).add("a");
        q.get(3).add("a");

        q.get(4).add("x");
        q.get(4).add("x");

        calcEquation(ls,new double[]{2.0,3.0},q);

//        during submision test cae failed
        /*
        testcase1:-[["a","b"],["c","d"]]
                    [1.0,1.0]
                    [["a","c"],["b","d"],["b","a"],["d","c"]]

        testcase 1:-[["a","b"],["a","c"],["a","d"],["a","e"],["a","f"],["a","g"],["a","h"],["a","i"],["a","j"],["a","k"],["a","l"],["a","aa"],["a","aaa"],["a","aaaa"],["a","aaaaa"],["a","bb"],["a","bbb"],["a","ff"]]
[1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,11.0,1.0,1.0,1.0,1.0,1.0,3.0,5.0]
[["d","f"],["e","g"],["e","k"],["h","a"],["aaa","k"],["aaa","i"],["aa","e"],["aaa","aa"],["aaa","ff"],["bbb","bb"],["bb","h"],["bb","i"],["bb","k"],["aaa","k"],["k","l"],["x","k"],["l","ll"]]

         */
    }
}
