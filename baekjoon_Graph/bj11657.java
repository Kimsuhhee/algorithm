import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11657 {
    static int N,M;
    static long[] dist;
    static ArrayList<Node>graph[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            graph[a].add(new Node(b,c));
        }

        dist = new long[N+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[1] = 0;

        //M-1번 반복하며 최단 경로 갱신
        for(int i=1;i<M;i++) {
            for (int j = 1; j <= N; j++) {
                for (Node node : graph[j]) {
                    if (dist[j]!=Long.MAX_VALUE && dist[node.next] > dist[j] + node.time) {
                        dist[node.next] = dist[j] + node.time;
                    }
                }
            }
        }

        boolean cycle = false;
        //M번째 최단 경로 갱신
        for(int i=1;i<=N;i++){
            for(Node node:graph[i]){
                if(dist[i]!=Long.MAX_VALUE && dist[node.next]>dist[i]+node.time){
                    cycle = true; //음수 사이클 존재
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        //음수 사이클 존재 -> 시간을 무한히 오래 전으로 되돌릴 수 있음
        if(cycle) sb.append(-1+"\n");
        else{ //음수 사이클이 존재하지 않는 경우 -> 나머지 도시로 가는 시간 출력
            for(int i=2;i<=N;i++){
                if(dist[i]==Long.MAX_VALUE)sb.append(-1+"\n");
                else sb.append(dist[i]+"\n");
            }
        }
        System.out.print(sb);
    }

    private static class Node {
        int next,time;

        public Node(int next, int time) {
            this.next = next;
            this.time = time;
        }
    }
}
