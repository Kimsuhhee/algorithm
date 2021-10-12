import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj17406 {
    static int N,M,K;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] arr,A;
    static int[] com;
    static boolean[]visited;
    static ArrayList<Info>list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        A = new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                A[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        list = new ArrayList<>();
        for(int i=0;i<K;i++){
            stk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            int s = Integer.parseInt(stk.nextToken());
            list.add(new Info(r,c,s));
        }

        com = new int[K];
        visited = new boolean[K];
        permutation(0);

        System.out.println(answer);
        
    }
    private static void permutation(int n){
        if(n==K){
            arr = new int[N+1][M+1];
            for(int i=1;i<=N;i++){
                for(int j=1;j<=M;j++){
                    arr[i][j] = A[i][j];
                }
            }
            for(int i:com){
                int r =list.get(i).r;
                int c =list.get(i).c;
                int s =list.get(i).s;
                turn(r,c,s);
            }
            findMin();
            return;
        }
        for(int i=0;i<K;i++){
            if(!visited[i]) {
                com[n] = i;
                visited[i] = true;
                permutation( n + 1);
                visited[i] = false;
            }
        }
    }

    private static void findMin() {
        for(int i=1;i<=N;i++){
            int sum = 0;
            for(int j=1;j<=M;j++){
                sum += arr[i][j];
            }
            answer = Math.min(sum,answer);
        }
    }

    private static void turn(int r, int c, int s) {
        int[][] temp = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                temp[i][j] = arr[i][j];
            }
        }
        int n = Math.abs((r-s)-(r+s))+1;
        int m = Math.abs((c-s)-(c+s))+1;
        int t = Math.min(n,m)/2;

        for(int i=0;i<t;i++){
            int x = r-s+i; int y = c-s+i;
            for(int d=0;d<4;d++){
                while(true){
                    int mx = x + dx[d];
                    int my = y + dy[d];
                    if(mx<r-s+i||my<c-s+i||mx>r+s-i||my>c+s-i)break;
                    if(d==3 && mx==r-s+i &&my==c-s+i){
                        arr[mx][my] = temp[x][y];
                        break;
                    }
                    arr[mx][my] = temp[x][y];
                    x = mx; y= my;
                }
            }
        }
    }

    private static class Info {
        int r,c,s;

        public Info(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
}
