import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj13549 {
    static int N,K;
    static int[] dist = new int[100001];
    static boolean[] visited = new boolean[100001];
    static Queue<Integer>q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NK = br.readLine();
        StringTokenizer stk = new StringTokenizer(NK," ");
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        Arrays.fill(dist,-1);
        dist[N] = 0;
        visited[N] = true;
        q.add(N);

        while(!q.isEmpty()){
            int temp = q.poll();
            if(temp==K)break;
            if(temp*2<=100000 && !visited[temp*2]){
                dist[temp*2] = dist[temp];
                q.add(temp*2);
                visited[temp*2] = true;
            }
            if(temp-1 >= 0 && !visited[temp-1]){
                dist[temp-1] = dist[temp]+1;
                q.add(temp-1);
                visited[temp-1] = true;
            }
            if(temp+1<=100000 && !visited[temp+1]){
                dist[temp+1] = dist[temp]+1;
                q.add(temp+1);
                visited[temp+1] = true;
            }

        }
        System.out.println(dist[K]);
    }

}
