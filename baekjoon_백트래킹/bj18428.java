import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj18428 {
    static int N;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static ArrayList<Point>empty = new ArrayList<Point>();
    static ArrayList<Point>teacher = new ArrayList<Point>();
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        StringTokenizer stk;
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = stk.nextToken().charAt(0);
                if(arr[i][j]=='X') empty.add(new Point(i,j));
                if(arr[i][j]=='T') teacher.add(new Point(i,j));
            }
        }

        dfs(0,0);
        System.out.println("NO");
    }

    private static void dfs(int start, int cnt) {
        if(cnt==3){
            if(watch()){
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }
        for(int i=start;i<empty.size();i++){
            arr[empty.get(i).x][empty.get(i).y] = 'O';
            dfs(i+1,cnt+1);
            arr[empty.get(i).x][empty.get(i).y] = 'X';
        }
    }

    private static boolean watch() {
        for(int i=0;i<teacher.size();i++){
            Point t = teacher.get(i);
            for (int d = 0; d < 4; d++) {
                int mx = t.x,my = t.y;
                    while(true) {
                        mx += dx[d];
                        my += dy[d];
                        if (mx < 0 || my < 0 || mx >= N || my >= N) break;
                        if (arr[mx][my] == 'O') break;
                        if (arr[mx][my] == 'S') return false;
                    }
                }
            }
        return true;
    }

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
