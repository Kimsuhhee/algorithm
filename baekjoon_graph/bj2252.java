import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2252 {
    static int N,M,a,b;
    static int[] cnt;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        cnt = new int[N];
        graph = new ArrayList<>();
        for(int i=0;i<N;i++){
            graph.add(new ArrayList<>());
        }
        while(M-- > 0){
            stk = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            graph.get(a-1).add(b-1);
            cnt[b-1]++;
        }

        topologySort();
    }

    private static void topologySort() {
        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<cnt.length;i++){
            if(cnt[i]==0)q.add(i);
        }

        for(int i=0;i<N;i++){
            int v = q.poll();
            System.out.print((v+1)+" ");
            for(int next: graph.get(v)){
                cnt[next]--;
                if(cnt[next]==0)q.add(next);
            }
        }

    }
}
