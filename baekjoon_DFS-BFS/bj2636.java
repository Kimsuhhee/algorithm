import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2636 {
    static int n,m,answer;
    static int[][] cheese;
    static boolean[][] check;
    static Queue<Point>q = new LinkedList<>();
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        cheese = new int[n][m];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                cheese[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int time = 0;
        while(true){
            if(count()==0)break;
            answer = count();
            checkPiece();
            melt();
            time++;
        }
        System.out.println(time);
        System.out.println(answer);

    }

    private static void melt() {
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //치즈 가장자리 부분 녹음
                if(check[i][j]==true && cheese[i][j]==1)
                    cheese[i][j] = 0;
            }
        }
    }

    private static void checkPiece() {
        check = new boolean[n][m];
       
        //치즈가장자리부분 체크
        q.add(new Point(0,0));
        check[0][0] = true;

        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0;i<4;i++){
                int mx = p.x+dx[i];
                int my = p.y+dy[i];
                if(mx<0||my<0||mx>=n||my>=m)continue;
                if(check[mx][my])continue;
                if(cheese[mx][my]==1) check[mx][my] = true;
                if(cheese[mx][my]==0){
                    q.add(new Point(mx,my));
                    check[mx][my] = true;
                }
            }
        }
    }

    private static int count() {
        Queue<Point>temp = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(cheese[i][j]==1&&!visited[i][j]){
                    temp.add(new Point(i,j));
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        Point p = q.poll();
                        for(int d = 0;d<4;d++){
                            int x = p.x + dx[d];
                            int y = p.y + dy[d];
                            if(x<0||y<0||x>=n||y>=m)continue;
                            if(visited[x][y])continue;
                            if(cheese[x][y]==1){
                                temp.add(new Point(x,y));
                                visited[x][y] = true;
                            }
                        }
                    }
                    sum++;
                }
            }
        }
        return sum;
    }

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
