import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1766 {
    static int N,M;
    static ArrayList<Integer>problems[];
    static int[] indegree;
    static PriorityQueue<Integer>pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        problems = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            problems[i] = new ArrayList<>();
        }
        indegree = new int[N+1];

        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());
            problems[A].add(B);
            indegree[B]++;
        }

        //가능하면 쉬운 문제부터 풀어야 함 -> 우선 순위 큐 사용해서 문제 난이도를 오름차순으로 뽑음
        pq = new PriorityQueue<>();
        for(int i=1;i<=N;i++){
            if(indegree[i]==0)pq.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur+" ");
            for(int next : problems[cur]){
                indegree[next]--;
                if(indegree[next]==0)pq.add(next);
            }
        }
        System.out.println(sb);
    }
}
