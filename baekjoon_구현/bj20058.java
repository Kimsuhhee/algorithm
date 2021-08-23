import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj20058 {
    static int N,Q,cnt;
    static int L[];
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static int[][] ice,temp;
    static boolean[][] visited;
    static ArrayList<Point>list;
    static Queue<Point>q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stk.nextToken());
        Q = Integer.parseInt(stk.nextToken());
        N = (int) Math.pow(2, N);
        ice = new int[N][N];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                ice[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        L = new int[Q];
        stk = new StringTokenizer(br.readLine());

        for (int idx = 0; idx < Q; idx++) {
            L[idx] = Integer.parseInt(stk.nextToken());
            cnt = 1;
            while (L[idx]-- > 0) cnt *= 2;

            temp = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[i][j] = ice[i][j];
                }
            }
            for (int i = 0; i < N; i += cnt) {
                for (int j = 0; j < N; j += cnt) {
                    rotate(i, j, cnt); //cnt 크기의 격자를 나누어 회전
                }
            }

            melt();
        }

        visited = new boolean[N][N];
        q = new LinkedList<>();
        int max = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(ice[i][j]!=0&& !visited[i][j]) {
                    list = new ArrayList<>();                     q.add(new Point(i, j));
                    list.add(new Point(i,j));
                    visited[i][j] = true;
                    bfs();
                    if(list.size()>max) //덩어리 크기 체크
                        max = list.size();
                }
            }
        }

        int sum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sum+=ice[i][j];
            }
        }
        System.out.println(sum);
        System.out.println(max);
    }

    private static void melt() {
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int c = 0;
                if(ice[i][j]!=0){
                    c = 0;
                    for(int k=0;k<4;k++){
                        int x = i+dx[k];
                        int y = j+dy[k];
                        if(x>=0&&y>=0&&x<N&&y<N&&ice[x][y]!=0)c++;
                    }
                }
                if(c<3)
                    visited[i][j] = true;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j] && ice[i][j]>0)
                    ice[i][j]-=1;
            }
        }
    }

    private static void bfs() {
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0;i<4;i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if(x<0||y<0||x>=N||y>=N)continue;
                if(!visited[x][y]&&ice[x][y]!=0){
                    q.add(new Point(x,y));
                    visited[x][y] = true;
                    list.add(new Point(x,y));
                }
            }

        }

    }

    private static void rotate(int x, int y, int M) {

        int cury = 0;
        for(int i=x;i<x+M;i++){
            int curx = 0;
            for(int j=y;j<y+M;j++){
                ice[x+curx++][y+M-1-cury] = temp[i][j];
            }
            cury++;
        }


    }

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
