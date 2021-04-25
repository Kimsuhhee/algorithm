import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj5014 {
    static int F,S,G,U,D;
    static int[] dist;
    static boolean[] visited;
    static Queue<Integer>q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String FSGUD = br.readLine();
        StringTokenizer stk = new StringTokenizer(FSGUD," ");
        F = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());
        G = Integer.parseInt(stk.nextToken());
        U = Integer.parseInt(stk.nextToken());
        D = Integer.parseInt(stk.nextToken());

        dist = new int[F+1];
        Arrays.fill(dist,-1);
        dist[S] = 0;
        q.add(S);

        while(!q.isEmpty()){
            int temp = q.poll();
            if((temp+U)<=F && (temp+U)>=1 && dist[temp+U]==-1){
                dist[temp+U] = dist[temp]+1;
                q.add(temp+U);
            }
            if((temp-D)>=1 && (temp-D)<=F && dist[temp-D]==-1){
                dist[temp-D] = dist[temp]+1;
                q.add(temp-D);
            }
        }
        if(dist[G]==-1) System.out.println("use the stairs");
        else System.out.println(dist[G]);
    }

}
