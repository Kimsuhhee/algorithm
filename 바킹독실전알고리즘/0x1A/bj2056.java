import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2056 {
    static int N;
    static int[]time,indegree,d;
    static ArrayList<Integer>jobs[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = new int[N+1];

        jobs = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            jobs[i] = new ArrayList<>();
        }
        indegree = new int[N+1];
        d = new int[N+1];

        StringTokenizer stk;
        for(int i=1;i<=N;i++){
            stk = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());
            if(n==0)continue;
            for(int j=0;j<n;j++){
                int job = Integer.parseInt(stk.nextToken());
                jobs[i].add(job);
                indegree[job]++;
            }
        }

        Queue<Integer>q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(indegree[i]==0){
                q.add(i);
                d[i] = time[i];
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : jobs[cur]){
                indegree[next]--;
                d[next] = Math.max(d[next],time[next] + d[cur]);
                if(indegree[next]==0){
                    q.add(next);
                }
            }
        }

        int t = -1;

        //모든 작업들의 수행이 끝나야 하기 때문에 가장 큰 값이 정답이 됨
        for(int i=1;i<=N;i++){
            t = Math.max(t,d[i]);
        }
        System.out.println(t);
    }

}
