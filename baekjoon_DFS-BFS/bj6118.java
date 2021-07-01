import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj6118 {
    static int N,M,a,b;
    static int[] dist;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        list = new List[N+1];
        dist = new int[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();

        while(M-- > 0){
            stk = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        bfs(1);
        int max = Integer.MIN_VALUE;
        int idx = Integer.MAX_VALUE;
        int cnt = 0;
        for(int i=1;i<=N;i++){
            if(max<dist[i]){
                max = dist[i];
            }
        }
        for(int i=1;i<=N;i++){
            if(max == dist[i]){
                if(i<idx)idx = i;
                cnt++;
            }

        }
        System.out.println(idx+" "+(max-1)+" "+cnt);

    }

    private static void bfs(int start) {
        Queue<Integer>q = new LinkedList<>();
        q.add(start);
        dist[start] = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0;i<list[cur].size();i++){
                int next = list[cur].get(i);
                if(dist[next]==0){
                    q.add(next);
                    dist[next] = dist[cur]+1;
                }
            }
        }
    }
}
