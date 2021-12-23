import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16768 {
    static int N,K;
    static char[][]area;
    static boolean[][]visited;
    static ArrayList<Point>mooyo;
    static ArrayList<Character>temp;
    static Queue<Point>q;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        area = new char[N][10];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<10;j++){
                area[i][j] = s.charAt(j);
            }
        }

        while(true) {
            visited = new boolean[N][10];
            boolean finish = true;
            for (int i = N - 1; i >= 0; i--) {
                for (int j = 9; j >= 0; j--) {
                    if(area[i][j]!='0' && !visited[i][j]){
                        mooyo = new ArrayList<>();
                        bfs(i,j);
                        if(mooyo.size()>=K){
                            finish = false;
                            for(Point p : mooyo){
                                area[p.x][p.y] = '0';
                            }
                        }
                    }
                }
            }
            if(finish)break;
            drop();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<10;j++){
                sb.append(area[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void drop() {
        for (int i = 0; i < 10; i++) {
            temp = new ArrayList<>();

            for (int j = N-1; j >= 0; j--) {
                if(area[j][i]!='0'){
                    temp.add(area[j][i]);
                    area[j][i] = '0';
                }
            }
            int y = N-1;
            for(int j=0;j<temp.size();j++){
                area[y-j][i] = temp.get(j);
            }
        }
    }

    private static void bfs(int x,int y) {
        q = new LinkedList<>();
        q.add(new Point(x,y,area[x][y]));
        visited[x][y] = true;
        mooyo.add(new Point(x,y,area[x][y]));

        while(!q.isEmpty()){
            Point cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            char type = cur.type;
            for(int i=0;i<4;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=10)continue;
                if(area[nx][ny]==type && !visited[nx][ny]){
                    q.add(new Point(nx,ny,type));
                    mooyo.add(new Point(nx,ny,type));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static class Point {
        int x,y;
        char type;

        public Point(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
