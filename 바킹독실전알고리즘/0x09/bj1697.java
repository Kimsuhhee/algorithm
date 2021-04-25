import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1697 {
    static int[] dist = new int[100005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nk = br.readLine();
        StringTokenizer stk = new StringTokenizer(nk," ");
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        if(N==K){
            System.out.println(0);return;
        }
        Queue<Integer>q = new LinkedList<>();
        q.add(N);
        dist[N] = 0;
        Arrays.fill(dist,-1);

        while(!q.isEmpty()){
            int temp = q.poll();
            if(dist[K]!=-1){
                break;
            }
            if(temp-1 >=0 && temp-1<=100000){
                if(dist[temp-1]==-1) {
                    dist[temp - 1] = dist[temp] + 1;
                    q.add(temp - 1);
                }
            }
            if(temp+1 >=0 && temp+1<=100000){
                if(dist[temp+1]==-1) {
                    dist[temp + 1] = dist[temp] + 1;
                    q.add(temp + 1);
                }
            }
            if(temp*2 >=0 && temp*2<=100000){
                if(dist[temp*2]==-1) {
                    dist[temp * 2] = dist[temp] + 1;
                    q.add(temp * 2);
                }
            }
        }
        System.out.println(dist[K]+1);
    }
}
