import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1005 {
    static int T,N,K,W;
    static ArrayList<Integer>buildings[];
    static int[]time,d,indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            K = Integer.parseInt(stk.nextToken());

            time = new int[N+1];
            d = new int[N+1];
            indegree = new int[N+1];
            buildings = new ArrayList[N+1];
            for(int i=0;i<=N;i++){
                buildings[i] = new ArrayList<>();
            }

            stk = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                time[i] = Integer.parseInt(stk.nextToken());
            }

            for(int i=0;i<K;i++){
                stk = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                buildings[x].add(y);
                indegree[y]++;
            }

            W = Integer.parseInt(br.readLine());

            Queue<Integer>q = new LinkedList<>();
            for(int i=1;i<=N;i++){
                if(indegree[i]==0){
                    q.add(i);
                    d[i] = time[i];
                }
            }

            while(!q.isEmpty()){
                int cur = q.poll();
                for(int next : buildings[cur]){
                    indegree[next]--;
                    d[next] = Math.max(d[next],d[cur] + time[next]);
                    if(indegree[next]==0)q.add(next);
                }
            }
            
            sb.append(d[W]+"\n");
        }
        System.out.print(sb);
    }
}
