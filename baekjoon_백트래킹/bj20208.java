import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj20208 {
    static int N,M,H,max;
    static int startX,startY;
    static int[][]town;
    static boolean[] visited;
    static ArrayList<Point>mint;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken()); //초기체력
        H = Integer.parseInt(stk.nextToken()); //민트초코우유를 마실때 마다 증가하는 체력의 양

        town = new int[N][N];
        mint = new ArrayList<>();
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                town[i][j] = Integer.parseInt(stk.nextToken());
                if(town[i][j]==1){
                    startX = i; startY = j;
                }
                if(town[i][j]==2){
                    mint.add(new Point(i,j));
                }
            }
        }
        visited = new boolean[mint.size()];
        dfs(startX,startY,0,M);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int cnt, int hp) {
        if(cnt>max){
            //집으로 돌아올수 있으면서 최대 값 갱신 가능하면 최대 값 갱신
            int h = Math.abs(x-startX) + Math.abs(y-startY);
            if(h<=hp) {
                max = Math.max(max,cnt);
            }
        }
        if(hp<=0){ //체력이 0이되면 이동X
            return;
        }
        for(int i=0;i<mint.size();i++){
            if(!visited[i]){
                int dist = Math.abs(x-mint.get(i).x) + Math.abs(y-mint.get(i).y);
                if(dist<=hp){
                    visited[i] = true;
                    dfs(mint.get(i).x,mint.get(i).y,cnt+1,hp-dist+H);
                    visited[i] = false;
                }
            }
        }
    }

    private static class Point {
        int x,y;

        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
}
