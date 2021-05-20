import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13913 {
    static int N,K;
    static int[] dist = new int[100001];
    static int[] parent = new int[100001]; //이동하면서 이전의 위치기록
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NK = br.readLine();
        StringTokenizer stk = new StringTokenizer(NK," ");
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        Arrays.fill(dist,-1);
        dist[N] = 0;
        q.add(N);

        while(!q.isEmpty()){
            int temp = q.poll();

            if(temp==K){ //동생을 찾았다면
                System.out.println(dist[K]);
                StringBuilder sb = new StringBuilder();
                while(temp!=N){
                    sb.insert(0,temp+" "); //역순으로 출력하기 위해서 맨앞에 값을 추가
                    temp = parent[temp];
                }
                sb.insert(0,temp+" ");
                System.out.println(sb);
                return;
            }
            if(temp+1 >= 0 && temp+1<=100000 && dist[temp+1]==-1){
                dist[temp+1] = dist[temp]+1;
                parent[temp+1] = temp;
                q.add(temp+1);
            }
            if(temp-1 >= 0 && temp-1<=100000 && dist[temp-1]==-1){
                dist[temp-1] = dist[temp]+1;
                parent[temp-1] = temp;
                q.add(temp-1);
            }
            if(temp*2 >= 0 && temp*2<=100000 && dist[temp*2]==-1){
                dist[temp*2] = dist[temp]+1;
                parent[temp*2] = temp;
                q.add(temp*2);
            }

        }

    }

}

