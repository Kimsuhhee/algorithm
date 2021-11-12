import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj5214 {
    static int N,K,M;
    static ArrayList<Integer>[]graph;
    static Queue<Info>q;
    static boolean[]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken()); //역의 수
        K = Integer.parseInt(stk.nextToken()); //하이퍼튜브가 연결하는 역의 수
        M = Integer.parseInt(stk.nextToken()); //하이퍼튜브 개수
        graph = new ArrayList[N+M+1];
        for(int i=0;i<N+M+1;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1;i<=M;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<K;j++){
                int s = Integer.parseInt(stk.nextToken());
                graph[s].add(N+i);
                graph[N+i].add(s);
            }
        }
        q = new LinkedList<>();
        visited = new boolean[N+M+1];
        q.add(new Info(1,1));
        visited[1] = true;
        int answer = -1;
        while(!q.isEmpty()){
            Info cur = q.poll();
            if(cur.idx==N){
                answer = cur.cnt;
                break;
            }
            for(int next:graph[cur.idx]){
                if(visited[next])continue;

                visited[next] = true;
                if(cur.idx>N)q.add(new Info(next, cur.cnt));
                else q.add(new Info(next,cur.cnt+1));
            }
        }
        System.out.println(answer);
    }

    private static class Info {
        int idx,cnt;

        public Info(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
