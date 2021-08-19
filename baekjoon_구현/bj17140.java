import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj17140 {
    static int r,c,k,N,M;
    static int[][] arr;
    static int[] count;
    static PriorityQueue<Info>q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        arr = new int[4][4];
        for(int i=1;i<=3;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=3;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int time = 0;
        N = 3;
        M = 3;
        while(true){
            if(N>=r && M>=c && arr[r][c]==k)break;
            if(time>100){
                time = -1;
                break;
            }
            time++;
            if(N>=M)function_r();
            else function_c();
        }
        System.out.println(time);
    }

    private static void function_c() {
        q = new PriorityQueue<>();
        int[][] temp = new int[101][M+1];
        int sum = 0;
        int max = -1;
        int j;
        for(int i=1;i<=M;i++){
            count = new int[101];
            for(j=1;j<=N;j++){
                count[arr[j][i]]++;
            }
            sum = 0;
            for(int k=1;k<=100;k++){
                if(count[k]!=0){
                    q.add(new Info(k,count[k]));
                    sum++;
                }
            }
            int idx = 0;
            while(!q.isEmpty()){
                Info t = q.poll();
                temp[++idx][i] = t.num;
                temp[++idx][i] = t.cnt;
            }
            max = Math.max(max,sum*2);

        }
        N = max+1;

        arr = new int[N+1][M];
        arr = temp.clone();
    }

    private static void function_r() {
        q = new PriorityQueue<>();
        int[][] temp = new int[N+1][101];
        int sum = 0;
        int max = -1;
        for(int i=1;i<=N;i++){
            count = new int[101];
            for(int j=1;j<=M;j++){
                count[arr[i][j]]++;
            }
            sum = 0;
            for(int j=1;j<=100;j++){
                if(count[j]!=0){
                    q.add(new Info(j,count[j]));
                    sum++;
                }
            }
            int idx = 0;
            while(!q.isEmpty()){
                Info t = q.poll();
                temp[i][++idx] = t.num;
                temp[i][++idx] = t.cnt;
            }
            max = Math.max(max,sum*2);

        }
        M = max+1;

        arr = new int[N+1][M];
        arr = temp.clone();

    }

    private static class Info implements Comparable<Info> {
        int num, cnt;

        public Info(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Info o) {
            if(this.cnt==o.cnt){
                return this.num-o.num;
            }else
                return this.cnt-o.cnt;
        }
    }
}
