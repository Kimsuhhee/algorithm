import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1600 {
    static int K,W,H;
    static int[] mdx = {1,0,-1,0};
    static int[] mdy = {0,1,0,-1};
    static int[] hdx = {1,2,2,1,-1,-2,-2,-1};
    static int[] hdy = {2,1,-1,-2,-2,-1,1,2};
    static int[][] map;
    static boolean[][][] visited;
    static Queue<Point>q = new LinkedList<>();

    private static class Point {
        int x,y,k,cnt;

        public Point(int x, int y, int k, int cnt) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        W = Integer.parseInt(stk.nextToken());
        H = Integer.parseInt(stk.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K+1];

        for(int i=0;i<H;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<W;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        q.add(new Point(0,0,0,0));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Point temp = q.poll();
            if(temp.x==H-1 && temp.y==W-1){
                System.out.println(temp.cnt);
                return;
            }
            if(temp.k<K){
                for(int i=0;i<8;i++){
                    int x = temp.x + hdx[i];
                    int y = temp.y + hdy[i];
                    if(x<0||y<0||x>=H||y>=W)continue;
                    if(map[x][y]==1 || visited[x][y][temp.k+1]) continue;
                    visited[x][y][temp.k+1] = true;
                    q.add(new Point(x,y,temp.k+1, temp.cnt+1));
                }
            }

            for(int i=0;i<4;i++){
                int x = temp.x + mdx[i];
                int y = temp.y + mdy[i];
                if(x<0||y<0||x>=H||y>=W)continue;
                if(map[x][y]==1 || visited[x][y][temp.k]) continue;
                visited[x][y][temp.k] = true;
                q.add(new Point(x,y,temp.k,temp.cnt+1));
            }
        }

        System.out.println(-1);

    }

}
