import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1389 {
    static int N,M;
    static int[][] friend;
    static int[] count;
    static int[] answer;
    static boolean[] visited;
    static Queue<Integer>q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        friend = new int[N+1][N+1];
        count = new int[N+1];
        answer = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            friend[a][b] = 1;
            friend[b][a] = 1;
        }

        int min = Integer.MAX_VALUE;

        for(int i=1;i<=N;i++){
            bfs(i);
            Arrays.fill(visited,false);
            for(int j=1;j<=N;j++){
                answer[i] += count[j];
            }
            if(answer[i]<min)min = answer[i];
            Arrays.fill(count,0);
        }

        for(int i=1;i<=N;i++){
            if(answer[i]==min){
                System.out.println(i);
                return;
            }
        }

    }

    private static void bfs(int start) {
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i=1;i<=M;i++){
                if(friend[temp][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                    count[i] = count[temp]+1;
                }
            }
        }
    }
}
