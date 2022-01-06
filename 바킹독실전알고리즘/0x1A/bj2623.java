import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2623 {
    static int N,M;
    static ArrayList<Integer>[]order;
    static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        order = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            order[i] = new ArrayList<>();
        }

        indegree = new int[N+1];
        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(stk.nextToken());
            int pre = -1;
            for(int j=0;j<k;j++){
                int n = Integer.parseInt(stk.nextToken());
                if(pre==-1)pre = n;
                else{
                    order[pre].add(n);
                    indegree[n]++;
                    pre = n;
                }
            }
        }

        Queue<Integer>q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(indegree[i]==0)q.add(i);
        }

        ArrayList<Integer>answer = new ArrayList<>();

        while(!q.isEmpty()){
            int cur = q.poll();
            answer.add(cur);
            for(int next : order[cur]){
                indegree[next]--;
                if(indegree[next]==0)q.add(next);
            }
        }
        if(answer.size()!=N) System.out.println(0);
        else {
            StringBuilder sb = new StringBuilder();
            for(int i:answer)sb.append(i+"\n");
            System.out.print(sb);
        }
    }
}
