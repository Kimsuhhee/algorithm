import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1939 {
    static int N,M,s,e,maxWeight,answer;
    static ArrayList<Info>[] bridge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        bridge = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            bridge[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());
            int C = Integer.parseInt(stk.nextToken());
            bridge[A].add(new Info(B,C));
            bridge[B].add(new Info(A,C));
            maxWeight = Math.max(maxWeight,C);
        }

        //공장 위치
        stk = new StringTokenizer(br.readLine());
        s = Integer.parseInt(stk.nextToken());
        e = Integer.parseInt(stk.nextToken());

        int st = 1, en = maxWeight;

        while(st<=en){
            //현재 트럭 무게
            int mid = (st + en)/2;

            //현재 트럭 무게로 s->e 이동 가능한경우
            if(bfs(mid)){
                answer = Math.max(answer,mid);
                st = mid + 1;
            }else{
                en = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean bfs(int curWeight) {
        Queue<Integer>q = new LinkedList<>();
        q.add(s);
        boolean[] visited = new boolean[N+1];
        visited[s] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur==e)return true;
            for(Info next : bridge[cur]){
                if(!visited[next.node] && curWeight<=next.weight){
                    visited[next.node] = true;
                    q.add(next.node);
                }
            }
        }
        return false;
    }

    private static class Info {
        int node,weight;

        public Info(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
